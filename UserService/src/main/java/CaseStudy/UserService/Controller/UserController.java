package CaseStudy.UserService.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.common.base.Optional;
import CaseStudy.UserService.Exception.ApiRequestException;
import CaseStudy.UserService.Repository.UserRepository;
import CaseStudy.UserService.Service.UserService;
import CaseStudy.UserService.model.User;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/user")
public class UserController {
	private static final String UserService = "User-Service";

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@CircuitBreaker(name=UserService,fallbackMethod="userFallback")
	
	//Creating/ADDING Customer
	@PostMapping("/adduser")
	public User saveUsers(@RequestBody User user) 
	{
		 return userService.addUser(user);
	
	}
	
	//Reading all Customer 
	@GetMapping("/allcustomers")
	public List<User> findAllCustomers()
	{
		return userService.getUsers();
		
	}
	
	//Reading Customer by ID
	@GetMapping("/allcustomers/{id}")
	public Optional<User> getCustomerById(@PathVariable int id) throws ApiRequestException
	{
		return Optional.of(userRepository.findById(id)
				.orElseThrow(()-> new ApiRequestException("CUSTOMER NOT FOUND WITH THIS ID ::")));
	}
	
	
	//Updating Customer Data by Id
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateCustomer(@PathVariable int id, @RequestBody User user)
	{
		boolean isCustomerExist=userRepository.existsById(id);
		if(isCustomerExist) {
			userRepository.save(user);
			return new ResponseEntity<Object>("user updated successfully with id " +id, HttpStatus.OK);
		}
		else 
		{
			throw new ApiRequestException("CAN NOT UPDATE AS USER NOT FOUND WITH THIS ID ::");
		}
		
	}
	
	// Deleting Customer Data by Id 
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteCustomer (@PathVariable int id)
	{
		boolean isCustomerExist=userRepository.existsById(id);
		if(isCustomerExist) {
			userService.deleteById(id);
			return new ResponseEntity<Object>("user deleted with id"+id,HttpStatus.OK);
		}
		else
		{
			throw new ApiRequestException("CAN NOT DELETE AS USER NOT FOUND WITH THIS ID ::");
		}

	}
	public ResponseEntity<String> userFallback(Exception e){
		return new ResponseEntity<String>("order list is busy",HttpStatus.OK);
	}
	
}
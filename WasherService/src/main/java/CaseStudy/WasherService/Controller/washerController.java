package CaseStudy.WasherService.Controller;

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
import CaseStudy.WasherService.Exception.ApiRequestException;
import CaseStudy.WasherService.Repository.WasherRepository;
import CaseStudy.WasherService.Service.WasherService;
import CaseStudy.WasherService.model.washer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/washer")
public class washerController {
	private static final String WasherService = "Washer-Service";
	@Autowired
	private WasherService washerService;
	
	@Autowired
	private WasherRepository washerRepository;	
	
	@CircuitBreaker(name=WasherService,fallbackMethod="userFallback")
	
	//Creating/Adding Washer
	@PostMapping("/addwasher")
	public washer saveWasher(@RequestBody washer washer) 
	{
		return washerService.addWasher(washer);
	}
	
	//Reading all washer
	@GetMapping("/allwashers")
	public List<washer> findAllWashers(){
		return washerService.getWashers();
		
	}
	
	//Reading Washer by ID
	@GetMapping("/allwashers/{id}")
	public Optional<washer> getWasherById(@PathVariable int id) throws ApiRequestException
	{
		return Optional.of(washerRepository.findById(id)
				.orElseThrow(()  -> new ApiRequestException("WASHER NOT FOUND WITH THIS ID ::") ) );
		
}
	//Updating Customer Data by Id
		@PutMapping("/update/{id}")
		public ResponseEntity<Object> updateWasher(@PathVariable int id, @RequestBody washer washer)
		{
			boolean isWasherExist=washerRepository.existsById(id);
			if(isWasherExist) {
				washerRepository.save(washer);
				return new ResponseEntity<Object>("Washer updated successfully with id " +id, HttpStatus.OK);
			}
			else 
			{
				throw new ApiRequestException("CAN NOT UPDATE AS WASHER NOT FOUND WITH THIS ID ::");
			}
			
		}
		
		// Deleting Customer Data by Id 
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<Object> deleteCustomer (@PathVariable int id)
		{
			boolean isWasherExist=washerRepository.existsById(id);
			if(isWasherExist) {
				washerService.deleteById(id);
				return new ResponseEntity<Object>("Washer deleted with id"+id,HttpStatus.OK);
			}
			else
			{
				throw new ApiRequestException("CAN NOT DELETE AS WASHER NOT FOUND WITH THIS ID ::");
			}
		}

		public ResponseEntity<String> userFallback(Exception e){
			return new ResponseEntity<String>("order list is busy",HttpStatus.OK);
		}
}

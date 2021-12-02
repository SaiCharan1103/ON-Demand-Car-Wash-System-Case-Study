package CaseStudy.AdminService.Controller;

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
import org.springframework.web.bind.annotation.RestController;
import com.google.common.base.Optional;
import CaseStudy.AdminService.Exception.ApiRequestException;
import CaseStudy.AdminService.Repository.AdminRepo;
import CaseStudy.AdminService.Service.AdminService;
import CaseStudy.AdminService.model.Admin;


@RestController
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private AdminRepo adminRepository;
	
	//Creating/ADDING Customer
	@PostMapping("/adduser")
	public Admin saveAdmin(@RequestBody Admin admin) 
	{
		 return adminService.addAdmin(admin);
	
	}
	
	//Reading all Customer 
	@GetMapping("/allcustomers")
	public List<Admin> findAllAdmin()
	{
		return adminService.getAdmin();
		
	}
	
	//Reading Customer by ID
	@GetMapping("/allcustomers/{id}")
	public Optional<Admin> getAdminById(@PathVariable int id) throws ApiRequestException
	{
		return Optional.of(adminRepository.findById(id)
				.orElseThrow(()-> new ApiRequestException("Admin NOT FOUND WITH THIS ID ::")));
	}
	
	
	//Updating Customer Data by Id
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateAdmin(@PathVariable int id, @RequestBody Admin admin)
	{
		boolean isCustomerExist=adminRepository.existsById(id);
		if(isCustomerExist) {
			adminRepository.save(admin);
			return new ResponseEntity<Object>("Admin updated successfully with id " +id, HttpStatus.OK);
		}
		else 
		{
			throw new ApiRequestException("CAN NOT UPDATE AS USER NOT FOUND WITH THIS ID ::");
		}
		
	}
	
	// Deleting Customer Data by Id 
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteAdmin (@PathVariable int id)
	{
		boolean isCustomerExist=adminRepository.existsById(id);
		if(isCustomerExist) {
			adminService.deleteById(id);
			return new ResponseEntity<Object>("Admin deleted with id"+id,HttpStatus.OK);
		}
		else
		{
			throw new ApiRequestException("CAN NOT DELETE AS USER NOT FOUND WITH THIS ID ::");
		}

	}
}	
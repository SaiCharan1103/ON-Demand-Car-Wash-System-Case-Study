package CaseStudy.AdminService.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import CaseStudy.AdminService.Repository.AdminRepo;
import CaseStudy.AdminService.model.Admin;

@Service
public class AdminService {
	@Autowired
	private AdminRepo adminRepository;
	
	
	//For CREATING/ADDING  Customer 
	public Admin addAdmin(Admin admin) {
		return adminRepository.save(admin);
		
	}
     //For getting All Customers
	public List<Admin> getAdmin() {
		List<Admin> users =adminRepository.findAll();
		System.out.println("Getting Admin from DB" + users);
		return users;
	}

	//For deleting By Id
	public void deleteById(int id) {
		adminRepository.deleteById(id);
		
	}

}

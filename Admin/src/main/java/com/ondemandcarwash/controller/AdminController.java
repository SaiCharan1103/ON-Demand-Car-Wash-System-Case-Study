package com.ondemandcarwash.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ondemandcarwash.models.Admin;
import com.ondemandcarwash.repository.AdminRepository;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminRepository adminRepository;
	
	//Adding Admin
	@PostMapping("/addadmin")
	public String addAdmin(@RequestBody Admin admin) {
		 adminRepository.save(admin) ;
		 return "Admin Saved Successfully with id:" +admin.getaId();
		
	}
	
	//Reading All admin 
	@GetMapping("/alladmins")
	public List<Admin> getallAdmins(){
		return adminRepository.findAll();
		
	}
	@GetMapping("/alladmins/{id}")
	public Optional<Admin> getadminbyId(@PathVariable int id){
		return adminRepository.findById(id);
		
	}
}
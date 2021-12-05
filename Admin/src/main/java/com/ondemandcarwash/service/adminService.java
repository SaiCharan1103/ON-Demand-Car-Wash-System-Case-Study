package com.ondemandcarwash.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ondemandcarwash.models.Admin;
import com.ondemandcarwash.repository.AdminRepository;

@Service
public class adminService {
	@Autowired
	private AdminRepository adminRepository;
	//for creating/adding order
	public Admin addAdmin(Admin admin) {
		return adminRepository.save(admin);
	}	
	//for getting List of Order
	public List<Admin> getallAdmins() {
		
		List<Admin> order= adminRepository.findAll();
		System.out.println("Getting order from DB" + order);
		return order;
	}
	public void deleteadminById(int id) {
		adminRepository.deleteById(id);		
	}
}
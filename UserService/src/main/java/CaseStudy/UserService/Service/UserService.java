package CaseStudy.UserService.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import CaseStudy.UserService.Repository.UserRepository;
import CaseStudy.UserService.model.User;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	
	//For CREATING/ADDING  Customer 
	public User addUser(User user) {
		return userRepository.save(user);
		
	}
     //For getting All Customers
	public List<User> getUsers() {
		List<User> users =userRepository.findAll();
		System.out.println("Getting Customers from DB" + users);
		return users;
	}

	//For deleting By Id
	public void deleteById(int id) {
		userRepository.deleteById(id);
		
	}
}
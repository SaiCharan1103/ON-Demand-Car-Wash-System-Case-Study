package CaseStudy.WasherService.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CaseStudy.WasherService.Repository.WasherRepository;
import CaseStudy.WasherService.model.washer;

@Service
public class WasherService {
	@Autowired
	private WasherRepository washerRepository;
    
	//for creating/adding washer
	public washer addWasher(washer washer) {
		return washerRepository.save(washer);
	}
	public List<washer> getWashers() {		
		List<washer> washer= washerRepository.findAll();
		System.out.println("Getting Washer from DB" + washer);
		return washer;
	}
	public void deleteById(int id) {
		washerRepository.deleteById(id);		
	}
}
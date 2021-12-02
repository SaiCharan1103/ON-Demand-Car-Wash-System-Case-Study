package CaseStudy.AdminService.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import CaseStudy.AdminService.model.Admin;

public interface AdminRepo extends MongoRepository<Admin, Integer> {

}

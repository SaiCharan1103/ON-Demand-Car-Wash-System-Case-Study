package CaseStudy.UserService.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import CaseStudy.UserService.model.User;

public interface UserRepository extends MongoRepository<User, Integer>{

}

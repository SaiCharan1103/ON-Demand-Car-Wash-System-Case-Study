package CaseStudy.WasherService.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import CaseStudy.WasherService.model.washer;

public interface WasherRepository extends MongoRepository<washer,Integer> {

}
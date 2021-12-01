package CaseStudy.OrderService.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import CaseStudy.OrderService.model.Order;

public interface OrderRepository extends MongoRepository <Order, Integer> {

}
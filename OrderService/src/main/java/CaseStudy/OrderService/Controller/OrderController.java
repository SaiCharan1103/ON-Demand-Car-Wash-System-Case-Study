package CaseStudy.OrderService.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import CaseStudy.OrderService.Exception.ApiRequestException;
import CaseStudy.OrderService.Repository.OrderRepository;
import CaseStudy.OrderService.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private OrderRepository orderRepository;

	// Creating/Adding Order
	@PostMapping("/addorder")
	public String saveOrder(@RequestBody Order order) {
		orderService.addOrder((CaseStudy.OrderService.model.Order) order);
		return "Order is Placed with Washer and will be Proceesed soon " + order;
	}

	// Reading all washer
	@GetMapping("/allorders")
	public List<CaseStudy.OrderService.model.Order> getOrder() {
		return orderRepository.findAll();
	}

	// Deleting order by Id
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteOrder(@PathVariable int id) {
		boolean isOrderExist = orderRepository.existsById(id);
		if (isOrderExist) {
			orderService.deleteById(id);
			return new ResponseEntity<Object>("Order deleted with id" + id, HttpStatus.OK);
		} else {
			throw new ApiRequestException("CAN NOT DELETE ORDER ,AS ORDER NOT FOUND WITH THIS ID ::");
		}

	}
}
package CaseStudy.UserService.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController	
public class HelloController4 {
		@RequestMapping("/hello")
		public String helloworld() {
			return "Hello World!";
		}
	}
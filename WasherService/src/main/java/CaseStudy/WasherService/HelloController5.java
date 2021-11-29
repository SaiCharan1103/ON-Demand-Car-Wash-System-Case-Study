package CaseStudy.WasherService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController	
public class HelloController5 {
		@RequestMapping("/hello")
		public String helloworld() {
			return "Hello World!";
		}
	}
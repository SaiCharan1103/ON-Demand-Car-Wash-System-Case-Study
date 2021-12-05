package com.ondemandcarwash;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class AdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminApplication.class, args);
	}
	@Bean
	  public Docket produceApi(){
		    return new Docket(DocumentationType.SWAGGER_2)
		    .select()
		    .paths(PathSelectors.ant("/admin/**"))
		    .apis(RequestHandlerSelectors.basePackage("com.ondemandcarwash"))
		    .build();	
	}

}

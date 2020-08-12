package com.capg.bookmanagement;

import java.util.Collections;

import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class SwaggerConfig {

	@Bean
	  public Docket SwaggerCongiguration()
	  {
		//here we need to create instance of docket to user swagger2 documentation
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.capg.bookmanagement"))
				.build()
				.apiInfo(apiDetails());
		  
	  }
	private ApiInfo apiDetails()
	{
		return new ApiInfo(
		"BookInfoManagement Service Api",
		"Api for BookStore Management System",
		"1.0",
		"Api end points for crud operation",
		new springfox.documentation.service.Contact("Sriya Agarwal","agarwal.sriya98@gmail.com","www.google.com"),
		"Capgemini BootCamp Training",
		"using swagger for documentation",
		Collections.emptyList());
	}

}


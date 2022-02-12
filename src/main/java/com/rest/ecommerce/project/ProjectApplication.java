package com.rest.ecommerce.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("es.uc3m.tiw.dominios")
@SpringBootApplication
//@ComponentScan(basePackages = {"com.rest.ecommerce.project.cart", "com.rest.ecommerce.project.category"})
@ComponentScan("com.myapp.repositories")
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

}

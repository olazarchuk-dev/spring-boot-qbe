package com.deb.qbe;

import com.deb.qbe.model.Customers;
import com.deb.qbe.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;

@Configuration
@EnableJpaRepositories
@SpringBootApplication
public class SpringBootQbeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootQbeApplication.class, args);
	}

	@Bean
	public CommandLineRunner specificationsDemo(CustomerRepository customerRepository) {
		return args -> {
			// create new movies
			customerRepository.saveAll(Arrays.asList(
					new Customers(1L, "Debendra","Dhinda", 5000L),
					new Customers(2L, "Satvik", "Dhinda", 2000L),
					new Customers(3L, "Anita", "Samal", 5000L),
					new Customers(4L, "Anita", "Das", 3000L),
					new Customers(5L, "Promod", "Barik", 2000L),
					new Customers(6L, "Vidushi", "Diwedy", 3000L),
					new Customers(7L, "Kuber", "Goel", 5000L),
					new Customers(8L, "Shyambrij", "Mourya", 1000L),
					new Customers(9L, "Harikant", "Ojha", 5000L),
					new Customers(10L, "Jitendra", "Bhandari", 2000L),
					new Customers(11L, "Ankit", "Jindal", 2000L),
					new Customers(12L, "Soumya", "Shankar", 1000L),
					new Customers(13L, "Rosalin", "Khillar", 2000L),
					new Customers(14L, "Mahendra", "Khillar", 5000L),
					new Customers(15L, "Narendra", "Jindal", 2000L)
			));
		};
	}
}

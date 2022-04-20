package com.api.customersupport;

import com.api.customersupport.models.ResolverModel;
import com.api.customersupport.repositorys.ResolverRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class CustomerSupportApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerSupportApplication.class, args);
	}
	@Bean
	ApplicationRunner init(ResolverRepository resolverRepository) {
		return args -> {
			Stream.of(
					"João",
					"Maria",
					"Zeca",
					"Mario",
					"Gustavo",
					"Camila",
					"Pedro",
					"Juliana",
					"Gisele"
			).forEach(name -> {
				ResolverModel resolverModel = new ResolverModel();
				resolverModel.setName(name);
				resolverRepository.save(resolverModel);
			});
			resolverRepository.findAll().forEach(System.out::println);
		};
	}
}

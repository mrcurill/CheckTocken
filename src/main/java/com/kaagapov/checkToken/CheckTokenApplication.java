package com.kaagapov.checkToken;

import com.kaagapov.checkToken.entity.ProductItem;
import com.kaagapov.checkToken.repo.ProductItemRepository;
import com.kaagapov.checkToken.repo.ProductRepository;
import com.kaagapov.checkToken.repo.UserRepository;
import com.kaagapov.checkToken.entity.Product;
import com.kaagapov.checkToken.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CheckTokenApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(CheckTokenApplication.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);
		ProductRepository productRepository = context.getBean(ProductRepository.class);
		ProductItemRepository productItemRepository = context.getBean(ProductItemRepository.class);
//
//		userRepository.save(new User("SADMIN", "SADMIN", 1));
//		userRepository.save(new User("USER1","USER1"));
//		userRepository.save(new User("USER2","USER2"));
//		userRepository.save(new User("USER3","USER3"));
//
		Iterable<User> users = userRepository.findAll();
		System.out.println();
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for(User user : users)
			System.out.println(user);
		System.out.println();

		Iterable<Product> products = productRepository.findAll();
		System.out.println();
		System.out.println("Products found with findAll():");
		System.out.println("------------------------------");
		for(Product product : products) {
			System.out.println(product);
			Iterable<ProductItem> productItems = productItemRepository.findByProductId(product.getId());
			for(ProductItem productItem : productItems)
				System.out.println(productItem);
		}
	}

}

package com.kaagapov.checkToken;

import com.kaagapov.checkToken.entity.Component;
import com.kaagapov.checkToken.repo.UserRepository;
import com.kaagapov.checkToken.entity.User;
import com.kaagapov.checkToken.repo.ComponentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class CheckTokenApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(CheckTokenApplication.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);
		ComponentRepository componentRepository = context.getBean(ComponentRepository.class);

//		Iterable<User> users = userRepository.findAll();
//		System.out.println();
//		System.out.println("Customers found with findAll():");
//		System.out.println("-------------------------------");
//		for(User user : users)
//			System.out.println(user);


//		List<String> compStr = new ArrayList<>();
//		compStr.add("comp1");
//		compStr.add("comp2");
//
//		Component component = new Component();
//		component.setName("test");
//		component.setButtons(Arrays.asList("111-111-1111", "222-222-222"));
//		componentRepository.save(component);

//		Iterable<Component> views = componentRepository.findAll();
//		System.out.println();
//		System.out.println("Views found with findAll():");
//		System.out.println("---------------------------");
//		for(Component component : views)
//			System.out.println(component);
	}

}

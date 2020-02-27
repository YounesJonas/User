package org.yb.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.yb.user.dao.UserDAO;
import org.yb.user.entities.User;

@SpringBootApplication
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

	@Bean
	CommandLineRunner start(UserDAO userDao) {
		return args -> {
			userDao.deleteAll();
			userDao.save(new User("u1","bouazizi","younes",28,"France","bouazizi.younes@gmail.com"));
			userDao.save(new User("u2","safwane","ilyas",27,"France",""));
			userDao.save(new User("u3","obaita","jaafar",29,"France","jaafar.obaita@gmail.com"));
			
			userDao.findAll().forEach(System.out::println);
			
		};
	}
}

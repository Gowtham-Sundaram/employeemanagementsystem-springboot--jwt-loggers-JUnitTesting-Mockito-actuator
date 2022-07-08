package com.accent.employeemanagementsystem;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.accent.employeemanagementsystem.jwtuserentitydao.User;
import com.accent.employeemanagementsystem.userrepository.UserRepository;

@SpringBootApplication
public class EmployeemanagementsystemApplication {
	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	public void initUsers() {
		List<User> users = Stream.of(new User(101, "admin", "pwd1", true, "ADMIN", "user1@gmail.com"),
				new User(102, "manager", "pwd2", true, "USER", "user2@gmail.com")).collect(Collectors.toList());
		userRepository.saveAll(users);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeemanagementsystemApplication.class, args);
	}
}

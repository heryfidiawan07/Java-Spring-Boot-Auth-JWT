package com.fidirestcore.fidirestcore;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fidirestcore.fidirestcore.entity.RoleEntity;
import com.fidirestcore.fidirestcore.entity.UserEntity;
import com.fidirestcore.fidirestcore.service.UserService;

@SpringBootApplication
public class FidirestcoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(FidirestcoreApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// Example to setup first data to application
	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new RoleEntity(null, "ROLE_USER"));
			userService.saveRole(new RoleEntity(null, "ROLE_ADMIN"));
			userService.saveRole(new RoleEntity(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new UserEntity(null, "M. Yahya", "yahya", "yahya@mail.com", "12345678", new ArrayList<>()));
			userService.saveUser(new UserEntity(null, "Rarakirana", "rarakirana", "rarakirana@mail.com", "12345678", new ArrayList<>()));
			userService.saveUser(new UserEntity(null, "Hery Fidiawan", "fidiawan", "fidiawan@mail.com", "12345678", new ArrayList<>()));

			userService.addRoleToUser("yahya", "ROLE_USER");
			userService.addRoleToUser("rarakirana", "ROLE_ADMIN");
			userService.addRoleToUser("fidiawan", "ROLE_SUPER_ADMIN");
		};
	}
}

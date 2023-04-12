package com.lavrinovich.mapstructexercises;

import com.lavrinovich.mapstructexercises.mapper.UserMapper;
import com.lavrinovich.mapstructexercises.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
public class MapstructExercisesApplication implements org.springframework.boot.ApplicationRunner {

	private UserRepo userRepo;

	public static void main(String[] args) {
		SpringApplication.run(MapstructExercisesApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		userRepo.findAll().stream().map(UserMapper.INSTANCE::mapToModel).forEach(System.out::println);
	}
}

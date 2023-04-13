package com.lavrinovich.mapstructexercises;

import com.lavrinovich.mapstructexercises.entity.User;
import com.lavrinovich.mapstructexercises.mapper.UserMapper;
import com.lavrinovich.mapstructexercises.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
@AllArgsConstructor
public class MapstructExercisesApplication implements org.springframework.boot.ApplicationRunner {

	private UserRepo userRepo;

	public static void main(String[] args) {
		SpringApplication.run(MapstructExercisesApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		List<User> users = userRepo.findAll();
		users.stream().map(UserMapper.INSTANCE::mapToModel).forEach(System.out::println);
		try(Scanner scanner = new Scanner(System.in)){
			for (User u :
					users) {
				System.out.println("Enter new country name for " + u.getName() + ": ");
				u.setCountryName(scanner.nextLine());
				userRepo.save(u);
			}
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		users.stream().map(UserMapper.INSTANCE::mapToModel).forEach(System.out::println);

	}
}

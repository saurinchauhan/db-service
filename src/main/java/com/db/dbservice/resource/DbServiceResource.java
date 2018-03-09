package com.db.dbservice.resource;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db.dbservice.model.User;
import com.db.dbservice.repository.UserRepository;

@RestController
@RequestMapping("/rest/db")
public class DbServiceResource {

	private UserRepository userRepository;

	public DbServiceResource(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@GetMapping("{username}")
	public User getUserByUserName(@PathVariable("username") final String userName) {
		return userRepository.findByUserName(userName);

	}
	
	@GetMapping("/all")
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	@PostMapping("/add")
	public User addUser(@RequestBody final User user) {
		userRepository.save(user);
		return userRepository.findByUserName(user.getUserName());
	}
	
	@PostMapping("/update")
	public User updateUser(@RequestBody final User user) {
		userRepository.save(user);
		return userRepository.findByUserName(user.getUserName());
	}

	@DeleteMapping("/delete/{username}")
	public User deleteUser(@PathVariable("username") final String userName) {
		User user = userRepository.findByUserName(userName);
		userRepository.delete(user.getUserid());
		return user;
	}

}

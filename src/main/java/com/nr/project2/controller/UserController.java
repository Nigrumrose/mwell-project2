package com.nr.project2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nr.project2.model.UserDto;
import com.nr.project2.service.UserService;

@Controller("userController")
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/add")
	public String add(UserDto user) throws Exception{
		userService.add(user);
		return "login";
	}
	
	@PostMapping("/login")
	public String login() throws Exception{
		return "login";
	}
	
	@PostMapping("/register")
	public String register(Model model) throws Exception{
		model.addAttribute("user", new UserDto());
		return "register";
	}
	
	@PutMapping("/update")
	public UserDto update(UserDto user){
		return userService.updateUser(user);
	}
	
	@DeleteMapping("/delete")
	public String delete(String userId){
		return userService.deleteUser(userId);

	}
	
	@GetMapping("/")
	public List<UserDto> getAllUsers(){
		return userService.getAllUsers();

	}
	
	@GetMapping("/{userId")
	public UserDto getAllUsers(@PathVariable("userId") String userId){
		return userService.getUserByLoginId(userId);
	}
}

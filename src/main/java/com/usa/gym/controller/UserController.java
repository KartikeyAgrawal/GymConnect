package com.usa.gym.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usa.gym.dto.Attendance;
import com.usa.gym.dto.Progress;
import com.usa.gym.dto.User;
import com.usa.gym.service.UserService;

@RestController
@RequestMapping("/api/v1")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/addUser")
	ResponseEntity<User> addUser(@RequestBody User user)
	{
		return ResponseEntity.ok(userService.addUser(user));
	}
	
	@GetMapping("/allUsers")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	ResponseEntity<List<User>> getAllUsers()
	{
		return ResponseEntity.ok(userService.getAllUsers());
	}
	
	@PostMapping("/addAttendance/{userId}")
	ResponseEntity markAttendancej(@PathVariable(name = "userId") int userId)
	{
		userService.addAttendance(userId);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@GetMapping("/userAttendance/{userId}")
	ResponseEntity<List<Attendance>> getUserAttendance(@PathVariable(name = "userId") int userId )
	{
		return ResponseEntity.ok(userService.getUserAttendance(userId));
	}
	
	@PostMapping("/addProgress/{userId}")
	ResponseEntity addUserProgress(@PathVariable(name = "userId") int userId,@RequestBody Progress progress)
	{
		userService.addUserProgress(userId,progress);
		return new ResponseEntity(HttpStatus.OK);
	}
}

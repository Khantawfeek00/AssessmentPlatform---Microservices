package com.examPortal.AssessmentPlatform.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examPortal.AssessmentPlatform.Entity.User;
import com.examPortal.AssessmentPlatform.Service.UserService;

import java.util.List;

@RequestMapping("/users")
@RestController
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/me")
	public ResponseEntity<User> authenticatedUser() {
		System.err.println("Authenticated User");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		User currentUser = (User) authentication.getPrincipal();

		return ResponseEntity.ok(currentUser);
	}

	@GetMapping("/all")
	public ResponseEntity<List<User>> allUsers() {
		System.err.println("Inside all users");
		List<User> users = userService.getUsers();

		return ResponseEntity.ok(users);
	}
}

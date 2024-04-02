package com.examPortal.AssessmentPlatform.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examPortal.AssessmentPlatform.DTO.LoginUserDTO;
import com.examPortal.AssessmentPlatform.DTO.RegisterUserDTO;
import com.examPortal.AssessmentPlatform.Entity.User;
import com.examPortal.AssessmentPlatform.Service.AuthenticationService;
import com.examPortal.AssessmentPlatform.Service.JwtService;
import com.examPortal.AssessmentPlatform.Service.UserService;
import com.examPortal.AssessmentPlatform.responses.LoginResponse;

@RequestMapping("/auth")
@RestController
@CrossOrigin("*")
public class AuthenticationController {

	@Autowired
	JwtService jwtService;

	@Autowired
	AuthenticationService authenticationService;

	@Autowired
	UserService userService;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginUserDTO loginUser) {

		System.err.println("Inside the Login Controller");
		// Authenticated User
		User user = authenticationService.login(loginUser);

		// Generating token
		String jwttoken = jwtService.generateToken(user);

		// Sending Token with Duration Time
		LoginResponse response = new LoginResponse();
		response.setToken(jwttoken);
		response.setTokenDuration(jwtService.getExpirationTime());
		return ResponseEntity.ok(response);

	}

	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody RegisterUserDTO newUser) {
		try {
			User user = authenticationService.register(newUser);
			if (user != null) {
				System.err.println("The user is already present");
				return ResponseEntity.status(HttpStatus.CREATED).body(user);
			}
			return ResponseEntity.status(HttpStatus.CONFLICT).body("User already registered");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Something went wrong !!");
		}

	}

	@GetMapping("/all")
	public ResponseEntity<List<User>> getUsers() {
		System.err.println("Inside the get Users ");
		List<User> users = userService.getUsers();
		return ResponseEntity.ok(users);
	}
}

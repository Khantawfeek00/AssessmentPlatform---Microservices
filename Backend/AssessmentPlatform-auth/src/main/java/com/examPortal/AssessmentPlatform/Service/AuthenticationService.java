package com.examPortal.AssessmentPlatform.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.examPortal.AssessmentPlatform.DTO.LoginUserDTO;
import com.examPortal.AssessmentPlatform.DTO.RegisterUserDTO;
import com.examPortal.AssessmentPlatform.Entity.User;
import com.examPortal.AssessmentPlatform.Repository.UserRepository;

@Service
public class AuthenticationService {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	UserRepository userRepository;

	// Registering User
	public User register(RegisterUserDTO newUser) {
		User user = userRepository.findByUsername(newUser.getUsername());
		if (user != null) {
			return null;
		} else {
			User addUser = new User().setFullName(newUser.getFullName())
					.setPassword(passwordEncoder.encode(newUser.getPassword())).setUsername(newUser.getUsername());
			return userRepository.save(addUser);
		}
	}

	// User is login
	public User login(LoginUserDTO user) {

//		 Checking that user is authenticated or not
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		System.err.println(authentication);
		return userRepository.findByUsername(user.getUsername());

	}
}

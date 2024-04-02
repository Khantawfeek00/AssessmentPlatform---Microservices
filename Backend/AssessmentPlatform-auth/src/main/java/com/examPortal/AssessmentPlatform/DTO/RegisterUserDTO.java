package com.examPortal.AssessmentPlatform.DTO;

public class RegisterUserDTO {
	private String username;
	private String password;
	private String fullName;

	public RegisterUserDTO() {
		super();
	}

	public RegisterUserDTO(String username, String password, String fullName) {
		super();
		this.username = username;
		this.password = password;
		this.fullName = fullName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Override
	public String toString() {
		return "RegisterUserDTO [username=" + username + ", password=" + password + ", fullName=" + fullName + "]";
	}

}

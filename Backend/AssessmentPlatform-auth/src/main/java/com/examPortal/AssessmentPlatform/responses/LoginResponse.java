package com.examPortal.AssessmentPlatform.responses;

public class LoginResponse {

	private String token;
	private long tokenDuration;

	public LoginResponse() {
		super();
	}

	public LoginResponse(String token, long tokenDuration) {
		super();
		this.token = token;
		this.tokenDuration = tokenDuration;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Long getTokenDuration() {
		return tokenDuration;
	}

	public void setTokenDuration(Long tokenDuration) {
		this.tokenDuration = tokenDuration;
	}

	@Override
	public String toString() {
		return "LoginResponse [token=" + token + ", tokenDuration=" + tokenDuration + "]";
	}

}

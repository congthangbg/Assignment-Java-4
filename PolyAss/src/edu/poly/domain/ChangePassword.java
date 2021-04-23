package edu.poly.domain;

public class ChangePassword {
	private String userId;
	private String password;
	private String confirmPassw;
	private String currentPassw;
	
	
	public ChangePassword() {
	}
	public ChangePassword(String userId, String password, String confirmPassw, String currentPassw) {
		super();
		this.userId = userId;
		this.password = password;
		this.confirmPassw = confirmPassw;
		this.currentPassw = currentPassw;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassw() {
		return confirmPassw;
	}
	public void setConfirmPassw(String confirmPassw) {
		this.confirmPassw = confirmPassw;
	}
	public String getCurrentPassw() {
		return currentPassw;
	}
	public void setCurrentPassw(String currentPassw) {
		this.currentPassw = currentPassw;
	}
	@Override
	public String toString() {
		return "ChangePassword [userId=" + userId + ", password=" + password + ", confirmPassw=" + confirmPassw
				+ ", currentPassw=" + currentPassw + "]";
	}
	
	
}

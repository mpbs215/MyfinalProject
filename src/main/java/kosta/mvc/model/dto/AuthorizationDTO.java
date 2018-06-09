package kosta.mvc.model.dto;

public class AuthorizationDTO {

	private String userId;
	private String role;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public AuthorizationDTO() {
		super();
	}
	public AuthorizationDTO(String userId, String role) {
		super();
		this.userId = userId;
		this.role = role;
	}
	
	
	
}

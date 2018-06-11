package kosta.mvc.model.dto;

public class AuthorityDTO {

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
	public AuthorityDTO() {
		super();
	}
	public AuthorityDTO(String userId, String role) {
		super();
		this.userId = userId;
		this.role = role;
	}
	
	
	
}

package kosta.mvc.model.dto;

import org.springframework.stereotype.Component;

@Component
public class AuthorityDTO {

	private String userId;
	private String role;
	private String key;
	private String hp;
	
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
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public AuthorityDTO() {
		super();
	}
	
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public AuthorityDTO(String userId, String key, String role, String hp) {
		super();
		this.userId = userId;
		this.key = key;
		this.role = role;
		this.hp = hp;
	}
}

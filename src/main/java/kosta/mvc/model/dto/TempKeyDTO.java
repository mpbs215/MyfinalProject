package kosta.mvc.model.dto;

import org.springframework.stereotype.Component;

@Component
public class TempKeyDTO {
	
	private String userId;
	private String hp;
	private String key;
	
	public TempKeyDTO() {}
	
	public String getNumKeys(int num) {
	
		StringBuffer buffer = new StringBuffer();
		
		for (int i=0; i < num; i++) {
			int n = (int)(Math.random() * 10);
			buffer.append(n);
		}
		return buffer.toString();
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}

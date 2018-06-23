package kosta.mvc.model.util;

import org.springframework.stereotype.Component;

@Component
public class TempKey {

	private String numKey;
	private String hp;
	
	public TempKey() {}
	
	public String getNumKey(int num) {
	
		StringBuffer buffer = new StringBuffer();
		
		for (int i=0; i < num; i++) {
			int n = (int)(Math.random() * 10);
			buffer.append(n);
		}
		return buffer.toString();
	}
	
	public String getNumKey() {
		return numKey;
	}
	public void setNumKey(String numKey) {
		this.numKey = numKey;
	}
	
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	
}

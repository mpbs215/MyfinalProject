package kosta.mvc.model.dto;

public class SidogugundongriDTO {
	private String sido;
	private String gugun;
	private String dong;
	private String ri;
	public String getSido() {
		return sido;
	}
	public void setSido(String sido) {
		this.sido = sido;
	}
	public String getGugun() {
		return gugun;
	}
	public void setGugun(String gugun) {
		this.gugun = gugun;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getRi() {
		return ri;
	}
	public void setRi(String ri) {
		this.ri = ri;
	}
	public SidogugundongriDTO(String sido, String gugun, String dong, String ri) {
		super();
		this.sido = sido;
		this.gugun = gugun;
		this.dong = dong;
		this.ri = ri;
	}
	public SidogugundongriDTO() {
		super();
	}
	
}
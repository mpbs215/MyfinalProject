package kosta.mvc.model.dto;

public class ParkRegiDTO {
	private int parkNo;
	private String regiStart;
	private String regiEnd;
	
	public int getParkNo() {
		return parkNo;
	}
	public void setParkNo(int parkNo) {
		this.parkNo = parkNo;
	}
	public String getRegiStart() {
		return regiStart;
	}
	public void setRegiStart(String regiStart) {
		this.regiStart = regiStart;
	}
	public String getRegiEnd() {
		return regiEnd;
	}
	public void setRegiEnd(String regiEnd) {
		this.regiEnd = regiEnd;
	}
	public ParkRegiDTO(int parkNo, String regiStart, String regiEnd) {
		super();
		this.parkNo = parkNo;
		this.regiStart = regiStart;
		this.regiEnd = regiEnd;
	}
	public ParkRegiDTO() {
		super();
	}
	
}
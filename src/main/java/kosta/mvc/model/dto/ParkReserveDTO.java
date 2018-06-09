package kosta.mvc.model.dto;

import java.util.List;

public class ParkReserveDTO {
	private int reserveNo;
	private String userId;
	private int parkNo;
	private String reserveStart;
	private String reserveEnd;
	
	private List<ParkDTO> park;
	
	public List<ParkDTO> getPark() {
		return park;
	}
	public void setPark(List<ParkDTO> park) {
		this.park = park;
	}
	public ParkReserveDTO(int reserveNo, String userId, int parkNo, String reserveStart, String reserveEnd) {
		super();
		this.reserveNo = reserveNo;
		this.userId = userId;
		this.parkNo = parkNo;
		this.reserveStart = reserveStart;
		this.reserveEnd = reserveEnd;
	}
	public ParkReserveDTO() {
		super();
	}
	public int getReserveNo() {
		return reserveNo;
	}
	public void setReserveNo(int reserveNo) {
		this.reserveNo = reserveNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getParkNo() {
		return parkNo;
	}
	public void setParkNo(int parkNo) {
		this.parkNo = parkNo;
	}
	public String getReserveStart() {
		return reserveStart;
	}
	public void setReserveStart(String reserveStart) {
		this.reserveStart = reserveStart;
	}
	public String getReserveEnd() {
		return reserveEnd;
	}
	public void setReserveEnd(String reserveEnd) {
		this.reserveEnd = reserveEnd;
	}
}
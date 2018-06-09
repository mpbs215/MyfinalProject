package kosta.mvc.model.dto;

import java.util.List;

public class CarTypeDTO {
	private int parkNo;
	private String carType;
	private List<String> carTypes;
	
	
	public CarTypeDTO(int parkNo, String carType) {
		super();
		this.parkNo = parkNo;
		this.carType = carType;
	}
	public CarTypeDTO(int parkNo, List<String> carTypes) {
		super();
		this.parkNo = parkNo;
		this.carTypes = carTypes;
	}
	public CarTypeDTO() {
		super();
	}
	public int getParkNo() {
		return parkNo;
	}
	public void setParkNo(int parkNo) {
		this.parkNo = parkNo;
	}
	public List<String> getCarTypes() {
		return carTypes;
	}
	public void setCarTypes(List<String> carTypes) {
		this.carTypes = carTypes;
	}
	
}
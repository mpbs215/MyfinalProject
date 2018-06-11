package kosta.mvc.model.dto;

import java.util.List;

public class CarTypeDTO {
	private int parkNo;
	private String carType;
	private int maxCar;
	private List<String> carTypes;
	
	
	public CarTypeDTO(int parkNo, String carType,int maxCar) {
		super();
		this.parkNo = parkNo;
		this.carType = carType;
		this.maxCar = maxCar;
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
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public int getMaxCar() {
		return maxCar;
	}
	public void setMaxCar(int maxCar) {
		this.maxCar = maxCar;
	}
	
	
}
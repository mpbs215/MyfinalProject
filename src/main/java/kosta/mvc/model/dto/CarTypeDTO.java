package kosta.mvc.model.dto;

import java.util.List;

public class CarTypeDTO {
	private int parkNo;
	private String carType;
	private int maxCar;

	private List<String> carTypeList;
	private List<Integer> maxCarList;
	
	public CarTypeDTO() {
		super();
	}
	public CarTypeDTO(int parkNo, String carType, int maxCar) {
		super();
		this.parkNo = parkNo;
		this.carType = carType;
		this.maxCar = maxCar;
	}
	public int getParkNo() {
		return parkNo;
	}
	public void setParkNo(int parkNo) {
		this.parkNo = parkNo;
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
	public List<String> getCarTypeList() {
		return carTypeList;
	}
	public void setCarTypeList(List<String> carTypeList) {
		this.carTypeList = carTypeList;
	}
	public List<Integer> getMaxCarList() {
		return maxCarList;
	}
	public void setMaxCarList(List<Integer> maxCarList) {
		this.maxCarList = maxCarList;
	}


}
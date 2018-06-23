package kosta.mvc.model.dto;

import java.util.List;

public class ParkDTO {
	private int parkNo;
	private String parkName;
	private String userId;
	private String parkAddr;
	private String parkSize;
	private String parkContent;
	private int price;
	
	private ParkImgDTO parkImg;
	private UserDTO user;
	private ParkRegiDTO parkRegi;
	private ParkReserveDTO parkReserve;
	private List<CarTypeDTO> carTypeList;
	
	public int getParkNo() {
		return parkNo;
	}
	public void setParkNo(int parkNo) {
		this.parkNo = parkNo;
	}
	public String getParkName() {
		return parkName;
	}
	public void setParkName(String parkName) {
		this.parkName = parkName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getParkAddr() {
		return parkAddr;
	}
	public void setParkAddr(String parkAddr) {
		this.parkAddr = parkAddr;
	}
	public String getParkSize() {
		return parkSize;
	}
	public void setParkSize(String parkSize) {
		this.parkSize = parkSize;
	}
	public String getParkContent() {
		return parkContent;
	}
	public void setParkContent(String parkContent) {
		this.parkContent = parkContent;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public ParkImgDTO getParkImg() {
		return parkImg;
	}
	public void setParkImg(ParkImgDTO parkImg) {
		this.parkImg = parkImg;
	}
	public UserDTO getUser() {
		return user;
	}
	public void setUser(UserDTO user) {
		this.user = user;
	}
	public ParkRegiDTO getParkRegi() {
		return parkRegi;
	}
	public void setParkRegi(ParkRegiDTO parkRegi) {
		this.parkRegi = parkRegi;
	}
	public ParkReserveDTO getParkReserve() {
		return parkReserve;
	}
	public void setParkReserve(ParkReserveDTO parkReserve) {
		this.parkReserve = parkReserve;
	}
	public List<CarTypeDTO> getCarTypeList() {
		return carTypeList;
	}
	public void setCarTypeList(List<CarTypeDTO> carTypeList) {
		this.carTypeList = carTypeList;
	}
	public ParkDTO(int parkNo, String parkName, String userId, String parkAddr, String parkSize, String parkContent,
			int price, ParkImgDTO parkImg, UserDTO user, ParkRegiDTO parkRegi, ParkReserveDTO parkReserve,
			List<CarTypeDTO> carTypeList) {
		super();
		this.parkNo = parkNo;
		this.parkName = parkName;
		this.userId = userId;
		this.parkAddr = parkAddr;
		this.parkSize = parkSize;
		this.parkContent = parkContent;
		this.price = price;
		this.parkImg = parkImg;
		this.user = user;
		this.parkRegi = parkRegi;
		this.parkReserve = parkReserve;
		this.carTypeList = carTypeList;
	}
	public ParkDTO() {
		super();
	}
	@Override
	public String toString() {
		return "ParkDTO [parkNo=" + parkNo + ", parkName=" + parkName + ", userId=" + userId + ", parkAddr=" + parkAddr
				+ ", parkSize=" + parkSize + ", parkContent=" + parkContent + ", price=" + price + ", parkImg="
				+ parkImg + ", user=" + user + ", parkRegi=" + parkRegi + ", parkReserve=" + parkReserve
				+ ", carTypeList=" + carTypeList + "]";
	}
	
	
	
}
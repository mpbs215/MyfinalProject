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

	private List<ParkImgDTO> parkImg;
	private List<ParkRegiDTO> parkRegi;
	private List<ParkReserveDTO> parkReserve;
	private List<ReviewDTO> review;
	private List<UserDTO> user;
	
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
	public List<ParkImgDTO> getParkImg() {
		return parkImg;
	}
	public void setParkImg(List<ParkImgDTO> parkImg) {
		this.parkImg = parkImg;
	}
	public List<ParkRegiDTO> getParkRegi() {
		return parkRegi;
	}
	public void setParkRegi(List<ParkRegiDTO> parkRegi) {
		this.parkRegi = parkRegi;
	}
	public List<ParkReserveDTO> getParkReserve() {
		return parkReserve;
	}
	public void setParkReserve(List<ParkReserveDTO> parkReserve) {
		this.parkReserve = parkReserve;
	}
	
	public List<ReviewDTO> getReview() {
		return review;
	}
	public void setReview(List<ReviewDTO> review) {
		this.review = review;
	}
	public List<UserDTO> getUser() {
		return user;
	}
	public void setUser(List<UserDTO> user) {
		this.user = user;
	}
	public ParkDTO(int parkNo, String parkName, String userId, String parkAddr, String parkSize, String parkContent,
			int price, List<ParkImgDTO> parkImg,
			List<ParkRegiDTO> parkRegi, List<ParkReserveDTO> parkReserve) {
		super();
		this.parkNo = parkNo;
		this.parkName = parkName;
		this.userId = userId;
		this.parkAddr = parkAddr;
		this.parkSize = parkSize;
		this.parkContent = parkContent;
		this.price = price;
		this.parkImg = parkImg;
		this.parkRegi = parkRegi;
		this.parkReserve = parkReserve;
	}
	public ParkDTO() {
		super();
	}
	
}
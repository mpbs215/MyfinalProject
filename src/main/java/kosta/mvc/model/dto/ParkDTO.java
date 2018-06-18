package kosta.mvc.model.dto;

public class ParkDTO {
	private int parkNo;
	private String parkName;
	private String userId;
	private String parkAddr;
	private String parkSize;
	private String parkContent;
	private int price;
	private String latitude;
	private String longitude;

	private ParkImgDTO parkImg;
	private ParkRegiDTO parkRegi;
	private ParkReserveDTO parkReserve;
	private ReviewDTO review;
	private UserDTO user;
	
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
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public ParkImgDTO getParkImg() {
		return parkImg;
	}
	public void setParkImg(ParkImgDTO parkImg) {
		this.parkImg = parkImg;
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
	public ReviewDTO getReview() {
		return review;
	}
	public void setReview(ReviewDTO review) {
		this.review = review;
	}
	public UserDTO getUser() {
		return user;
	}
	public void setUser(UserDTO user) {
		this.user = user;
	}
	
	
	
}
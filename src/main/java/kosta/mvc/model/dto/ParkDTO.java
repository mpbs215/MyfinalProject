package kosta.mvc.model.dto;

public class ParkDTO {
	private int parkNo;
	private String parkName;
	private String userId;
	private String parkAddr;
	private String parkSize;
	private String parkContent;
	private int price;
<<<<<<< HEAD

	private List<ParkImgDTO> parkImg;
	private List<ParkRegiDTO> parkRegi;
	private List<ParkReserveDTO> parkReserve;
	private List<ReviewDTO> review;
	private List<UserDTO> user;
=======
	private String latitude;
	private String longitude;
/*
	private ParkImgDTO parkImg;
	private ParkRegiDTO parkRegi;
	private ParkReserveDTO parkReserve;
	private ReviewDTO review;
	private UserDTO user;
>>>>>>> branch 'master' of https://github.com/mpbs215/finalProject.git
	
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
<<<<<<< HEAD
	public List<ParkImgDTO> getParkImg() {
=======
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
>>>>>>> branch 'master' of https://github.com/mpbs215/finalProject.git
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
	}*/
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
	public ParkDTO(int parkNo, String parkName, String userId, String parkAddr, String parkSize, String parkContent,
<<<<<<< HEAD
			int price, List<ParkImgDTO> parkImg,
			List<ParkRegiDTO> parkRegi, List<ParkReserveDTO> parkReserve) {
=======
			int price, String latitude, String longitude) {
>>>>>>> branch 'master' of https://github.com/mpbs215/finalProject.git
		super();
		this.parkNo = parkNo;
		this.parkName = parkName;
		this.userId = userId;
		this.parkAddr = parkAddr;
		this.parkSize = parkSize;
		this.parkContent = parkContent;
		this.price = price;
<<<<<<< HEAD
		this.parkImg = parkImg;
		this.parkRegi = parkRegi;
		this.parkReserve = parkReserve;
=======
		this.latitude = latitude;
		this.longitude = longitude;
>>>>>>> branch 'master' of https://github.com/mpbs215/finalProject.git
	}
	public ParkDTO() {
		super();
	}
	
	
	
	
}
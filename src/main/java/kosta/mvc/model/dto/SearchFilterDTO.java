package kosta.mvc.model.dto;

public class SearchFilterDTO {
	private String parkAddr;
	private String carType;
	private String reserveDate;
	private String parkContent;
	private String destination;
	private String parkName;
	private int price;
	public String getParkAddr() {
		return parkAddr;
	}
	public void setParkAddr(String parkAddr) {
		this.parkAddr = parkAddr;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public String getReserveDate() {
		return reserveDate;
	}
	public void setReserveDate(String reserveDate) {
		this.reserveDate = reserveDate;
	}
	public String getParkContent() {
		return parkContent;
	}
	public void setParkContent(String parkContent) {
		this.parkContent = parkContent;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getParkName() {
		return parkName;
	}
	public void setParkName(String parkName) {
		this.parkName = parkName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public SearchFilterDTO(String parkAddr, String carType, String reserveDate, String parkContent, String destination,
			String parkName, int price) {
		super();
		this.parkAddr = parkAddr;
		this.carType = carType;
		this.reserveDate = reserveDate;
		this.parkContent = parkContent;
		this.destination = destination;
		this.parkName = parkName;
		this.price = price;
	}
	public SearchFilterDTO() {
		super();
	}
	@Override
	public String toString() {
		return "SearchFilterDTO [parkAddr=" + parkAddr + ", carType=" + carType + ", reserveDate=" + reserveDate
				+ ", parkContent=" + parkContent + ", destination=" + destination + ", parkName=" + parkName
				+ ", price=" + price + "]";
	}
	
}
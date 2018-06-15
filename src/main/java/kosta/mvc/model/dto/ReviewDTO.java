package kosta.mvc.model.dto;

public class ReviewDTO {
	private String userId;
	private int parkNo;
	private int rating;
	private String reviewContent;
	
	public ReviewDTO(int parkNo, int rating) {
		super();
		this.parkNo = parkNo;
		this.rating = rating;
	}
	public ReviewDTO(String userId, int parkNo, int rating, String reviewContent) {
		super();
		this.userId = userId;
		this.parkNo = parkNo;
		this.rating = rating;
		this.reviewContent = reviewContent;
	}
	public ReviewDTO() {
		super();
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
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	
	
}
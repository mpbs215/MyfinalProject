package kosta.mvc.model.dto;

public class ReviewDTO {
	private String userId;
	private int parkNo;
	private int rating;
	private int reviewContent;
	
	public ReviewDTO(String userId, int parkNo, int rating, int reviewContent) {
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
	public int getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(int reviewContent) {
		this.reviewContent = reviewContent;
	}
	
}
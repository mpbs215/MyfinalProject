package kosta.mvc.model.dto;

public class UserDTO {
	
		private String userId;
		private String password;
		private String userName;
		private String email;
		private String hp;
		private String address;
		private String regidate;
		private int seller;
		
		//Join¿ë
		private ParkReserveDTO parkReserve;
		private ParkDTO park;
		private ParkRegiDTO parkRegi;
		private ReviewDTO review;
		
		public UserDTO(String userId, String password, String userName, String email, String hp, String address,
				String regidate, int seller, ParkReserveDTO parkReserve, ParkDTO park, ParkRegiDTO parkRegi,
				ReviewDTO review) {
			super();
			this.userId = userId;
			this.password = password;
			this.userName = userName;
			this.email = email;
			this.hp = hp;
			this.address = address;
			this.regidate = regidate;
			this.seller = seller;
			this.parkReserve = parkReserve;
			this.park = park;
			this.parkRegi = parkRegi;
			this.review = review;
		}
		public UserDTO() {
			super();
		}
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getHp() {
			return hp;
		}
		public void setHp(String hp) {
			this.hp = hp;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getRegidate() {
			return regidate;
		}
		public void setRegidate(String regidate) {
			this.regidate = regidate;
		}
		public int getSeller() {
			return seller;
		}
		public void setSeller(int seller) {
			this.seller = seller;
		}
		public ParkReserveDTO getParkReserve() {
			return parkReserve;
		}
		public void setParkReserve(ParkReserveDTO parkReserve) {
			this.parkReserve = parkReserve;
		}
		public ParkDTO getPark() {
			return park;
		}
		public void setPark(ParkDTO park) {
			this.park = park;
		}
		public ParkRegiDTO getParkRegi() {
			return parkRegi;
		}
		public void setParkRegi(ParkRegiDTO parkRegi) {
			this.parkRegi = parkRegi;
		}
		public ReviewDTO getReview() {
			return review;
		}
		public void setReview(ReviewDTO review) {
			this.review = review;
		}
}
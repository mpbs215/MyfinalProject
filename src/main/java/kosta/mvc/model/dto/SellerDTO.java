package kosta.mvc.model.dto;

public class SellerDTO {
	private String userId;
	private String Account;
	private String realName;
	
	public SellerDTO(String userId, String account, String realName) {
		super();
		this.userId = userId;
		Account = account;
		this.realName = realName;
	}

	public SellerDTO() {
		super();
	}
	
	
}

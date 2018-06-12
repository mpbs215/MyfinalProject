package kosta.mvc.model.dto;

public class TermsDTO {

	private int termsNo;
	private String termsSub;
	private String termsContent;
	public int getTermsNo() {
		return termsNo;
	}
	public void setTermsNo(int termsNo) {
		this.termsNo = termsNo;
	}
	public String getTermsSub() {
		return termsSub;
	}
	public void setTermsSub(String termsSub) {
		this.termsSub = termsSub;
	}
	public String getTermsContent() {
		return termsContent;
	}
	public void setTermsContent(String termsContent) {
		this.termsContent = termsContent;
	}
	public TermsDTO(int termsNo, String termsSub, String termsContent) {
		super();
		this.termsNo = termsNo;
		this.termsSub = termsSub;
		this.termsContent = termsContent;
	}
	public TermsDTO() {
		super();
	}
	
}

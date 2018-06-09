package kosta.mvc.model.dto;

public class TermsDTO {

	private int termsNo;
	private String termsSubject;
	private String termsContent;

	public TermsDTO() {
		super();
	}

	public TermsDTO(int termsNo, String termsSubject, String termsContent) {
		super();
		this.termsNo = termsNo;
		this.termsSubject = termsSubject;
		this.termsContent = termsContent;
	}

	public int getTermsNo() {
		return termsNo;
	}

	public void setTermsNo(int termsNo) {
		this.termsNo = termsNo;
	}

	public String getTermsSubject() {
		return termsSubject;
	}

	public void setTermsSubject(String termsSubject) {
		this.termsSubject = termsSubject;
	}

	public String getTermsContent() {
		return termsContent;
	}

	public void setTermsContent(String termsContent) {
		this.termsContent = termsContent;
	}

}

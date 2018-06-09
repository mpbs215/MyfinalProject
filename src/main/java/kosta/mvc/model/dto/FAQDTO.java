package kosta.mvc.model.dto;

public class FAQDTO {

	private int FAQNo;
	private String FAQSubject;
	private String FAQContent;

	public int getFAQNo() {
		return FAQNo;
	}

	public void setFAQNo(int fAQNo) {
		FAQNo = fAQNo;
	}

	public String getFAQSubject() {
		return FAQSubject;
	}

	public void setFAQSubject(String fAQSubject) {
		FAQSubject = fAQSubject;
	}

	public String getFAQContent() {
		return FAQContent;
	}

	public void setFAQContent(String fAQContent) {
		FAQContent = fAQContent;
	}

	public FAQDTO(int fAQNo, String fAQSubject, String fAQContent) {
		super();
		FAQNo = fAQNo;
		FAQSubject = fAQSubject;
		FAQContent = fAQContent;
	}

	public FAQDTO() {
		super();
	}

}

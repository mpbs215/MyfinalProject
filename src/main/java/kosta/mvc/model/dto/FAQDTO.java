package kosta.mvc.model.dto;

public class FAQDTO {

	private int FAQNo;
	private String FAQSub;
	private String FAQContent;
	public int getFAQNo() {
		return FAQNo;
	}
	public void setFAQNo(int fAQNo) {
		FAQNo = fAQNo;
	}
	public String getFAQSub() {
		return FAQSub;
	}
	public void setFAQSub(String fAQSub) {
		FAQSub = fAQSub;
	}
	public String getFAQContent() {
		return FAQContent;
	}
	public void setFAQContent(String fAQContent) {
		FAQContent = fAQContent;
	}
	public FAQDTO(int fAQNo, String fAQSub, String fAQContent) {
		super();
		FAQNo = fAQNo;
		FAQSub = fAQSub;
		FAQContent = fAQContent;
	}
	public FAQDTO() {
		super();
	}

}
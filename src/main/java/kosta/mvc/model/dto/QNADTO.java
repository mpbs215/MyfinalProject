package kosta.mvc.model.dto;

import org.springframework.web.multipart.MultipartFile;

public class QNADTO {

	private int QNANo;
	private String userId;
	private String QNASub;
	private String QNAContent;
	private String QNADT;
	private String QNAReview;
	private String QNAReviewDT;
	private int QNAHit;
	private int QNAPwd;
	private String QNAImage;
	private MultipartFile QNAImageFile;
	public QNADTO() {
		super();
	}
	public QNADTO(int qNANo, String userId, String qNASub, String qNAContent, String qNADT, String qNAReview,
			String qNAReviewDT, int qNAHit, int qNAPwd, String qNAImage, MultipartFile qNAImageFile) {
		QNANo = qNANo;
		this.userId = userId;
		QNASub = qNASub;
		QNAContent = qNAContent;
		QNADT = qNADT;
		QNAReview = qNAReview;
		QNAReviewDT = qNAReviewDT;
		QNAHit = qNAHit;
		QNAPwd = qNAPwd;
		QNAImage = qNAImage;
		QNAImageFile = qNAImageFile;
	}
	public int getQNANo() {
		return QNANo;
	}
	public void setQNANo(int qNANo) {
		QNANo = qNANo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getQNASub() {
		return QNASub;
	}
	public void setQNASub(String qNASub) {
		QNASub = qNASub;
	}
	public String getQNAContent() {
		return QNAContent;
	}
	public void setQNAContent(String qNAContent) {
		QNAContent = qNAContent;
	}
	public String getQNADT() {
		return QNADT;
	}
	public void setQNADT(String qNADT) {
		QNADT = qNADT;
	}
	public String getQNAReview() {
		return QNAReview;
	}
	public void setQNAReview(String qNAReview) {
		QNAReview = qNAReview;
	}
	public String getQNAReviewDT() {
		return QNAReviewDT;
	}
	public void setQNAReviewDT(String qNAReviewDT) {
		QNAReviewDT = qNAReviewDT;
	}
	public int getQNAHit() {
		return QNAHit;
	}
	public void setQNAHit(int qNAHit) {
		QNAHit = qNAHit;
	}
	public int getQNAPwd() {
		return QNAPwd;
	}
	public void setQNAPwd(int qNAPwd) {
		QNAPwd = qNAPwd;
	}
	public String getQNAImage() {
		return QNAImage;
	}
	public void setQNAImage(String qNAImage) {
		QNAImage = qNAImage;
	}
	public MultipartFile getQNAImageFile() {
		return QNAImageFile;
	}
	public void setQNAImageFile(MultipartFile qNAImageFile) {
		QNAImageFile = qNAImageFile;
	}

	
}

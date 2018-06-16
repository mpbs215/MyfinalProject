package kosta.mvc.model.dto;

import org.springframework.web.multipart.MultipartFile;

public class NoticeDTO {

	private int noticeNo;
	private String noticeSub;
	private String noticeDt;
	private String noticeContent;
	private int noticeHit;
	private String noticeImage;
	private MultipartFile noticeImageFile; // form 안의 file의 이름과 같아야 함.

	public NoticeDTO() {
	}

	public NoticeDTO(int noticeNo, String noticeSub, String noticeDt, String noticeContent, int noticeHit,
			String noticeImage, MultipartFile noticeImageFile) {
		super();
		this.noticeNo = noticeNo;
		this.noticeSub = noticeSub;
		this.noticeDt = noticeDt;
		this.noticeContent = noticeContent;
		this.noticeHit = noticeHit;
		this.noticeImage = noticeImage;
		this.noticeImageFile = noticeImageFile;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getNoticeSub() {
		return noticeSub;
	}

	public void setNoticeSub(String noticeSub) {
		this.noticeSub = noticeSub;
	}

	public String getNoticeDt() {
		return noticeDt;
	}

	public void setNoticeDt(String noticeDt) {
		this.noticeDt = noticeDt;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public int getNoticeHit() {
		return noticeHit;
	}

	public void setNoticeHit(int noticeHit) {
		this.noticeHit = noticeHit;
	}

	public String getNoticeImage() {
		return noticeImage;
	}

	public void setNoticeImage(String noticeImage) {
		this.noticeImage = noticeImage;
	}

	public MultipartFile getNoticeImageFile() {
		return noticeImageFile;
	}

	public void setNoticeImageFile(MultipartFile noticeImageFile) {
		this.noticeImageFile = noticeImageFile;
	}

}
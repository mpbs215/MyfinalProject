package kosta.mvc.model.dto;

import org.springframework.web.multipart.MultipartFile;

public class ParkImgDTO {
	private int imgNo;
	private int parkNo;
	private String imgPath;
	private MultipartFile files;
	
	public ParkImgDTO(int parkNo, String imgPath) {
		super();
		this.parkNo = parkNo;
		this.imgPath = imgPath;
	}
	public int getImgNo() {
		return imgNo;
	}
	public void setImgNo(int imgNo) {
		this.imgNo = imgNo;
	}
	public int getParkNo() {
		return parkNo;
	}
	public void setParkNo(int parkNo) {
		this.parkNo = parkNo;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public MultipartFile getFiles() {
		return files;
	}
	public void setFiles(MultipartFile files) {
		this.files = files;
	}
	public ParkImgDTO() {
		super();
	}	
	public ParkImgDTO(int imgNo, int parkNo, String imgPath, MultipartFile files) {
		super();
		this.imgNo=imgNo;
		this.parkNo = parkNo;
		this.imgPath = imgPath;
		this.files=files;
	}

}
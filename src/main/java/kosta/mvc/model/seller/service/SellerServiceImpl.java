package kosta.mvc.model.seller.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import kosta.mvc.model.dao.CarTypeDAO;
import kosta.mvc.model.dao.ParkDAO;
import kosta.mvc.model.dao.ParkImgDAO;
import kosta.mvc.model.dao.ParkReserveDAO;
import kosta.mvc.model.dao.RegiDAO;
import kosta.mvc.model.dto.CarTypeDTO;
import kosta.mvc.model.dto.ParkDTO;
import kosta.mvc.model.dto.ParkImgDTO;
import kosta.mvc.model.dto.ParkRegiDTO;
import kosta.mvc.model.dto.ParkReserveDTO;

@Transactional
@Service
public class SellerServiceImpl {

	@Autowired
	private RegiDAO regiDAO;
	@Autowired
	private ParkDAO parkDAO;
	@Autowired
	private ParkImgDAO parkImgDAO;
	@Autowired
	private CarTypeDAO carTypeDAO;
	@Autowired
	private ParkReserveDAO parkReserveDAO;

	public List<ParkReserveDTO> sellerReserveList(String userId) {
		return parkReserveDAO.sellerReserveList(userId);
	}

	public void sellerReserveDelete(int parkNo) {
		int re = parkReserveDAO.sellerReserveDelete(parkNo);
		if(re==0) {
			throw new RuntimeException();
		}
	}

	public List<ParkReserveDTO> sellerReserveListLoad(String userId) {
		return parkReserveDAO.sellerReserveListLoad(userId);
	}

	public List<ParkDTO> sellerParkList(String id) {
		return parkDAO.selectParkList(id);
	}

	public void sellerParkRegist(ParkDTO parkDto, CarTypeDTO carTypeDto, ParkImgDTO parkImgDto, ParkRegiDTO parkRegiDto, String imgPath, List<MultipartFile> mf) throws Exception{		
		
		// 시퀀스인 parkNo를 네개 테이블에 같은 값으로 넣기 위해. 
		int parkNo = parkDAO.selectParkNo();
		parkDto.setParkNo(parkNo);
		carTypeDto.setParkNo(parkNo);
		parkRegiDto.setParkNo(parkNo);
		parkImgDto.setParkNo(parkNo);
		
		int resultPark = parkDAO.insertPark(parkDto);
		System.out.println("resultPark"+resultPark);
		if(resultPark == 0) {
			throw new RuntimeException();
		}		
		
		int resultParkRegi = regiDAO.insertParkRegi(parkRegiDto);
		System.out.println("resultParkRegi"+resultParkRegi);
		if(resultParkRegi == 0) {
			throw new RuntimeException();
		}
		
		/** 차종, 대 수 */
		List<String> carTypeList = carTypeDto.getCarTypeList();
		List<Integer> maxCarList = carTypeDto.getMaxCarList();
				
		for(int i=0; i<carTypeList.size(); i++) {
			String carType = carTypeList.get(i);
			carTypeDto.setCarType(carType);
			System.out.println("=============carType="+carType);
			int maxCar = maxCarList.get(i);
			carTypeDto.setMaxCar(maxCar);
			System.out.println("=============maxCar="+maxCar);
			
			int resultCarType = carTypeDAO.insertCarType(carTypeDto); 
			System.out.println("resultCarType"+resultCarType);
			if(resultCarType == 0) {
				throw new RuntimeException();
			}
		}

			   
		/** 이미지 업로드 */		 
		MultipartFile file = null;
		String originalFilename = null; // 오리지널 파일 이름
		String fileName = null; // 파일이름 중복 막기위해 바꾼 이름(저장될 이름)
		double fileSize = 0; // 파일 사이즈
		//String fileExtension = null; // 파일 확장자
		int fileCnt = mf.size(); // 파일 개수
        	
		for(int i=0; i<mf.size(); i++) {
			
			file = mf.get(i);
			
			parkImgDto.setFiles(mf.get(i));
			
			originalFilename = mf.get(i).getOriginalFilename();
			fileName= System.currentTimeMillis() + "_" + originalFilename;			
			fileSize = mf.get(i).getSize();
			//fileExtension = FilenameUtils.getExtension(originalFilename).toLowerCase();
			
			parkImgDto.setImgPath(fileName);
						
			// DAO 호출
			int resultParkImg = parkImgDAO.insertImg(parkImgDto);
			System.out.println("resultParkImg"+resultParkImg);
			if(resultParkImg == 0) {
				throw new RuntimeException();
			}
						
			file.transferTo(new File(imgPath+ "/" + fileName));// 이미지 저장
		}
		
	}

	

	public int sellerParkDelete(int parkNo) {
		return parkDAO.sellerParkDelete(parkNo);
	}

	public int sellerParksDelete(int[] parkNos) {
		int count=0;
		for(int parkNo:parkNos) {
			int re=parkDAO.sellerParkDelete(parkNo);
			if(re==0) {
				throw new RuntimeException();
			}else {
				count++;
			}
		}
		return count;
	}
}
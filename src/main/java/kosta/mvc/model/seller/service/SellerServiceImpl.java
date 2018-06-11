package kosta.mvc.model.seller.service;

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
		return parkDAO.sellerParkList(id);
	}

	public void sellerParkRegist(ParkDTO parkDto, CarTypeDTO carTypeDto, ParkImgDTO parkImg, ParkRegiDTO parkRegi) {
		int resultPark = parkDAO.insertPark(parkDto);
		if (resultPark == 0) {
			throw new RuntimeException();
		}
		int resultParkRegi = regiDAO.insertParkRegi(parkDto);
		if (resultParkRegi == 0) {
			throw new RuntimeException();
		}
		for (String carType : carTypeDto.getCarTypes()) {
			if (carTypeDAO.insertCarType(carType, parkDto.getParkNo()) == 0) {
				throw new RuntimeException();
			}
		}
		for (MultipartFile file : parkImg.getFiles()) {
			if (parkImgDAO.insertImg(file.getOriginalFilename(), parkDto.getParkNo()) == 0) {
				throw new RuntimeException();
			}
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
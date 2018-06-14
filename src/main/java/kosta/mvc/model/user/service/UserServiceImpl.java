package kosta.mvc.model.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kosta.mvc.model.dao.ParkDAO;
import kosta.mvc.model.dao.ParkImgDAO;
import kosta.mvc.model.dao.ParkReserveDAO;
import kosta.mvc.model.dao.RegiDAO;
import kosta.mvc.model.dao.ReviewDAO;
import kosta.mvc.model.dao.UserDAO;
import kosta.mvc.model.dto.ParkDTO;
import kosta.mvc.model.dto.ParkImgDTO;
import kosta.mvc.model.dto.ParkRegiDTO;
import kosta.mvc.model.dto.ParkReserveDTO;
import kosta.mvc.model.dto.ReviewDTO;
import kosta.mvc.model.dto.UserDTO;

@Service
@Transactional
public class UserServiceImpl {

	@Autowired
	private ReviewDAO reviewDAO;
	@Autowired
	private ParkDAO parkDAO;
	@Autowired
	private ParkImgDAO parkImgDAO;
	@Autowired
	private RegiDAO regiDAO;
	@Autowired
	private ParkReserveDAO parkReserveDAO;
	@Autowired
	private UserDAO userDAO;

	public List<ReviewDTO> userClickReviewStar(int parkNo, int starNo) {
		return reviewDAO.userClickReviewStar(parkNo, starNo);
	}

	public ParkDTO selectOnePark(int parkNo) {
		return parkDAO.selectOnePark(parkNo);
	}

	public List<ReviewDTO> selectReview(int parkNo) {
		return reviewDAO.selectReview(parkNo);
	}

	public ParkRegiDTO selectOneParkRegi(int parkNo) {
		return regiDAO.selectOneParkRegi(parkNo);
	}

	public List<ParkReserveDTO> selectparkReserve(int parkNo) {
		return parkReserveDAO.selectparkReserve(parkNo);
	}

	public List<ParkDTO> userReserve() {
		return parkDAO.selectParkList(null);
	}

	public Map<String, Object> userReserveForm(int parkNo) {
		ParkDTO parkDTO = parkDAO.selectOnePark(parkNo);
		if(parkDTO==null) {
			throw new RuntimeException("해당 주차장은 존재하지 않습니다.");
		}
		ParkRegiDTO parkRegiDTO = regiDAO.selectOneParkRegi(parkNo);
		if(parkRegiDTO==null) {
			throw new RuntimeException("해당 주차장의 예약정보가 존재하지 않습니다.");
		}
		List<ParkReserveDTO> parkReserveList = parkReserveDAO.selectparkReserve(parkNo);
		List<ReviewDTO> reviewList = reviewDAO.selectReview(parkNo);
		List<ParkImgDTO> parkImageList = parkImgDAO.selectImage(parkNo);
		Map<String, Object> map = new HashMap<>();
		map.put("parkDTO", parkDTO);
		map.put("parkRegiDTO", parkRegiDTO);
		map.put("parkReserveList", parkReserveList);
		map.put("reviewList", reviewList);
		map.put("parkImageList", parkImageList);
		
		
		
		if(true) {
			
		}
		return map;
	}

	/**
	 * 회원정보 확인 및 수정
	 */

	public UserDTO selectUserInfo(String userId) {

		return userDAO.selectMemberById(userId);
	}

	public void updateUserInfo(UserDTO userDTO) {
		userDAO.updateUserInfo(userDTO);
	}

	public void insertReview(ReviewDTO dto) {
		int result=reviewDAO.insertReview(dto);
		if(result==0) {
			throw new RuntimeException("리뷰 등록에 실패하였습니다.");
		}
	}

}
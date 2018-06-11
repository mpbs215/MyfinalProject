package kosta.mvc.model.user.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosta.mvc.model.dao.ParkDAO;
import kosta.mvc.model.dao.ParkReserveDAO;
import kosta.mvc.model.dao.RegiDAO;
import kosta.mvc.model.dao.ReviewDAO;
import kosta.mvc.model.dao.UserDAO;
import kosta.mvc.model.dto.ParkDTO;
import kosta.mvc.model.dto.ParkRegiDTO;
import kosta.mvc.model.dto.ParkReserveDTO;
import kosta.mvc.model.dto.ReviewDTO;
import kosta.mvc.model.dto.UserDTO;

@Service
public class UserServiceImpl {
	
	@Autowired
	private ReviewDAO reviewDAO;
	@Autowired
	private ParkDAO parkDAO;
	@Autowired
	private RegiDAO regiDAO;
	@Autowired
	private ParkReserveDAO parkReserveDAO;
	@Autowired
	private UserDAO userDAO;

	public List<ReviewDTO> userClickReviewStar(int parkNo, int starNo) {
		return reviewDAO.userClickReviewStar(parkNo,starNo);
	}

	public ParkDTO selectOnePark(int parkNo) {
		return parkDAO.selectOnePark(parkNo);
	}

	public List<ReviewDTO> selectReview(int parkNo) {
		// TODO Auto-generated method stub
		return null;
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
		ParkDTO parkDTO=parkDAO.selectOnePark(parkNo);
		ParkRegiDTO parkRegiDTO = regiDAO.selectOneParkRegi(parkNo);
		List<ParkReserveDTO> parkReserveList = parkReserveDAO.selectparkReserve(parkNo);
		List<ReviewDTO> reviewList = reviewDAO.selectReview(parkNo);
		return null;
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

}
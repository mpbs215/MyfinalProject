package kosta.mvc.model.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosta.mvc.model.dao.ParkDAO;
import kosta.mvc.model.dao.ParkReserveDAO;
import kosta.mvc.model.dao.RegiDAO;
import kosta.mvc.model.dao.ReviewDAO;
import kosta.mvc.model.dto.ParkDTO;
import kosta.mvc.model.dto.ParkRegiDTO;
import kosta.mvc.model.dto.ParkReserveDTO;
import kosta.mvc.model.dto.ReviewDTO;

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

}
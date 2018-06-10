package kosta.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kosta.mvc.model.dto.ParkDTO;
import kosta.mvc.model.dto.ParkRegiDTO;
import kosta.mvc.model.dto.ParkReserveDTO;
import kosta.mvc.model.dto.ReviewDTO;
import kosta.mvc.model.dto.SearchFilterDTO;
import kosta.mvc.model.user.service.UserServiceImpl;

@RequestMapping("/user")
@Controller
public class UserController {

	@Autowired
	private UserServiceImpl service;

	@RequestMapping("/userReserve")
	public void userReserve() {
	}

	/*
	 * 검색 필터(지역, 구, 동, 날짜, 시간, 차종, 면적, 대를 클릭시) 검색
	 * 
	 */
	@RequestMapping("/userClickSearchPark")
	public ModelAndView userClickSearchPark(SearchFilterDTO searchFilterDTO) {

		return null;
	}

	/*
	 * 키워드와 키필드(주소, 내용, 날짜)
	 */
	@RequestMapping("/userStringSearchPark")
	public ModelAndView userStringSearchPark(String keyWord, String keyField) {
		return null;
	}

	/*
	 * 주차장 예약하기 폼으로 이동 return : parkDTO , List<reviewDTO>,List<parkRegiDTO>
	 */
	@RequestMapping("/userReserveForm")
	public ModelAndView userReserveForm(int parkNo) {
		ModelAndView mv = new ModelAndView();
		ParkDTO parkDto = service.selectOnePark(parkNo);
		ParkRegiDTO  parkRegiDto= service.selectOneParkRegi(parkNo);
		List<ParkReserveDTO> parkReserveList = service.selectparkReserve(parkNo);
		List<ReviewDTO> reviewList = service.selectReview(parkNo);
		return null;
	}

	/*
	 * 리뷰 별점 갯수 클릭시 AJAX로 리뷰 리스트 갱신
	 */
	@RequestMapping("/userClickReviewStar")
	@ResponseBody
	public List<ReviewDTO> userClickReviewStar(int parkNo, int starNo) {
		return service. userClickReviewStar(parkNo,starNo);
	}

	//////////////

}
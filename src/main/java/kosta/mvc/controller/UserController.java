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
import kosta.mvc.model.dto.UserDTO;
import kosta.mvc.model.user.service.UserServiceImpl;

@RequestMapping("/user")
@Controller
public class UserController {

	@Autowired
	private UserServiceImpl service;
	
	/**
	 * 주차장 예약 초기페이지
	 */
	@RequestMapping("/userReserve")
	public ModelAndView userReserve() {
		ModelAndView mv = new ModelAndView();
		List<ParkDTO> list=service.userReserve();
		return mv;
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
		ParkDTO parkDTO = service.selectOnePark(parkNo);
		ParkRegiDTO parkRegiDTO = service.selectOneParkRegi(parkNo);
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
		return service.userClickReviewStar(parkNo, starNo);
	}

	/**
	 * 마이페이지 회원정보 수정 폼으로 이동했을때 시행 request:userId
	 * 
	 * @return ModelAndView에 유저아이디에 해당하는 DTO 정보세팅
	 */
	@RequestMapping("/userModifyUserForm")
	public ModelAndView userModifyUserForm(String userId) {
		return null;
	}

	/**
	 * 실제 회원정보 수정 페이지에서 수정버튼 클릭시 작업
	 * 
	 * @param userDto
	 * @return userModifyUserForm호출
	 */
	@RequestMapping("/userModifyUser")
	public ModelAndView userModifyUser(UserDTO userDTO) {

		return null;
	}

}
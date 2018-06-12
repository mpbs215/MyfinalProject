package kosta.mvc.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
	
	@Autowired
	private PasswordEncoder passwordEncoder;
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
		Map<String, Object> dataMap = service.userReserveForm(parkNo);
		mv.addObject("parkDTO",dataMap.get("parkDTO"));
		mv.addObject("parkRegiDTO",dataMap.get("parkRegiDTO"));
		mv.addObject("parkReserveList",dataMap.get("parkReserveList"));
		mv.addObject("reviewList",dataMap.get("reviewList"));
		mv.setViewName("user/userReserveForm");
		return mv;
	}
	
	@RequestMapping("/insert")
	public String insertReview(ReviewDTO dto) {
		service.insertReview(dto);
		return "redirect:/user/userReserveForm";
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

	/*
	 * UserDTO
	 * userDTO=(UserDTO)SecurityContextHolder.getContext().getAuthentication().
	 * getPrincipal(); 이거 써주시고 DTO에서 id를 가져오면 됩니다.
	 */
	@RequestMapping("/userModifyUserForm")
	public ModelAndView userModifyUserForm(HttpServletRequest request) {
		String id = request.getParameter("userId");
		UserDTO userDTO = service.selectUserInfo(id);
		return new ModelAndView("User/userModifyUserForm", "userDTO", userDTO);
	}

	/**
	 * 실제 회원정보 수정 페이지에서 수정버튼 클릭시 작업
	 * 
	 * @param userDto
	 * @return userModifyUserForm호출
	 */
	@RequestMapping("/userModifyUser")
	public ModelAndView userModifyUser(HttpServletRequest request, UserDTO userDTO) {
		// System.out.println("1. UserDTO :: "+userDTO);
		// 회원정보 수정위해 Spring Security 세션 회원정보를 반환받는다
		UserDTO uDTO = (UserDTO)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		// System.out.println("2. Spring Security 세션 수정 전 회원정보:" + uDTO);

		// 변경할 비밀번호를 암호화한다
		String encodePassword = passwordEncoder.encode(userDTO.getPassword());
		userDTO.setPassword(encodePassword);
		service.updateUserInfo(userDTO);

		// 수정버튼 클릭 처리
		
		// 수정한 회원정보로 Spring Security 세션 회원정보를 업데이트한다
		uDTO.setPassword(encodePassword);
		uDTO.setUserName(userDTO.getUserName());
		uDTO.setAddress(userDTO.getAddress());
		//System.out.println("3. Spring Security 세션 수정 후 회원정보:" + pvo);

		return new ModelAndView("User/userModifyUserForm");
	}

}
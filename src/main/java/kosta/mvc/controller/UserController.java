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
		mv.addObject("parkImageList", dataMap.get("parkImageList"));
		mv.addObject("carTypeList",dataMap.get("carTypeList"));
		mv.setViewName("User/userReserveForm");
		return mv;
	}
	
	@RequestMapping("/insertReview")
	public String insertReview(ReviewDTO dto) {
		UserDTO userDTO = (UserDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		dto.setUserId(userDTO.getUserId());
		service.insertReview(dto);
		return "redirect:/user/userReserveForm?parkNo="+dto.getParkNo();
	}

	/*
	 * 리뷰 별점 갯수 클릭시 AJAX로 리뷰 리스트 갱신
	 */
	@RequestMapping("/userClickReviewStar")
	@ResponseBody
	public List<ReviewDTO> userClickReviewStar(int parkNo, int rating) {
		List<ReviewDTO> list=service.userClickReviewStar(parkNo, rating);
		for(ReviewDTO dto:list) {
			System.out.println(dto.getUserId());
		}
		return list;
	}
	

	@RequestMapping("/reservation")
	public String reservation(ParkReserveDTO dto) {
		//UserDTO userDTO = (UserDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		//dto.setUserId(userDTO.getUserId());
		dto.setUserId("customer");
		System.out.println(dto);
		service.insertReserve(dto);
		return "redirect:/user/userMypageReserveList";
	}
	
	@ResponseBody
	@RequestMapping(value="/reserveCheck",produces="text/plain;charset=UTF-8")
	public String reserveCheck(ParkReserveDTO dto) {
		System.out.println("컨트롤러 호출됨");
		System.out.println(dto);
		//UserDTO userDTO = (UserDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		//dto.setUserId(userDTO.getUserId());
		return service.reserveCheck(dto);
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
		String id = (String)(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		UserDTO dto = service.selectUserInfo(id);
		return new ModelAndView("User/userModifyUserForm", "dto", dto);
	}

	/**
	 * 실제 회원정보 수정 페이지에서 수정버튼 클릭시 작업
	 * 
	 * @param userDto
	 * @return userModifyUserForm호출
	 */
	@RequestMapping("/userModifyUser")
	public ModelAndView userModifyUser(UserDTO userDTO) {
		// 회원정보 수정위해 Spring Security 세션 회원정보를 반환받는다
		UserDTO uDTO = (UserDTO)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		userDTO.setUserId(uDTO.getUserId());

		// 변경할 비밀번호를 암호화한다
		String encodePassword = passwordEncoder.encode(userDTO.getPassword());
		userDTO.setPassword(encodePassword);
		

		// 수정버튼 클릭 처리
		service.updateUserInfo(userDTO);

		return new ModelAndView("User/userModifyUserForm");
	}
	
	/**
	 * 마이페이지 예약목록
	 */
	@RequestMapping("/userMypageReserveList")
	public ModelAndView regiParkLoad(){
		ModelAndView mv = new ModelAndView();
		UserDTO userDTO = (UserDTO)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<ParkReserveDTO> list = service.userMypageReserveList(userDTO.getUserId());
		mv.setViewName("User/userMypageReserveList");
		mv.addObject("list",list);
		return mv;
	}
	
	@RequestMapping("/logout")
	public String logout() {
		return "redirect:/";
	}
}
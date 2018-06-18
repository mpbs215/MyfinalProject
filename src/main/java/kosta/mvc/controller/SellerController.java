package kosta.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import kosta.mvc.model.dto.CarTypeDTO;
import kosta.mvc.model.dto.ParkDTO;
import kosta.mvc.model.dto.ParkImgDTO;
import kosta.mvc.model.dto.ParkRegiDTO;
import kosta.mvc.model.dto.ParkReserveDTO;
import kosta.mvc.model.dto.UserDTO;
import kosta.mvc.model.seller.service.SellerServiceImpl;

@RequestMapping("/seller")
@Controller
public class SellerController {

	@Autowired
	private SellerServiceImpl service;
	
	UserDTO userDTO=(UserDTO)SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 

	private String imgPath;

	/**
	 * request : 세션 아이디
	 * 
	 * @return 자신의 주차장 레코드리스트
	 */
	@RequestMapping("/sellerParkList")
	public String sellerParkList() {
		return "Seller/sellerParkList";
	}

	@ResponseBody
	@RequestMapping
	public List<ParkDTO> sellerParkListLoad() {
		UserDTO userDTO = (UserDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<ParkDTO> list = service.sellerParkList(userDTO.getUserId());
		return list;
	}

	@ResponseBody
	@RequestMapping("/sellerParkDelete")
	public int sellerParkDelete(int parkNo) {
		return service.sellerParkDelete(parkNo);
	}

	@ResponseBody
	@RequestMapping("/sellerParksDelete")
	public int sellerParksDelete(int[] parkNos) {
		return service.sellerParksDelete(parkNos);
	}

	/**
	 * 주차장 등록 폼으로 이동
	 */
	@RequestMapping("/sellerParkRegistForm")
	public void sellerParkRegistForm() {
	}

	/**
	 * 주차장 등록하기
	 * 
	 * @param parkDto
	 *            주차장정보
	 * @return
	 */
	@RequestMapping("/sellerParkRegist")
	public ModelAndView sellerParkRegist(HttpSession session, ParkDTO parkDto, CarTypeDTO carTypeDto, ParkImgDTO parkImgDto, ParkRegiDTO parkRegiDto, MultipartHttpServletRequest req) throws Exception{
		
		
		ModelAndView mv = new ModelAndView();

		parkDto.setUserId(userDTO.getUserId());

		//멀티 파일 업로드
		List<MultipartFile> mf = req.getFiles("files");		
		imgPath = session.getServletContext().getRealPath("/resources/images/park");// 파일 저장 폴더 경로

		service.sellerParkRegist(parkDto, carTypeDto, parkImgDto, parkRegiDto, imgPath, mf);
	
		mv.setViewName("redirect:/Seller/sellerParkList");
		return mv;
	}

	/**
	 * 주소 검색창 오픈
	 */
	@RequestMapping("/addrPopup")
	public void addrPopup() {}
	
	/**
	 * request : 세션 id
	 * 
	 * @return 지난예약상황 리스트
	 */
	@RequestMapping("/sellerReserveList")
	public ModelAndView sellerReserveList(String userId) {
		ModelAndView mv = new ModelAndView();
		UserDTO userDTO = (UserDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<ParkReserveDTO> list = service.sellerReserveList(userDTO.getUserId());
		mv.addObject("list", list);
		return mv;
	}

	/**
	 * 예약상황 페이지에서 현재 예약상황 테이블 레코드 호출
	 */
	@ResponseBody
	@RequestMapping("/sellerReserveListLoad")
	public List<ParkReserveDTO> sellerReserveListLoad() {
		UserDTO userDTO = (UserDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<ParkReserveDTO> list = service.sellerReserveListLoad(userDTO.getUserId());
		return list;
	}

	/**
	 * request: parkNo result: 0-실패, 1-성공 예약상황 페이지에서 취소 버튼클릭시
	 */
	@ResponseBody
	@RequestMapping("/sellerReserveDelete")
	public void sellerReserveDelete(int reserveNo) {
		service.sellerReserveDelete(reserveNo);
	}
}
package kosta.mvc.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import kosta.mvc.model.dto.SearchFilterDTO;
import kosta.mvc.model.dto.UserDTO;
import kosta.mvc.model.seller.service.SellerServiceImpl;

@RequestMapping("/seller")
@Controller
public class SellerController {

	@Autowired
	private SellerServiceImpl service;
	

	private String imgPath;

	/**
	 * 등록한 주차장 레코드리스트
	 */

	@RequestMapping("/sellerParkList")
	public String sellerParkList(Model model) {
		
		UserDTO userDTO = (UserDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<ParkDTO> parkList =  service.sellerParkList(userDTO.getUserId());
		
		model.addAttribute("sellerParkList", parkList);
			
		return "seller/sellerParkList";
	}

	/**
	 * 주차장 리스트에서 삭제 버튼 클릭 후 리스트 리로드
	 * 
	 * 수정 필요!!!
	 */
/*	@ResponseBody
	@RequestMapping
	public List<ParkDTO> sellerParkListReload() {
		UserDTO userDTO = (UserDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<ParkDTO> list = service.sellerParkList(userDTO.getUserId());
		return list;
	}*/

	/**
	 * 주차장 하나 삭제
	 */
	@ResponseBody
	@RequestMapping("/sellerParkDelete")
	public int sellerParkDelete(String pNo) {
		int parkNo = Integer.parseInt(pNo);
		return service.sellerParkDelete(parkNo);
	}

	/**
	 * 주차장 여러개 삭제
	 */
	@ResponseBody
	@RequestMapping("/sellerParksDelete")
	public int sellerParksDelete(List<String> parkNos) {
		
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
	 */
	@RequestMapping("/sellerParkRegist")
	public ModelAndView sellerParkRegist(HttpSession session, ParkDTO parkDto, CarTypeDTO carTypeDto, ParkImgDTO parkImgDto, ParkRegiDTO parkRegiDto, MultipartHttpServletRequest req) throws Exception{
		
		UserDTO userDTO=(UserDTO)SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
		ModelAndView mv = new ModelAndView();
		
		parkDto.setUserId(userDTO.getUserId());

		//멀티 파일 업로드
		List<MultipartFile> mf = req.getFiles("files");		
		imgPath = session.getServletContext().getRealPath("/resources/images/park");// 파일 저장 폴더 경로

		service.sellerParkRegist(parkDto, carTypeDto, parkImgDto, parkRegiDto, imgPath, mf);
	
		mv.setViewName("redirect:/seller/sellerParkList");
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
	 * @return 예약 리스트
	 */
	@RequestMapping("/sellerReserveList")
	public ModelAndView sellerReserveList() {
		ModelAndView mv = new ModelAndView();
		UserDTO userDTO = (UserDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		// 지난 예약
		List<ParkReserveDTO> list = service.sellerReserveList(userDTO.getUserId());
		mv.addObject("reserveList", list);
		// 현재 예약 상황
		List<ParkReserveDTO> listLoad = service.sellerReserveListLoad(userDTO.getUserId());
		mv.addObject("reserveListLoad", listLoad);
		return mv;
	}

	/**
	 * 예약상황 페이지에서 취소 버튼클릭시
	 * request: parkNo result: 0-실패, 1-성공 
	 */
	@ResponseBody
	@RequestMapping("/sellerReserveDelete")
	public void sellerReserveDelete(int reserveNo) {
		service.sellerReserveDelete(reserveNo);
	}
}
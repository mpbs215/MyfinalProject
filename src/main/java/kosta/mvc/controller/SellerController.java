package kosta.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kosta.mvc.model.dto.CarTypeDTO;
import kosta.mvc.model.dto.ParkDTO;
import kosta.mvc.model.dto.ParkImgDTO;
import kosta.mvc.model.dto.ParkRegiDTO;
import kosta.mvc.model.dto.ParkReserveDTO;
import kosta.mvc.model.seller.service.SellerServiceImpl;

@RequestMapping("/seller")
@Controller
public class SellerController {
	
	@Autowired
	private SellerServiceImpl service;
	
	/**
	 * request : 세션 아이디
	 * @return 자신의 주차장 레코드리스트
	 */
	@RequestMapping("/sellerParkList")
	public String sellerParkList(String id) {		
		return "Seller/sellerParkList";
	}
	
	@ResponseBody
	@RequestMapping
	public List<ParkDTO> sellerParkListLoad(String id){
		List<ParkDTO> list=service.sellerParkList(id);
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
	
	@RequestMapping("/sellerParkRegistForm")
	public void sellerParkRegistForm() {}
	
	/**
	 * 주차장 등록하기
	 * @param parkDto 주차장정보
	 * @return
	 */
	@RequestMapping("/sellerParkRegist")
	public ModelAndView sellerParkRegist(ParkDTO parkDto,CarTypeDTO carTypeDto,ParkImgDTO parkImg,ParkRegiDTO parkRegi) {
		ModelAndView mv = new ModelAndView();
		
		service.sellerParkRegist(parkDto,carTypeDto,parkImg,parkRegi);
		
		mv.setViewName("redirect:/seller/sellerParkList");
		return mv;
	}
	
	/**
	 * request : 세션 id
	 * @return 지난예약상황 리스트
	 */
	@RequestMapping("/sellerReserveList")
	public ModelAndView sellerReserveList(String userId) {
		ModelAndView mv = new ModelAndView();
		List<ParkReserveDTO> list=service.sellerReserveList(userId);
		return mv;
	}
	
	/**
	 * 예약상황 페이지에서 현재 예약상황 테이블 레코드 호출
	 */
	@ResponseBody
	@RequestMapping("/sellerReserveListLoad")
	public List<ParkReserveDTO> sellerReserveListLoad(String userId) {
		List<ParkReserveDTO> list=service.sellerReserveListLoad(userId);
		return list;
	}

	/**
	 * request: parkNo
	 * result: 0-실패, 1-성공
	 * 예약상황 페이지에서 취소 버튼클릭시
	 */
	@ResponseBody
	@RequestMapping("/sellerReserveDelete")
	public void sellerReserveDelete(int reserveNo) {
		service.sellerReserveDelete(reserveNo);
	}
}
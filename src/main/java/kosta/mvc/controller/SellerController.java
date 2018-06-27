package kosta.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	

	private String imgPath;

	/**
	 * 등록한 주차장 레코드리스트
	 */
	@RequestMapping("/sellerParkList")
	public String sellerParkList(Model model) {
		UserDTO userDTO = (UserDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<ParkDTO> parkList = service.sellerParkList(userDTO.getUserId());
		
		model.addAttribute("sellerParkList", parkList);
			
		return "seller/sellerParkList";
		
	/* 페이지네이션 주석 처리
	 * public ModelAndView sellerParkList(HttpServletRequest request) {	
		
		UserDTO userDTO = (UserDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = userDTO.getUserId();
		
		
		 * 페이지네이션
		 
		int numPerPage = 10; // 한 페이지당 글 개수
		int cPage; // 클릭된 페이지 번호
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		} catch (NumberFormatException e) {
			cPage = 1;
		}

		// 2.3 페이징바 만들기
		int totalQNA = service.parkCnt(userId, cPage, numPerPage); // 총 게시물 개수

		int totalPage = (int) Math.ceil((double) totalQNA / numPerPage); // 게시물 개수 기반 페이지 수 구하기
		String pageBar = "";
		int pageBarSize = 5; // 한번에 보이는 페이지 개수
		
		// 시작페이지 no - 다음버튼 눌렀을 때 나오는 맨 앞 페이지 숫자
		int pageNo;
		pageNo = (int) (Math.ceil(((double) cPage / pageBarSize) - 1) * pageBarSize) + 1;

		// 종료페이지 no - 다음버튼 앞 페이지 숫자
		int pageEnd = pageNo + pageBarSize - 1;

		pageBar += "<ul class='pagination justify-content-center pagination-sm'>";

		// [이전]
		if (pageNo == 1) {
			// 이전버튼 필요없음
			pageBar += "<li class='page-item disabled'>";
			pageBar += "<a class='page-link' href='#' tabindex='-1'>이전</a>";
			pageBar += "</li>";
		} else {
			pageBar += "<li class='page-item'>";
			pageBar += "<a class='page-link' href=" + request.getContextPath() + "/seller/sellerParkList?cPage=" + (pageNo - 1)
					+ "><span>[이전]</span></a>";
			pageBar += "</li>";
		}

		// [pageNo] - 페이지 다섯개에 대한 링크(페이지 이동)
		while (pageNo <= pageEnd && pageNo <= totalPage) {
			if (pageNo == cPage) {
				pageBar += "<li class='page-item active'>";
				pageBar += "<a class='page-link'>" + pageNo + "</a>";
				pageBar += "</li>";
			} else {
				pageBar += "<li class='page-item'>";
				pageBar += "<a class='page-link' href =" + request.getContextPath() + "/seller/sellerParkList?cPage=" + pageNo + "> <span>" + pageNo + "</span></a>";
				pageBar += "</li>";
			}

			pageNo++;
		}
		// [다음]

		if (pageNo > totalPage) {
			pageBar += "<li class='page-item disabled'>";
	         pageBar += "<a class='page-link' href='#'>다음</a>";
	         pageBar += "</li>";
		} else {
			pageBar += "<li class='page-item'>";
			pageBar += "<a class='page-link' href=" + request.getContextPath() + "/seller/sellerParkList?cPage=" + (pageNo)
					+ "><span>[다음]</span></a>";
			pageBar += "</li>";
		}

		pageBar += "</ul>";
		
		ModelAndView mv = new ModelAndView();
		List<ParkDTO> list = service.sellerParkList(userId, cPage, numPerPage);	
		mv.setViewName("seller/sellerParkList");
		mv.addObject("sellerParkList", list);
		mv.addObject("pageBar", pageBar);

		return mv;*/
	}

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
	public int sellerParksDelete(@RequestParam(value="pNos[]") List<String> parkNos) {
		
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
	 * @throws Exception 
	 */
	@RequestMapping(value="/sellerParkRegist", method=RequestMethod.POST)
	public ModelAndView sellerParkRegist(HttpSession session,ParkDTO parkDto, CarTypeDTO carTypeDto, ParkImgDTO parkImgDto, ParkRegiDTO parkRegiDto,MultipartHttpServletRequest req) throws Exception{
		System.out.println("주차장등록 컨트롤러 진입");
		UserDTO userDTO=(UserDTO)SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
		ModelAndView mv = new ModelAndView();
		System.out.println(userDTO.getUserId());
		parkDto.setUserId(userDTO.getUserId());

		//멀티 파일 업로드
		List<MultipartFile> mf = req.getFiles("files");		
		imgPath = session.getServletContext().getRealPath("/resources/images/park");// 파일 저장 폴더 경로

		service.sellerParkRegist(parkDto, carTypeDto, parkImgDto, parkRegiDto, imgPath, mf);
	
		mv.setViewName("redirect:/seller/sellerParkList");
		return mv;
	}
	
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
	
	@RequestMapping("/sellerStats")
	public void sellerStats() {
		
	}
	
	@ResponseBody
	@RequestMapping("/callStats")
	public List<ParkDTO> callStats(String startDate,String endDate) {
		UserDTO userDTO = (UserDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return service.callStats(startDate,endDate,userDTO.getUserId());
	}
}
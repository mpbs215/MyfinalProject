package kosta.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kosta.mvc.model.admin.service.FaqService;
import kosta.mvc.model.admin.service.ManageUserService;
import kosta.mvc.model.admin.service.NoticeService;
import kosta.mvc.model.admin.service.QnaReviewService;
import kosta.mvc.model.admin.service.QnaService;
import kosta.mvc.model.admin.service.TermsService;
import kosta.mvc.model.dto.UserDTO;

@RequestMapping("/admin")
@Controller
public class AdminController {

	@Autowired
	private FaqService faqService;

	@Autowired
	private ManageUserService manageUserService;

	@Autowired
	private NoticeService noticeService;

	@Autowired
	private QnaReviewService qnaReviewService;

	@Autowired
	private QnaService qnaService;

	@Autowired
	private TermsService termsService;

	@RequestMapping("/manageUser")
	public void manageUser() {
	}

	/**
	 * Ajax로 유저리스트 호출
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/manageUserList")
	public List<UserDTO> manageUserList() {
		return manageUserService.manageUserList();
	}

	/**
	 * 유저 한명 강퇴 request: 유저번호
	 * 
	 * @return 삭제결과
	 */
	@ResponseBody
	@RequestMapping("/manageUserDelete")
	public int manageUserDelete(int userNo) {
		return 00;
	}

	/**
	 * 유저 여러명 동시 강퇴
	 * 
	 * @param userNo
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/manageUserMultiDelete")
	public int manageUserMultiDelete(int userNo[]) {
		return 0;
	}

	@ResponseBody
	@RequestMapping("/manageUserSearch")
	public List<UserDTO> manageUserSearch(String keyword) {
		return null;
	}

	/**
	 * @param userId
	 *            유저 아이디
	 * @return 회원 한명 DTO 정보
	 */
	@RequestMapping("/manageUserDetail")
	public ModelAndView manageUserDetail(String userId) {
		// 이용내역보기, 판매정보보기 추가예정
		return null;
	}

}
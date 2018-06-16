package kosta.mvc.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kosta.mvc.model.admin.service.FaqService;
import kosta.mvc.model.admin.service.ManageUserService;
import kosta.mvc.model.admin.service.NoticeService;
import kosta.mvc.model.admin.service.QnaReviewService;
import kosta.mvc.model.admin.service.QnaService;
import kosta.mvc.model.admin.service.TermsService;
import kosta.mvc.model.dto.FAQDTO;
import kosta.mvc.model.dto.NoticeDTO;
import kosta.mvc.model.dto.TermsDTO;
import kosta.mvc.model.dto.UserDTO;

@RequestMapping("/admin")
@Controller
public class AdminController {

	String savePath = "";
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

	/**
	 * updateForm으로 이동하여 해당 Terms 수정
	 */

	@RequestMapping("/updateTerms/{termsNo}")
	public ModelAndView termsUpdateForm(@PathVariable int termsNo) {
		ModelAndView mv = new ModelAndView();
		TermsDTO termsDTO = termsService.updateFormTerms(termsNo);
		mv.addObject("termsDTO", termsDTO);
		mv.setViewName("common/termsUpdateForm");
		return mv;
	}

	@RequestMapping("/updateTerms")
	public ModelAndView updateTerms(TermsDTO termsDTO) {
		ModelAndView mv = new ModelAndView();
		int result = termsService.updateTerms(termsDTO);
		mv.setViewName("redirect:/common/terms");
		return mv;
	}

	@RequestMapping("/insertTermsForm")
	public String insertTermsForm() {
		return "common/insertTermsForm";
	}

	@RequestMapping("/insertTerms")
	public ModelAndView insertTerms(TermsDTO termsDTO) {
		ModelAndView mv = new ModelAndView();
		int result = termsService.insertTerms(termsDTO);
		mv.setViewName("redirect:/common/terms");
		return mv;
	}

	@RequestMapping("/deleteTerms/{termsNo}")
	public ModelAndView deleteTerms(@PathVariable int termsNo) {
		ModelAndView mv = new ModelAndView();
		int result = termsService.deleteTerms(termsNo);
		mv.setViewName("redirect:/common/terms");
		return mv;
	}

	@RequestMapping("/insertFAQForm")
	public String insertFAQForm() {
		return "common/insertFAQForm";
	}

	@RequestMapping("/insertFAQ")
	public ModelAndView insertFAQ(FAQDTO faqDTO) {
		ModelAndView mv = new ModelAndView();
		int result = faqService.insertFAQ(faqDTO);
		mv.setViewName("redirect:/common/faq");
		return mv;
	}

	@RequestMapping("/updateFAQ/{FAQNo}")
	public ModelAndView updateFAQ(@PathVariable int FAQNo) {
		ModelAndView mv = new ModelAndView();
		FAQDTO faqDTO = faqService.updateFAQ(FAQNo);
		mv.addObject("faqDTO", faqDTO);
		mv.setViewName("common/faqUpdateForm");
		return mv;
	}

	@RequestMapping("/updateFAQ")
	public ModelAndView updateFAQ(FAQDTO faqDTO) {
		ModelAndView mv = new ModelAndView();
		int result = faqService.updateFAQ(faqDTO);
		mv.setViewName("redirect:/common/faq");
		return mv;
	}

	@RequestMapping("/deleteFAQ/{FAQNo}")
	public ModelAndView deleteFAQ(@PathVariable int FAQNo) {
		ModelAndView mv = new ModelAndView();
		int result = faqService.deleteFAQ(FAQNo);
		mv.setViewName("redirect:/common/faq");
		return mv;
	}

	@RequestMapping("/insertNoticeForm")
	public String insertNoticeForm() {
		return "common/insertNoticeForm";
	}

	@RequestMapping("/insertNotice")
	public String insertNotice(HttpSession session, NoticeDTO noticeDTO) throws Exception {
		MultipartFile file = noticeDTO.getNoticeImageFile();
		String now = new SimpleDateFormat("yyyyMMddHmsS").format(new Date()); // 현재시간
		String fileOriginalName = file.getOriginalFilename();

		if (file.getSize() > 0) {
			if (fileOriginalName.substring(fileOriginalName.length() - 3, fileOriginalName.length()).toLowerCase()
					.equals("jpg")
					|| fileOriginalName.substring(fileOriginalName.length() - 3, fileOriginalName.length())
							.toLowerCase().equals("png")
					|| fileOriginalName.substring(fileOriginalName.length() - 4, fileOriginalName.length())
							.toLowerCase().equals("jppg")) {
				savePath = session.getServletContext().getRealPath("/resources/images/notice");
				file.transferTo(new File(savePath + "/" + now + file.getOriginalFilename()));
				noticeDTO.setNoticeImage(now + file.getOriginalFilename());
			}
		}
		// insert 호출하기
		noticeService.insertNotice(noticeDTO);
		// redirect:list 이동
		return "redirect:/common/notice";
	}

	@RequestMapping("/deleteNotice/{noticeNo}")
	public ModelAndView deleteNotice(@PathVariable int noticeNo) {
		ModelAndView mv = new ModelAndView();
		int result = noticeService.deleteNotice(noticeNo);
		mv.setViewName("redirect:/common/notice");
		return mv;
	}

	@RequestMapping("/updateNotice/{noticeNo}")
	public ModelAndView updateNotice(@PathVariable int noticeNo) {
		ModelAndView mv = new ModelAndView();
		NoticeDTO noticeDTO = noticeService.noticeUpdateForm(noticeNo);
		mv.addObject(noticeDTO);
		mv.setViewName("common/noticeUpdateForm");
		return mv;
	}

	@RequestMapping("/updateNotice")
	public ModelAndView updateNotice(HttpSession session, NoticeDTO noticeDTO)
			throws IllegalStateException, IOException {
		ModelAndView mv = new ModelAndView();
		MultipartFile file = noticeDTO.getNoticeImageFile();
		String now = new SimpleDateFormat("yyyyMMddHmsS").format(new Date()); // 현재시간
		String fileOriginalName = file.getOriginalFilename();

		if (file.getSize() > 0) {
			if (fileOriginalName.substring(fileOriginalName.length() - 3, fileOriginalName.length()).toLowerCase()
					.equals("jpg")
					|| fileOriginalName.substring(fileOriginalName.length() - 3, fileOriginalName.length())
							.toLowerCase().equals("png")
					|| fileOriginalName.substring(fileOriginalName.length() - 4, fileOriginalName.length())
							.toLowerCase().equals("jppg")) {
				savePath = session.getServletContext().getRealPath("/resources/images/notice");
				file.transferTo(new File(savePath + "/" + now + file.getOriginalFilename()));
				noticeDTO.setNoticeImage(now + file.getOriginalFilename());
			}
		}

		int result = noticeService.noticeUpdate(noticeDTO);
		mv.setViewName("redirect:/common/notice");
		return mv;

	}
}
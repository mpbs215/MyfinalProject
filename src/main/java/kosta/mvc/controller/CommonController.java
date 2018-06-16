package kosta.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kosta.mvc.model.common.service.CommonService;
import kosta.mvc.model.dto.FAQDTO;
import kosta.mvc.model.dto.NoticeDTO;
import kosta.mvc.model.dto.QNADTO;
import kosta.mvc.model.dto.TermsDTO;
import kosta.mvc.model.dto.UserDTO;

@RequestMapping("/common")
@Controller
public class CommonController {

	UserDTO userDTO = new UserDTO();

	@Autowired
	private CommonService commonService;

	/**
	 * @return FAQ 테이블의 리스트
	 */
	@RequestMapping("/faq")
	public ModelAndView faq() {
		ModelAndView mv = new ModelAndView();
		List<FAQDTO> list = commonService.selectFAQAll();
		mv.addObject("list", list);
		mv.setViewName("common/faq");
		return mv;
	}

	/**
	 * 서비스안내 메인페이지로 이동
	 */
	@RequestMapping("/introduce")
	public void introduce() {
	}

	/**
	 * 서비스이용안내 페이지로 이동
	 */
	@RequestMapping("/serviceInfo")
	public void serviceInfo() {
	}

	/**
	 * 이용약관 페이지 이동
	 */
	@RequestMapping("/terms")
	public ModelAndView terms() {
		ModelAndView mv = new ModelAndView();
		List<TermsDTO> list = commonService.selectTerms();
		mv.addObject("list", list);
		mv.setViewName("common/terms");
		return mv;
	}

	/**
	 * 공지사항 페이지로 이동
	 * 
	 * @return 공지사항 List
	 */
	@RequestMapping("/notice")
	public ModelAndView notice() {
		ModelAndView mv = new ModelAndView();
		List<NoticeDTO> list = commonService.selectNotice();
		mv.addObject("list", list);
		mv.setViewName("common/notice");
		return mv;
	}

	/**
	 * 공지사항 페이지의 게시물 클릭시 이동
	 * 
	 * @param noticeNo
	 * @return noticeDTO
	 */
	@RequestMapping("/noticeDetail/{noticeNo}")
	public ModelAndView noticeDetail(@PathVariable int noticeNo) {
		ModelAndView mv = new ModelAndView();
		NoticeDTO noticeDTO = commonService.selectOneNotice(noticeNo);
		mv.setViewName("common/noticeDetail");
		mv.addObject("noticeDTO", noticeDTO);
		return mv;
	}

	@RequestMapping("/qna")
	public ModelAndView qna() {
		ModelAndView mv = new ModelAndView();
		List<QNADTO> list = commonService.selectQNAList();
		mv.setViewName("common/qna");
		mv.addObject("QNAList", list);
		return mv;
	}

	@RequestMapping("/qnaDetail/{QNANo}")
	public ModelAndView qnaDetial(@PathVariable int QNANo) {
		ModelAndView mv = new ModelAndView();
		QNADTO qnaDTO = commonService.selectOneQNA(QNANo);
		mv.addObject("qnaDTO", qnaDTO);
		mv.setViewName("common/qnaDetail");
		return mv;
	}

	@RequestMapping("/insertQNAForm")
	public String insertQNAForm() {
		return "common/insertQNAForm";
	}

	@RequestMapping("/updateQNA/{QNANo}")
	public ModelAndView qnaUpdateForm(@PathVariable int QNANo) {
		ModelAndView mv = new ModelAndView();
		QNADTO qnaDTO = commonService.selectOneQNA(QNANo);
		mv.addObject("qnaDTO", qnaDTO);
		mv.setViewName("common/qnaUpdateForm");
		return mv;
	}

	@RequestMapping("/updateQNA")
	public ModelAndView qnaUpdate() {
		ModelAndView mv = new ModelAndView();
		return mv;
	}

}
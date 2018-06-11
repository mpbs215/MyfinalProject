package kosta.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kosta.mvc.model.common.service.CommonServiceImpl;
import kosta.mvc.model.dto.FAQDTO;
import kosta.mvc.model.dto.NoticeDTO;
import kosta.mvc.model.dto.TermsDTO;
import kosta.mvc.model.dto.UserDTO;

@RequestMapping("/common")
@Controller
public class CommonController {
	
	@Autowired
	private CommonServiceImpl service;
	
	/**
	 * @return FAQ 테이블의 리스트
	 */
	@RequestMapping("/faq")
	public ModelAndView faq() {
		ModelAndView mv = new ModelAndView();
		List<FAQDTO> list=service.selectFAQ();
		mv.addObject("list",list);
		mv.setViewName("Common/faq");
		return mv;
	}
	
	/**
	 * 파인드IDForm페이지로 이동
	 * @return 
	 */
	@RequestMapping("/findIdForm")
	public void findIdForm() {}
	
	/**
	 * request: 이름과 이메일
	 * @return 아이디
	 */
	@RequestMapping("/findId")
	public ModelAndView findId() {
		
		return null;
	}
	
	/**
	 * 파인드Pwd페이지로 이동
	 * @return 
	 */
	@RequestMapping("/findPwdForm")
	public void findPwdForm() {}
	
	/**
	 * request: 이름 아이디 비밀번호
	 * @return 비밀번호
	 */
	@RequestMapping("/findPwd")
	public ModelAndView findPwd() {
		
		return null;
	}
	
	/**
	 * 서비스안내 메인페이지로 이동
	 */
	@RequestMapping("/introduce")
	public void introduce() {}
	
	/**
	 * 서비스이용안내 페이지로 이동
	 */
	@RequestMapping("/serviceInfo")
	public void serviceInfo() {}
	
	/**
	 * 로그인 페이지로 이동
	 */
	@RequestMapping("/loginForm")
	public void loginForm() {}
	
	/**
	 * Request : ID, PWD
	 */
	@RequestMapping("/login")
	public ModelAndView login(String userId,String password) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/");
		return mv;
	}
	
	/**
	 * 메인 페이지 이동
	 */
	@RequestMapping("/")
	public void mainView() {}
	
	/**
	 * 회원가입 페이지 이동
	 */
	@RequestMapping("/signUpForm")
	public void signUpForm() {}
	
	/**
	 * request : UserDTO
	 * @return
	 */
	@RequestMapping("/signUp")
	public ModelAndView signUp(UserDTO dto) {
		return null;
	}
	
	/**
	 * 이용약관 페이지 이동
	 */
	@RequestMapping("/terms")
	public ModelAndView terms() {
		ModelAndView mv = new ModelAndView();
		List<TermsDTO> list = service.selectTerms();
		mv.addObject("list",list);
		mv.setViewName("/Common/terms");
		return mv;
	}
	
	/**
	 * 공지사항 페이지로 이동
	 * @return 공지사항 List
	 */
	@RequestMapping("/notice")
	public ModelAndView notice() {
		ModelAndView mv = new ModelAndView();
		List<NoticeDTO> list = service.selectNotice();
		mv.addObject("list",list);
		mv.setViewName("/Common/notice");
		return mv;
	}
	
	/**
	 * 공지사항 페이지의 게시물 클릭시 이동
	 * @param noticeNo
	 * @return noticeDTO
	 */
	@RequestMapping("/noticeDetail")
	public ModelAndView noticeDetail(int noticeNo) {
		ModelAndView mv = new ModelAndView();
		NoticeDTO noticeDTO = service.selectOneNotice(noticeNo);
		mv.setViewName("/Common/noticeDetail");
		mv.addObject("dto",noticeDTO);
		return mv;
	}
	
	
}
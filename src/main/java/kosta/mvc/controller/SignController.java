package kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kosta.mvc.model.dto.UserDTO;

@Controller
@RequestMapping("/sign")
public class SignController {

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
}

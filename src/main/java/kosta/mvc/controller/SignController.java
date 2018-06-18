package kosta.mvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kosta.mvc.model.dto.UserDTO;
import kosta.mvc.model.user.service.UserServiceImpl;

@Controller
@RequestMapping("/sign")
public class SignController {

	@Autowired
	private UserServiceImpl userService;

	/**
	 * 아이디 찾기 폼으로 이동
	 * */
	@RequestMapping("/findId")
	public String findIdForm() {
		return "sign/findIdForm";
	}
	
	@RequestMapping(value="/idFind", method = RequestMethod.POST)
    public String find_pass(UserDTO userDTO, RedirectAttributes redirectattr, Errors errors) {
		
		
		System.out.println("컨트롤러에서 userDTO의 이메일은 : " +userDTO.getEmail());
        new FindPassValidator().validate(userDTO, errors);
        
        if(errors.hasErrors()) {
        	return "sign/findIdForm";
        } else {
        
        try {
            UserDTO resultDTO = userService.execute(userDTO.getEmail());
            System.out.println("service에서 resultDTO값 : "+resultDTO);
            
            redirectattr.addFlashAttribute("resultDTO",resultDTO); 

            return "redirect:/sendpass";
            
        } catch(Exception e) {
            e.printStackTrace();
            
           return "sign/findIdForm";
        	}
        }
    }

	/**
	 * 	아이디 중복 체크 하기
	 * */
	@RequestMapping(value= "/idCheck",  produces="text/html; charset=utf-8")
	@ResponseBody
	public String idCheck(String userId) {
		String message = userService.idcheck(userId); 
		System.out.println(message);
		return message;
	}

	/**
	 * 비밀번호 찾기 폼으로 이동
	 * */
	@RequestMapping("/findPassword")
	public String findPasswordForm() {
		return "sign/findPwdForm";
	}

	/**
	 *  로그인 폼 띄우기
	 * */
	@RequestMapping("/loginForm")
	public String loginForm() {
		return "sign/loginForm";
	}

	/**
	 * Request : ID, PWD
	 */
	@RequestMapping("/login")
	public ModelAndView login(String userId, String password) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/");
		return mv;
	}

	/**
	 * 	회원가입 폼 띄우기
	 * */
	@RequestMapping("/signUpForm")
	public String signUpForm() {
		return "sign/signUpForm";
	}

	/**
	 * 	회원 가입 하기
	 * */
	@RequestMapping("/signUp")
	public String signUp(UserDTO userDTO) {
		
		System.out.println("이름" +userDTO.getUserName());
		
		userService.signUp(userDTO);	
		
		return "redirect:/";
	}
	

	/**
	 * 	로그인 체크 하기
	 * */
	@RequestMapping("/loginCheck")
	public ModelAndView loginCheck(UserDTO userDTO, HttpSession session) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		UserDTO dto = userService.loginCheck(userDTO, session);
		System.out.println("session값 = " +session);
		
		if (session != null) {
			session.setAttribute("userName", userDTO.getUserName());
			session.setAttribute("userId", userDTO.getUserId());
		}

		mv.addObject("resultDTO", dto);
		mv.setViewName("redirect:/");
		
		return mv;
	}
}

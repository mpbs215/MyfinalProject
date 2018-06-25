package kosta.mvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String moveMain() {
		return "main";
	}
	
	/**
	 * 주소 검색창 오픈
	 */
	@RequestMapping("/addrPopup")
	public void addrPopup() {}
	
	@RequestMapping("/real")
	public void real(HttpSession session) {
		System.out.println("홈컨트롤러");
		System.out.println(session.getServletContext().getRealPath("/"));
	}
}

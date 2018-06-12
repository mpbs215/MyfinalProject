package kosta.mvc.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kosta.mvc.model.dto.UserDTO;

@Controller
public class TestController {
	
	@Autowired
	private SqlSession session;
	
	@RequestMapping("/test/test")
	public String test(Model model) {
		System.out.println("½ÇÇà");
		List<UserDTO> list = session.selectList("testMapper.test");
		for(UserDTO dto:list) {
			System.out.println(dto.getUserId());
		}
		model.addAttribute("list",list);
		return "testResult";
	}
}
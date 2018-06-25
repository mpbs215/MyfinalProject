package kosta.mvc.model.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosta.mvc.model.dao.ParkDAO;
import kosta.mvc.model.dao.UserDAO;
import kosta.mvc.model.dto.ParkDTO;
import kosta.mvc.model.dto.UserDTO;

@Service
public class ManageUserService {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private ParkDAO parkDAO;
	/**
	 * 회원 목록 표시
	 * 
	 * @return
	 */
	public List<UserDTO> manageUserList() {

		return userDAO.manageUserList();
	}

	/**
	 * 회원 삭제
	 */

	public int deleteUser(String userId) {
		int result = userDAO.deleteUser(userId);
		return result;
	}

	public List<ParkDTO> manageParkList() {
		return parkDAO.selectParkList();
	}
	
	
}

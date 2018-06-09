package kosta.mvc.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosta.mvc.model.dto.UserDTO;

@Repository
public class UserDAO {
	@Autowired
	private SqlSession session;

	public List<UserDTO> manageUserList() {
		return session.selectList("");
	}
}
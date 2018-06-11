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

	public UserDTO selectMemberById(String id) {
		return null;
	}
	
	/**
	 *사용자의 정보를 보여주는 메소드
	 */
	public UserDTO viewUserInfo(String userId) {
		return session.selectOne("userMapper.selectUserInfo",userId);
	}
	
	/**
	 * 사용자 정보를 수정하는 메소드
	 */
	public void updateUserInfo(UserDTO userDTO) {
		session.update("userMapper.updateUserInfo", userDTO);
	}
}
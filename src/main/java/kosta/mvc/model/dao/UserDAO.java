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
	
	/**
	 *사용자의 정보를 보여주는 메소드
	 */
	public UserDTO viewUserInfo(String userId) {
		return session.selectOne("userMapper.selectUserInfo",userId);
	}
	
	/**
	 * 사용자 정보를 수정하는 메소드
	 */
	public int updateUserInfo(UserDTO userDTO) {
		return session.update("userMapper.updateUserInfo", userDTO);
	}
	
	/**
	 * 회원 가입
	 * */
	public int signUp(UserDTO userDTO) {
	
		int result = session.insert("signMapper.insertMember", userDTO);
		System.out.println("결과 : " +result);
		return result;
	}
	
	/**
	 *	 id 중복 체크 하기
	 * */
	public UserDTO idcheck(String userId) {
		UserDTO userDTO = session.selectOne("signMapper.idCheck",userId);
		return userDTO; 				
	}

	/**
	 * 	id를 pk값으로 하여 정보를 찾는 메소드
	 * */
	public UserDTO selectMemberById(String userId) {
		return session.selectOne("userMapper.selectUserInfo", userId);
	}
	
	/**
	 * 	로그인 체크 하기 (로그인 성공, 로그인 실패 체크)
	 * */
	public UserDTO loginCheck(UserDTO userDTO) {
		
		UserDTO dto = session.selectOne("userMapper.loginCheck", userDTO);
		
		System.out.println("dto는" +dto);
		
		return dto;
	}
	
	/**
	 * 메일을 이용하여 사용자의 정보를 찾아주는 메소드
	 * */
	public UserDTO findByEmail(String email) {
		 
		UserDTO dto = session.selectOne("signMapper.findByEmail",email);
		System.out.println("DAO에서 dto의 값은 " +dto);
		
		return dto;
	}
	
	
	
	
}
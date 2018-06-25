package kosta.mvc.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosta.mvc.model.dto.TempKeyDTO;
import kosta.mvc.model.dto.UserDTO;

@Repository
public class UserDAO {
	@Autowired
	private SqlSession session;

//	public List<UserDTO> manageUserList() {
	//	return session.selectList("");
	//}
	/**
	 * 가입 한 user 목록 출력하는 메소드 (admin이 사용)
	 */
	public List<UserDTO> manageUserList() {
		return session.selectList("manageUserMapper.regiUserList");
	}
	
	/**
	 * 회원 강제 삭제 (admin이 사용)
	 */
	public void deleteUser(String userID) {
		session.delete("manageUserMapper.manageUser",userID);
	}
	
	/**
	 *사용자의 정보를 보여주는 메소드
	 */
//	public UserDTO viewUserInfo(String userId) {
	//	return session.selectOne("userMapper.selectUserInfo",userId);
	//}
	
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
	 *사용자의 정보를 보여주는 메소드
	 */
	public UserDTO viewUserInfo(String userId) {
		return session.selectOne("userMapper.selectUserInfo",userId);
	}
	
	/**
	 * 사용자 정보를 수정하는 메소드
	 *//*
	public void updateUserInfo(UserDTO userDTO) {
		session.update("userMapper.updateUserInfo", userDTO);
	}*/
	
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
	
	/**
	 * 	SMS로 인증번호 받기
	 * */
	public int SMSAuth(TempKeyDTO sms) {
		
		int result = session.insert("userMapper.SMS",sms);
		System.out.println("결과 : " + result);
		
		return result; 
	}
	
	/**
	 * 	회원 탈퇴 하기 (SMS 테이블)
	 * */
	/*public int deleteSMS(String password, String hp) {
		
		return session.delete("userMapper.deleteSMS", hp);
	}*/
	
	/**
	 * 	회원 탈퇴를 위해 암호화된 비밀번호 가저오기
	 * */
	public String selectPassword(String userId) {
		String password = session.selectOne("userMapper.selectPassword", userId);
		
		System.out.println("DAO에서 비밀번호 : " +password);
		
		return password;
	}
	
	/**
	 * 	회원 탈퇴 하기 (USER 테이블)
	 * */
	public int deleteUserInfo(String encodePassword) {
		
		return session.delete("userMapper.deleteUser",encodePassword);
	}
	
}
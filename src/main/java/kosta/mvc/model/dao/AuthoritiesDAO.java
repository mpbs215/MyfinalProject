package kosta.mvc.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosta.mvc.model.dto.AuthorityDTO;


@Repository
public class AuthoritiesDAO{

	@Autowired
	private SqlSession sqlSession;
	
	public int insertAuthority(AuthorityDTO authority) {
		return sqlSession.insert("authoritiesMapper.insertAuthority", authority);
	}

	public int updateKey(AuthorityDTO auth) {
		int result = 0;
		result = sqlSession.update("authoritiesMapper.updateKey",auth);
		
		return result;
	}
	
	public List<AuthorityDTO> selectAuthorityByUserId(String userId) {
		return sqlSession.selectList("authoritiesMapper.selectAuthorityByUserId", userId);
	}
	
	/**
	 * 	인증번호가 일치하면 권한을 Seller로 바꿔주기
	 * */
	public int updateAuth(String authKey) {
		
		System.out.println("key값: "+authKey);
		int result= sqlSession.update("authoritiesMapper.updateAuth", authKey);
		
		return result;
	}
	
	/**
	 * 	사용자의 아이디에 따른 정보 삭제 (Auth 테이블 삭제)
	 * */
	public int deleteAuth(String password, String hp) {
		int result =sqlSession.delete("authoritiesMapper.deleteAuth",hp);
		
		System.out.println("hp(authDAO) :" +hp);
		System.out.println("authoDao에서 result값 : " +result);
		
		return result;
	}
}
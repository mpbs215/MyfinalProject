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

	public List<AuthorityDTO> selectAuthorityByUserName(String username) {
		return sqlSession.selectList("authoritiesMapper.selectAuthorityByUserName", username);
	}

}
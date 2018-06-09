package kosta.mvc.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosta.mvc.model.dto.TermsDTO;

@Repository
public class TermsDAO {
	@Autowired
	private SqlSession session;

	public List<TermsDTO> selectTerms() {
		return session.selectList("commonMapper.selectTerms");
	}
}
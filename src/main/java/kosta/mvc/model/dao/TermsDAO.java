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
		return session.selectList("commonMapper.selectTermsAll");
	}

	public TermsDTO updateFormTerms(int termsNo) {
		TermsDTO termsDTO = session.selectOne("termsMapper.updateFormTerms", termsNo);
		return termsDTO;
	}

	public int updateTerms(TermsDTO termsDTO) {
		int result = session.update("termsMapper.updateTerms", termsDTO);
		return result;
	}

	public int insertTerms(TermsDTO termsDTO) {
		int result = session.insert("termsMapper.insertTerms", termsDTO);
		return result;
	}

	public int deleteTerms(int termsNo) {
		int result = session.delete("termsMapper.deleteTerms", termsNo);
		return result;
	}
}
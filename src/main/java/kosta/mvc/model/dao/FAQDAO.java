package kosta.mvc.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosta.mvc.model.dto.FAQDTO;

@Service
public class FAQDAO {

	@Autowired
	private SqlSession session;

	public List<FAQDTO> selectFAQAll() {
		List<FAQDTO> list = session.selectList("commonMapper.selectFAQAll");
		return list;
	}

	public int insertFAQ(FAQDTO faqDTO) {
		int result = session.insert("faqMapper.insertFAQ", faqDTO);
		return result;
	}

	public FAQDTO updateFormFAQ(int FAQNo) {
		FAQDTO faqDTO = session.selectOne("faqMapper.updateFormFAQ", FAQNo);
		return faqDTO;
	}

	public int updateFAQ(FAQDTO faqDTO) {
		int result = session.update("faqMapper.updateFAQ", faqDTO);
		return result;
	}

	public int deleteFAQ(int FAQNo) {
		int result = session.delete("faqMapper.deleteFAQ", FAQNo);
		return result;
	}
}
package kosta.mvc.model.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosta.mvc.model.dao.FAQDAO;
import kosta.mvc.model.dto.FAQDTO;

@Service
public class FaqService {

	@Autowired
	FAQDAO faqDAO;

	public int insertFAQ(FAQDTO faqDTO) {
		int result = faqDAO.insertFAQ(faqDTO);
		return result;

	}

	public FAQDTO updateFAQ(int FAQNo) {
		FAQDTO faqDTO = faqDAO.updateFormFAQ(FAQNo);
		return faqDTO;
	}

	public int updateFAQ(FAQDTO faqDTO) {
		int result = faqDAO.updateFAQ(faqDTO);
		return result;
	}

	public int deleteFAQ(int FAQNo) {
		int result = faqDAO.deleteFAQ(FAQNo);
		return result;
	}
}

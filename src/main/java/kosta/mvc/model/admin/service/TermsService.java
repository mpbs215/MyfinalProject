package kosta.mvc.model.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosta.mvc.model.dao.TermsDAO;
import kosta.mvc.model.dto.TermsDTO;

@Service
public class TermsService {

	@Autowired
	private TermsDAO termsDAO;

	public TermsDTO updateFormTerms(int termsNo) {
		TermsDTO termsDTO = termsDAO.updateFormTerms(termsNo);
		return termsDTO;
	}
	
	public int updateTerms(TermsDTO termsDTO) {
		int result = termsDAO.updateTerms(termsDTO);
		return result;
	}
	
	public int insertTerms(TermsDTO termsDTO) {
		int result = termsDAO.insertTerms(termsDTO);
		return result;
	}
	
	public int deleteTerms(int termsNo) {
		int result = termsDAO.deleteTerms(termsNo);
		return result;
	}
}

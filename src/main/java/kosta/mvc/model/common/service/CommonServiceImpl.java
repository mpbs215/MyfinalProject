package kosta.mvc.model.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosta.mvc.model.dao.FAQDAO;
import kosta.mvc.model.dao.NoticeDAO;
import kosta.mvc.model.dao.TermsDAO;
import kosta.mvc.model.dto.FAQDTO;
import kosta.mvc.model.dto.NoticeDTO;
import kosta.mvc.model.dto.TermsDTO;

@Service
public class CommonServiceImpl implements CommonService{
	
	@Autowired
	private FAQDAO faqDAO;
	
	@Autowired
	private TermsDAO termsDAO;
	
	@Autowired
	private NoticeDAO noticeDAO;

	public List<FAQDTO> selectFAQAll() {
		List<FAQDTO> list = faqDAO.selectFAQAll();
		return list;
	}

	public List<TermsDTO> selectTerms() {
		return termsDAO.selectTerms();
	}

	public List<NoticeDTO> selectNotice() {
		return noticeDAO.selectNotice();
	}

	public NoticeDTO selectOneNotice(int noticeNo) {
		return noticeDAO.selectOneNotice(noticeNo);
	}

}
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
public class CommonServiceImpl {
	
	@Autowired
	private FAQDAO faqDao;
	
	@Autowired
	private TermsDAO termsDao;
	
	@Autowired
	private NoticeDAO noticeDao;

	public List<FAQDTO> selectFAQ() {
		return faqDao.selectFAQ();
	}

	public List<TermsDTO> selectTerms() {
		return termsDao.selectTerms();
	}

	public List<NoticeDTO> selectNotice() {
		return noticeDao.selectNotice();
	}

	public NoticeDTO selectOneNotice(int noticeNo) {
		return noticeDao.selectOneNotice(noticeNo);
	}

}
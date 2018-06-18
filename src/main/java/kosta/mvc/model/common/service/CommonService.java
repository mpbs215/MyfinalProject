package kosta.mvc.model.common.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.mvc.model.dto.FAQDTO;
import kosta.mvc.model.dto.NoticeDTO;
import kosta.mvc.model.dto.QNADTO;
import kosta.mvc.model.dto.TermsDTO;

public interface CommonService {

	public List<FAQDTO> selectFAQAll();

	public List<TermsDTO> selectTerms();

	public List<NoticeDTO> selectNotice();

	public NoticeDTO selectOneNotice(int noticeNo);

	public List<QNADTO> selectQNAList();

	public QNADTO selectOneQNA(HttpServletRequest request, HttpServletResponse response, int QNANo);
}

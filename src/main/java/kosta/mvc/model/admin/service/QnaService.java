package kosta.mvc.model.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kosta.mvc.model.dao.QNADAO;
import kosta.mvc.model.dto.QNADTO;

@Service
public class QnaService {

	@Autowired
	private QNADAO qnaDAO;

	public int insertQNA(QNADTO qnaDTO) {
		int result = qnaDAO.insertQNA(qnaDTO);
		return result;
	}

	public int qnaUpdate(QNADTO qnaDTO) {
		int result = qnaDAO.updateQNA(qnaDTO);		
		return result;
	}

	public int qnaDelte(int QNANo) {
		int result = qnaDAO.deleteQNA(QNANo);
		return result;
	}
}

package kosta.mvc.model.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosta.mvc.model.dao.NoticeDAO;
import kosta.mvc.model.dto.NoticeDTO;

@Service
public class NoticeService {

	@Autowired
	private NoticeDAO noticeDAO;

	public int insertNotice(NoticeDTO noticeDTO) {
		int result = noticeDAO.insertNotice(noticeDTO);
		return result;
	}

	public int deleteNotice(int noticeNo) {
		int result = noticeDAO.deleteNotice(noticeNo);
		return result;
	}
	
	public NoticeDTO noticeUpdateForm(int noticeNo) {
		NoticeDTO noticeDTO = noticeDAO.noticeUpdateForm(noticeNo);
		return noticeDTO;
	}
	
	public int noticeUpdate(NoticeDTO noticeDTO) {
		int result = noticeDAO.noticeUpdate(noticeDTO);
		return result;
	}

}

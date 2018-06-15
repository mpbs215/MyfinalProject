package kosta.mvc.model.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosta.mvc.model.dao.NoticeDAO;
import kosta.mvc.model.dto.NoticeDTO;

@Service
public class NoticeService {

	@Autowired
	NoticeDAO noticeDAO;

	public int insertNotice(NoticeDTO noticeDTO) {
		int result = noticeDAO.insertNotice(noticeDTO);
		return result;
	}
}

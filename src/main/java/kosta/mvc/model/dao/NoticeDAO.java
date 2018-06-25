package kosta.mvc.model.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosta.mvc.model.dto.NoticeDTO;

@Repository
public class NoticeDAO {
	@Autowired
	private SqlSession session;

	public List<NoticeDTO> selectNotice() {
		return session.selectList("commonMapper.selectNotice");
	}

	public NoticeDTO selectOneNotice(HttpServletRequest request, HttpServletResponse response, int noticeNo) {
		return session.selectOne("commonMapper.selectNotice", noticeNo);
	}

	public int insertNotice(NoticeDTO noticeDTO) {

		int result = session.insert("noticeMapper.insertNotice", noticeDTO);
		return result;
	}

	public int deleteNotice(int noticeNo) {
		int result = session.delete("noticeMapper.deleteNotice", noticeNo);
		return result;
	}

	public NoticeDTO noticeUpdateForm(int noticeNo) {
		return session.selectOne("commonMapper.selectNotice", noticeNo);
	}

	public int noticeUpdate(NoticeDTO noticeDTO) {
		return session.update("noticeMapper.updateNotice", noticeDTO);
	}

	public void increaseNoticeHit(NoticeDTO noticeDTO) {
		session.update("noticeMapper.increaseNoticeHit", noticeDTO);
	}
}
package kosta.mvc.model.common.service;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kosta.mvc.model.dao.FAQDAO;
import kosta.mvc.model.dao.NoticeDAO;
import kosta.mvc.model.dao.QNADAO;
import kosta.mvc.model.dao.TermsDAO;
import kosta.mvc.model.dto.FAQDTO;
import kosta.mvc.model.dto.NoticeDTO;
import kosta.mvc.model.dto.QNADTO;
import kosta.mvc.model.dto.TermsDTO;

@Service
public class CommonServiceImpl implements CommonService {

	@Autowired
	private FAQDAO faqDAO;

	@Autowired
	private TermsDAO termsDAO;

	@Autowired
	private NoticeDAO noticeDAO;

	@Autowired
	private QNADAO qnaDAO;

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

	@Transactional
	public NoticeDTO selectOneNotice(HttpServletRequest request, HttpServletResponse response, int noticeNo) {
		NoticeDTO noticeDTO = noticeDAO.selectOneNotice(request, response, noticeNo);
		Cookie[] cookies = request.getCookies();
		String noticeBoardCookieVal = "";
		boolean hasRead = false;

		if (cookies != null) {
			for (Cookie c : cookies) {
				String name = c.getName();
				String value = c.getValue();

				if ("noticeBoardCookie".equals(name)) {
					noticeBoardCookieVal = value;
					if (noticeBoardCookieVal.contains("|" + noticeDTO.getNoticeNo() + "|")) {
						hasRead = true;
						break;
					}
				}

			}
		}

		// 게시글 읽음 여부 따지기
		if (!hasRead) {
			// 조회수 증가
			noticeDTO.setNoticeHit(noticeDTO.getNoticeHit() + 1);
			noticeDAO.increaseNoticeHit(noticeDTO);

			// 쿠키생성
			Cookie noticeBoardCookie = new Cookie("noticeBoardCookie",
					noticeBoardCookieVal + "|" + noticeDTO.getNoticeNo() + "|");
			// boardCookie.setPath("/mvc/board"); 안적으면 저절로 현재 경로로 잡힘.
			// boardCookie.setMaxAge(60*60*24); //작성 안하면, 브라우져에 영구저장.
			response.addCookie(noticeBoardCookie);
		}

		return noticeDTO;
	}

	@Override
	public List<QNADTO> selectQNAList(int cPage, int numPerPage) {
		return qnaDAO.selectQNAList(cPage, numPerPage);
	}

	@Transactional
	@Override
	public QNADTO selectOneQNA(HttpServletRequest request, HttpServletResponse response, int QNANo) {
		QNADTO qnaDTO = qnaDAO.selectOneQNA(request, response, QNANo);

		Cookie[] cookies = request.getCookies();
		String QNABoardCookieVal = "";
		boolean hasRead = false;

		if (cookies != null) {
			for (Cookie c : cookies) {
				String name = c.getName();
				String value = c.getValue();

				if ("QNABoardCookie".equals(name)) {
					QNABoardCookieVal = value;
					if (QNABoardCookieVal.contains("|" + qnaDTO.getQNANo() + "|")) {
						hasRead = true;
						break;
					}
				}

			}
		}

		// 게시글 읽음 여부 따지기
		if (!hasRead) {
			// 조회수 증가
			qnaDTO.setQNAHit(qnaDTO.getQNAHit() + 1);
			qnaDAO.increaserQNA(qnaDTO);

			// 쿠키생성
			Cookie QNABoardCookie = new Cookie("QNABoardCookie", QNABoardCookieVal + "|" + qnaDTO.getQNANo() + "|");
			// boardCookie.setPath("/mvc/board"); 안적으면 저절로 현재 경로로 잡힘.
			// boardCookie.setMaxAge(60*60*24); //작성 안하면, 브라우져에 영구저장.
			response.addCookie(QNABoardCookie);
		}

		return qnaDTO;
	}

	@Override
	public int QNACnt() {

		return qnaDAO.QNACnt();
	}

}
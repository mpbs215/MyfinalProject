package kosta.mvc.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kosta.mvc.model.admin.service.QnaService;
import kosta.mvc.model.common.service.CommonService;
import kosta.mvc.model.dto.FAQDTO;
import kosta.mvc.model.dto.NoticeDTO;
import kosta.mvc.model.dto.QNADTO;
import kosta.mvc.model.dto.TermsDTO;
import kosta.mvc.model.dto.UserDTO;
import kosta.mvc.model.user.service.UserServiceImpl;

@RequestMapping("/common")
@Controller
public class CommonController {

	String savePath = "";
	UserDTO userDTO = new UserDTO();

	@Autowired
	private CommonService commonService;

	@Autowired
	private QnaService qnaService;

	@Autowired
	private UserServiceImpl userService;

	/**
	 * @return FAQ 테이블의 리스트
	 */
	@RequestMapping("/faq")
	public ModelAndView faq() {
		ModelAndView mv = new ModelAndView();
		List<FAQDTO> list = commonService.selectFAQAll();
		mv.addObject("list", list);
		mv.setViewName("common/faq");
		return mv;
	}

	/**
	 * 서비스안내 메인페이지로 이동
	 */
	@RequestMapping("/introduce")
	public void introduce() {
	}

	/**
	 * 서비스이용안내 페이지로 이동
	 */
	@RequestMapping("/serviceInfo")
	public void serviceInfo() {
	}

	/**
	 * 이용약관 페이지 이동
	 */
	@RequestMapping("/terms")
	public ModelAndView terms() {
		ModelAndView mv = new ModelAndView();
		List<TermsDTO> list = commonService.selectTerms();
		mv.addObject("list", list);
		mv.setViewName("common/terms");
		return mv;
	}

	/**
	 * 공지사항 페이지로 이동
	 * 
	 * @return 공지사항 List
	 */
	@RequestMapping("/notice")
	public ModelAndView notice() {
		ModelAndView mv = new ModelAndView();
		List<NoticeDTO> list = commonService.selectNotice();
		mv.addObject("list", list);
		mv.setViewName("common/notice");
		return mv;
	}

	/**
	 * 공지사항 페이지의 게시물 클릭시 이동
	 * 
	 * @param noticeNo
	 * @return noticeDTO
	 */
	@RequestMapping("/noticeDetail/{noticeNo}")
	public ModelAndView noticeDetail(HttpServletRequest request, HttpServletResponse response,
			@PathVariable int noticeNo) {
		ModelAndView mv = new ModelAndView();
		NoticeDTO noticeDTO = commonService.selectOneNotice(request, response, noticeNo);
		mv.setViewName("common/noticeDetail");
		mv.addObject("noticeDTO", noticeDTO);
		return mv;
	}

	@RequestMapping("/qna")
	public ModelAndView qna(HttpServletRequest request) {
		int numPerPage = 5; // 한 페이지당 글 개수
		int cPage; // 클릭된 페이지 번호
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		} catch (NumberFormatException e) {
			cPage = 1;
		}

		// 2.3 페이징바 만들기
		int totalQNA = commonService.QNACnt(); // 총 게시물 개수

		int totalPage = (int) Math.ceil((double) totalQNA / numPerPage); // 게시물 개수 기반 페이지 수 구하기
		String pageBar = "";
		int pageBarSize = 5; // 한번에 보이는 페이지 개수
		
		// 시작페이지 no - 다음버튼 눌렀을 때 나오는 맨 앞 페이지 숫자
		int pageNo;
		pageNo = (int) (Math.ceil(((double) cPage / pageBarSize) - 1) * pageBarSize) + 1;

		// 종료페이지 no - 다음버튼 앞 페이지 숫자
		int pageEnd = pageNo + pageBarSize - 1;

		pageBar += "<ul class='pagination justify-content-center pagination-sm'>";

		// [이전]
		if (pageNo == 1) {
			// 이전버튼 필요없음
			pageBar += "<li class='page-item disabled'>";
			pageBar += "<a class='page-link' href='#' tabindex='-1'>이전</a>";
			pageBar += "</li>";
		} else {
			pageBar += "<li class='page-item'>";
			pageBar += "<a class='page-link' href=" + request.getContextPath() + "/common/qna?cPage=" + (pageNo - 1)
					+ "><span>[이전]</span></a>";
			pageBar += "</li>";
		}

		// [pageNo] - 페이지 다섯개에 대한 링크(페이지 이동)
		while (pageNo <= pageEnd && pageNo <= totalPage) {
			if (pageNo == cPage) {
				pageBar += "<li class='page-item active'>";
				pageBar += "<a class='page-link'>" + pageNo + "</a>";
				pageBar += "</li>";
			} else {
				pageBar += "<li class='page-item'>";
				pageBar += "<a class='page-link' href =" + request.getContextPath() + "/common/qna?cPage=" + pageNo + "> <span>" + pageNo + "</span></a>";
				pageBar += "</li>";
			}

			pageNo++;
		}
		// [다음]

		if (pageNo > totalPage) {
			pageBar += "<li class='page-item disabled'>";
	         pageBar += "<a class='page-link' href='#'>다음</a>";
	         pageBar += "</li>";
		} else {
			pageBar += "<li class='page-item'>";
			pageBar += "<a class='page-link' href=" + request.getContextPath() + "/common/qna?cPage=" + (pageNo)
					+ "><span>[다음]</span></a>";
			pageBar += "</li>";
		}

		pageBar += "</ul>";
		
		ModelAndView mv = new ModelAndView();
		List<QNADTO> list = commonService.selectQNAList(cPage, numPerPage);
		mv.setViewName("common/qna");
		mv.addObject("QNAList", list);
		mv.addObject("pageBar", pageBar);

		return mv;
	}

	@RequestMapping("/qnaDetail/{QNANo}")
	public ModelAndView qnaDetial(HttpServletRequest request, HttpServletResponse response, @PathVariable int QNANo) {
		ModelAndView mv = new ModelAndView();
		QNADTO qnaDTO = commonService.selectOneQNA(request, response, QNANo);
		mv.addObject("qnaDTO", qnaDTO);
		mv.setViewName("common/qnaDetail");
		return mv;
	}

	@RequestMapping("/insertQNAForm")
	public ModelAndView insertQNAForm() {
		ModelAndView mv = new ModelAndView();
		userDTO.setUserId("qwer");
		mv.addObject("userDTO", userDTO);
		mv.setViewName("common/insertQNAForm");
		return mv;
	}

	@RequestMapping("/insertQNA")
	public String insertQNA(HttpSession session, QNADTO qnaDTO) throws Exception {
		MultipartFile file = qnaDTO.getQNAImageFile();
		String now = new SimpleDateFormat("yyyyMMddHmsS").format(new Date()); // 현재시간
		String fileOriginalName = file.getOriginalFilename();
		if (file.getSize() > 0) {
			if (fileOriginalName.substring(fileOriginalName.length() - 3, fileOriginalName.length()).toLowerCase()
					.equals("jpg")
					|| fileOriginalName.substring(fileOriginalName.length() - 3, fileOriginalName.length())
							.toLowerCase().equals("png")
					|| fileOriginalName.substring(fileOriginalName.length() - 4, fileOriginalName.length())
							.toLowerCase().equals("jppg")) {
				savePath = session.getServletContext().getRealPath("/resources/images/QNA");
				file.transferTo(new File(savePath + "/" + now + file.getOriginalFilename()));
				qnaDTO.setQNAImage(now + file.getOriginalFilename());
			}
		}

		// insert 호출하기
		qnaService.insertQNA(qnaDTO);
		return "redirect:/common/qna";
	}

	@RequestMapping("/updateQNA/{QNANo}")
	public ModelAndView qnaUpdateForm(HttpServletRequest request, HttpServletResponse response,
			@PathVariable int QNANo) {
		ModelAndView mv = new ModelAndView();
		QNADTO qnaDTO = commonService.selectOneQNA(request, response, QNANo);
		mv.addObject("qnaDTO", qnaDTO);
		mv.setViewName("common/qnaUpdateForm");
		return mv;
	}

	@RequestMapping("/updateQNA")
	public ModelAndView qnaUpdate(HttpSession session, QNADTO qnaDTO) throws IllegalStateException, IOException {
		ModelAndView mv = new ModelAndView();
		MultipartFile file = qnaDTO.getQNAImageFile();
		String now = new SimpleDateFormat("yyyyMMddHmsS").format(new Date()); // 현재시간
		String fileOriginalName = file.getOriginalFilename();
		if (file.getSize() > 0) {
			if (fileOriginalName.substring(fileOriginalName.length() - 3, fileOriginalName.length()).toLowerCase()
					.equals("jpg")
					|| fileOriginalName.substring(fileOriginalName.length() - 3, fileOriginalName.length())
							.toLowerCase().equals("png")
					|| fileOriginalName.substring(fileOriginalName.length() - 4, fileOriginalName.length())
							.toLowerCase().equals("jppg")) {
				savePath = session.getServletContext().getRealPath("/resources/images/QNA");
				file.transferTo(new File(savePath + "/" + now + file.getOriginalFilename()));
				qnaDTO.setQNAImage(now + file.getOriginalFilename());
			}
		}

		int result = qnaService.qnaUpdate(qnaDTO);
		mv.setViewName("redirect:/common/qna");
		return mv;
	}

	@RequestMapping("/deleteQNA/{QNANo}")
	public ModelAndView deleteQNA(@PathVariable int QNANo) {
		ModelAndView mv = new ModelAndView();
		int result = qnaService.qnaDelte(QNANo);
		mv.setViewName("redirect:/common/qna");
		return mv;
	}
}
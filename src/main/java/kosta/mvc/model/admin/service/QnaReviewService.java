package kosta.mvc.model.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosta.mvc.model.dao.ReviewDAO;

@Service
public class QnaReviewService {

	@Autowired
	private ReviewDAO reviewDAO;

	public void updateQNAReview(int QNANo, String QNAReview) {
		reviewDAO.updateReview(QNANo, QNAReview);
		
	}

}

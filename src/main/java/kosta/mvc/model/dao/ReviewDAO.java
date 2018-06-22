package kosta.mvc.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosta.mvc.model.dto.ParkReserveDTO;
import kosta.mvc.model.dto.QNADTO;
import kosta.mvc.model.dto.ReviewDTO;

@Repository
public class ReviewDAO {
	@Autowired
	private SqlSession session;

	public List<ReviewDTO> userClickReviewStar(int parkNo, int rating) {
		return session.selectList("userMapper.selectReviewByStar", new ReviewDTO(parkNo, rating));
	}

	public List<ReviewDTO> selectReview(int parkNo) {
		return session.selectList("userMapper.selectReview", parkNo);
	}

	public int insertReview(ReviewDTO dto) {
		return session.insert("userMapper.insertReview", dto);
	}

	public void updateReview(int QNANo, String QNAReview) {
		Map<String, Object> map = new HashMap<>();
		map.put("QNANo", QNANo);
		map.put("QNAReview", QNAReview);

		session.update("qnaReviewMapper.updateQnaReview", map);

	}
}
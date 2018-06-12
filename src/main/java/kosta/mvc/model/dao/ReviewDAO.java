package kosta.mvc.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosta.mvc.model.dto.ReviewDTO;

@Repository
public class ReviewDAO {
	@Autowired
	private SqlSession session;

	public List<ReviewDTO> userClickReviewStar(int parkNo, int starNo) {
		return session.selectList("userMapper.selectReviewByStar",new ReviewDTO(parkNo,starNo) );
	}

	public List<ReviewDTO> selectReview(int parkNo) {
		return session.selectList("userMapper.selectReview",parkNo);
	}

	public int insertReview(ReviewDTO dto) {
		return session.insert("userMapper.insertReview",dto);
	}
}
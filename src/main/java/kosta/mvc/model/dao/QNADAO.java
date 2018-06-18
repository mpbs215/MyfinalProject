package kosta.mvc.model.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosta.mvc.model.dto.QNADTO;

@Repository
public class QNADAO {

	@Autowired
	private SqlSession session;

	public List<QNADTO> selectQNAList() {
		List<QNADTO> list = session.selectList("commonMapper.selectQNAAll");
		return list;
	}

	public QNADTO selectOneQNA(HttpServletRequest request, HttpServletResponse response, int QNANo) {
		QNADTO qnaDTO = session.selectOne("commonMapper.selectOneQNA", QNANo);
		return qnaDTO;
	}

	public int insertQNA(QNADTO qnaDTO) {
		int result = session.insert("commonMapper.insertQNA", qnaDTO);
		return result;
	}

	public int updateQNA(QNADTO qnaDTO) {
		int result = session.update("commonMapper.updateQNA", qnaDTO);
		return result;
	}

	public int deleteQNA(int QNANo) {
		int result = session.update("commonMapper.deleteQNA", QNANo);
		return result;
	}

	public void increaserQNA(QNADTO qnaDTO) {
		session.update("commonMapper.increaseQNAHit", qnaDTO);
	}
}
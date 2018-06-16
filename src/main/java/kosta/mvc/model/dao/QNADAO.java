package kosta.mvc.model.dao;

import java.util.List;

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

	public QNADTO selectOneQNA(int QNANo) {
		QNADTO qnaDTO = session.selectOne("commonMapper.selectOneQNA", QNANo);
		return qnaDTO;
	}
}
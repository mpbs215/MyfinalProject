package kosta.mvc.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosta.mvc.model.dto.FAQDTO;

@Service
public class FAQDAO {
	
	@Autowired
	private SqlSession session;

	public List<FAQDTO> selectFAQ() {
		return session.selectList("commonMapper.selectFAQ");
	}

}
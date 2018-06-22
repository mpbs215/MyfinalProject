package kosta.mvc.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosta.mvc.model.dto.SidogugundongriDTO;

@Repository
public class SidogugundongriDAO {
	
	@Autowired
	private SqlSession session;
	
	public List<String> selectSido() {
		return session.selectList("searchMapper.selectSido");
	}
	
	public List<String> selectGugun(String sido) {
		return session.selectList("searchMapper.selectGugun",sido);
	}
	
	public List<String> selectDong(String gugun) {
		return session.selectList("searchMapper.selectDong",gugun);
	}
	
	public List<String> selectRi(String dong) {
		return session.selectList("searchMapper.selectRi",dong);
	}
	
}
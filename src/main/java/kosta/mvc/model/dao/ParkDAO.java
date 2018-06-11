package kosta.mvc.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosta.mvc.model.dto.ParkDTO;

@Repository
public class ParkDAO {
	@Autowired
	private SqlSession session;

	public int insertPark(ParkDTO parkDTO) {
		return session.insert("",parkDTO);
	}

	public List<ParkDTO> selectParkList(String userId) {
		return session.selectList("sellerMapper.selectPark",userId);
	}

	public int sellerParkDelete(int parkNo) {
		return session.delete("sellerMapper.deletePark", parkNo);
	}

	public ParkDTO selectOnePark(int parkNo) {
		return session.selectOne("userMapper.selectOnePark",parkNo);
	}
}
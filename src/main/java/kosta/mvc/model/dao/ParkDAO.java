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

	public int insertPark(ParkDTO parkDto) {
		return session.insert("",parkDto);
	}

	public List<ParkDTO> sellerParkList(String id) {
		return session.selectList("sellerMapper.sellerParkByUserId",id);
	}

	public int sellerParkDelete(int parkNo) {
		return session.delete("sellerMapper.deletePark", parkNo);
	}
}
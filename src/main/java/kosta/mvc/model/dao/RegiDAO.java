package kosta.mvc.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosta.mvc.model.dto.ParkDTO;

@Repository
public class RegiDAO {
	
	@Autowired
	private SqlSession session;

	public int sellerReserveDelete(int parkNo) {
		return session.delete("sellerMapper.deleteSellerReserveByparkNo", parkNo);
	}

	public int insertParkRegi(ParkDTO parkDto) {
		return session.insert("sellerMapper.insertParkRegi",parkDto);
	}
	
}
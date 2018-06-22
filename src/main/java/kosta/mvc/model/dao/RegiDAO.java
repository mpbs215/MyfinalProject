package kosta.mvc.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosta.mvc.model.dto.ParkDTO;
import kosta.mvc.model.dto.ParkRegiDTO;

@Repository
public class RegiDAO {
	
	@Autowired
	private SqlSession session;

	public int sellerReserveDelete(int parkNo) {
		return session.delete("sellerMapper.deleteSellerReserveByparkNo", parkNo);
	}

	public int insertParkRegi(ParkRegiDTO parkRegiDto) {		
		return session.insert("sellerMapper.insertParkRegi",parkRegiDto);
	}

	public ParkRegiDTO selectOneParkRegi(int parkNo) {
		return session.selectOne("userMapper.selectOneParkRegi",parkNo);
	}
	
}
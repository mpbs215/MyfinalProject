package kosta.mvc.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosta.mvc.model.dto.CarTypeDTO;

@Repository
public class CarTypeDAO {
	@Autowired
	private SqlSession session;

	public int insertCarType(String carType,int parkNo) {
		return session.insert("sellerMapper.insertCarType",null);
	}
}
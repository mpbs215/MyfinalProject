package kosta.mvc.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosta.mvc.model.dto.CarTypeDTO;
import kosta.mvc.model.dto.ParkReserveDTO;

@Repository
public class CarTypeDAO {
	@Autowired
	private SqlSession session;

	public int insertCarType(String carType,int parkNo) {
		return session.insert("sellerMapper.insertCarType",null);
	}

	public int selectMaxCar(ParkReserveDTO dto) {
		return session.selectOne("userMapper.selectMaxCar",dto);
	}
	
	public List<CarTypeDTO> selectCarType(int parkNo) {
		return session.selectList("userMapper.selectCarType", parkNo);
	}
}
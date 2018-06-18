package kosta.mvc.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosta.mvc.model.dto.ParkDTO;
import kosta.mvc.model.dto.ParkReserveDTO;

@Repository
public class ParkReserveDAO {
	
	@Autowired
	private SqlSession session;

	public int sellerReserveDelete(int reserveNo) {
		return session.delete("sellerMapper.deleteReserve",reserveNo);
	}
	
	/**
	 * @param id
	 * @return 지난예약상황
	 */
	public List<ParkReserveDTO> sellerReserveList(String id) {
		return session.selectList("sellerMapper.selectReserveById",id);
	}
	
	/**
	 * 
	 * @param userId 판매자 아이디
	 * @return 현재예약상황
	 */
	public List<ParkReserveDTO> sellerReserveListLoad(String userId) {
		return session.selectList("sellerMapper.selectReserveLoadById",userId);
	}

	public List<ParkReserveDTO> selectparkReserve(int parkNo) {
		return session.selectList("userMapper.selectparkReserve",parkNo);
	}

	public int insertReserve(ParkReserveDTO dto) {
		return session.insert("userMapper.insertReserve",dto);
	}

	public int confirmReserve(ParkReserveDTO parkReserveDTO) {
		return session.selectOne("userMapper.confirmReserve",parkReserveDTO);
	}

	public List<ParkDTO> userReserveList(String userId) {
		return session.selectList("userMapper.selectUserReserve",userId);
	}
	
	
}
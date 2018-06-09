package kosta.mvc.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosta.mvc.model.dto.ParkImgDTO;

@Repository
public class ParkImgDAO {
	@Autowired
	private SqlSession session;

	public int insertImg(String originalFilename, int parkNo) {
		return session.insert("sellerMapper.insertImg", new ParkImgDTO(parkNo,originalFilename));
	}
}
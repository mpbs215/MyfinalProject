package kosta.mvc.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosta.mvc.model.dto.ParkImgDTO;

@Repository
public class ParkImgDAO {
	@Autowired
	private SqlSession session;

	public int insertImg(ParkImgDTO parkImgDto) {		
		return session.insert("sellerMapper.insertImg",parkImgDto);
	}

	public List<ParkImgDTO> selectImage(int parkNo) {
		return session.selectList("userMapper.selectImage",parkNo);
	}
}
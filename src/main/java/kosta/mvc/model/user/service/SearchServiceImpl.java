package kosta.mvc.model.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosta.mvc.model.dao.ParkDAO;
import kosta.mvc.model.dao.SidogugundongriDAO;
import kosta.mvc.model.dto.ParkDTO;
import kosta.mvc.model.dto.SearchFilterDTO;

@Service
public class SearchServiceImpl {
	@Autowired
	private SidogugundongriDAO sidogugundongriDAO;
	
	@Autowired
	private ParkDAO parkDAO;
	
	public List<String> selectSido(){
		return sidogugundongriDAO.selectSido();
	}
	
	public List<String> selectGugun(String sido){
		return sidogugundongriDAO.selectGugun(sido);
	}
	
	public List<String> selectDong(String gugun){
		return sidogugundongriDAO.selectDong(gugun);
	}
	
	public List<String> selectRi(String dong){
		return sidogugundongriDAO.selectRi(dong);
	}

	public List<ParkDTO> renewParkList(SearchFilterDTO dto) {
		return parkDAO.renewParkList(dto);
	}
}
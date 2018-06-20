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
		System.out.println("ajax 작동");
		System.out.println("유효성 체크");
		if(dto.getParkAddr()!=null && dto.getParkAddr().trim().equals("")) {
			dto.setParkAddr(null);
		}
		if(dto.getCarType()!=null && dto.getCarType().trim().equals("")) {
			dto.setCarType(null);
		}
		if(dto.getReserveDate()!=null && dto.getReserveDate().trim().equals("")) {
			dto.setReserveDate(null);
		}
		if(dto.getParkContent()!=null && dto.getParkContent().trim().equals("")) {
			dto.setParkContent(null);
		}
		if(dto.getDestination()!=null && dto.getDestination().trim().equals("")) {
			dto.setDestination(null);
		}
		if(dto.getParkName()!=null &&dto.getParkName().trim().equals("")) {
			dto.setParkName(null);
		}
		System.out.println("유효성 체크완료");
		System.out.println(dto);
		return parkDAO.renewParkList(dto);
	}
}
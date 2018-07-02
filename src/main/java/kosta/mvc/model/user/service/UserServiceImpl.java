package kosta.mvc.model.user.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kosta.mvc.model.dao.AuthoritiesDAO;
import kosta.mvc.model.dao.CarTypeDAO;
import kosta.mvc.model.dao.ParkDAO;
import kosta.mvc.model.dao.ParkImgDAO;
import kosta.mvc.model.dao.ParkReserveDAO;
import kosta.mvc.model.dao.RegiDAO;
import kosta.mvc.model.dao.ReviewDAO;
import kosta.mvc.model.dao.SidogugundongriDAO;
import kosta.mvc.model.dao.UserDAO;
import kosta.mvc.model.dto.AuthorityDTO;
import kosta.mvc.model.dto.CarTypeDTO;
import kosta.mvc.model.dto.ParkDTO;
import kosta.mvc.model.dto.ParkImgDTO;
import kosta.mvc.model.dto.ParkRegiDTO;
import kosta.mvc.model.dto.ParkReserveDTO;
import kosta.mvc.model.dto.ReviewDTO;
import kosta.mvc.model.dto.TempKeyDTO;
import kosta.mvc.model.dto.SidogugundongriDTO;
import kosta.mvc.model.dto.UserDTO;

@Service
@Transactional
public class UserServiceImpl {

	@Autowired
	private ReviewDAO reviewDAO;
	@Autowired
	private ParkDAO parkDAO;
	@Autowired
	private ParkImgDAO parkImgDAO;
	@Autowired
	private RegiDAO regiDAO;
	@Autowired
	private ParkReserveDAO parkReserveDAO;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private CarTypeDAO carTypeDAO;
	@Autowired
	private AuthoritiesDAO authoritiesDAO;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	/**
	 *	ȸ�������ϱ�
	 * */
	@Transactional
	public void signUp(UserDTO userDTO) {

		// ��й�ȣ ��ȣȭ
		String encodedPassword = passwordEncoder.encode(userDTO.getPassword());
		userDTO.setPassword(encodedPassword);
		userDAO.signUp(userDTO);
		
		AuthorityDTO authDTO = new AuthorityDTO();
		authDTO.setUserId(userDTO.getUserId());
		authDTO.setRole("ROLE_USER");
		authDTO.setKeydata("0");
		authDTO.setHp(userDTO.getHp());
		
		System.out.println("Auth���̺��� ���̵�� : " + authDTO.getUserId());
		
		if (userDTO.getSeller() == 0 ) {
			int result = authoritiesDAO.insertAuthority(authDTO);
			System.out.println("���� ����Ϸ��µ� : " +result);
			
			if (result ==0) {
				throw new RuntimeException("���� ��Ͽ� ���� �Ͽ����ϴ�. / ȸ�������� ������ �ּ���");
			}
		}  
	}

	public List<ReviewDTO> userClickReviewStar(int parkNo, int rating) {
		return reviewDAO.userClickReviewStar(parkNo, rating);
	}

	public ParkDTO selectOnePark(int parkNo) {
		return parkDAO.selectOnePark(parkNo);
	}

	public List<ReviewDTO> selectReview(int parkNo) {
		return reviewDAO.selectReview(parkNo);
	}

	public ParkRegiDTO selectOneParkRegi(int parkNo) {
		return regiDAO.selectOneParkRegi(parkNo);
	}

	public List<ParkReserveDTO> selectparkReserve(int parkNo) {
		return parkReserveDAO.selectparkReserve(parkNo);
	}

/*	public List<ParkDTO> userReserve() {
		System.out.println("���� �����");
		return parkDAO.selectParkList(null);
	}*/

	public Map<String, Object> userReserveForm(int parkNo) {
		ParkDTO parkDTO = parkDAO.selectOnePark(parkNo);
		if (parkDTO == null) {
			throw new RuntimeException("�ش� �������� �������� �ʽ��ϴ�.");
		}
		ParkRegiDTO parkRegiDTO = regiDAO.selectOneParkRegi(parkNo);
		if (parkRegiDTO == null) {
			throw new RuntimeException("�ش� �������� ���������� �������� �ʽ��ϴ�.");
		}
		List<ParkReserveDTO> parkReserveList = parkReserveDAO.selectparkReserve(parkNo);
		List<ReviewDTO> reviewList = reviewDAO.selectReview(parkNo);
		List<ParkImgDTO> parkImageList = parkImgDAO.selectImage(parkNo);
		List<CarTypeDTO> carTypeList = carTypeDAO.selectCarType(parkNo);
		Map<String, Object> map = new HashMap<>();
		map.put("parkDTO", parkDTO);
		map.put("parkRegiDTO", parkRegiDTO);
		map.put("parkReserveList", parkReserveList);
		map.put("reviewList", reviewList);
		map.put("parkImageList", parkImageList);
		map.put("carTypeList", carTypeList);

		return map;
	}

	/**
	 * ȸ������ Ȯ�� �� ����
	 */

	public UserDTO selectUserInfo(String userId) {

		return userDAO.selectMemberById(userId);
	}

	public void updateUserInfo(UserDTO userDTO) {
		int result=userDAO.updateUserInfo(userDTO);
		if(result == 0) {
			throw new RuntimeException("ȸ������ ���ſ� �����Ͽ����ϴ�.");
		}
	}

	public void insertReview(ReviewDTO dto) {
		try {
			int result = reviewDAO.insertReview(dto);
		} catch (Exception e) {
			throw new RuntimeException("����� �ѻ���� �ϳ��� ��ϰ����մϴ�.");
		}
	}

	public void insertReserve(ParkReserveDTO dto) {
		parkReserveDAO.insertReserve(dto);
	}

	public String reserveCheck(ParkReserveDTO dto) {
		System.out.println("����ȣ���");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String result = "OK";
		try {

			Date date1 = sdf.parse(dto.getReserveStart());
			Date date2 = sdf.parse(dto.getReserveEnd());

			Calendar cal1 = Calendar.getInstance();
			Calendar cal2 = Calendar.getInstance();
			cal1.setTime(date1);
			cal2.setTime(date2);

			int maxCar = carTypeDAO.selectMaxCar(dto);

			// ��¥ ����
			while (cal1.getTimeInMillis() <= cal2.getTimeInMillis()) {
				int s = parkReserveDAO.confirmReserve(new ParkReserveDTO(sdf.format(cal1.getTime()), dto.getCarType()));
				System.out.println("�����" + s);
				if (s >= maxCar) {
					result = "No";
				}
				cal1.add(Calendar.HOUR, 1);
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}

		System.out.println("���񽺿Ϸ��");

		return result;
	}

	/**
	 * 	�α���üũ�ϱ�
	 * */
	public UserDTO loginCheck(UserDTO userDTO) {

		return userDAO.loginCheck(userDTO);
	}

	/**
	 * ���̵�� ���� �˻��ϱ� (�ϳ��� ���̵𿡴� �������� ������ ���� �� �ִ�)
	 * */
	public List<AuthorityDTO> selectAuthorityByUserId(String userId) {
		return authoritiesDAO.selectAuthorityByUserId(userId);
	}

	/**
	 * 	�̸����� �̿��Ͽ� ���̵�, ��й�ȣ ã��
	 * */
	public UserDTO execute(String email) throws Exception {

		UserDTO resultDTO = userDAO.findByEmail(email);

		System.out.println("service���� resultDTO�� : " + resultDTO);

		if (resultDTO == null)
			throw new RuntimeException();
		// ����ڰ� �Է��� ���̵� �������� ������ ���� ����.

		return resultDTO;
	}
	
	/**
	 * 	id �ߺ� üũ
	 * */
	public String idcheck(String userId) {
		UserDTO userDTO = userDAO.idcheck(userId);
		
		return (userDTO!=null) ? "fail" : "ok"; 	//fail  �ߺ�, ok ��밡��
	}

	public List<ParkDTO> userMypageReserveList(String userId) {
		return parkReserveDAO.userReserveList(userId);
	}
	
	/**
	 * 	SMS�̿��Ͽ� ���������ϱ�
	 * */
	public void insertAuthCode(String userId, String hp, String key) {
			AuthorityDTO authDTO = new AuthorityDTO();
			TempKeyDTO sms = new TempKeyDTO();
			authDTO.setKeydata(key);
			System.out.println("key : " +key);
			
			authDTO.setRole("ROLE_SELLER");
			authDTO.setUserId(userId);
			authDTO.setHp(hp);
			
			System.out.println("authDTO : " + authDTO.getKeydata());
			
		 	sms.setUserId(userId);
			sms.setHp(hp);
		 	sms.setKey(key);
		 	
		 	authoritiesDAO.updateKey(authDTO);
			int result = userDAO.SMSAuth(sms);
			
			System.out.println("result �� : " +result);
			
			if (result == 0) {
				throw new RuntimeException("���� ���� ����");
			}
	}
	
	/**
	 * 	���� ��ȣ�� ��ġ�� ��� ������ Seller�� �ٲ��ֱ�
	 * */
	public void updateAuth(String authKey) {
				int result = authoritiesDAO.updateAuth(authKey);
				
				if (result ==0) 
						throw new RuntimeException("���� ��ȣ�� ��ġ���� �ʾ� ������ �����Ͽ����ϴ�.");
	}

	
	/**
	 * 	ȸ�� Ż���ϱ� (Auth ���̺�)
	 * */
	
	/*public int deleteAuth(String password, String hp) {
		int result = authoritiesDAO.deleteAuth(password, hp);
		
		int count=0;
		
		System.out.println("Auth (service ���� result ) " +result);
		if (result == 0 ) {
			throw new RuntimeException(hp+ "�� ��ġ�ϴ� ȸ�������� ã�� �� �Ͽ����ϴ�.(Auth)" );
		} else {
			System.out.println(hp +"�� ��ġ�ϴ� ȸ�� �Դϴ�.");
		}
		return result;
	}*/
	
	/**
	 *  ȸ�� Ż���ϱ� (SMS ���̺�)
	 * */
	
/*	public int deleteSMS(String password, String hp) {
		int result = userDAO.deleteSMS(password, hp);
		
		if (result == 0 ) { 
			throw new RuntimeException(hp+ "�� ��ġ�ϴ� ȸ�������� ã�� �� �Ͽ����ϴ�.(SMS)");
		}
		return result;
	}*/
	
	/**
	 * ȸ�� Ż��� ��й�ȣ ��ġ�����ֱ� ���ؼ� ��ȣȭ�� ��й�ȣ �������� 
	 * */
	public String selectPassword(String userId) {
			String password = userDAO.selectPassword(userId);
			
			System.out.println("Service���� ��й�ȣ : " +password);
			
			return password;
	}
	
	/**
	 * ȸ�� Ż���ϱ� (UserInfo ���̺�)
	 * */
	public int deleteUserInfo(String encodePassword) {
		int result = userDAO.deleteUserInfo(encodePassword);
		
		if (result == 0 ) { 
			throw new RuntimeException(encodePassword+ "�� ��ġ ���� �ʽ��ϴ�.");
		}
		return result;
	}
	
	
	public void deleteReserve(int reserveNo) {
		parkReserveDAO.deleteReserve(reserveNo);
	}

	public void updateReserve(ParkReserveDTO dto) {
		parkReserveDAO.updateReserve(dto);
	}
}
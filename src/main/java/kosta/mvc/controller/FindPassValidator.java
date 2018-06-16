package kosta.mvc.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kosta.mvc.model.dto.UserDTO;

public class FindPassValidator implements Validator { //비밀번호 찾기 화면에서 이메일과 아이디가 제대로 입력 됬는지 검증하는 클래스
	 
	
    private Pattern pattern;
    private Matcher matcher;
	
    String regexp = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$"; //이메일 정규 표현식
    
    public FindPassValidator() {
    	pattern = pattern.compile(regexp);
    }
    @Override
    public boolean supports(Class<?> clazz) {
        return UserDTO.class.isAssignableFrom(clazz);
    }
 
	@Override
    public void validate(Object target, Errors errors) {
        UserDTO userDTO = (UserDTO)target;    
        System.out.println("validate" +"여기 실행되나" +target);
        System.out.println("userDTO의 이메일" +userDTO.getEmail());
        //이메일이 올바른 형식인지 검사
        matcher = pattern.matcher(userDTO.getEmail());
        
        if(userDTO.getEmail() == null || userDTO.getEmail().trim().isEmpty()) {
            errors.reject("NoEmail");
        }
        else if(!matcher.matches())  { //사용자가 입력한 이메일이 정규표현식에 매치 되지않는다면
            errors.reject("NotEmailPattern");
        }
    }
}
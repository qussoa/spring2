package com.biz.sec.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.biz.sec.domain.UserVO;
import com.biz.sec.persistence.UserDao;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

	private final PasswordEncoder passwordEncoder;
	private final UserDao userDao;	
	
	
	/*
	 * 회원가입을 신청하면 비밀번호는 암호화하고
	 * 아이디와 비번을 DB에 insert 수행
	 */
	
	public int insert(String username,String password) {

		// 회원가입 form에서 전달받은 password값을 암호화 시키는 과정
		String encPassword = passwordEncoder.encode(password);
		
		//UserVO userVO = new UserVO(username,encPassword,true);
		Map<String, String> userVO = new HashMap<String,String>();
		userVO.put("username",username);
		userVO.put("password",encPassword);
		int ret = userDao.insert(userVO);
		
		return ret;
	}


	public boolean isExistsId(String username) {

		String user_name = userDao.findByUserName(username);
		if(user_name != null && user_name.equalsIgnoreCase(username)) {
			return true;
		}
		
		return false;
	}
}

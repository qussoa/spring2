package com.biz.sec.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.biz.sec.domain.UserDetailsVO;
import com.biz.sec.domain.UserVO;
import com.biz.sec.persistence.UserDao;


@Service
public class UserService {

	// @Autowirted
	private final PasswordEncoder passwordEncoder;
	
	private final UserDao userDao;

	
	
	public UserService(PasswordEncoder passwordEncoder, UserDao userDao) {
		super();
		this.passwordEncoder = passwordEncoder;
		this.userDao = userDao;
		
		String create_user_table = "CREATE TABLE IF NOT EXISTS tbl_users( " + 
				" id BIGINT PRIMARY KEY AUTO_INCREMENT, " + 
				" user_name VARCHAR(50) UNIQUE, " + 
				" user_password VARCHAR(125), " + 
				" enabled boolean default true, " +
				" email VARCHAR(50), " +
				" phone VARCHAR(20), " +
				" address VARCHAR(125) " +
				" )";
		
		String create_auth_table = "CREATE TABLE IF NOT EXISTS authorities(" + 
				" id BIGINT PRIMARY KEY AUTO_INCREMENT," + 
				" username VARCHAR(50)," + 
				" authority VARCHAR(50)" + 
				")";
		
		userDao.create_table(create_user_table);
		userDao.create_table(create_auth_table);
	}

	public int insert(String username, String password) {
		
		// 회원가입 form에서 전달받은 password 값을 암호화 시키는 과정
		String encPassword = passwordEncoder.encode(password);
		UserVO userVO = UserVO.builder()
							.username(username)
							.password(encPassword).build();
		
		int ret = userDao.insert(userVO);
		return ret;
	
	}

	public boolean isExistsUserName(String username) {
		
		UserDetailsVO userVO = userDao.findByUserName(username);
		// 이미 DB에 회원정보(username)이 저장되어 있다.
		if(userVO != null && 
				userVO.getUsername().equalsIgnoreCase(username)) {
			return true;
		}
		return false;
	
	}

	public UserDetailsVO findById(long id) {

		UserDetailsVO userVO = userDao.findById(id);
		
		return userVO;
	}

}






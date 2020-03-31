package com.biz.models.service;

import org.springframework.stereotype.Service;

import com.biz.models.dao.UsersDao;
import com.biz.models.domain.UsersVO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {


	private final UsersDao userDao;
	
	public UsersVO getUser(String userId) {
//		UsersVO usersVO = UsersVO.builder()
//				.userId("admin")
//				.password("1234")
//				.userName("홍길동")
//				.userRolle("admin")
//				.build();

		UsersVO usersVO = userDao.findByUserId("admin");
		if(userId.equals("admin")) {
			return usersVO;
		} else if(userId.equals("guest")) {
			
//			usersVO.setUserId("guest");
//			usersVO.setUserName("성춘향");
			usersVO = userDao.findByUserId("guest");
		} else if(userId.equals("dba")) {
//			usersVO.setUserId("dba");
//			usersVO.setUserName("이몽룡");
			usersVO = userDao.findByUserId("dba");
		} else {
			usersVO = null;
		}
		return usersVO;
	}
	
	/*
	 * insert method는 UsersVO에 담긴 데이터를 받아서
	 * insert를 수행한 후
	 * 결과를 return 하도록 되어 있다
	 * return 한 값은 데이터가 1개이므로 정수 1(0보다 큰값)이 된다
	 * 이러한 테스트코드를 만들기 위해
	 * 일단 가상으로 return 1의 코드를 추가
	 */
	public int insert(UsersVO userVO) {
		
		
		return userDao.insert(userVO);
	}

	public int delete(String userId) {
		
		return userDao.delete(userId);
	}
	


}

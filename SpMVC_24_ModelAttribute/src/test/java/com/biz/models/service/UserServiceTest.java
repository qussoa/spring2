package com.biz.models.service;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.biz.models.domain.UsersVO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/*-context.xml"})
public class UserServiceTest {

	@Autowired
	UserService us;	
	
	/*
	 * TDD : Test Driven Developer
	 * 테스트 주도형 개발
	 * 1. 클래스와 필요한 메서드의 이름만 만들고 필요에 따라
	 * 2. 매개변수와 리턴 값만 설정을 한다
	 * 3. Test에서 매개변수를 주입했을때 리턴되는 값이 일치함을 test하는 코드를 작성한후
	 * 4. 실제 클래스에서 가상의 일치하는 데이터를 만들고
	 * 5. 데이터를 return 하도록 코드를 작성
	 * 6. 테스트를 수행하여 통과되도록 코드를 리펙트링하여 
	 * 7. 임시로 클래스를 완성한다
	 * 
	 *    Dao에서 데이터를 가져온 후 ID에 따라 사용자아이디와
	 *    사용자 이름이 일치하는 Test코드를 작성해 둔 상태이다
	 *    1. Dao에 데이터를 저장할때 테스트 코드가 통과될 수 있는
	 *    	 데이터를 INSERT한 후
	 *    2. 다시 한번 테스트를 수행하여 Dao와 연동되는 것을
	 *     	 계속해서 확인한다
	 */
	
	@Test
	public void c_getUserTest() {
		UsersVO usersVO = us.getUser("admin");
		assertEquals(usersVO.getUserId(), "admin");
		assertEquals(usersVO.getUserName(), "홍길동");
		
		usersVO = us.getUser("guest");
		assertEquals(usersVO.getUserId(), "guest");
		assertEquals(usersVO.getUserName(), "성춘향");
		
		usersVO = us.getUser("dba");
		assertEquals(usersVO.getUserId(), "dba");
		assertEquals(usersVO.getUserName(), "이몽룡");
	}

	@Test
	public void b_insertTest() {
		UsersVO usersVO = UsersVO.builder()
				.userId("korea")
				.password("12345")
				.userName("대한민국")
				.userRolle("gov")
				.build();
		int ret = us.insert(usersVO);
		// ret 값이 1이며 오차가 없는 결과를 받았느냐라고 묻고
		// Test를 수행한다
		assertEquals(ret, 1,0);
		
		usersVO = UsersVO.builder()
				.userId("admin")
				.password("1234")
				.userName("홍길동")
				.userRolle("admin")
				.build();
		ret = us.insert(usersVO);
		assertEquals(ret,1, 0);

		
		
		usersVO = UsersVO.builder()
				.userId("guest")
				.password("1234")
				.userName("성춘향")
				.userRolle("guest")
				.build();

		ret = us.insert(usersVO);
		assertEquals(ret,1, 0);

		
		usersVO = UsersVO.builder()
				.userId("dba")
				.password("1234")
				.userName("이몽룡")
				.userRolle("dba")
				.build();
		
		
		ret = us.insert(usersVO);
		assertEquals(ret,1, 0);
				
	}
	
	
	@Test
	public void a_deleteTest() {
		int ret = us.delete("admin");
		ret = us.delete("guest");
		ret = us.delete("dba");
		ret = us.delete("korea");
		
		assertEquals(ret,1,0);
	}
	
	
}
























package com.biz.ajax.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserVO implements Serializable {

	private String userId;
	private String password;
	private String userName;
	private String rolle;
	
	// get method는 필드변수가 있다고 인식
	// jackson이 json으로 변경하는 동안에 착각을하고
	// 오류를 일으킬 수 있다
	public UserVO sampleVO() {
		UserVO userVO = UserVO.builder()
				.userId("admin")
				.password("1234")
				.userName("홍길동")
				.rolle("admin")
				.build();
		return userVO;
	}
}

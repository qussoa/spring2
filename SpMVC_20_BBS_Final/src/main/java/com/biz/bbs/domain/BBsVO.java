package com.biz.bbs.domain;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/*
 * VO(value object) = DTO(Data Transfer Object) 클래스
 * method와 method간의
 * web browser와 controller간의
 * controller와 view.jsp 간의 데이터를
 * 교환하는 매개체 역할을 수행
 * 일반적으로 select되는 table의 칼럼을 포함하고
 * web browser에서 form tag를 사용하여 
 * controller로 데이터를 보낼때 form tag가 포함하는
 *  input tag들의 name값들을 포함
 *  
 *   VO클래스는
 *   객체지향 특징중 추상화, 정보은닉, 캡슐화 특징을 포함하고 있다
 *   추상화 : 어떤 필드변수들을 만들 것인가 설계
 *   정보은닉 : 필드변수를 private로 선언
 *   캡슐화 : getter, setter method의 코드 정의 
 * 
 */
@Alias("bbsVO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class BBsVO {

	private long b_id;			// number
	private String b_p_id;			//	number
	private String b_date_time;	//	varchar2(30)
	private String b_writer;		//	nvarchar2(30)
	private String b_subject;		//	nvarchar2(125)
	private String b_content;		//	nvarchar2(2000)
	private String b_file;			//	nvarchar2(125)

}

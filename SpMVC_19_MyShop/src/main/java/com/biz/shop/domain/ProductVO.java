package com.biz.shop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.ibatis.type.Alias;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * @Email
 * @NotBlank,@NotNull,@NotEmpty : 공백형식
 * @Null : null일 경우
 * @Size(min,max)
 * @Max()
 * @Min()
 * @DecimalMax(x) : x값 이하의 실수
 * @DecimalMin(x) : x값 이상의 실수
 * @Digits(정수) : 정수 자릿수 검사
 * @Digits(숫자, fraction=y) : 숫자 자릿수 이하이면서 소숫점 y 자리수 이하
 * @Pattern(regxp = "//d{1,15}) 1 부터 15까지의 숫자만 가능
 * 			전화번호를 순수 숫자로만 입력받고 싶을때
 * 			전체가 숫자로만 이루어지고
 * 			숫자 15자리수 미만
 * @Pattern(regxp - "//d[30-55]") 30~55 
 */
@Alias("productVO")
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Builder

@Entity
@Table(name = "tbl_product",schema = "emsDB")
public class ProductVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="p_id")
	private long id;
	
	/*
	 * 입력값이 공백일 경우 error
	 * @NotEmpty()
	 * @NotNull
	 */
	@NotBlank(message = "* 상품코드 입력")
	/*
	 * 문자열의 길이가 맞지 않을경우
	 * @Size(max, min)
	 * @Min(), max()
	 */
	@Size(max = 13, message = "* 상품코드 13자 이하")
	@Column(name="p_code", length = 13,unique = true,nullable = false)
	private String p_code;
	
	/* 
	 * @phoneNuber() : email 형식
	 * @Pattern(정규식문법)
	 * /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/
	 */
	/*
	 * 문자열이 email 형식과 같은지 검사
	 * @Email()
	 */
	@NotBlank(message = "* 상품명 입력")
	@Column(name="p_name")
	private String p_name;
	
	@Size(min=5, max=5,message = "*품목코드확인")
	@Column(name="p_bcode", length = 5)
	private String p_bcode;
	
	@Size(min=5, max=5,message = "*거래처코드확인" )
	@Column(name="p_dcode", length = 5)
	private String p_dcode;
	
	@Column(name="p_iprice")
	private int p_iprice;
	
	@Column(name="p_oprice")
	private int p_oprice;
	
	@Column(name="p_detail")
	@Type(type = "text")
	private String p_detail;
}

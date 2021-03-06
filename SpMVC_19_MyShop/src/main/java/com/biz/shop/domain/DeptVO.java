package com.biz.shop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.apache.ibatis.type.Alias;

import com.biz.shop.domain.ProductVO.ProductVOBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * 거래처정보를 저장할 테이블 Entity설계
 * id 
 * 거래처코드 d_code
 * 거래처명 d_name
 * 대표자명 d_ceo
 * 사업자번호 d_sid
 * 대표 전화번호 d_tel
 * 주소 d_addr
 * 담당자 d_manager
 * 담당자 연락처 d_mtel
 * 비고 d_remark
 */
@Alias("deptVO")
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Builder

@Entity
@Table(name = "tbl_dept", schema = "emsDB")
public class DeptVO {

	@Id
	@Column(name = "d_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(length = 5,unique = true,nullable = false)
	@Size(min = 5, max=5)
	@NotEmpty(message = "* 거래처 코드 입력")
	private String d_code;

	@Column(length = 30,nullable = false)
	@NotEmpty(message = "* 거래처 이름 입력")
	private String d_name;

	@Column(length = 30)
	private String d_ceo;

	@Column(length = 13,unique = true,nullable = false)
	@Size(min = 13, max = 13)
	private String d_sid;

	@Column(length = 20)
	private String d_tel;
	private String d_addr;

	@Column(length = 30)
	private String d_manager;

	@Column(length = 20)
	private String d_mtel;
	private String d_rem;
}

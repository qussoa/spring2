package com.biz.shop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.ibatis.type.Alias;

import com.biz.shop.domain.DeptVO.DeptVOBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;

@Alias("cartVO")
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Builder

@Entity
@Table(name = "tbl_cart", schema = "emsDB")
public class CartVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long seq;
	
	@Column(name = "username")
	private String username;
	//vo에서만 사용하고 table에 칼럼으로 등록하지말라
	@Transient
	private String p_name; 
	
	@Column(name = "p_code")
	private String p_code;
	@Column
	private int p_oprice;
	@Column
	private int p_qty;
	/*
	 * ,columnDefinition = "varchar(10) default='CART'"
	 */
	@Column(name="p_status",columnDefinition = "varchar(10) default'CART'")
	private String p_status;
	}

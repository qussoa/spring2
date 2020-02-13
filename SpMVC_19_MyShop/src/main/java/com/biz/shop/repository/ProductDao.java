package com.biz.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biz.shop.domain.ProductVO;

/*
 * hibernation에서 기본적으로 제공하는 CRUD를 사용하기 위해
 * JpaRepository를 상속받는데
 * <사용할VO,pk type>을 Generic으로 지정
 * 
 * PK type에서 primitive 형식으로 지정하지 않고
 * wrapper class 형식으로 지정
 * 
 * primitive
 * 매개 변수로 전달 했을때 그 값을 받아 
 * method에 (int) 변수의 값을 지정 method 외부에서 참조 불가능
 * 
 * wrapper class 참조형 변수
 * 어떤 method에 매개변수로 보내고 값이 변동되었을때
 * 원래 값이 변동될 수 있는 변수들 
 *  class로 만든 변수(객체) , 배열로 선언한 변수
 * method 밖에서 참조 가능
 * 모든 클래스와 배열 type형 변수
 * =================================
 * primitive  wrapper class
 * ---------------------------------
 * int        Integer
 * long       Long
 * double     Double
 * char       Character
 * 문자열     String
 * boolean    Boolean
 * =================================
 */
public interface ProductDao extends JpaRepository<ProductVO, Long> {
	// C(R)UD의 기본 method가 준비되었있다
}

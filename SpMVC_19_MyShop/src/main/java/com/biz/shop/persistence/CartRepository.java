package com.biz.shop.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biz.shop.domain.CartVO;

public interface CartRepository extends JpaRepository<CartVO, Long> {

	// C(R)UD의 기본 method가 준비되었있다
}

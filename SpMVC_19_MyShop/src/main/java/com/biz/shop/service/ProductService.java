package com.biz.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.biz.shop.domain.ProductVO;
import com.biz.shop.repository.ProductDao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductService {

	private final ProductDao pDao;
	
	public void save(ProductVO productVO) {
		ProductVO v = pDao.save(productVO);
		log.debug("상품 정보 : " + v.toString());
	}
	
	public List<ProductVO> selectAll(){
		
		List<ProductVO> proList = pDao.findAll();		
		return proList;
	}

	public ProductVO findByPCode(long id) {
		
		//ProductVO proVO = pDao
		
		return null;
	}

	public ProductVO findById(long id) {
		
		/*
		 * hibernate의 기본 조회 method들은
		 * 모든 VO 클래스를 Optional 클래스로 감싸서 return을 한다
		 * 이것은 혹시 모든 NullPointException을 방지하기 위한 조치
		 * 실제 VO 객체를 추출할 때는 return ret.get()을 사용한다
		 */
		Optional<ProductVO> proVO = pDao.findById(id);
		
		return proVO.get();
	}
}

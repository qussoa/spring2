package com.biz.shop.dao;

import java.util.List;

import com.biz.shop.domain.ProductVO;

public interface ProductDao {

	public List<ProductVO> findByName(String p_name);
}

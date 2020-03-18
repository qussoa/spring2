package com.biz.naver.controller;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.naver.domain.NaverVO;
import com.biz.naver.service.NaverService;

@Controller
public class NaverController {
	
	@Autowired
	NaverService nService;

	@ResponseBody
	@RequestMapping(value = "/search",method=RequestMethod.GET,produces = "application/json;charset=UTF-8")
	public List<NaverVO> naverSearch(String cat,String search) {
		
		List<NaverVO> naverVO;
		try {
			naverVO= nService.naverSearch(cat,search);
			return naverVO;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}

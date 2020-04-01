package com.biz.ajax.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.ajax.domain.UserVO;

@Controller
public class HomeController {
	
	/*
	 * userVO데이터를 생성하고(Service로부터 가져오기)
	 * model userVO를 싣고
	 * return "home"(home.jsp 호출)
	 * userVO와 home.jsp를 랜더링하여
	 * web client로 전송하라(*.html 코드로 변환되어 전송)
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		UserVO userVO = new UserVO();
		model.addAttribute("userVO",userVO.sampleVO());
		
		return "home";
	}
	
}

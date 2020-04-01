package com.biz.ajax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.ajax.domain.BookVO;

@RequestMapping(value = "/book")
@Controller
public class BookController {

	@RequestMapping(value = "/insert",method=RequestMethod.GET)
	public String insert(BookVO bookVO,Model model) {
		return "book_insert";
	}
	@RequestMapping(value = "/input",method=RequestMethod.GET)
	public String input(BookVO bookVO,Model model) {
		/*
		 * ResponseBody가 없는 controller의 method의 return 값은
		 * 문자열.jsp파일을 찾으라
		 * return 값이 null이면
		 * 현재 method를 호출할때 사용한 url의 path(book/input)를
		 * 문자열로 인식하고 book/input.jsp 파일을 찾는다 
		 */
		return null;
	}
	@RequestMapping(value = "/insert",method=RequestMethod.POST)
	public String insert(BookVO bookVO) {
		return "home";
	}
}

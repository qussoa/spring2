package com.biz.shop.controller;

import java.security.Principal;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.shop.domain.UserDetailsVO;
import com.biz.shop.service.UserService;

import lombok.RequiredArgsConstructor;

@RequestMapping(value = "/user")
@RequiredArgsConstructor
@Controller
public class UserController {

	private final UserService uService;
	
	@RequestMapping(value = "/login",method=RequestMethod.GET)
	public String login() {
		return "auth/login";
	}
	
	@RequestMapping(value = "/join",method=RequestMethod.GET)
	public String join() {
		return "auth/join";
	}
	
	@ResponseBody
	@RequestMapping(value = "/join",method=RequestMethod.POST)
	public String join(String username, String password) {
		uService.insert(username,password);
		return String.format("아이디 : <b>%s</b> , 비번 : <b>%s</b>",username,password);
	}
	
	@ResponseBody
	@RequestMapping(value = "/idcheck",method=RequestMethod.POST)
	public String idcheck(String username) {
		boolean ret = uService.isExistsUserName(username);
		if(ret) {
			return "Exists".toUpperCase();
		}
		return "NonExists".toUpperCase();
	}
	
	@ResponseBody
	@RequestMapping(value = "/password",method=RequestMethod.POST)
	public String password(String password) {
		boolean ret = uService.check_password(password);
		if(ret)
			return "PASS_OK";
		return "PASS_FAIL";
	}
	
	@ResponseBody
	@RequestMapping(value = "",method=RequestMethod.GET)
	public String user() {
		return "user HOME";
	}
	
	@RequestMapping(value = "/mypage",method=RequestMethod.GET)
	public String mypage(Principal principal, Model model) {
		UsernamePasswordAuthenticationToken upa 
		= (UsernamePasswordAuthenticationToken) principal;
		UserDetailsVO userVO = (UserDetailsVO) upa.getPrincipal();
		userVO.setAuthorities(upa.getAuthorities());
		model.addAttribute("userVO",userVO);
		return "auth/mypage";
	}
	
	@RequestMapping(value = "/mypage",method=RequestMethod.POST)
	public String mypage(UserDetailsVO userVO, String[] auth, Model model) {
		int ret = uService.update(userVO);
		return "redirect:/user/mypage";
	}
	
}



























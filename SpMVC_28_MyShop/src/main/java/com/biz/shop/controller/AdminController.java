package com.biz.shop.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.shop.domain.UserDetailsVO;
import com.biz.shop.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	
	private final UserService uService;
	
	@RequestMapping(value = "",method=RequestMethod.GET)
	public String admin(Principal principal) {
		return "admin/admin_main";
	}
	
	@RequestMapping(value = "/user_list",method=RequestMethod.GET)
	public String user_list(Model model) {
		List<UserDetailsVO> userList = uService.selectAll();
		model.addAttribute("userList",userList);
		return "admin/user_list";
	}
	
	@RequestMapping(value = "/user_detail_view/{username}",method=RequestMethod.GET)
	public String user_detail_view(@PathVariable("username") String username, 
			Model model) {
		UserDetailsVO userVO = uService.findByUserName(username);
		model.addAttribute("userVO",userVO);
		return "admin/user_detail_view";
	}
	
	public String mypage(UserDetailsVO userVO, String[] auth, Model model ) {
		int ret = uService.update(userVO,auth);
		return "redirect:/admin/user_details_view/"+userVO.getUsername();
	}
}

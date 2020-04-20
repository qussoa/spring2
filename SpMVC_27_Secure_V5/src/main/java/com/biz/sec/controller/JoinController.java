package com.biz.sec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.biz.sec.domain.UserDetailsVO;
import com.biz.sec.service.UserService;
import com.biz.sec.utils.PBEEncyptor;
import com.mysql.cj.Session;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@SessionAttributes("userVO")
@Controller
@RequestMapping(value = "/join")
public class JoinController {

	private final UserService uService;
	
	@ModelAttribute("userVO")
	public UserDetailsVO newUser() {
		return new UserDetailsVO();
	}

	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String join(@ModelAttribute("userVO") UserDetailsVO userVO, Model model) {

		return "join/join";
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String user(@ModelAttribute("userVO") UserDetailsVO userVO, Model model) {

		return "join/join_email";
	}
	
	@ResponseBody
	@RequestMapping(value = "/joinok", method = RequestMethod.POST)
	public String joinok(@ModelAttribute("userVO") UserDetailsVO userVO, Model model
			, SessionStatus session
			) {
		
		int ret = uService.insert(userVO);
		//String ret = uService.insert(userVO);
		
		model.addAttribute("JOIN","EMAIL_OK");
		
		//sessionAttribute에 저장된 session 값을 초기화 clear시키기
		//session.setComplete();
		return "join/join_email";
		//return userVO;
	//	return ret;
		}
	
	@ResponseBody
	@RequestMapping(value = "/emailok",method=RequestMethod.GET)
	public String emailOk(@ModelAttribute("userVO") UserDetailsVO userVO, Model model,SessionStatus session) {
		
		boolean ret = uService.emailok(userVO.getUsername(),userVO.getEmail());
		session.setComplete();
		if(ret) {
			return "redirect:/user/login";
		}else {
//			userVO = uService.findByUserName(PBEEncyptor.getDecrypt(userVO.getUsername()));
//			model.addAttribute("JOIN","EMAIL_FAIL");
			return "join/join_email_fail";
		}
		//return PBEEncyptor.getDecrypt(username)+PBEEncyptor.getDecrypt(email);
		
	}
}

package com.biz.shop.controller.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.biz.shop.domain.ProductVO;
import com.biz.shop.service.ProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping(value = "/user/product")
@Controller
public class B2C_Controller {

	public final ProductService pService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model,
			@RequestParam(value = "p_name", required = false, defaultValue = "") String p_name) {

		List<ProductVO> proList = new ArrayList<ProductVO>();
		if (p_name == "") {
			proList = pService.selectAll();
		} else {
			proList = pService.findByPName(p_name);
		}
		model.addAttribute("PROLIST", proList);

		return "users/user_product_list";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail() {
		return "";
	}
}

package com.biz.bbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.bbs.domain.BBsVO;
import com.biz.bbs.service.BBsService;

import lombok.RequiredArgsConstructor;


@Controller
public class BBsController {
	
	/*
	 * 현재 BBscontroller와 BBsService*는 
	 * BBsService interface를 거쳐서 연결이 되어 있다
	 * BBsService interface를 imp한 class code가 미완성된 상태이나
	 * BBsController 입장에서는 BBsService*의 코드가 완성되었다는 
	 * 전제하에 Controller 코드 작성을 진행할 수 있다
	 * 만약 이후에 BBsService*의 코드가 완성되고 
	 * 여러개의 BBsServiceImp* 클래스가 작성되면
	 * 필요한 클래스를 가져다가 부착만하면 
	 * 프로젝트가 완성이 될 것이다
	 * 결합도를 낮추는 결과
	 *  - 결합도 : 모듈간의 의존도, 모듈 코드 작성의 유연성과 관련
	 *  * 결합도 낮게 응집도 높은 모듈간의 연계가 좋은 설계이다
	 */
	@Autowired
	private BBsService bbsService;

	@RequestMapping(value = "/list",method=RequestMethod.GET)
	public String list() {
		bbsService.selectAll();
		return "bbs_list";
	}
	
	@RequestMapping(value = "/insert",method=RequestMethod.GET)
	public String insert() {
		
		
		return "bbs_write";
	}

	@RequestMapping(value = "/insert",method=RequestMethod.POST)
	public String insert(BBsVO bbsVO) {
		
		bbsService.insert(bbsVO);
		return "";
	}

	public String update(BBsVO bbsVO) {
		bbsService.update(bbsVO);
		return null;
	}

	public String delete(String strId) {
		bbsService.delete(Long.valueOf(strId));
		return null;
	}
}

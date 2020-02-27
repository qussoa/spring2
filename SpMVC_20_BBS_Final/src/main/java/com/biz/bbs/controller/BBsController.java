package com.biz.bbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.biz.bbs.domain.BBsVO;
import com.biz.bbs.service.BBsService;
import com.biz.bbs.service.FileService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
	
	@Autowired
	private FileService fileService;

	/*
	 * 게시판 목록 전체를 보기위한 method이고
	 * DB에서 tbl_bbs 테이블 전체를 SELECT한 결과를
	 * BBS_LIST라는 이름으로 model에 Attribute를 추가하여
	 * bbs0list.jsp와 rendering 하도록 수행
	 */
	@RequestMapping(value = "/list",method=RequestMethod.GET)
	public String list(Model model) {
		List<BBsVO> bbsList = bbsService.selectAll();
		
		model.addAttribute("BBS_LIST", bbsList);
		return "bbs_list";
	}
	/*
	 * 리스트에서
	 * 글쓰기(작성) 버튼을 클릭했을 떄 
	 * 게시판 작성화면을 열어줄 path
	 * 버튼을 클릭했을때 작동할 path 
	 * method를 get로 설정
	 */
	
	@RequestMapping(value = "/detail/{b_id}",method=RequestMethod.GET)
	public String detail(Model model, @PathVariable("b_id") String strId) {
		BBsVO bbsVO = bbsService.findById(Long.valueOf(strId));
		model.addAttribute("BBS",bbsVO);
		
		return "/bbs_detail";
	}
	
	@RequestMapping(value = "/insert",method=RequestMethod.GET)
	public String insert() {
		
		
		return "bbs_write";
	}

	/*
	 * 게시판 작성화면에서 저장(글쓰기)버튼을 클릭했을 때
	 *  - 게시판 작성화면은 <form> tag로 감싸져 있고
	 *  - form tag내의 input tag로 입력 상자를 구성하고
	 *  - 버튼이 2개 있다
	 *  - 그 중 저장(글쓰기) 버튼에는 아무런 type도 지정하지 않았기 때문에
	 *  - 저장 버튼을 클릭하면 <form> tag에 지정된 
	 *  - action path로 POST method에 지정된 방식으로 데이터를 전송한다
	 *  - 이러한 버튼의 기본 기능을 submit 기능이라 한다
	 *  
	 *  bbs_write.jsp에서는 <form> action을 제거했다
	 *  - 이렇게 되면
	 * - 처음 게시판 작성화면을 열기 위해서 사용했던
	 * - path인 ${rootPath}/bbs/insert가
	 *   action에 자동으로 설정이 된다
	 *   또한 method는 POST로 지정이 되어 있기 때문에
	 *   암시적으로 ${rootPath}/bbs/insert path로 POST방식으로 
	 *   데이터를 전송하라는 설정과 같다
	 *   method에서 요청을 수신하게 되고 input tag에 입력된
	 *   문자열들은 bbsVO 객체 변수에 담기게 된다
	 */
	@RequestMapping(value = "/insert",method=RequestMethod.POST)
	public String insert(BBsVO bbsVO) {
		
		Long b_id = bbsVO.getB_id();
		if(b_id > 0 ) {
			bbsService.update(bbsVO);	
		} else {
			bbsService.insert(bbsVO);
		}
					
		return "redirect:/list";
	}

	/*
	 * 게시판 리스트에서 제목을 클릭하면 
	 * update path에게 b_id 값을 전달하고
	 * b_id 값을 수신하여 게시판에서 한개의 게시판 데이터를 SELECT하고
	 * bbsVO에 담는다
	 * model에 bbsVO를 BBS라는 이름으로 Attribute를 추가하고
	 * bbs_wrtie.jsp파일에게 전달한다
	 */
	@RequestMapping(value = "/update",method=RequestMethod.GET)
	public String update(@RequestParam("b_id") String b_id, Model model) {
		
		BBsVO bbsVO = bbsService.findById(Long.valueOf(b_id));		
		model.addAttribute("BBS", bbsVO);
		
		return "bbs_write";
	}
	@RequestMapping(value = "/update",method=RequestMethod.POST)
	public String update(BBsVO bbsVO,Model model) {
		
	
		bbsService.update(bbsVO);	
		
		return "redirect:/list";
	}

	@RequestMapping(value = "/delete/{b_id}",method=RequestMethod.GET)
	public String delete(@PathVariable("b_id") String strId) {
		bbsService.delete(Long.valueOf(strId));
		return "redirect:/list";
	}
	
	@ResponseBody
	@RequestMapping(value = "/image_up",method= RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String fileUp(MultipartFile upFile) {
		
		log.debug("파일 업 : " + upFile.getOriginalFilename().toString());
		String retFileName = fileService.fileUp(upFile);
		if(retFileName == null) {
			return "FAIL";
		}
		return retFileName;
	}
}

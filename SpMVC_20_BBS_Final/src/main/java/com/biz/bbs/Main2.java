package com.biz.bbs;

import java.util.List;

import com.biz.bbs.domain.BBsVO;
import com.biz.bbs.service.FileReaderService;

public class Main2 {

	public static void main(String[] args) {
		
		FileReaderService fService = new FileReaderService();

		List<BBsVO> bbsList = fService.getBBsData();
		
		List<BBsVO> pList = fService.getMain(bbsList);
		
		pList.forEach(vo->{
			pList.add(vo);
			pList.addAll(fService.getRepl(bbsList,vo));
		});
		
		pList.forEach(System.out::println);
		
	}
}

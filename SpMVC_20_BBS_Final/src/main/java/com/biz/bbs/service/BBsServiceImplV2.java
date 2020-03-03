package com.biz.bbs.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.biz.bbs.domain.BBsVO;
import com.biz.bbs.repository.BBsDao;

import lombok.RequiredArgsConstructor;

@Transactional
@Service("bbsV2")
public class BBsServiceImplV2 extends BBsServiceImpl {

	public BBsServiceImplV2(BBsDao bbsDao) {
		super(bbsDao);

	}

	/*
	 * pagination을 수행할때 원글목록을 
	 * page 대상으로 할것인지 원글 + 댓글 
	 * 포함한 목록 page대상으로 할 것인지 결정
	 */
	@Override
	public List<BBsVO> selectAll() {
		List<BBsVO> retList = bbsDao.selectLevel();
		return retList;
	}

}

package com.biz.socket.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.slf4j.Slf4j;

/*
 * STOMP를 지원하는 기능 사용할 수 있도록
 * 만들어져 있는 기본 클래스(TextWebSocketHandler)를 상속받아서 사용한다
 */
@Slf4j
@Component
public class WebSocketController extends TextWebSocketHandler{

	// socket으로 서버에 접속할 때 접속하는 
	// 클라이언트들을 관리하기 위한 세션
	List<WebSocketSession> sessionList;

	public WebSocketController() {
	sessionList = new ArrayList<WebSocketSession>();
	}
	
	/*
	 * client가 웹소켓을 통해서 접속을 시도할 때
	 * 처음 실행될 method
	 */
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// TODO Auto-generated method stub
		
		super.afterConnectionEstablished(session);
		// 접속된 클라이언트의 정보를 sessionList 추가
		sessionList.add(session);
		log.debug("접속된 클라이언트 ID : {}" , session.getId() );
				
	}
	
	/*
	 * 클라이언트가 메시지를 보내면 메시지를 수신하는
	 * 컨트롤러 메서드
	 * 
	 */
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// TODO Auto-generated method stub
		super.handleTextMessage(session, message);
		log.debug("{} 클라이언트가 보낸 메시지 : {} ",session.getId(),message.getPayload());
		for(WebSocketSession ws : sessionList) {
			String msg = "Republic of Korea";// message.getPayload();
			
			
			// 문자열이나, 여러 메시지를 socket을 통해서 전송하기 편리한
			// STOMP ,데이터 구조로 변경항다
			TextMessage textMessage = new TextMessage(msg);
			ws.sendMessage(textMessage);
			// 수신된 문자열 구조가 TextMessage이므로
			// 바로 클라이언트로 전송
			ws.sendMessage(message);
			
		}
	}

	
	
}

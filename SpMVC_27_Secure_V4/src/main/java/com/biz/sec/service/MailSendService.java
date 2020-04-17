package com.biz.sec.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class MailSendService {


	JavaMailSender javaMailSender;
	
	
	public MailSendService(	@Qualifier("gamilMailHandler") JavaMailSender javaMailSender) {
		super();
		this.javaMailSender = javaMailSender;
	}


	public void sendMail() {
		String from_email = "qussoa@naver.com";
		String to_email = "qussoa@naver.com";
		String subject = "test";
		String content = "고양이 고장";
		
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper mHelper ;
		mHelper = new MimeMessageHelper(message,"UTF-8");
		try {
			mHelper.setFrom(from_email);
			mHelper.setTo(to_email);
			mHelper.setSubject(subject);
			mHelper.setText(content,true); 
			// true : 메일 본문에 html 효과 주기
			javaMailSender.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

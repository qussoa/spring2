package com.biz.sec.utils;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class EncMain {

	public static void main(String[] args) {
		/*
		 * 로컬 컴퓨터에 설정된 환경변수 목록을 가져와서
		 * 그 중에 BIZ.COM으로 등록된 값을 보여라
		 */
		StandardPBEStringEncryptor pbEnc = new StandardPBEStringEncryptor();
		
		Map<String,String> envList = System.getenv();
		System.out.println(envList.get("BIZ.COM"));
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("MySQL UserName : ");
		String userName = scan.nextLine();
		System.out.print("MySQL Password : ");
		String password = scan.nextLine();
		
		/*
		 * 암호화 설정
		 */
		
		pbEnc.setAlgorithm("PBEWithMD5AndDES");
		pbEnc.setPassword(envList.get("BIZ.COM"));
		
		String encUserName = pbEnc.encrypt(userName);
		String encPassword = pbEnc.encrypt(password);
		
		System.out.printf("userName : %s \n", encUserName);
		System.out.printf("password : %s \n", encPassword);
		
		String saveFile = "./src/main/webapp/WEB-INF/spring/db.connection.properties";
		
		String saveUserName = String.format("mysql.username=ENC(%s)", encUserName);
		String savePassword = String.format("mysql.password=ENC(%s)", encPassword);
		try {
			PrintWriter out = new PrintWriter(saveFile);
			out.println(saveUserName);
			out.println(savePassword);
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scan.close();
		System.out.println("db.connection.properties 저장 완료");
	}

}

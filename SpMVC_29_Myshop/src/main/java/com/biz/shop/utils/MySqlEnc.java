package com.biz.shop.utils;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class MySqlEnc {

	public static void main(String[] args) {
		StandardPBEStringEncryptor pbEnc = new StandardPBEStringEncryptor();

		Map<String, String> envList = System.getenv();
		System.out.println(envList.get("BIZ.COM"));

		Scanner scan = new Scanner(System.in);

		System.out.println("MySql UserName : ");
		String userName = scan.nextLine();
		System.out.println("MySql Password : ");
		String password = scan.nextLine();

		pbEnc.setAlgorithm("PBEWITHMD5ANDDES");
		pbEnc.setPassword("BIZ.COM");

		String encUserName = pbEnc.encrypt(userName);
		String encPassword = pbEnc.encrypt(password);

		System.out.printf("userName : %s\n", encUserName);
		System.out.printf("password : %s\n", encPassword);

//		String saveFile = "./src/main/webapp/WEB-INF/" + "spring/properties/db.connection.properties";
		String saveFile = "classpath:db.connection.properties";

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
		System.err.println("db.connection.properties 저장완료");

	}
}

package com.laon.common;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MailAuth extends Authenticator {

	PasswordAuthentication pa;
	
	public MailAuth() {//객체 생성
		String mailId="laondanim";//구글아이디
		String mailPw="rclasspm!";//구글 비밀번호
		
		pa=new PasswordAuthentication(mailId,mailPw);
	}
	
	public PasswordAuthentication getPasswordAuthentication() {
		//smtp에 연결해 사용자 인증을 하기위해 Authenticator 클래스 사용 필요.
		
		return pa;
	}
}

package com.laon.common;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSend {

	public void Mailsend() {
		
		//String mailTo="aldus9302@gmail.com";
		
		Properties prop=System.getProperties();
		prop.put("mail.smtp.starttls.enable", "true");//로그인시 tls쓸껀지
		prop.put("mail.smtp.host", "smtp.gmail.com");//이메일발송 처리해줄 서버->구글
		prop.put("mail.smtp.auth", "true");//smtp서버의 인증을 사용
		prop.put("mail.smtp.port", "587");//tls 포트번호 587, ssl은 465
		
		Authenticator auth=new MailAuth();
		
		Session session=Session.getDefaultInstance(prop, auth);
		
		MimeMessage msg=new MimeMessage(session);
		
	try{
		//보내는 날짜 지정 setSentDate
		msg.setSentDate(new Date());
		//발송자 지정 메소드 setFrom(발송자의메일,발송자명)
		msg.setFrom(new InternetAddress("laondanim@gmail.com","danimHOST"));
		//수신자의 메일생성 setRecipient
		msg.setRecipient(Message.RecipientType.TO, new InternetAddress("aldus9302@gmail.com"));
		//메일 제목설정
		msg.setSubject("제목","UTF-8");
		//메일 내용 
		msg.setText("비밀번호 찾기연습.테스트메일입니다","UTF-8");
		//메일을 보냄!
		Transport.send(msg);
		
	}catch(AddressException ae) {
		System.out.println("AddressException:"+ae.getMessage());
	}catch(MessagingException me) { //메일계정인증 예외처리
		System.out.println("MessagingException:"+me.getMessage());
	}catch(UnsupportedEncodingException e) {//지원되지않는 인코딩을 사용할때
		System.out.println("UnsupportedEncodingException:"+e.getMessage());
	}
	
	}
	
}

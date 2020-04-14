package com.laon.user.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.laon.common.MailAuth;
import com.laon.user.model.service.UserService;
import com.laon.user.model.vo.User;

/**
 * Servlet implementation class FindUserPwServlet
 */
@WebServlet("/user/findPw.do")
public class FindUserPwServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindUserPwServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//비밀번호 찾는 로직
		//아이디와 이메일이 일치하는 디비값이 있는지 확인후 메일 발송.
		String id=request.getParameter("id");
		String email=request.getParameter("email");
		System.out.println(id+":"+email);
		User u=new UserService().findPw(id,email);
		System.out.println("유저가있니?"+u);
		
		if(u!=null&&u.getEmail().equals(email)) {
			//일치하는 유저가 있고, 입력한 이메일값과 같을경우
			String host="smtp.google.com";
			String user="laondanim@gmail.com";//보낼계정
			String password="rclasspm!";//비번
			
			String mailTo=u.getEmail();
			
			Properties prop=new Properties();
			prop.put("mail.smtp.starttls.enable", "true");//로그인시 tls쓸껀지
			prop.put("mail.smtp.host", "smtp.gmail.com");//이메일발송 처리해줄 서버->구글
			prop.put("mail.smtp.auth", "true");//smtp서버의 인증을 사용
			prop.put("mail.smtp.port", "587");//tls 포트번호 587, ssl은 465
			
			//인증번호 생성(요게 좀 이해가 안감..)
			StringBuffer temp=new StringBuffer();
			Random rnd=new Random();
			for(int i=0;i<10;i++) {
				int ranIndex=rnd.nextInt(3);
				switch (ranIndex) {
				case 0:
					// a-z
					temp.append((char) ((int) (rnd.nextInt(26)) + 97));
					break;
				case 1:
					// A-Z
					temp.append((char) ((int) (rnd.nextInt(26)) + 65));
					break;
				case 2:
					// 0-9
					temp.append((rnd.nextInt(10)));
					break;
				}
			 	 
			}
			//생성된 값 조합
			 String AuthenticationKey=temp.toString();
			 System.out.println(AuthenticationKey);
			//세션 생성
			Session session=Session.getDefaultInstance(prop,new MailAuth());
			//이메일 전송
			try{
				MimeMessage msg=new MimeMessage(session);
				//보내는 날짜 지정 setSentDate
				msg.setSentDate(new Date());
				//발송자 지정 메소드 setFrom(발송자의메일,발송자명)
				msg.setFrom(new InternetAddress("laondanim@gmail.com","danimHOST"));
				//수신자의 메일생성 setRecipient
				msg.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
				//메일 제목설정
				msg.setSubject("라온다님 인증메일(비밀번호 찾기)","UTF-8");
				//메일 내용 
				msg.setText("라온다님 인증번호:"+AuthenticationKey,"UTF-8");
				//메일을 보냄!
				Transport.send(msg);
				System.out.println("이메일 전송!");
			}catch(AddressException ae) {
				System.out.println("AddressException:"+ae.getMessage());
			}catch(MessagingException me) { //메일계정인증 예외처리
				System.out.println("MessagingException:"+me.getMessage());
			}catch(UnsupportedEncodingException e) {//지원되지않는 인코딩을 사용할때
				System.out.println("UnsupportedEncodingException:"+e.getMessage());
			}
			//
			System.out.println("디비에넣을값"+id+":"+AuthenticationKey);
			int result=new UserService().updateTemPw(id,AuthenticationKey);
			System.out.println("수정되었니"+result);
			
			 //인증번호 값 생성한것을 session에 넣어보관.값을 비교하기 위함임! HttpSession
			 HttpSession saveKey=request.getSession(); 
			 saveKey.setAttribute("AuthenticationKey",AuthenticationKey); 
			 saveKey.setAttribute("AuthId",u.getUserId());
		
			 response.setContentType("text/csv;charset=UTF-8");
			 response.getWriter().write("<strong>이메일로 임시 비밀번호가 전송되었습니다<strong><br><strong>로그인후 비밀번호를  변경해주세요</strong>");
				
		}else {
				//아이디와 이메일 일치하는 값이 없을때
				response.setContentType("text/csv;charset=UTF-8");
				response.getWriter().write("<strong>일치하는 회원정보가 없습니다.!!<strong>");
				
			}
		
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

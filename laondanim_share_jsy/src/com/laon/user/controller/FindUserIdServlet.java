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
 * Servlet implementation class FindUserIdServlet
 */
@WebServlet("/user/findId.do")
public class FindUserIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindUserIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//db�뿉 �빐�떦�븯�뒗 �씠由꾧낵 �씠硫붿씪�씠 �엳�뒗吏� �솗�씤.
		//�씠由꾧낵 �씠硫붿씪媛믪씠 �꽆�뼱�삤�뒗吏� �솗�씤
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		
		User u=new UserService().findId(name,email);
		System.out.println("�쑀��媛��엳�땲?"+u);
		
		if(u!=null&&u.getEmail().equals(email)) {
			//�씪移섑븯�뒗 �쑀��媛� �엳怨�, �엯�젰�븳 �씠硫붿씪媛믨낵 媛숈쓣寃쎌슦
			String host="smtp.google.com";
			String user="laondanim@gmail.com";//蹂대궪怨꾩젙
			String password="rclasspm!";//鍮꾨쾲
			
			String mailTo=u.getEmail();
			
			Properties prop=new Properties();
			prop.put("mail.smtp.starttls.enable", "true");//濡쒓렇�씤�떆 tls�벝猿�吏�
			prop.put("mail.smtp.host", "smtp.gmail.com");//�씠硫붿씪諛쒖넚 泥섎━�빐以� �꽌踰�->援ш�
			prop.put("mail.smtp.auth", "true");//smtp�꽌踰꾩쓽 �씤利앹쓣 �궗�슜
			prop.put("mail.smtp.port", "587");//tls �룷�듃踰덊샇 587, ssl�� 465
			
			//�씤利앸쾲�샇 �깮�꽦(�슂寃� 醫� �씠�빐媛� �븞媛�..)
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
			//�깮�꽦�맂 媛� 議고빀
			 String AuthenticationKey=temp.toString();
			 System.out.println(AuthenticationKey);
			//�꽭�뀡 �깮�꽦
			Session session=Session.getDefaultInstance(prop,new MailAuth());
			//�씠硫붿씪 �쟾�넚
			try{
				MimeMessage msg=new MimeMessage(session);
				//蹂대궡�뒗 �궇吏� 吏��젙 setSentDate
				msg.setSentDate(new Date());
				//諛쒖넚�옄 吏��젙 硫붿냼�뱶 setFrom(諛쒖넚�옄�쓽硫붿씪,諛쒖넚�옄紐�)
				msg.setFrom(new InternetAddress("laondanim@gmail.com","danimHOST"));
				//�닔�떊�옄�쓽 硫붿씪�깮�꽦 setRecipient
				msg.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
				//硫붿씪 �젣紐⑹꽕�젙
				msg.setSubject("�씪�삩�떎�떂 �씤利앸찓�씪(�븘�씠�뵒 李얘린)","UTF-8");
				//硫붿씪 �궡�슜 
				msg.setText("�씪�삩�떎�떂 �씤利앸쾲�샇:"+AuthenticationKey,"UTF-8");
				//硫붿씪�쓣 蹂대깂!
				Transport.send(msg);
				System.out.println("�씠硫붿씪 �쟾�넚!");
			}catch(AddressException ae) {
				System.out.println("AddressException:"+ae.getMessage());
			}catch(MessagingException me) { //硫붿씪怨꾩젙�씤利� �삁�쇅泥섎━
				System.out.println("MessagingException:"+me.getMessage());
			}catch(UnsupportedEncodingException e) {//吏��썝�릺吏��븡�뒗 �씤肄붾뵫�쓣 �궗�슜�븷�븣
				System.out.println("UnsupportedEncodingException:"+e.getMessage());
			}
			
			
			 //�씤利앸쾲�샇 媛� �깮�꽦�븳寃껋쓣 session�뿉 �꽔�뼱蹂닿�.媛믪쓣 鍮꾧탳�븯湲� �쐞�븿�엫! HttpSession
			 HttpSession saveKey=request.getSession(); 
			 saveKey.setAttribute("AuthenticationKey",AuthenticationKey); 
			 saveKey.setAttribute("AuthId",u.getUserId());
			 
			
			/*
			 * request.setAttribute("AuthenticationKey",AuthenticationKey);
			 * request.setAttribute("id",u.getUserId());
			 */
			
			
			response.setContentType("text/csv;charset=UTF-8");
			response.getWriter().write("<strong>�씠硫붿씪�씠 �쟾�넚�릺�뿀�뒿�땲�떎<strong>");
			
			
			
		}else {
			//�븘�씠�뵒�� �씠由� �씪移섑븯�뒗 媛믪씠 �뾾�쓣�븣
			response.setContentType("text/csv;charset=UTF-8");
			response.getWriter().write("<strong>�씪移섑븯�뒗 �쉶�썝�젙蹂닿� �뾾�뒿�땲�떎.<strong>");
			
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

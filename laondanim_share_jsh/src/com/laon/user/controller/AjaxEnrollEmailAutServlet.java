package com.laon.user.controller;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjaxEnrollEmailAutServlet
 */
@WebServlet("/user/enrollEmailAut.do")
public class AjaxEnrollEmailAutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxEnrollEmailAutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���� �̸��� �ޱ�
		String userEmail = request.getParameter("userEmail");
		//���� ������
        //mail server ����
        String host = "smtp.google.com";
        String laonEmail = "laondanim@gmail.com"; //��´ٴ� ���� ����
        String laonPw = "rclasspm!";//��´ٴ� ���̹� �н�����
        

        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");


        //���� ��ȣ ������
        StringBuffer temp = new StringBuffer();
        Random rnd = new Random();
        for(int i=0;i<10;i++)
        {
            int rIndex = rnd.nextInt(3);
            switch (rIndex) {
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

        //������ȣ
        String AuthenticationKey = temp.toString();
        
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(laonEmail,laonPw);
            }
        });
        
        //email ����
        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(laonEmail, "��´ٴ�"));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(userEmail));
            
            //���� ����
            msg.setSubject("��´ٴ� ���� �����ڵ��Դϴ�.");
            //���� ����
            msg.setContent("<h3 style='color: #00abbf; font-weight: 600;'>��´ٴ� ���� �����ڵ�</h3>"
            				+ "<p>"+temp+"</p>"
            		, "text/html; charset=UTF-8");
            
            Transport.send(msg);
            System.out.println("�̸��� ����");
            
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        response.getWriter().write(AuthenticationKey);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

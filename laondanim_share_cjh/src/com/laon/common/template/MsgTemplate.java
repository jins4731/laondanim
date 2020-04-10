package com.laon.common.template;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class MsgTemplate {

	public static void sendMSG(String msg, String loc,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	}
	
	public static void sendMSGClosePopup(String msg, String loc,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String script = "opener.location.replace('"+request.getContextPath()+ loc +"');"
				+ "self.close()";
		request.setAttribute("msg", msg);
		request.setAttribute("script",script);
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	}
	
	
}

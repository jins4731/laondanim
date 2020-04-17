package com.laon.tripinfo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.laon.tripinfo.model.service.TripInfoService;
import com.laon.tripinfo.model.vo.TripInfoComment;
import com.laon.user.model.vo.User;

/**
 * Servlet implementation class TripInfoCommentInsertServlet
 */
@WebServlet("/tripinfo/insertComment.do")
public class TripInfoCommentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TripInfoCommentInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String content = request.getParameter("content");
		String nickName = request.getParameter("nickName");
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		int tripinfoNo = Integer.parseInt(request.getParameter("tripinfoNo"));
		
		System.out.println("content : " + content);
		System.out.println("userNo : " + userNo);
		System.out.println("tripinfoNo : " + tripinfoNo);
		
		User u = new User(userNo,null,null,null,null,nickName,null,null,null,null,null);
		
		
						
		TripInfoComment tc = new TripInfoComment(0,tripinfoNo,userNo,null,content,'N');
		
		int result = new TripInfoService().insertComment(tc);
		
		//TripInfoComment tc2 = new TripInfoService().selectComment2(); 
		//System.out.println("서블릿에서 롸이트데이트:"+tc2.getWriteDate());
		
		
		System.out.println(result);
		if(result>0) {
			JSONObject jo=new JSONObject();
			jo.put("content", tc.getContent());
			jo.put("userNo", tc.getUserTbNo());
			jo.put("tripinfoNo", tc.getUserTbNo());
			jo.put("nickName",u.getNickName());
			//jo.put("writeDate",tc2.getWriteDate());
		
			response.getWriter().print(jo);
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

package com.laon.tripinfo.controller;

import java.io.IOException;
import java.util.List;

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
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		int tripinfoNo = Integer.parseInt(request.getParameter("tripinfoNo"));
		String userName = request.getParameter("userName");
		
		System.out.println("content : " + content);
		System.out.println("userNo : " + userNo);
		System.out.println("tripinfoNo : " + tripinfoNo);
		
		
		
		
		
		TripInfoComment tc = new TripInfoComment(0,tripinfoNo,userNo,null,content,'N');
		
		
		
		int result = new TripInfoService().insertComment(tc);
		
		if(result>0) {
		
		
		List<TripInfoComment> comment=new TripInfoService().selectUserComment();
		
		//List<User> user=new TripInfoService().selectUserComment();
		
		JSONObject jo=new JSONObject();
		jo.put("content", tc.getContent());
		jo.put("writeDate",tc.getWriteDate());
	
		System.out.println("¼­ºí¸´¿¡¼­  writeDate : " + tc.getWriteDate());
		response.getWriter().print(jo); 
		
		}
		
		
		//new Gson().toJson(tc,response.getWriter());
		
		
		
		/* request.getRequestDispatcher("/views/tripinfo/"); */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

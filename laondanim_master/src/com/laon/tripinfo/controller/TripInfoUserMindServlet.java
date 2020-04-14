package com.laon.tripinfo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.laon.tripinfo.model.service.TripInfoService;
import com.laon.tripinfo.model.vo.Mind;
import com.laon.tripinfo.model.vo.Picture;
import com.laon.tripinfo.model.vo.TripInfo2;

/**
 * Servlet implementation class TripInfoUserMindServlet
 */
@WebServlet("/tripinfo/userMind.do")
public class TripInfoUserMindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TripInfoUserMindServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//�α����� ������ �� ��� ����Ʈ
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		
		List<Mind> userMindList=new TripInfoService().selectUserMind(userNo);
		for(Mind mind : userMindList) {
			System.out.println("����" + mind);
		}
		
//���� ����Ʈ�� tripinfo_no �� ��ġ�ϴ� picture ����Ʈ 				
		List<Picture> pictureList = new TripInfoService().selectPicture(userMindList);
		for(Picture p : pictureList) {
			System.out.println("����" + p);
		}
		
//������ �ҷ��� ���� ����Ʈ�� �Ű������� ����Ʈ�� TRIPINFO_NO���� ��ġ�ϴ� �������� ����Ʈ ��������
		List<TripInfo2> tripInfoList = new TripInfoService().selectTripinfo(userMindList);
		for(TripInfo2 ti : tripInfoList) {
			System.out.println("����" + ti);
		}
		
		
		// Mind(int no, int userNo, int tripinfoNo, String cancled, int count)
		
		
		
		//userMindList 
//		JSONArray jsonMindList = new JSONArray();
//		
//		for(Mind mind : userMindList) {
//			JSONObject j = new JSONObject();
//			j.put("no", mind.getNo());
//			j.put("userNo", mind.getUserNo());
//			j.put("tripinfoNo", mind.getTripinfoNo());
//			j.put("cancled", mind.getCancled());
//			j.put("count", mind.getCount());
//			
//			jsonMindList.add(j);
//		}
//		
//		//pictureList
//		JSONArray jsonPictureList = new JSONArray();
//		//Picture(int pictureNo, int tripNo, int donghangNo, int userNo, int tripinfoNo, String image)
//		for(Picture picture : pictureList) {
//			JSONObject j = new JSONObject();
//			j.put("pictureNo", picture.getPictureNo());
//			j.put("tripNo", picture.getTripNo());
//			j.put("donghangNo", picture.getDonghangNo());
//			j.put("tripinfoNo", picture.getTripinfoNo());
//			j.put("image", picture.getImage());
//			
//			jsonPictureList.add(j);
//		}
//		//TripInfo(int tripinfoNo, String tripinfoCategory, String tripinfoTag, String tripinfoName,
//				//String tripinfoAddress, String tripinfotime, String tripinfoNumber, String tripinfoHomePage,
//				//String tripinfoNaver, String tripinfoSns)
//		JSONArray jsonTripInfoList = new JSONArray();
//		
//		for(TripInfo ti : tripInfoList) {
//			JSONObject j = new JSONObject();
//			j.put("tripinfoNo", ti.getTripinfoNo());
//			j.put("tripinfoCategory", ti.getTripinfoCategory());
//			j.put("tripinfoTag", ti.getTripinfoTag());
//			j.put("tripinfoName", ti.getTripinfoName());
//			j.put("tripinfoAddress", ti.getTripinfoAddress());
//			j.put("tripinfoTime", ti.getTripinfotime());
//			j.put("tripinfoNumber", ti.getTripinfoNumber());
//			j.put("tripinfoHomePage", ti.getTripinfoHomePage());
//			j.put("tripinfoNaver", ti.getTripinfoNaver());
//			j.put("tripinfoSns", ti.getTripinfoSns());
//			
//			jsonTripInfoList.add(j);
//		}
//		
//		new Gson().toJson(jsonMindList, response.getWriter());
//		new Gson().toJson(jsonPictureList, response.getWriter());
//		new Gson().toJson(jsonTripInfoList, response.getWriter());
		
		request.setAttribute("userMindList", userMindList);
		request.setAttribute("pictureList", pictureList);
		request.setAttribute("tripInfoList", tripInfoList);
		
		request.getRequestDispatcher("/views/tripinfo/myHeartModal.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

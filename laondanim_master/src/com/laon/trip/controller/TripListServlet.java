package com.laon.trip.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laon.common.Paging;
import com.laon.trip.model.service.TripService2;
import com.laon.trip.model.vo.Trip2;

/**
 * Servlet implementation class TripListServlet
 */
@WebServlet("/trip/list.do")
public class TripListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TripListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//�˻����� ���� ���� ���ͷ� ���� ���� �б� ó�� �ؾ���
		//�˻����� ���� ���� �˻��� ���� ��Ʈ������ �޾Ƽ� db �����Ͽ� �������� (�����ε� �� �Լ� ���ؼ�)
		//���ͷ� ���ö��� ���������� order by �� �̿��Ͽ� �����ϰ� ������
		String keyword = request.getParameter("keyword");
		String sort = request.getParameter("sort");
		String category = request.getParameter("category");
		String filter = request.getParameter("filter");
		
		int cPage;
			
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		}catch(NumberFormatException e) {
			cPage = 1;
		}
		System.out.println(cPage);	
		int perPage = 10;
		int totalData=0;
		ArrayList<Trip2> list = null;
		
		if(keyword==null) {
			totalData = new TripService2().getTotalData();
			list = new TripService2().searchList(cPage, perPage);	//����� ����Ʈ ��������
			//���� ����Ʈ �������� �߰�
		}
		else {
			totalData = new TripService2().getTotalData(keyword);
			list = new TripService2().searchList(cPage, perPage, keyword);
		}
		
//		if(sort!=null) {
//			if(category.equals("date")) {
//				list = new TripService().sortListWriteDate(sort,cPage);
//			}else if(category.equals("like")) {
//				list = new TripService().sortListLike(sort,cPage);
//			}
//		}
		
		if(category!=null) {
			String type="";
			
			switch(category) {
			case "plan":
				type = "���� ����";
				totalData = new TripService2().getTotalDataPr(type);	//plan or review
				list = new TripService2().searchListPr(cPage, perPage, type);
				break;
			
			case "review":
				type = "���� �ı�";
				totalData = new TripService2().getTotalDataPr(type);	//plan or review
				list = new TripService2().searchListPr(cPage, perPage, type);
				break;
			}
			
			request.setAttribute("category", type);
		}
		
		String pageBar = new Paging().pageBar(request.getContextPath()+"/trip/list.do", totalData, cPage, perPage); //�������� ��������
		
		request.setAttribute("triplist", list);	//����� ����Ʈ ����
		//request.setAttribute("picture", picture); //���� ����Ʈ ���� 
		request.setAttribute("pageBar", pageBar);	//pageBar ����
		request.setAttribute("totalData", totalData);
		request.getRequestDispatcher("/views/trip/triplist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package com.laon.trip.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laon.common.Paging;
import com.laon.trip.model.vo.Trip;
import com.laon.trip.service.TripService;

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
		
		//�˻���ư ������ ��, keyword �� �������� , null �̸� �˻� ���Ѱ� ������ �˻��Ѱ�
		String keyword = request.getParameter("keyword");
		//��ü ����� Ŭ�� ��, category �� ��������
		String category = request.getParameter("category")==null?"��ü �����":request.getParameter("category");
		//�ֱټ� Ŭ���� recent �� ��������
		String recent = request.getParameter("recent");
		System.out.println("recent�� ����?"+recent);
		
		System.out.println("category:"+category);
		System.out.println(keyword);
		int cPage;
			
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		}catch(NumberFormatException e) {
			cPage = 1;
		}
		
		int perPage = 10;
		int totalData=0;
		ArrayList<Trip> list = null;
		
		if((keyword==null && category==null) || category.equals("��ü �����")) {
			totalData = new TripService().getTotalData();
			list = new TripService().searchList(cPage, perPage);	//����� ����Ʈ ��������
			//���� ����Ʈ �������� �߰�
		}
		
		//�˻� ��ư�� ������ keyword ���� ���� ��Ʈ�� �������� �����߱� ������ ���� �ִ�.
		if(keyword!=null){	
			totalData = new TripService().getTotalData(keyword);
			list = new TripService().searchList(cPage, perPage, keyword);
			request.setAttribute("keyword", keyword);
		}
		
		//category�� ���� ������ select �ڽ��� �مf�ٴ� ��� �ش� category �� �ش��ϴ� ������ ���
		if(category!=null && !category.equals("��ü �����")) {
			//category = category.equals("���� ����")?"plan":"review";
			totalData = new TripService().getTotalDataPr(category, keyword);
			System.out.println("totalData"+ totalData);
			list = new TripService().searchListPr(cPage, perPage, category, keyword);
			request.setAttribute("category", category);
		}
		
		
		
		String pageBar = new Paging().pageBar(request.getContextPath()+"/trip/list.do", totalData, cPage, perPage, keyword, category); //�������� ��������
		
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

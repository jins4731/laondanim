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
		keyword=keyword==null?"null":keyword;
		//��ü ����� Ŭ�� ��, category �� ��������
		String category = request.getParameter("category")==null?"��ü �����":request.getParameter("category");
		category=category==null?"null":category;
		//���� Ŭ�� ��, lo �� ��������
		String lo = request.getParameter("lo")==null?"���� ������":request.getParameter("lo");
		lo=lo==null?"null":lo;
		System.out.println("lo���� �����ΰ�?" + lo);
		//�ֱټ� Ŭ���� recent �� ��������
		String recent = request.getParameter("recent");
		recent=recent==null?"null":recent;
		
		int cPage;
			
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		}catch(NumberFormatException e) {
			cPage = 1;
		}
		
		int perPage = 10;
		int totalData=0;
		ArrayList<Trip> list = null;
		
//		System.out.println("���̳� �����̳�" + category.equals("��ü �����"));
//		if((keyword.equals("null") && category.equals("null")) || category.equals("��ü �����")) {
//			totalData = new TripService().getTotalData();
//			list = new TripService().searchList(cPage, perPage);	//����� ����Ʈ ��������
//			System.out.println("��ü ������ ���� : " + totalData);
//			System.out.println("����Ʈ : " + list);
//			//���� ����Ʈ �������� �߰�
//		}
//		
//		//�˻� ��ư�� ������ keyword ���� ���� ��Ʈ�� �������� �����߱� ������ ���� �ִ�.
//		if(!keyword.equals("null")){	
//			totalData = new TripService().getTotalData(keyword);
//			list = new TripService().searchList(cPage, perPage, keyword);
//			request.setAttribute("keyword", keyword);			
//		}
//		
//		//category�� ���� ������ select �ڽ��� �مf�ٴ� ��� �ش� category �� �ش��ϴ� ������ ���
//		if(!category.equals("null") && !category.equals("��ü �����")) {				
//			//category = category.equals("���� ����")?"plan":"review";
//			totalData = new TripService().getTotalDataPr(category, keyword);
//			System.out.println("totalData"+ totalData);
//			list = new TripService().searchListPr(cPage, perPage, category, keyword);
//			request.setAttribute("category", category);
//		}
//		
//		//lo�� ���� ������ dropdown �ڽ��� �مf�ٴ� ��� �ش� category�� �ش��ϴ� ������ ���
//		if(!lo.equals("null") && !lo.equals("���� ������")) {
//			totalData = new TripService().getTotalDataLo(lo, category, keyword);
//			list = new TripService().searchList(cPage, perPage, lo, category, keyword);
//			request.setAttribute("lo", lo);
//			System.out.println("totalData�� ����?"+totalData);
//			System.out.println("list�� ���� ����??"+list);
//		}
		totalData = new TripService().getTotalDataLo(lo, category, keyword);
		list = new TripService().searchList(cPage, perPage, lo, category, keyword, recent);
		
		String pageBar = new Paging().pageBar(request.getContextPath()+"/trip/list.do", totalData, cPage, perPage, keyword, category, lo); //�������� ��������
		
		//������Ʈ�� ����
		request.setAttribute("keyword", keyword);
		request.setAttribute("category", category);
		request.setAttribute("lo", lo);
		request.setAttribute("recent", recent);
		
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

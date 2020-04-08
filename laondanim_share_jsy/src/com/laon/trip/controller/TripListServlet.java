package com.laon.trip.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laon.common.Paging;
import com.laon.trip.model.vo.Trip;
import com.laon.trip.model.vo.TripPicture;
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
		System.out.println("category���� �����ΰ�?" + category);
		System.out.println("lo���� �����ΰ�?" + lo);
		System.out.println("keyword���� �����ΰ�?" + keyword);
		//�ֱټ� Ŭ���� recent �� ��������
		String recent = request.getParameter("recent");
		recent=recent==null?"null":recent;
		//���ƿ� �� Ŭ���� like �� ��������
		String like = request.getParameter("like");
		like=like==null?"null":like;
		
		System.out.println("���� recent : " + recent);
		System.out.println("���� like : " + like);
		int cPage;
			
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		}catch(NumberFormatException e) {
			cPage = 1;
		}
		
		int perPage = 10;
		int totalData=0;
		ArrayList<Trip> list = null;
		ArrayList<TripPicture> pictureList = null;

		totalData = new TripService().getTotalDataLo(lo, category, keyword);
		list = new TripService().searchList(cPage, perPage, lo, category, keyword, recent,like);
		pictureList = new TripService().searchPicture();
		
		String pageBar = new Paging().pageBar(request.getContextPath()+"/trip/list.do", totalData, cPage, perPage, keyword, category, lo, recent, like); //�������� ��������
		
		//������Ʈ�� ����
		request.setAttribute("keyword", keyword);
		request.setAttribute("category", category);
		request.setAttribute("lo", lo);
		request.setAttribute("recent", recent);
		request.setAttribute("like", like);
		
		System.out.println("servlet ���� list : " + list);
		request.setAttribute("triplist", list);	//����� ����Ʈ ����
		request.setAttribute("picture", pictureList); //���� ����Ʈ ���� 
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

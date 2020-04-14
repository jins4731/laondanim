package com.laon.trip.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.laon.common.CommonKey;
import com.laon.common.Paging;
import com.laon.common.TagFilter;
import com.laon.etc.model.vo.Like;
import com.laon.etc.model.vo.Picture;
import com.laon.trip.model.service.TripService2;
import com.laon.trip.model.vo.TagCount;
import com.laon.trip.model.vo.Trip2;
import com.laon.user.model.vo.User;
/**
 * Servlet implementation class TripListServlet
 */
@WebServlet("/trip/tripListView.do")
public class TripListViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TripListViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//ó�� ����� Ŭ������ ��
		String first = request.getParameter("first");
		first=first==null?"null":first;
		System.out.println("list에서 first : " + first);
		//�˻���ư ������ ��, keyword �� �������� , null �̸� �˻� ���Ѱ� ������ �˻��Ѱ�
		String keyword = request.getParameter("keyword");
		keyword=keyword==null?"null":keyword;
		//��ü ����� Ŭ�� ��, category �� ��������
		String category = request.getParameter("category")==null?"전체 여행기":request.getParameter("category");
		System.out.println("서블릿에서 category : " + category);
		category=category==null?"null":category;
		//���� Ŭ�� ��, lo �� ��������
		String lo = request.getParameter("lo")==null?"선택 지역별":request.getParameter("lo");
		System.out.println("서블릿에서 lo : " + lo);
		lo=lo==null?"null":lo;
		//�ֱټ� Ŭ���� recent �� ��������
		String recent = request.getParameter("recent");
		recent=recent==null?"null":recent;
		//���ƿ� �� Ŭ���� like �� ��������
		String like = request.getParameter("like");
		like=like==null?"null":like;
		
		int cPage;
			
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		}catch(NumberFormatException e) {
			cPage = 1;
		}
		
		int perPage = 10;
		int totalItemCount=0;
		
		ArrayList<Trip2> list = null;
		ArrayList<Picture> pictureList = null;
		ArrayList<Like> likeCountList = null;
		ArrayList<User> userList = null;
		ArrayList<Like> likeList = null;
		ArrayList<TagCount> tripTagCountList = null;
			
		//�α��ε� ���� no ��������
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("loginUser");
		int userNo = user.getNo();
		String userTag = user.getTag();
		
		//�α��ε� ���� no�� ��ġ�ϴ� �±׼��� ���� ���� ����� �Խù� ��������
		tripTagCountList = new TagFilter().tagCountList(userTag);
		
		
		//총 데이터 수
		totalItemCount = new TripService2().selectTripCount(lo, category, keyword);
		
		list = new TripService2().selectTripPage(cPage, perPage, lo, category, keyword, recent, like, tripTagCountList, first);
		for(Trip2 t : list) {
			System.out.println("servlet 에서 list" +t );
		}
		//����Ʈ���� �������� �ش� ����Ʈ�� ��Ī�Ǵ� picture ��������
		pictureList = new TripService2().selectPicture(list);
		
		//�ش� ����Ʈ�� ��Ī�Ǵ� ���ƿ� �� ��������
		likeCountList = new TripService2().selectLikeCount(list);
		
		//�ش� ����Ʈ�� ��Ī�Ǵ� �ۼ��� ��������
		userList = new TripService2().selectUser(list);
		
		//�ش� ����Ʈ�� ��Ī�Ǵ� ���ƿ� ���� ��������
		likeList = new TripService2().selectLike(userNo);		
		
		//����¡ ó��
		String pageBar = new Paging().pageBar(request.getContextPath()+"/trip/tripListView.do", totalItemCount, cPage, perPage, keyword, category, lo, recent, like, first); //�������� ��������
		
		//������Ʈ�� ����
		request.setAttribute("keyword", keyword);
		request.setAttribute("category", category);
		request.setAttribute("lo", lo);
		request.setAttribute("recent", recent);
		request.setAttribute("like", like);
		request.setAttribute("first", first);
		
		request.setAttribute(CommonKey.LIST, list);	//����� ����Ʈ ����
		request.setAttribute("pictureList", pictureList); //���� ����Ʈ ���� 
		request.setAttribute("likeCountList", likeCountList);//���ƿ� ��  ����Ʈ ����
		request.setAttribute("likeList", likeList);//���ƿ� ���� ����Ʈ ����
		request.setAttribute("userList", userList);//ȸ�� ����Ʈ ����
		request.setAttribute(CommonKey.PAGE_BAR, pageBar);	//pageBar ����
		request.setAttribute(CommonKey.total_Item_Count, totalItemCount);
		request.getRequestDispatcher("/views/trip/tripListPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

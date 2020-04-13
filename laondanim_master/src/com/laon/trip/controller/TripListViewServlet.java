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
import com.laon.trip.model.service.TripService;
import com.laon.trip.model.vo.TagCount;
import com.laon.trip.model.vo.Trip;
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
		//�˻���ư ������ ��, keyword �� �������� , null �̸� �˻� ���Ѱ� ������ �˻��Ѱ�
		String keyword = request.getParameter("keyword");
		keyword=keyword==null?"null":keyword;
		//��ü ����� Ŭ�� ��, category �� ��������
		String category = request.getParameter("category")==null?"��ü �����":request.getParameter("category");
		category=category==null?"null":category;
		//���� Ŭ�� ��, lo �� ��������
		String lo = request.getParameter("lo")==null?"���� ������":request.getParameter("lo");
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
		
		ArrayList<Trip> list = null;
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
		
		//����� �Խù��� ��ü ����, ����¡ ó�� �� ����� �Խù� ��������
		totalItemCount = new TripService().selectTripCount(lo, category, keyword);
		
		list = new TripService().selectTripPage(cPage, perPage, lo, category, keyword, recent, like, tripTagCountList, first);
		
		//����Ʈ���� �������� �ش� ����Ʈ�� ��Ī�Ǵ� picture ��������
		pictureList = new TripService().selectPicture(list);
		
		//�ش� ����Ʈ�� ��Ī�Ǵ� ���ƿ� �� ��������
		likeCountList = new TripService().selectLikeCount(list);
		
		//�ش� ����Ʈ�� ��Ī�Ǵ� �ۼ��� ��������
		userList = new TripService().selectUser(list);
		
		//�ش� ����Ʈ�� ��Ī�Ǵ� ���ƿ� ���� ��������
		likeList = new TripService().selectLike(userNo);		
		for(Like l : likeList) {
			System.out.println("���ƿ� ����"+l);
		}
		
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

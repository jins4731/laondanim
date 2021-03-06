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
import com.laon.trip.model.vo.TripSchedule;
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
		String infoNo = request.getParameter("infoNo");
		infoNo = infoNo==null?"null":infoNo;
		
		String first = request.getParameter("first");
		first=first==null?"null":first;
		
		//�˻���ư ������ ��, keyword �� �������� , null �̸� �˻� ���Ѱ� ������ �˻��Ѱ�
		String keyword = request.getParameter("keyword");
		keyword=keyword==null?"null":keyword;
		//��ü ����� Ŭ�� ��, category �� ��������
		String category = request.getParameter("category")==null?"전체 여행기":request.getParameter("category");

		category=category==null?"null":category;
		//���� Ŭ�� ��, lo �� ��������
		String lo = request.getParameter("lo")==null?"선택 지역별":request.getParameter("lo");
	
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
		//스케쥴 리스트 가져오기
		ArrayList<TripSchedule> scheduleList = null;
		ArrayList<Trip2> tripList = null;	//스케쥴 리스트와 일치하는 여행기 리스트
		//스케쥴 리스트와 일치하는 여행기 가져오기
		if(!infoNo.equals("null")) {
			int no = Integer.parseInt(infoNo);
			scheduleList = new TripService2().selectSchedule(no);
						
			tripList = new TripService2().selectTripList(scheduleList);
								
		}
		
		//�α��ε� ���� no ��������
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("loginUser");
		int userNo = user.getNo();
		String userTag = user.getTag();
		
		//�α��ε� ���� no�� ��ġ�ϴ� �±׼��� ���� ���� ����� �Խù� ��������
		tripTagCountList = new TagFilter().tagCountList(userTag);	
		
		if(infoNo.equals("null")) {
			totalItemCount = new TripService2().selectTripCount(lo, category, keyword);
			list = new TripService2().selectTripPage(cPage, perPage, lo, category, keyword, recent, like, tripTagCountList, first);
		}else {						
			if(tripList.size()>0) {
			
			ArrayList<Trip2> sortList = new ArrayList<Trip2>(); 
			for(int i=(cPage-1)*perPage; i<cPage*perPage; i++) {
				if(i<tripList.size())
					sortList.add(tripList.get(i));
			}
			list = sortList;
			
			totalItemCount = list.size();
		
			}else {
				request.setAttribute("msg", "관련된 여행기가 없습니다.");
				request.setAttribute("loc", "/tripinfo/tripinfoMain?category=맛집");
				
				request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);;
			}
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
		String pageBar = new Paging().pageBar(request.getContextPath()+"/trip/tripListView.do", totalItemCount, cPage, perPage, keyword, category, lo, recent, like, first, infoNo); //�������� ��������
		
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

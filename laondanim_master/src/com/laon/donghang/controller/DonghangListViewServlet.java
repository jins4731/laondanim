package com.laon.donghang.controller;

import static com.laon.common.template.PageTemplate.getCurrentPage;
import static com.laon.common.template.PageTemplate.getEndNum;
import static com.laon.common.template.PageTemplate.getStartNum;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laon.common.CommonKey;
import com.laon.common.Paging;
import com.laon.common.TagFilter;
import com.laon.donghang.model.service.DonghangService;
import com.laon.donghang.model.vo.Donghang;
import com.laon.donghang.model.vo.DonghangJoinUserPicture;
import com.laon.donghang.model.vo.DonghangTagCount;
import com.laon.etc.model.vo.Picture;
import com.laon.user.model.vo.User;

/**
 * Servlet implementation class DonghangListViewServlet
 */
@WebServlet(name = "DonghangListViewServlet", urlPatterns = "/donghang/donghangListView.do")
public class DonghangListViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonghangListViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ùȭ���� ���� �±� ��������
		//by 승연
		String first = request.getParameter("first");
		first=first==null?"null":first;
		
		String userTag = request.getParameter("userTag");
		userTag=(userTag==null?"null":userTag);
		//�˻� Ű���� �� �������� 
		String keyword = request.getParameter("keyword");
		keyword=(keyword==null?"null":keyword);
		// +) Ű���� ī�װ� �� ��������
		String searchFilter = request.getParameter("searchFilter");
		searchFilter=(searchFilter==null?"null":searchFilter);
		//�ֱټ� Ŭ�� recent��
		String recent = request.getParameter("recent");
		recent=(recent==null?"null":recent);
		//��ȸ���� Ŭ�� viewcount��
		String viewcount = request.getParameter("viewcount");
		viewcount=(viewcount==null?"null":viewcount);
		//����������� Ŭ�� 
		String nearSchedule = request.getParameter("nearSchedule");
		nearSchedule=(nearSchedule==null?"null":nearSchedule);
		
		
		//by 승연
		ArrayList<DonghangTagCount> tagCountList = new TagFilter().donghangTagCountList(userTag);
		for(DonghangTagCount tg : tagCountList) {
			System.out.println(tg);
		}
		int[] order = new int[tagCountList.size()];
		
		for(int i=0; i<tagCountList.size(); i++) {
			order[i] = tagCountList.get(i).getNo();
			System.out.println(order[i]);
		}
		
		int currentPage = getCurrentPage(request);
		int pagePerRow = 10;
		
		List<DonghangJoinUserPicture> list = new ArrayList<DonghangJoinUserPicture>();
		//Tag�� �������� ùȭ�� ���� ȭ�� ������ �ȵ� ���� ó���ұ�..?
//		if(userTag!=null) {
//			list = new DonghangService().selectDonghangTag(getStartNum(currentPage, pagePerRow), getEndNum(currentPage, pagePerRow), userTag);
//		}else {
//			list = new DonghangService().selectDonghangPage(getStartNum(currentPage, pagePerRow), getEndNum(currentPage, pagePerRow), keyword, recent, viewcount, nearSchedule, searchFilter);
//		}
		
		Donghang d = null;
		ArrayList<Donghang> donghangList = new ArrayList<Donghang>();
		if(first.equals("first")) {
			for(int i=(currentPage-1)*pagePerRow; i<(currentPage)*pagePerRow; i++) {
				if(i<tagCountList.size()) {
				d = new Donghang();
				
				d.setNo(tagCountList.get(i).getNo());
				d.setUserNo(tagCountList.get(i).getUserNo());
				d.setTripNo(tagCountList.get(i).getTripNo());
				d.setWriteDate(tagCountList.get(i).getWriteDate());
				d.setViewcount(tagCountList.get(i).getViewCount());
				d.setTag(String.join(",", tagCountList.get(i).getTag()));
				d.setTitle(tagCountList.get(i).getTitle());
				d.setContent(tagCountList.get(i).getContent());
				d.setTravleLocale(tagCountList.get(i).getTravleLocale());
				d.setTravleStartDate(tagCountList.get(i).getTravleStartDate());
				d.setTravleEndDate(tagCountList.get(i).getTravleEndDate());
				d.setPw(tagCountList.get(i).getPw());
				d.setPublicEnabled(tagCountList.get(i).getPublicEnabled());
				d.setEnded(tagCountList.get(i).getEnded());
				d.setDeleted(tagCountList.get(i).getDeleted());
				d.setRecruitPeopleNo(tagCountList.get(i).getRecruitPeopleNo());
				d.setJoinPeopleNo(tagCountList.get(i).getJoinPeopleNo());
				
				donghangList.add(d);
				}
			}
			
			ArrayList<Picture> pictureList = new DonghangService().selectPicture(donghangList);
			ArrayList<User> userList = new DonghangService().selectUser(donghangList);
			
			DonghangJoinUserPicture dp = null;
			
			for(Donghang dh : donghangList) {
				for(Picture p : pictureList) {					
						if(dh.getNo() == p.getDonghangNo()) {							
								dp = new DonghangJoinUserPicture();
								dp.setNo(dh.getNo());
								dp.setUserNo(dh.getUserNo());
								dp.setTripNo(dh.getTripNo());
								dp.setWriteDate(dh.getWriteDate());
								dp.setViewcount(dh.getViewcount());
								dp.setTag(dh.getTag());
								dp.setTitle(dh.getTitle());
								dp.setContent(dh.getContent());
								dp.setTravleLocale(dh.getTravleLocale());
								dp.setTravleStartDate(dh.getTravleStartDate());
								dp.setTravleEndDate(dh.getTravleEndDate());
								dp.setRecruitStartDate(dh.getRecruitStartDate());
								dp.setRecruitEndDate(dh.getRecruitEndDate());
								dp.setPw(dh.getPw());
								dp.setPublicEnabled(dh.getPublicEnabled());
								dp.setEnded(dh.getEnded());
								dp.setDeleted(dh.getDeleted());
								dp.setRecruitPeopleNo(dh.getRecruitPeopleNo());
								dp.setJoinPeopleNo(dh.getJoinPeopleNo());								
								dp.setImage(p.getImage());
								
								list.add(dp);
					}
				}				
			}
			
			for(DonghangJoinUserPicture djup : list) {
				for(User u : userList) {
					if(djup.getUserNo() == u.getNo()) {
						djup.setNickName(u.getNickName());
					}
				}
			}
			for(DonghangJoinUserPicture dd : list) {
				System.out.println(dd);
			}
			
			
		}else {
			list = new DonghangService().selectDonghangPage(getStartNum(currentPage, pagePerRow), getEndNum(currentPage, pagePerRow), keyword, recent, viewcount, nearSchedule, searchFilter);
		}
		
		
		int totalRowCount = new DonghangService().selectDonghangCount(keyword, searchFilter);
		
		String pageBar = new Paging().pageBar2(request.getContextPath()+"/donghang/donghangListView.do", totalRowCount, currentPage, pagePerRow, userTag, keyword, recent, viewcount, nearSchedule, searchFilter, first);
		
		//������Ʈ�� ����
		request.setAttribute(CommonKey.KEYWORD, keyword);
		
		request.setAttribute(CommonKey.DONGHANG_LIST, list);
		System.out.println("______________"+list);
		request.setAttribute(CommonKey.PAGE_BAR, pageBar);
		request.setAttribute(CommonKey.TOTAL_ROWCOUNT, totalRowCount);
		
		
		request.getRequestDispatcher("/views/donghang/donghangList.jsp").forward(request, response);
		
//		System.out.println(userTag+keyword+recent+viewcount+nearSchedule+"********************************");
//		for(DonghangJoinUserPicture dh : list) {
//			System.out.println("list : "+dh);
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

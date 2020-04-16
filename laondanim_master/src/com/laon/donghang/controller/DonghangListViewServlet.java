package com.laon.donghang.controller;

import static com.laon.common.template.PageTemplate.getCurrentPage;
import static com.laon.common.template.PageTemplate.getEndNum;
import static com.laon.common.template.PageTemplate.getPageBar;
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
import com.laon.common.DonghangKey;
import com.laon.common.Paging;
import com.laon.donghang.model.service.DonghangService;
import com.laon.donghang.model.vo.Donghang;
import com.laon.donghang.model.vo.DonghangJoinUserPicture;
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
		
		int currentPage = getCurrentPage(request);
		int pagePerRow = 10;
		
		List<DonghangJoinUserPicture> list = new ArrayList<DonghangJoinUserPicture>();
		//Tag�� �������� ùȭ�� ���� ȭ�� ������ �ȵ� ���� ó���ұ�..?
//		if(userTag!=null) {
//			list = new DonghangService().selectDonghangTag(getStartNum(currentPage, pagePerRow), getEndNum(currentPage, pagePerRow), userTag);
//		}else {
			list = new DonghangService().selectDonghangPage(getStartNum(currentPage, pagePerRow), getEndNum(currentPage, pagePerRow), keyword, recent, viewcount, nearSchedule, searchFilter);
//		}
		
		int totalRowCount = new DonghangService().selectDonghangCount(keyword, searchFilter);
		
		String pageBar = new Paging().pageBar2(request.getContextPath()+"/donghang/donghangListView.do", totalRowCount, currentPage, pagePerRow, userTag, keyword, recent, viewcount, nearSchedule, searchFilter );
		
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

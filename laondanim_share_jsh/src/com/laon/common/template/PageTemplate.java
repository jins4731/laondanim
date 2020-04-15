package com.laon.common.template;

import javax.servlet.http.HttpServletRequest;

import com.laon.common.CommonKey;

public class PageTemplate {
	
	public static int getStartNum(int currentPage, int pagePerRow) {
		return (currentPage-1)*pagePerRow+1;
	}
	public static int getEndNum(int currentPage, int pagePerRow) {
		return (currentPage-1)*pagePerRow+1 + (pagePerRow-1);
//		return currentPage*pagePerRow;
	}
	
	public static int getCurrentPage(HttpServletRequest request) {
		int currentPage = 0;
		try {
			currentPage = Integer.parseInt(request.getParameter(CommonKey.CURRENT_PAGE));
		} catch (Exception e) {
			currentPage = 1;
			return currentPage;
		}
		return currentPage;
	}
		
	public static String getPageBar(int totalRowCount,int currentPage,int pagePerRow,HttpServletRequest request,String mappingAddress) {
		int _totalRowCount = totalRowCount; // 전체 카운트
		int _pagePerRow = pagePerRow; // 페이지당 뿌려질 아이템 갯수
		int totalPageSize = (int) Math.ceil((double)_totalRowCount/_pagePerRow); // 총 페이지 갯수
		
		int pageBarSize = 5; // 페이지바 크기
		int pageBarFirst = ((currentPage-1)/pageBarSize)*pageBarSize+1; // 페이지바 첫번째 숫자
		int pageBarLast = pageBarFirst + pageBarSize-1; // 페이지바 마지막 숫자
		if(pageBarLast > totalPageSize) { // 페이지바 마지막 크기 보정
			pageBarLast = totalPageSize;
		}
		
		
		String pageBar = "";
		
		// 이전 버튼
		if(totalPageSize > pageBarSize&&!(pageBarLast==pageBarSize)) {
			pageBar += "<span class='mr-3'><a href='"+request.getContextPath()+ mappingAddress +"?currentPage="+(pageBarFirst-1)+"'>"+"이전"+"</a></span>";
		}else {
			pageBar += "<span class='mr-3'>"+"이전"+"</span>";
		}
		
		// 페이지 숫자
		for(int i = pageBarFirst;i <= pageBarLast;i++) {
			if(currentPage == i) 
			{
				pageBar += "<span>"+i+"</span>&nbsp;";
			}else {
				pageBar += "<span><a href='"+request.getContextPath()+ mappingAddress +"?currentPage="+i+"'>"+i+"</a></span>&nbsp;";
			}
		}
		
		// 다음 버튼
		if(totalPageSize > pageBarSize&&!(pageBarLast==totalPageSize)) {
			pageBar += "<span class='ml-3'><a href='"+request.getContextPath()+ mappingAddress +"?currentPage="+(pageBarLast+1)+"'>"+"다음"+"</a></span>";
		}else {
			pageBar += "<span class='ml-3'>"+"다음"+"</span>";
		}
		
		return pageBar;
	}
}

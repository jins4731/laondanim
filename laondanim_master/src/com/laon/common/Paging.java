package com.laon.common;

import javax.servlet.http.HttpServletRequest;

public class Paging {

//	public String pageBar(String url, int totalData, int cPage, int perPage, String keyword, String category, String lo, String recent, String like) {
//		
//	
//		
//		String pageBar = "<ul class=\"pagination justify-content-center\"> <li class='page-item'><a class='page-link' href='' area-label='Previous'>&laquo;</a></li>";
//		
//		int totalPage = (int) Math.ceil((double)totalData/perPage);
//		
//		int pageBarSize = 5;
//	
//		int rowNum = ((cPage-1)/pageBarSize)*pageBarSize+1; // 페이지바 첫번째 숫자
//		int pageLast = rowNum + pageBarSize-1; // 페이지바 마지막 숫자
//		
//		if(rowNum == 1) {
//			pageBar += "<li class='page-item'><a class='page-link' area-label='Previous'>&lt;</a></li>";
//		}else {
//			pageBar += "<li class='page-item'><a class='page-link' href='"+url+"?cPage=" + (rowNum-1) +"&keyword="+keyword+"&category="+category+"&lo="+lo+"&recent="+recent+"&like="+like+"' area-label='Previous'>&lt;</a></li>";
//		}
//		
//		while(!(rowNum>pageLast || rowNum>totalPage)) {
//			if(cPage==rowNum) {
//				pageBar += "<li class='page-item'><a class='page-link' href=''>"+rowNum+"</a></li>";
//			}else {
//				pageBar += "<li class='page-item'><a class='page-link' href='"+url+"?cPage="+rowNum+"&keyword="+keyword+"&category="+category+"&lo="+lo+"&recent="+recent+"&like="+like+"'>"+rowNum+"</a></li>";
//			}
//			rowNum++;
//		}
//		
//		if(rowNum>totalPage) {
//			pageBar += "<li class='page-item'><a class='page-link' href='' area-label='Previous'>&gt;</a></li>";
//		}else {
//			pageBar +="<li class='page-item'><a class='page-link' href='"+url+"?cPage="+rowNum+"&keyword="+keyword+"&category="+category+"&lo="+lo+"&recent="+recent+"&like="+like+"' area-label='Previous'>&gt;</a></li>";
//		}
//		
//		pageBar += "<li class='page-item'><a class='page-link' href='' area-label='Previous'>&raquo;</a></li> </ul>";
//		
//		return pageBar;
//	}
	
	//동행페이지사용 -jsh
	public String pageBar2(String url, int totalData, int cPage, int perPage, String userTag, String keyword, String recent, String viewcount, String nearSchedule, String searchFilter, String first) {
		
	
		
		String pageBar = "<ul class=\"pagination justify-content-center\"> <li class='page-item'><a class='page-link' href='' area-label='Previous'>&laquo;</a></li>";
		
		int totalPage = totalData/perPage+1;
		
		int pageBarSize = 5;
	
		int rowNum = (cPage-1)/pageBarSize*pageBarSize+1;
		int pageLast = rowNum+pageBarSize-1;
		
		if(rowNum == 1) {
			pageBar += "<li class='page-item'><a class='page-link' href='' area-label='Previous'>&lt;</a></li>";
		}else {
			pageBar += "<li class='page-item'><a class='page-link' href='"+url+"?currentPage=" + (rowNum-1) +"&userTag="+ userTag +"&searchFilter="+searchFilter+"&keyword="+keyword+"&recent="+recent+"&viewcount="+viewcount+"&nearSchedule="+nearSchedule+"&first="+first+"' area-label='Previous'>&lt;</a></li>";
		}
		
		while(!(rowNum>pageLast || rowNum>totalPage)) {
			if(cPage==rowNum) {
				pageBar += "<li class='page-item'><a class='page-link' href=''>"+rowNum+"</a></li>";
			}else {
				pageBar += "<li class='page-item'><a class='page-link' href='"+url+"?currentPage="+rowNum+"&userTag="+ userTag + "&searchFilter=" + searchFilter + "&keyword="+keyword+"&recent="+recent+"&viewcount="+viewcount+"&nearSchedule="+nearSchedule+"&first="+first+"'>"+rowNum+"</a></li>";
			}
			rowNum++;
		}
		
		if(rowNum>totalPage) {
			pageBar += "<li class='page-item'><a class='page-link' href='' area-label='Previous'>&gt;</a></li>";
		}else {
			pageBar +="<li class='page-item'><a class='page-link' href='"+url+"?currentPage="+rowNum+"&userTag="+ userTag+ "&searchFilter=" + searchFilter + "&keyword=" + keyword+"&recent="+recent+"&viewcount="+viewcount+"&nearSchedule="+nearSchedule+"&first="+first+"' area-label='Previous'>&gt;</a></li>";
		}
		
		pageBar += "<li class='page-item'><a class='page-link' href='' area-label='Previous'>&raquo;</a></li> </ul>";

		return pageBar;
	}
		public  String pageBar(String url, int totalData, int cPage, int perPage) {
		
	
		
		String pageBar = "<ul class=\"pagination justify-content-center\"> <li class='page-item'><a class='page-link' href='' area-label='Previous'>&laquo;</a></li>";
		
		int totalPage = totalData/perPage+1;
		
		
		int pageBarSize = 5;
	
		int rowNum = ((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageLast = rowNum+pageBarSize-1;
		
		
		
		if(rowNum == 1) {
			pageBar += "<li class='page-item'><a class='page-link' href='' area-label='Previous'>&lt;</a></li>";
		}else {
			pageBar += "<li class='page-item'><a class='page-link' href='"+url+"?cPage=" + (rowNum-1) +"' area-label='Previous'>&lt;</a></li>";
		}
		
		while(!(rowNum>pageLast || rowNum>totalPage)) {
			if(cPage==rowNum) {
				pageBar += "<li class='page-item'><a class='page-link' href=''>"+rowNum+"</a></li>";
			}else {
				pageBar += "<li class='page-item'><a class='page-link' href='"+url+"?cPage="+rowNum+"'>"+rowNum+"</a></li>";
			}
			rowNum++;
		}
		
		if(rowNum>totalPage) {
			pageBar += "<li class='page-item'><a class='page-link' href='' area-label='Previous'>&gt;</a></li>";
		}else {
			pageBar +="<li class='page-item'><a class='page-link' href='"+url+"?cPage="+rowNum+"' area-label='Previous'>&gt;</a></li>";
		}
		
		
		  pageBar +=
		  "<li class='page-item'><a class='page-link' href='' area-label='Previous'>&raquo;</a></li> </ul>"
		 ;
		 
		return pageBar;
	}
	//aldus
	public  String pageBar(String url,
			int totalItemCount,int cPage,int perPage,String category,String searchDetail, String searchBox,String recent,String viewCount) {
		
	
		
		String pageBar = "<ul class=\"pagination justify-content-center\"> <li class='page-item'><a class='page-link' href='' area-label='Previous'>&laquo;</a></li>";
		
		int totalPage = totalItemCount/perPage+1;
		
		int pageBarSize = 5;
	
		int rowNum = (cPage-1)/pageBarSize*pageBarSize+1;
		int pageLast = rowNum+pageBarSize-1;
		
		if(rowNum == 1) {
			pageBar += "<li class='page-item'><a class='page-link' href='' area-label='Previous'>&lt;</a></li>";
		}else {
			pageBar += "<li class='page-item'><a class='page-link' href='"+url+"?cPage=" + (rowNum-1) +"&searchBox="+searchBox+"&category="+category+"&searchDetail="+searchDetail+"&recent="+recent+"&viewCount="+viewCount+"' area-label='Previous'>&lt;</a></li>";
		}
		
		while(!(rowNum>pageLast || (rowNum>totalPage))) {
			if(cPage==rowNum) {
				pageBar += "<li class='page-item'><a class='page-link' href=''>"+rowNum+"</a></li>";
			}else {
				pageBar += "<li class='page-item'><a class='page-link' href='"+url+"?cPage="+rowNum+"&searchBox="+searchBox+"&category="+category+"&searchDetail="+searchDetail+"&recent="+recent+"&viewCount="+viewCount+"'>"+rowNum+"</a></li>";
			}
			rowNum++;
		}
		
		if(rowNum>totalPage) {
			pageBar += "<li class='page-item'><a class='page-link' href='' area-label='Previous'>&gt;</a></li>";
		}else {
			pageBar +="<li class='page-item'><a class='page-link' href='"+url+"?cPage="+rowNum+"&searchBox="+searchBox+"&category="+category+"&searchDetail="+searchDetail+"&recent="+recent+"&viewCount="+viewCount+"' area-label='Previous'>&gt;</a></li>";
		}
		
		pageBar += "<li class='page-item'><a class='page-link' href='' area-label='Previous'>&raquo;</a></li> </ul>";
		
		return pageBar;
	}
	
	public String pageBar(String url, int totalData, int cPage, int perPage, String keyword, String category, String lo, String recent, String like, String first, String infoNo) {
		
	
		
		String pageBar = "<ul class=\"pagination justify-content-center\"> <li class='page-item'><a class='page-link' href='' area-label='Previous'>&laquo;</a></li>";
		System.out.println("총 데이터 : " + totalData);
		int totalPage = 0;
		
		if(totalData%perPage==0) {
			totalPage = totalData/perPage;
		}else {
			totalPage = totalData/perPage+1;
		}
	
		System.out.println("왜출력안되");
		System.out.println("총페이지수:"+totalPage);
		int pageBarSize = 5;
	
		int rowNum = ((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageLast = rowNum+pageBarSize-1;
		System.out.println("rowNum : " + rowNum);
		System.out.println("pageLast : " + pageLast);
		System.out.println("totalPage : " + totalPage);
		if(rowNum == 1) {
			pageBar += "<li class='page-item'><a class='page-link' href='' area-label='Previous'>&lt;</a></li>";
		}else {
			pageBar += "<li class='page-item'><a class='page-link' href='"+url+"?cPage=" + (rowNum-1) +"&keyword="+keyword+"&category="+category+"&lo="+lo+"&recent="+recent+"&like="+like+"&first="+first+"&infoNo="+infoNo+"' area-label='Previous'>&lt;</a></li>";
		}
		
		while(!(rowNum>pageLast || rowNum>totalPage)) {
			if(cPage==rowNum) {
				pageBar += "<li class='page-item'><a class='page-link' href=''>"+rowNum+"</a></li>";
			}else {
				pageBar += "<li class='page-item'><a class='page-link' href='"+url+"?cPage="+rowNum+"&keyword="+keyword+"&category="+category+"&lo="+lo+"&recent="+recent+"&like="+like+"&first="+first+"&infoNo="+infoNo+"'>"+rowNum+"</a></li>";
			}
			rowNum++;
		}
		
		if(rowNum>totalPage) {
			pageBar += "<li class='page-item'><a class='page-link' href='' area-label='Previous'>&gt;</a></li>";
		}else {
			pageBar +="<li class='page-item'><a class='page-link' href='"+url+"?cPage="+rowNum+"&keyword="+keyword+"&category="+category+"&lo="+lo+"&recent="+recent+"&like="+like+"&first="+first+"&infoNo="+infoNo+"' area-label='Previous'>&gt;</a></li>";
		}
		
		pageBar += "<li class='page-item'><a class='page-link' href='' area-label='Previous'>&raquo;</a></li> </ul>";
		
		return pageBar;
	}
}

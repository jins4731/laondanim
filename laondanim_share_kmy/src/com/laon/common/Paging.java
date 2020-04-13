package com.laon.common;

import javax.servlet.http.HttpServletRequest;

public class Paging {

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
	
	public  String pageBar(String url,
			int totalItemCount,int cPage,int perPage,String category,String searchDetail, String searchBox,String recent,String viewCount) {
		
	
		
		String pageBar = "<ul class=\"pagination justify-content-center\"> <li class='page-item'><a class='page-link' href='' area-label='Previous'>&laquo;</a></li>";
		
		int totalPage = totalItemCount/perPage+1;
		System.out.println("총페이지수:"+totalPage);
		int pageBarSize = 5;
	
		int rowNum = ((cPage-1)/pageBarSize)*pageBarSize+1;
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
	
	
	
}
	


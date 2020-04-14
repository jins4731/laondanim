package com.laon.common;

public class PagingTemplate {

	
	public static String getPageBar(String url,int cPage,int numPerPage,int totalPage) {
		
		String pageBar="";
		int pageBarSize=3;
		int pageNo=((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd=pageNo+pageBarSize-1;
		
		if(pageNo==1) {
			pageBar+="<span>[이전]<span>";
		}else {
			pageBar+="<a href='"+url+"/board/list.do?cPage="+(pageNo-1)+"'>[이전]</a>";
		};
				
		while(!(pageNo>pageEnd||pageNo>totalPage)) {
		if(pageNo==cPage) {
			pageBar+="<span>"+pageNo+"<span>";
		}else {
			pageBar+="<a href='"+url+"/board/list.do?cPage="+pageNo+"'>"+pageNo+"</a>";
								
		}pageNo++;
				};
		//다음페이지
		if(pageNo>totalPage) {
			pageBar+="<span>[다음]<span>";
			
		}else {
			pageBar+="<a href='"+url+"/board/list.do?cPage="+pageNo+"'>[다음]</a>";
			};
		
		return pageBar;
	}
}

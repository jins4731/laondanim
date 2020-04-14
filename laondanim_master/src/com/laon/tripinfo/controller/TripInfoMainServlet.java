package com.laon.tripinfo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.laon.tripinfo.model.service.TripInfoService;
import com.laon.tripinfo.model.vo.Mind;
import com.laon.tripinfo.model.vo.TripInfoComment;
import com.laon.tripinfo.model.vo.TripInfoPicture;
import com.laon.user.model.vo.User;

/**
 * Servlet implementation class GuideMainServlet
 */
@WebServlet("/tripinfo/tripinfoMain")
public class TripInfoMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TripInfoMainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String category=request.getParameter("category");
		
		String type=request.getParameter("type");
		type = type==null?"��ȣ��":type;
		
		String keyword = request.getParameter("keyword");
		keyword = keyword==null?"null":keyword;
		
		String mind = request.getParameter("mind");
		mind = mind==null?"null":mind;
		
		
		HttpSession session = request.getSession();
		User loginUser = (User)session.getAttribute("loginUser");
		int userNo = loginUser.getNo();
		System.out.println("�������� userNo :"+userNo);
		
		List<TripInfoComment> commentList = new TripInfoService().selectComment();
		
		
		
		
		
		int cPage;
		
		try {
			cPage=Integer.parseInt(request.getParameter("cPage"));
		}catch(NumberFormatException e) {
			cPage=1;
		}
		
		int numPerPage=10;
		
		/* �������� ����Ʈ �������� (ī�װ�)*/
//		List<TripInfoPicture> list=new TripInfoService().selectTripinfoList(cPage,numPerPage,category);
		List<TripInfoPicture> list=new TripInfoService().selectTripinfoList(cPage,numPerPage,category,type,keyword,mind);
		//��� �� ��� ����Ʈ
			
			List<Mind> mindList = new TripInfoService().selectMind();
			
			for(Mind mmm : mindList) {
				System.out.println("����������?" + mmm);
			}
			
			
		
		
		
		
		//Mind vo �� count ��������� �� �����
		//dao ���� ���� count(*) ���� count ��� ������ set�ϰ� mind ���̺��� ������ ���������� Mind vo �� ����
		
		//list ���� �ؿ� heartCount�� �ְ� 
		//set �Ѵ��� jsp�� ����
		//jsp ���� �ش� mind ����Ʈ�� �������� no ���� ��µ� �������� �Խñ��� no ���� ���ؼ� ��ġ�ϴ� mind vo ��ü�� count ���� �� ������ ���� 
		List<Mind> heartCount = new TripInfoService().heartCount(list);
		//LIST�� NO �� �Ű� ������ MIND_TB ���� no�� ��ġ�ϴ� row ���� ���� �޼ҵ� ����
		//SELECT * FROM MIND_TB WHERE TRIP_INFO_NO=?
		//���⼭ row�� ������ ���� �� �� �ְ� �׷��� ���� �� �� ����
	
		
		
		
		
		int totalDate=new TripInfoService().selectCountTripInfo(category,type,keyword);
		int totalPage=(int)Math.ceil((double)totalDate/numPerPage);
		
		String pageBar="";
		int pageBarSize=5;
		
		int pageNo=((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd=pageNo+pageBarSize-1;
		
		if(pageNo==1) {
			pageBar+="<span>[����]</span>";
		}else {
			pageBar+="<a href='"+request.getContextPath()
			+"/tripinfo/tripinfoMain?cPage="+(pageNo-1)
			+"&category="+category+"&type="+type+"&keyword="+keyword+"&mind="+mind
			+"'>[����]</a>";
		}
		
		while(!(pageNo>pageEnd||pageNo>totalPage)) {
			if(pageNo==cPage) {
				pageBar+="<span>"+pageNo+"</span>";
			}else {
				pageBar+="<a href='"+request.getContextPath()
				+"/tripinfo/tripinfoMain?cPage="+pageNo
				+"&category="+category+"&type="+type+"&keyword="+keyword+"&mind="+mind
				+"'>"+pageNo+"</a>";
			}
			pageNo++;
		}
		
		if(pageNo>totalPage) {
			pageBar+="<span>[����]</span>";
		}else {
			pageBar+="<a href='"+request.getContextPath()
			+"/tripinfo/tripinfoMain?cPage="+pageNo
			+"&category="+category+"&type="+type+"&keyword="+keyword+"&mind="+mind
			+"'>[����]</a>";
		}
		
		request.setAttribute("pageBar", pageBar);
		
		request.setAttribute("list", list);
		
		request.setAttribute("totalData",totalDate);
		
		request.setAttribute("heartCount", heartCount);
		
		request.setAttribute("mindList", mindList);
		
		request.setAttribute("commentList",  commentList);
		
		request.getRequestDispatcher("/views/tripinfo/tripinfoMain.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

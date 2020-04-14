package com.laon.tripinfo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laon.tripinfo.model.service.TripInfoService;
import com.laon.tripinfo.model.vo.Mind;

/**
 * Servlet implementation class TripInfoMindServlet
 */
@WebServlet("/tripinfo/tripinfoMind.do")
public class TripInfoMindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TripInfoMindServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String category=request.getParameter("category");
		int userNo=Integer.parseInt(request.getParameter("userNo"));
		int tripinfoNo=Integer.parseInt(request.getParameter("tripinfoNo"));	
		
		System.out.println("카테고리 : " + category);
		System.out.println("로그인된 유저 : " + userNo);
		System.out.println("트립인포넘버 : " +tripinfoNo);
		
		//-----서블릿 에서 처리
		//category 랑 userNo랑 tripinfoNo 이용해서 하트 색깔 변화 and 숫자 count(- , +)
		//1. 로그인 한 유저의 여행 정보 별 찜 여부 체크 
		//2. 로그인된 유저가 여행 정보 게시물의 찜을 한번도 안했을 때, MIND_TB 에 새로운 row insert
		//3. 만약 이미 MIND_TB 에 해당 게시물에 대한 row가 있을 때, 해당 게시물에 대한 CANCLED의 칼럼 값을 가져옴 ('Y', 'N')
		//4. 해당 게시물에 대한 CANCLED의 칼럼 값을 ('Y' -> 'N' OR 'N' -> 'Y')로 update
		//5. insert or update를 통해 나온 result 값 을 jsp로 보내줌(response.getWriter.print(result);)
		
		//-----jsp 에서 처리
		//6. success함수의 data 매개변수를 가지고 분기 처리
		//7. data > 0 -> 제대로 insert or update가 이루어짐 -> 하트의 모양 바꾸고, 찜 개수 카운터
		//   data < 0 -> insert or update 오류 발생
				
		String cancled = "";
		int resultInsert = 0;
		int result = 0;
		cancled = new TripInfoService().checkMind(userNo,tripinfoNo); //select 해서 cancled 칼럼을 가져오자나
		//MIND_TB 에 위에 조건에 해당하는 row 가 안나왓어 그 소리는 (한번도 그 게시물을 찜한 사람이 없다는 소리야)
		//MIND_TB에 위에 조건에 해당하는 row를 만들어야 되
		
		if(cancled==null) {	//로그인된 유저가 여행 정보 게시물의 찜을 한번도 안했을 때
			resultInsert = new TripInfoService().insertMind(userNo, tripinfoNo);//여기서 insert가 제대로 수행되면 0보다 큰거지?
		}
		
		if(!(cancled==null)) { 
			result=new TripInfoService().updateMind(userNo, tripinfoNo, cancled);
		}
		
		if(resultInsert>0 || result>0 ) response.getWriter().print(1);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

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
		
		//-----���� ���� ó��
		//category �� userNo�� tripinfoNo �̿��ؼ� ��Ʈ ���� ��ȭ and ���� count(- , +)
		//1. �α��� �� ������ ���� ���� �� �� ���� üũ 
		//2. �α��ε� ������ ���� ���� �Խù��� ���� �ѹ��� ������ ��, MIND_TB �� ���ο� row insert
		//3. ���� �̹� MIND_TB �� �ش� �Խù��� ���� row�� ���� ��, �ش� �Խù��� ���� CANCLED�� Į�� ���� ������ ('Y', 'N')
		//4. �ش� �Խù��� ���� CANCLED�� Į�� ���� ('Y' -> 'N' OR 'N' -> 'Y')�� update
		//5. insert or update�� ���� ���� result �� �� jsp�� ������(response.getWriter.print(result);)
		
		//-----jsp ���� ó��
		//6. success�Լ��� data �Ű������� ������ �б� ó��
		//7. data > 0 -> ����� insert or update�� �̷���� -> ��Ʈ�� ��� �ٲٰ�, �� ���� ī����
		//   data < 0 -> insert or update ���� �߻�
				
		String cancled = "";
		int resultInsert = 0;
		int result = 0;
		cancled = new TripInfoService().checkMind(userNo,tripinfoNo); //select �ؼ� cancled Į���� �������ڳ�
		//MIND_TB �� ���� ���ǿ� �ش��ϴ� row �� �ȳ��Ӿ� �� �Ҹ��� (�ѹ��� �� �Խù��� ���� ����� ���ٴ� �Ҹ���)
		//MIND_TB�� ���� ���ǿ� �ش��ϴ� row�� ������ ��
		
		if(cancled==null) {	//�α��ε� ������ ���� ���� �Խù��� ���� �ѹ��� ������ ��
			resultInsert = new TripInfoService().insertMind(userNo, tripinfoNo);//���⼭ insert�� ����� ����Ǹ� 0���� ū����?
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

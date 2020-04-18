package com.laon.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laon.board.model.service.BoardService;
import com.laon.board.model.vo.BoardComment;
import com.laon.board.model.vo.BoardCommentJoinUser;
import com.laon.board.model.vo.BoardJoinUser;

/**
 * Servlet implementation class BoardViewServlet
 */
@WebServlet("/board/boardView.do")
public class BoardViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�Խñ� ���� ����
		//�Խñ� ��ȣ ������
		int boardNo=Integer.parseInt(request.getParameter("boardNo"));
		System.out.println("���Դ�?"+boardNo);
		//��Ű�� ��ȸ�� ����. f5������ ��ȸ���� ��ӿö���
		Cookie[] cookies=request.getCookies();
		String cookieVal="";
		boolean hasRead=false;//false��  ��ȸ�� ����, true�� ��ȸ�� �״��
		if(cookies!=null) {
			for(Cookie c:cookies) {
				String name=c.getName();
				String value=c.getValue();
				System.out.println("��Ű��:"+name+":"+value);
				if("boardCookie".equals(name)) {
					cookieVal=value;
					if(value.contains("|"+boardNo+"|")) {//"|"�� ������. �ۿ��� ��Ű�� Ȯ���ϸ� ���� ����.
						hasRead=true;
						break;
					}
				}
			}
		}
		if(!hasRead) {
			//�������Ÿ�
			Cookie c=new Cookie("boardCookie",cookieVal+"|"+boardNo+"|");
			c.setMaxAge(-1);//session ����� ����
			response.addCookie(c);
		}
		
		BoardJoinUser b=new BoardService().boardDetail(boardNo,hasRead);
		
		//��۵� �޾ƿ���
		//�Խñ��� ��ȣ�� ��۵� �����ϰ� �����ϱ�!
		List<BoardCommentJoinUser> comments=new BoardService().selectComment(boardNo);
		System.out.println("��� �ִ�:"+comments.size());
		
		if(b==null) { //�Խñ��� �������
			
			request.setAttribute("msg", "선택한 게시물이 없습니다");
			request.setAttribute("loc", "/board/list.do");
			request.getRequestDispatcher("/views/common/msg.jsp");
			
		}else {
		 
			request.setAttribute("BoardJoinUser", b);
			request.setAttribute("comments", comments);
			request.getRequestDispatcher("/views/board/boardView.jsp").forward(request, response);
		}
		
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

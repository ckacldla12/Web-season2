package board.dong.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dong.command.MCommand;
import board.dong.command.MDeleteCommand;
import board.dong.command.MInsertCommand;
import board.dong.command.MListCommand;
import board.dong.command.MUpdateCommand;
import board.dong.command.MViewCommand;



@WebServlet("*.do")
public class MemberController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String viewPage = null;
		MCommand command = null;
		
		String url = request.getRequestURL().toString();
		String com = url.substring(url.lastIndexOf("/") + 1, url.lastIndexOf(".do"));
		if(com != null && com.trim().equals("list")) {
			command = new MListCommand();
			command.execute(request, response);
			viewPage = "/WEB-INF/View/mList.jsp";
		}		
		if(com != null && com.trim().equals("insertForm")) {
			viewPage = "/WEB-INF/View/mInsertForm.jsp";
		}
		if(com != null && com.trim().equals("insert")) {
			command = new MInsertCommand();
			command.execute(request, response);
			viewPage = "list.do";
		}
		if(com != null && com.trim().equals("view")) {
			command = new MViewCommand();
			command.execute(request, response);
			viewPage = "/WEB-INF/View/mView.jsp";
		}
		if(com != null && com.trim().equals("update")) {
			command = new MUpdateCommand();
			command.execute(request, response);
			viewPage = "list.do";
		}
		if(com != null && com.trim().equals("delete")) {
			command = new MDeleteCommand();
			command.execute(request, response);
			viewPage = "list.do";
		}
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
	}
}
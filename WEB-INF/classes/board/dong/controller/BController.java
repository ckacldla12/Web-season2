package board.dong.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dong.command.BCommand;
import board.dong.command.BDeleteCommand;
import board.dong.command.BInsertCommand;
import board.dong.command.BListCommand;
import board.dong.command.BUpdateCommand;
import board.dong.command.BViewCommand;


@WebServlet("*.di")
public class BController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String viewPage = null;
		BCommand command = null;
		
		String url = request.getRequestURL().toString();
		String com = url.substring(url.lastIndexOf("/") + 1, url.lastIndexOf(".di"));
		if(com != null && com.trim().equals("blist")) {
			command = new BListCommand();
			command.execute(request, response);
			viewPage = "/WEB-INF/View/BList.jsp";
		}		
		if(com != null && com.trim().equals("binsertForm")) {
			viewPage = "/WEB-INF/View/BInsertForm.jsp";
		}
		if(com != null && com.trim().equals("binsert")) {
			command = new BInsertCommand();
			command.execute(request, response);
			viewPage = "blist.di";
		}
		if(com != null && com.trim().equals("bview")) {
			command = new BViewCommand();
			command.execute(request, response);
			viewPage = "/WEB-INF/View/BView.jsp";
		}
		if(com != null && com.trim().equals("bupdate")) {
			command = new BUpdateCommand();
			command.execute(request, response);
			viewPage = "blist.di";
		}
		if(com != null && com.trim().equals("bdelete")) {
			command = new BDeleteCommand();
			command.execute(request, response);
			viewPage = "blist.di";
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
package board.dong.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import board.dong.dao.ReplyDAO;


@WebServlet("*.rp")
public class ReplyController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/x-json; charset=UTF-8");
		
		JSONArray list = new JSONArray();
		ReplyDAO rdao = new ReplyDAO();
		String reply = request.getParameter("reply"); //null
		String title = request.getParameter("title");
//		String title = "67";
		
		String uri = request.getRequestURI();
		String com = uri.substring(uri.lastIndexOf("/")+1,uri.lastIndexOf(".rp"));
		
		if(com !=null && com.trim().equals("rinsert")) {
			rdao.register(title, reply);
		}else if(com !=null && com.trim().equals("rlist")) {			 
			list = rdao.rlist(title);
			response.getWriter().print(list);
		}
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
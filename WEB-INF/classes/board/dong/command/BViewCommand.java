package board.dong.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dong.dao.BDAO;
import board.dong.dto.BDTO;





public class BViewCommand implements BCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		String title = request.getParameter("title");
		BDAO bdao = new BDAO();
		BDTO bdto = bdao.getBoard(title);
		
		request.setAttribute("bdto", bdto);
	}

}
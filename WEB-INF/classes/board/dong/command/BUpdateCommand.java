package board.dong.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dong.dao.BDAO;
import board.dong.dto.BDTO;



public class BUpdateCommand implements BCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		

		BDTO bdto = new BDTO();
		bdto.setTitle(request.getParameter("title"));
		bdto.setContents(request.getParameter("contents"));
		bdto.setBname(request.getParameter("bname"));		
		
		BDAO bdao = new BDAO();
		bdao.bupdate(bdto);
	}

}
package board.dong.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dong.dao.BDAO;
import board.dong.dto.BDTO;





public class BInsertCommand implements BCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// TODO Auto-generated method stub
		BDTO bdto = new BDTO();
		bdto.setTitle(request.getParameter("title"));
		bdto.setContents(request.getParameter("contents"));
		bdto.setBname(request.getParameter("bname"));		
		
		BDAO bdao = new BDAO();
		bdao.binsert(bdto);
	}
	
}
package board.dong.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import board.dong.dto.BDTO;

public class BDAO {
	private DataSource ds;
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public BDAO() {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:comp/env");
			ds = (DataSource)envContext.lookup("jdbc/DONG");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			if(con != null) {
				con.close();
				con = null;
			}
		} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
		}
	}
	
	public void bdelete(String title) {
		String sql = "DELETE FROM BOARD WHERE TITLE=?";
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.executeQuery();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void bupdate(BDTO bdto) {
		String sql = "UPDATE BOARD SET BNAME=?, CONTENTS=?, bjoinDate=SYSDATE WHERE TITLE=?";
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bdto.getBname());
			pstmt.setString(2, bdto.getContents());
			pstmt.setString(3, bdto.getTitle());
			
			pstmt.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}	
	public BDTO getBoard(String title) {
		String sql = "select * from board where title=?";
		BDTO bdto = new BDTO();
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, title);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				bdto.setBname(rs.getString("bname"));
				bdto.setTitle(rs.getString("title"));
				bdto.setContents(rs.getString("contents"));				
				bdto.setBjoinDate(rs.getDate("bjoinDate"));				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return bdto;
	}
	
	public ArrayList<BDTO> blist() {
		String sql = "select * from board";
		
		ArrayList<BDTO> bdtos = new ArrayList<BDTO>();
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BDTO bdto = new BDTO();
				bdto.setTitle(rs.getString("title"));
				bdto.setContents(rs.getString("contents"));
				bdto.setBname(rs.getString("bname"));
				bdto.setBjoinDate(rs.getDate("bjoinDate"));				
				bdtos.add(bdto);
			}
			rs.close();
			pstmt.close();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close();
		}
		return bdtos;
	}
	public void binsert(BDTO bdto) {
		String sql = "INSERT INTO BOARD VALUES(?, ?, ?, SYSDATE)";
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bdto.getTitle());
			pstmt.setString(2, bdto.getContents());
			pstmt.setString(3, bdto.getBname());			
			pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close();
		}
	}
}
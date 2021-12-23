package board.dong.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class ReplyDAO {
	private DataSource ds;
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public ReplyDAO() {
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
	public void register(String title, String reply) {
		CallableStatement cstmt = null;
		String sql = "{call pro_reply2(?,?)}";
		try {
			con = ds.getConnection();
			cstmt = con.prepareCall(sql);
			
			cstmt.setString(1, title);
			cstmt.setString(2, reply);
			cstmt.execute();
			
			cstmt.close();
		}catch(SQLException ex) {
			System.out.println("register :  오류  : " + ex.getLocalizedMessage());
		}finally {
			close();
		}
	}
	public JSONArray rlist(String title) { 
		String sql = "select title, num, reply from reply2 where title = ? order by num desc";
		JSONArray list = new JSONArray();
		try {
			con = ds.getConnection();

			System.out.println("rlist : " + title);
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, title);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				JSONObject json = new JSONObject();				
				json.put("num", rs.getInt("num"));
				json.put("reply", rs.getString("reply"));				
				list.add(json);
				
				System.out.println(json);
				System.out.println(list);
			}
			rs.close();
			pstmt.close();
		}catch (SQLException ex) {
			System.out.println("rlist : SQL inset 오류  : " + ex.getLocalizedMessage());
		}finally {
			close();
		}
		return list;
	}
}
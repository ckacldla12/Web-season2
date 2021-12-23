package board.dong.dto;

import java.sql.Date;

public class MemberDTO {
	private String id;
	private String name;
	private String email;
	private String pwd;
	private Date joinDate;
	
	public MemberDTO(String id, String name, String email, Date joinDate) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.joinDate = joinDate;
	}
	
	public MemberDTO() {
		super();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
}
package board.dong.dto;

import java.sql.Date;

public class BDTO {
	private String title;
	private String contents;
	private String bname;	
	private Date bjoinDate;
	
	public BDTO(String title, String contents, String bname, Date bjoinDate) {
		super();
		this.title = title;
		this.contents = contents;
		this.bname = bname;
		this.bjoinDate = bjoinDate;
	}
	
	public BDTO() {
		super();
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}
	
	public Date getBjoinDate() {
		return bjoinDate;
	}

	public void setBjoinDate(Date bjoinDate) {
		this.bjoinDate = bjoinDate;
	}

	
	
}
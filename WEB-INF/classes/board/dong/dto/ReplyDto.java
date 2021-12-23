package board.dong.dto;

public class ReplyDto {
	private int seq;
	private String title;
	private int num;
	private String reply;
	
	public ReplyDto(int seq, String title, int num, String reply) {
		super();
		this.seq = seq;
		this.title = title;
		this.num = num;
		this.reply = reply;
	}
	
	public ReplyDto() {
		super();
	}
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	

}

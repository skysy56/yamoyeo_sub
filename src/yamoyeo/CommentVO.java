package yamoyeo;

public class CommentVO {
	
	private int comment_id;
	private String comment_text;
	private String user_id;
	private String group_id;
	
	public CommentVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommentVO(int comment_id, String comment_text, String user_id, String group_id) {
		super();
		this.comment_id = comment_id;
		this.comment_text = comment_text;
		this.user_id = user_id;
		this.group_id = group_id;
	}

	public int getComment_id() {
		return comment_id;
	}

	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}

	public String getComment_text() {
		return comment_text;
	}

	public void setComment_text(String comment_text) {
		this.comment_text = comment_text;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getGroup_id() {
		return group_id;
	}

	public void setGroup_id(String group_id) {
		this.group_id = group_id;
	}

	@Override
	public String toString() {
		return "CommentVO [comment_id=" + comment_id + ", comment_text=" + comment_text + ", user_id=" + user_id
				+ ", group_id=" + group_id + "]";
	}
	
	
	
	

}

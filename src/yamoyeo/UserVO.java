package yamoyeo;

public class UserVO {
	
	private String user_id;
	private String user_pwd;
	private String user_name;
	private String phone;
	private String sex;
	private String interest;
	private String address;
	
	public UserVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserVO(String user_id, String user_pwd, String user_name, String phone, String sex, String interest,
			String address) {
		super();
		this.user_id = user_id;
		this.user_pwd = user_pwd;
		this.user_name = user_name;
		this.phone = phone;
		this.sex = sex;
		this.interest = interest;
		this.address = address;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pwd() {
		return user_pwd;
	}

	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "UserVO [user_id=" + user_id + ", user_pwd=" + user_pwd + ", user_name=" + user_name + ", phone=" + phone
				+ ", sex=" + sex + ", interest=" + interest + ", address=" + address + "]";
	}

	
	
	
	
	

}

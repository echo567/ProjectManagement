package cn.bean;

/*
 * 军辉  2018年12月19日上午10:01:20
 */
public class User {
	private Integer userId;
	private String userName;
	private String password;

	public User() {
	}

	public User(Integer userId, String userName) {
		this.userId = userId;
		this.userName = userName;
	}

	public User(String userName, String password) {

		this.userName = userName;
		this.password = password;
	}

	public User(Integer userId, String userName, String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", Password=" + password + "]";
	}

}

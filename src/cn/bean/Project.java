package cn.bean;

import java.util.Date;

/*
 * 军辉  2018年12月19日下午3:25:10
 */
public class Project {
	private Integer id;
	private String name;
	private String startTime;
	private String user;
	private String introduction;
	private String note;

	public Project() {
	}

	public Project(String name, String startTime, String user, String introduction) {
		super();
		this.name = name;
		this.startTime = startTime;
		this.user = user;
		this.introduction = introduction;
	}

	public Project(Integer id, String name, String startTime, String user, String introduction, String note) {
		super();
		this.id = id;
		this.name = name;
		this.startTime = startTime;
		this.user = user;
		this.introduction = introduction;
		this.note = note;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", startTime=" + startTime + ", user=" + user
				+ ", Introduction=" + introduction + ", note=" + note + "]";
	}

}

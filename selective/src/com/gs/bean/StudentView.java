package com.gs.bean;

public class StudentView {

	private int sid; //学号
	
	private String sname; //学生姓名
	
	private String spassword; //学生密码
	
	private String ssex; //学生性别
	
	private int sage; //学生年龄
	
	private String classname; //班级
	
	private String depname; //系别

	public StudentView() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentView(int sid, String sname, String spassword, String ssex,
			int sage, String classname, String depname) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.spassword = spassword;
		this.ssex = ssex;
		this.sage = sage;
		this.classname = classname;
		this.depname = depname;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSpassword() {
		return spassword;
	}

	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}

	public String getSsex() {
		return ssex;
	}

	public void setSsex(String ssex) {
		this.ssex = ssex;
	}

	public int getSage() {
		return sage;
	}

	public void setSage(int sage) {
		this.sage = sage;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getDepname() {
		return depname;
	}

	public void setDepname(String depname) {
		this.depname = depname;
	}

	
	
	
}

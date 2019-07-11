package com.gs.bean;

public class TeacherView {
	private int tid; //教师编号
	
	private String tpassword; //教师密码
	
	private String tname; //教师姓名
	
	private String tsex; //教师性别
	
	private int tage; //教师年龄
	
	private String tjob; //教师职务
	
	private String depname; //教师系别
    
	@Override
	public String toString() {
		return tname;
	}

	public TeacherView() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TeacherView(int tid, String tpassword, String tname, String tsex,
			int tage, String tjob, String depname) {
		super();
		this.tid = tid;
		this.tpassword = tpassword;
		this.tname = tname;
		this.tsex = tsex;
		this.tage = tage;
		this.tjob = tjob;
		this.depname = depname;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTpassword() {
		return tpassword;
	}

	public void setTpassword(String tpassword) {
		this.tpassword = tpassword;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getTsex() {
		return tsex;
	}

	public void setTsex(String tsex) {
		this.tsex = tsex;
	}

	public int getTage() {
		return tage;
	}

	public void setTage(int tage) {
		this.tage = tage;
	}

	public String getTjob() {
		return tjob;
	}

	public void setTjob(String tjob) {
		this.tjob = tjob;
	}

	public String getDepname() {
		return depname;
	}

	public void setDepname(String depname) {
		this.depname = depname;
	}
	
	

}

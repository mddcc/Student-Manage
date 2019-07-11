package com.gs.bean;

public class CourseView {

	private int cid; //课程编号
	
	private String coursename; //科目名称
	
	private int credit; //学分
	
	private String ctime; //上课时间
	
	private String caddress; //上课地点
	
	private String teacher; //教师编号
	
	private int limitnumber; //限定人数
	
	private int turenumber; //实际选课人数

	@Override
	public String toString() {
		return coursename;
	}
	
	public CourseView() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CourseView(int cid, String coursename, int credit, String ctime,
			String caddress, String teacher, int limitnumber, int turenumber) {
		super();
		this.cid = cid;
		this.coursename = coursename;
		this.credit = credit;
		this.ctime = ctime;
		this.caddress = caddress;
		this.teacher = teacher;
		this.limitnumber = limitnumber;
		this.turenumber = turenumber;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public String getCtime() {
		return ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

	public String getCaddress() {
		return caddress;
	}

	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public int getLimitnumber() {
		return limitnumber;
	}

	public void setLimitnumber(int limitnumber) {
		this.limitnumber = limitnumber;
	}

	public int getTurenumber() {
		return turenumber;
	}

	public void setTurenumber(int turenumber) {
		this.turenumber = turenumber;
	}
	

}

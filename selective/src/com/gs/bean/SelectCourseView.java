package com.gs.bean;

/**
 * 
 * @author 
 * 选课成绩视图
 */
public class SelectCourseView {
	private int id;// 编号自增
	   private int sid;//学号
	   private String sname;//学生姓名
	   private int cid;//课程编号
	   private String coursename;//课程名称
	   private int score;//成绩
	public SelectCourseView() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SelectCourseView(int cid, String coursename, int score) {
		super();
		this.cid = cid;
		this.coursename = coursename;
		this.score = score;
	}

	public SelectCourseView(int id, int sid, String sname, int cid,
			String coursename, int score) {
		super();
		this.id = id;
		this.sid = sid;
		this.sname = sname;
		this.cid = cid;
		this.coursename = coursename;
		this.score = score;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}

package com.gs.bean;
/***
 * 
 * @author 
 * 学生类
 */
public class Student {

	private int sid; //学号
	
	private String sname; //学生姓名
	
	private String spassword; //学生密码
	
	private int ssex; //学生性别
	
	private int sage; //学生年龄
	
	private int sclass; //所属班级
	
	private int sdapartment; //学生系别

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int sid, String sname, String spassword, int ssex, int sage,
			int sclass, int sdapartment) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.spassword = spassword;
		this.ssex = ssex;
		this.sage = sage;
		this.sclass = sclass;
		this.sdapartment = sdapartment;
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

	public int getSsex() {
		return ssex;
	}

	public void setSsex(int ssex) {
		this.ssex = ssex;
	}

	public int getSage() {
		return sage;
	}

	public void setSage(int sage) {
		this.sage = sage;
	}

	public int getSclass() {
		return sclass;
	}

	public void setSclass(int sclass) {
		this.sclass = sclass;
	}

	public int getSdapartment() {
		return sdapartment;
	}

	public void setSdapartment(int sdapartment) {
		this.sdapartment = sdapartment;
	}

	
}

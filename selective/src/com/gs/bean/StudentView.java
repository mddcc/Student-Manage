package com.gs.bean;

public class StudentView {

	private int sid; //ѧ��
	
	private String sname; //ѧ������
	
	private String spassword; //ѧ������
	
	private String ssex; //ѧ���Ա�
	
	private int sage; //ѧ������
	
	private String classname; //�༶
	
	private String depname; //ϵ��

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

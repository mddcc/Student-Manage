package com.gs.bean;

public class Teacher {

	private int tid; //��ʦ���
	
	private String tpassword; //��ʦ����
	
	private String tname; //��ʦ����
	
	private int tsex; //��ʦ�Ա�
	
	private int tage; //��ʦ����
	
	private String tjob; //��ʦְ��
	
	private int tdepartment; //��ʦϵ��

	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Teacher(int tid, String tpassword, String tname, int tsex, int tage,
			String tjob, int tdepartment) {
		super();
		this.tid = tid;
		this.tpassword = tpassword;
		this.tname = tname;
		this.tsex = tsex;
		this.tage = tage;
		this.tjob = tjob;
		this.tdepartment = tdepartment;
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

	public int getTsex() {
		return tsex;
	}

	public void setTsex(int tsex) {
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

	public int getTdepartment() {
		return tdepartment;
	}

	public void setTdepartment(int tdepartment) {
		this.tdepartment = tdepartment;
	}
	
	
}

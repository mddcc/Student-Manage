package com.gs.bean;

public class Manager {

	private int id; //����Ա���
	
	private String sysaccount; //����Ա�˺�
	
	private String syspassword; //����Ա����

	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manager(int id, String sysaccount, String syspassword) {
		super();
		this.id = id;
		this.sysaccount = sysaccount;
		this.syspassword = syspassword;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSysaccount() {
		return sysaccount;
	}

	public void setSysaccount(String sysaccount) {
		this.sysaccount = sysaccount;
	}

	public String getSyspassword() {
		return syspassword;
	}

	public void setSyspassword(String syspassword) {
		this.syspassword = syspassword;
	}
	
	
}

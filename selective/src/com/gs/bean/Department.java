package com.gs.bean;

public class Department {

	private int id; //ϵ����
	
	private String depname; //ϵ��

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(int id, String depname) {
		super();
		this.id = id;
		this.depname = depname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepname() {
		return depname;
	}

	public void setDepname(String depname) {
		this.depname = depname;
	}
	
	@Override
	public String toString() {
		return depname;
	}
}

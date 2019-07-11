package com.gs.bean;

public class Department {

	private int id; //系别编号
	
	private String depname; //系名

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

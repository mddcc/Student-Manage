package com.gs.bean;

public class ClassBean {

	private int id; //°à¼¶±àºÅ
	
	private String classname; //°à¼¶Ãû

	public ClassBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClassBean(int id, String classname) {
		super();
		this.id = id;
		this.classname = classname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}
	@Override
	public String toString() {
		return classname;
	}
	
}

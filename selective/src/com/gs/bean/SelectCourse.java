package com.gs.bean;

public class SelectCourse {

	private int id; //ѡ�α��
	
	private String sid; //ѧ��
	
	private int cid; //��Ŀ���
	
	private int score; //�ɼ�

	public SelectCourse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SelectCourse(int id, String sid, int cid, int score) {
		super();
		this.id = id;
		this.sid = sid;
		this.cid = cid;
		this.score = score;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	
}

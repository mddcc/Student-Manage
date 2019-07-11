package com.gs.bean;

public class CourseView {

	private int cid; //�γ̱��
	
	private String coursename; //��Ŀ����
	
	private int credit; //ѧ��
	
	private String ctime; //�Ͽ�ʱ��
	
	private String caddress; //�Ͽεص�
	
	private String teacher; //��ʦ���
	
	private int limitnumber; //�޶�����
	
	private int turenumber; //ʵ��ѡ������

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

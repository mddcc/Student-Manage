package com.gs.bean;
/***
 * 
 * @author 
 * ѧ����
 */
public class Student {

	private int sid; //ѧ��
	
	private String sname; //ѧ������
	
	private String spassword; //ѧ������
	
	private int ssex; //ѧ���Ա�
	
	private int sage; //ѧ������
	
	private int sclass; //�����༶
	
	private int sdapartment; //ѧ��ϵ��

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

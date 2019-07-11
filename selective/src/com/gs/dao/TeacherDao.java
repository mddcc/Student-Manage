package com.gs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.gs.bean.StudentView;
import com.gs.bean.Teacher;
import com.gs.utils.DBUtil;

public class TeacherDao {
	/*
	 * 查询登录成功的教师信息
	 * 
	 */
	public Teacher loginTea(String name,String pass){
		Teacher tea = new Teacher();
		Connection conn = DBUtil.getConnection();
		String sql = "select * from t_teacher where Tname=? and tpassword=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, pass);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				tea.setTid(rs.getInt("tid"));
				tea.setTname(rs.getString("Tname"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
		return tea;
	}
	/*
	 * 教师修改密码
	 * 
	 */
	public int updatePwd(int id,String pass){
		Connection conn = DBUtil.getConnection();
		String sql = "update t_teacher set tpassword=? where tid=?";
		int rtn = -1;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pass);
			pstmt.setInt(2, id);
			rtn = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
		return rtn;
	}
	/*
	 * 查询教师任课信息
	 * 
	 */
	public Vector<Vector> courseQuery(int id){
		Vector<Vector> courses = new Vector<Vector>();
		Connection conn = DBUtil.getConnection();
		String sql = "select * from t_course where teacher = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Vector vtr = new Vector();
				vtr.add(rs.getInt("id"));
				vtr.add(rs.getString("coursename"));
				vtr.add(rs.getInt("credit"));
				vtr.add(rs.getString("ctime"));
				vtr.add(rs.getString("caddress"));
				vtr.add(rs.getInt("limitnumber"));
				vtr.add(rs.getInt("truenumber"));
				courses.add(vtr);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
		return courses;
	}
	/**
	 * 
	 * 搜索选课学生
	 * 
	 */
	public List courseselect(int cid){
		List list=new ArrayList();
		Connection conn = DBUtil.getConnection();
		try {
			Statement stm = conn.createStatement();
			String sql = "select * from t_student where t_student.sid in"
					+ "(select t_selectcourse.sid from t_selectcourse where cid='"+cid+"')";
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				int sid=rs.getInt(1);
				String spassword= rs.getString(2);
				String sname=rs.getString(3);
				String ssex = rs.getInt(4)==0?"女":"男";
				int sage=rs.getInt(5);
				String classname=rs.getString(6);
				String depname=rs.getString(7);
				StudentView bean = new StudentView(sid,spassword,sname,ssex,sage,classname,depname);
				list.add(bean);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
		return list;
	}
}

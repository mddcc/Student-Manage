package com.gs.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.gs.bean.Student;
import com.gs.utils.DBUtil;

public class StudentDao {
	/*
	 * 查询登录成功的学生信息
	 * 
	 */
	public Student loginStu(int sid,String pass){
		Student stu = new Student();
		Connection conn = DBUtil.getConnection();
		String sql = "select * from t_student where sid=? and spassword = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sid);
			pstmt.setString(2, pass);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				stu.setSid(rs.getInt("sid"));
				stu.setSname(rs.getString("sname"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
		return stu;
	}
	/*
	 * 学生修改密码
	 * 
	 */
	public int updatePwd(int id,String pass){
		Connection conn = DBUtil.getConnection();
		String sql = "update t_student set spassword=? where sid=?";
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
	 * 查询学生选课信息
	 * 
	 */
	public Vector<Vector> selectCourseQuery(int id){
		Vector<Vector> courses = new Vector<Vector>();
		Connection conn = DBUtil.getConnection();
		String sql = "select * from t_course where id in ("+
							"select cid from t_selectcourse where sid=?)";
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
	/*
	 * 学生选课
	 * 
	 */
	public int  selective(int sid,int cid){
		int i = 0;
		Connection conn = DBUtil.getConnection();
		String sql = "insert into t_selectcourse (sid,cid) values (?,?)";
//		System.out.println(sql);
		try {
	        CallableStatement cstm = conn.prepareCall(sql);
			cstm.setInt(1,sid);
			cstm.setInt(2,cid);
			System.out.println(sid);
			System.out.println(cid);
			//cstm.executeUpdate();
			cstm.executeUpdate();
			//System.out.println(ifTrue);
//			System.out.println(sql);
			i=1;
				System.out.println("成功");
			
		} catch (SQLException e) {
			i=0;
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
		return i;
		
	}
	
	
	/**
	 * 获取某次课程选课次数
	 * @param cid
	 * @param sid
	 * @return
	 */
	public int getcountcid(int cid,int sid) {
		Connection conn = DBUtil.getConnection();
		int cidcount = 0;
		try {
			Statement stm = conn.createStatement();			 
			String sql = "select count(cid)cidcount FROM t_selectcourse where cid = '"+cid+"' and sid = '"+sid+"'";
			ResultSet rs = stm.executeQuery(sql);
			if(rs.next()) {
				cidcount = rs.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(conn);
		}
		System.out.println(cidcount);
		return cidcount;
		
	}
	
	/**
	 * 添加选课人数
	 * @param cid
	 */
	public void addTruePeople(int id) {
		Connection conn = DBUtil.getConnection();
		
		try {
			Statement stm = conn.createStatement();			 
			String sql = "UPDATE t_course set `truenumber` = truenumber + 1 WHERE id = '"+id+"'";
			stm.execute(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(conn);
		}
		
	}
	public static void main(String[] args) {
		StudentDao dao = new StudentDao();
		dao.selective(12831101, 1);
	}
}

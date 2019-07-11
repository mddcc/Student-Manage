package com.gs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.gs.bean.ClassBean;
import com.gs.bean.Department;
import com.gs.bean.Student;
import com.gs.bean.StudentView;
import com.gs.utils.DBUtil;

/**
 * 
 * @author 
 * 学生管理接口（管理员部分）
 */
public class SysStudentDao {
	
	/*
	 * 查询所有的系别
	 */
	public List<Department> queryAllDepts(){
		List depts = new ArrayList<Department>();
		Connection conn = DBUtil.getConnection();
		ResultSet rs =null;
		try {
			String sql = "select * from t_department";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String depname = rs.getString("depname");
				Department dept = new Department(id,depname);
				depts.add(dept);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn);
		}
		return depts;
	}
	/*
	 * 查询给定系别的所有班级
	 */
	public List<ClassBean> queryAllClass(){
		List classes = new ArrayList<ClassBean>();
		Connection conn = DBUtil.getConnection();
		ResultSet rs =null;
		try {
			String sql = "select * from t_class";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String classname = rs.getString("classname");
				ClassBean cls = new ClassBean(id, classname);
				classes.add(cls);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn);
		}
		return classes;
	}
	/*
	 * 查询所有学生信息
	 */
	public Vector<Vector> queryAllStudentView(){
		Vector stuView = new Vector<Vector>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		try {
			String sql = null;
			sql="SELECT t_student.sid,t_student.spassword,t_student.sname,t_student.ssex,t_student.sage,t_class.classname sclass,t_department.depname sDepartment from t_student INNER JOIN t_class on t_student.sclass = t_class.id INNER JOIN t_department on t_department.id = t_student.sDepartment";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				Vector vtr = new Vector();
				vtr.add(rs.getInt("sid"));
				vtr.add(rs.getString("spassword"));
				vtr.add(rs.getString("sname"));
				if(rs.getInt("ssex")==1){
					vtr.add("男");
				}else{
					vtr.add("女");
				}
				vtr.add(rs.getInt("sage"));
				vtr.add(rs.getString("sclass"));
				vtr.add(rs.getString("sDepartment"));
				stuView.add(vtr);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn);
		}
		return stuView;
	}
	/*
	 * 删除一条数据
	 */
	public int delete(int sid){
		List stuView = new ArrayList<StudentView>();
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		int ifTrue = -1;
		try {
			String sql = "delete from t_student where sid =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sid);
			ifTrue = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn);
		}
		return ifTrue;
	}
	/*
	 * 修改一条数据
	 */
	public int update(Student stu){
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		int ifTrue = -1;
		try {
			String sql = "update t_student set spassword=?,sname=?,ssex=?,sage=?,sclass=?,sDepartment=? where sid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stu.getSpassword());
			pstmt.setString(2, stu.getSname());
			pstmt.setInt(3, stu.getSsex());
			pstmt.setInt(4, stu.getSage());
			pstmt.setInt(5, stu.getSclass());
			pstmt.setInt(6, stu.getSdapartment());
			pstmt.setInt(7, stu.getSid());
			ifTrue = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn);
		}
		return ifTrue;
	}
	/*
	 * 新增一条数据
	 */
	public int insert(Student stu){
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		int ifTrue = -1;
		try {
			String sql = "insert into t_student values(?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, stu.getSid());
			pstmt.setString(2, stu.getSpassword());
			pstmt.setString(3,stu.getSname());
			pstmt.setInt(4, stu.getSsex());
			pstmt.setInt(5, stu.getSage());
			pstmt.setInt(6, stu.getSclass());
			pstmt.setInt(7, stu.getSdapartment());
			ifTrue = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn);
		}
		return ifTrue;
	}

}

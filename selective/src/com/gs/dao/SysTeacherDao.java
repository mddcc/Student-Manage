package com.gs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.gs.bean.Teacher;
import com.gs.bean.TeacherView;
import com.gs.utils.DBUtil;

/**
 * 
 * @author 
 *系统教师管理
 */

public class SysTeacherDao {
	/**
	 * 
	 * 显示教师表
	 */
	public List<TeacherView> select(){
		List<TeacherView> list=new ArrayList<TeacherView>();
		Connection conn = DBUtil.getConnection();
		try {
			Statement stm = conn.createStatement();
			String sql = "select * from t_teacher";
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				int tid=rs.getInt(1);
				String tpassword= rs.getString(2);
				String tname=rs.getString(3);
				String tsex = rs.getInt(4)==0?"女":"男";
				int tage=rs.getInt(5);
				String tjob=rs.getString(6);
				String depname=rs.getString(7);
				TeacherView bean = new TeacherView(tid,tpassword,tname,tsex,tage,tjob,depname);
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
	/**
	 * 添加
	 */
	public void add(Teacher bean){
		Connection conn = DBUtil.getConnection();
		try {
			String sql = "insert into t_teacher(tpassword,tname,tsex,tage,tjob,tdepartment) values('"+bean.getTpassword()+"','"
					+ ""+bean.getTname() +"','"+bean.getTsex()+"','"
					+ ""+bean.getTage()+"','"+bean.getTjob()+"','"+bean.getTdepartment()+"')";
			Statement pstmt = conn.createStatement();
			pstmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
	}
	/**
	 * 
	 * 修改
	 */
	public void update(Teacher bean){
		Connection conn = DBUtil.getConnection();
		String sql = "update t_teacher set tpassword=?,tname=?,"
				+ "tsex=?,tage=?,tjob=?,tdepartment=? where tid=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bean.getTpassword());
			pstmt.setString(2,bean.getTname());
			pstmt.setInt(3,bean.getTsex());
			pstmt.setInt(4,bean.getTage());
			pstmt.setString(5,bean.getTjob());
			pstmt.setInt(6,bean.getTdepartment());
			pstmt.setInt(7, bean.getTid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
	}
	
	/**
	 * 删除
	 */
	public void delete(Teacher bean){
		Connection conn = DBUtil.getConnection();
		try {
			String sql = "delete from t_teacher where tid =?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bean.getTid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
	}
	
}

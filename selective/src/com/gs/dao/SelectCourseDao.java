package com.gs.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.gs.bean.ClassBean;
import com.gs.bean.Department;
import com.gs.bean.SelectCourse;
import com.gs.bean.SelectCourseView;
import com.gs.utils.DBUtil;

/**
 * 
 * @author 
 * 添加进StudentDao
 */

public class SelectCourseDao {
	
	
	/*
	 * 成绩查询操作
	 * 
	 */
	public void selective(int sid,int cid) {
		Connection conn = DBUtil.getConnection();
		String sql = "call t_selectcourse(?,?)";
		try {
			CallableStatement cstm = conn.prepareCall(sql);
			cstm.setInt(1, sid);
			cstm.setInt(2, cid);
			cstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}

	}
	/*
	 * 
	 */
	public List select(int sid){
		List list = new ArrayList(); 
		Connection conn = DBUtil.getConnection();
		try {
			Statement stm = conn.createStatement();
			String sql = "SELECT t_course.id,t_course.coursename,t_selectcourse.Score FROM t_selectcourse INNER JOIN t_course on t_selectcourse.cid = t_course.id WHERE t_selectcourse.sid = '"+sid+"'";
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				int cid = rs.getInt(1);
				String coursename = rs.getString(2);
				int score =rs.getInt(3);
				SelectCourseView bean = new SelectCourseView(cid,coursename,score);
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

	

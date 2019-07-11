package com.gs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import com.gs.utils.DBUtil;

public class SysLogDao {
	/*
	 * 查询日志信息
	 * 
	 */
	public Vector<Vector> logQuery(){
		Vector<Vector> logs = new Vector<Vector>();
		Connection conn = DBUtil.getConnection();
		String sql = "select * from t_log";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Vector vtr = new Vector();
				vtr.add(rs.getInt("id"));
				vtr.add(rs.getString("loginaccount"));
				vtr.add(rs.getString("logintime"));
				logs.add(vtr);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
		return logs;
	}
	/*
	 * 插入日志信息
	 * 
	 */
	public void addLog(String name){
		Connection conn = DBUtil.getConnection();
		String sql = "insert into t_log(loginaccount,logintime) values(?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			pstmt.setString(2, sdf.format(date));
			pstmt.executeUpdate();
			
			// pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
	}
}

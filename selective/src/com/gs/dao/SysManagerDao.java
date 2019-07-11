package com.gs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gs.bean.Manager;
import com.gs.utils.DBUtil;

public class SysManagerDao {
	/*
	 * 查询登录成功的管理员信息
	 * 
	 */
	public Manager loginAdmin(String name,String pass){
		Manager admin = new Manager();
		Connection conn = DBUtil.getConnection();
		String sql = "select * from t_manager where sysaccount=? and Syspassword = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, pass);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				admin.setId(rs.getInt("id"));
				admin.setSysaccount(rs.getString("sysaccount"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
		return admin;
		
	}
	/**
	 * 
	 * 显示管理员表
	 * 
	 */
	public List select(){
		List list=new ArrayList();
		Connection conn = DBUtil.getConnection();
		try {
			Statement stm = conn.createStatement();
			String sql = "select * from t_manager";
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				int sysid=rs.getInt(1);
				String sysaccount= rs.getString(2);
				String syspassword=rs.getString(3);
				
				Manager bean = new Manager(sysid,sysaccount,syspassword);
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
	 * 
	 */
	public void add(Manager bean){
		Connection conn = DBUtil.getConnection();
		try {
			String sql = "insert into t_manager(sysaccount,syspassword) values('"+bean.getSysaccount()+"','"
					+ ""+bean.getSyspassword() +"')";
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
	 * 
	 */
	public void update(Manager bean){
		Connection conn = DBUtil.getConnection();
		String sql = "update t_manager set sysaccount=?,syspassword=? where id=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bean.getSysaccount());
			pstmt.setString(2,bean.getSyspassword());
			pstmt.setInt(3, bean.getId());
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
	 * 
	 */
	public void delete(Manager bean){
		Connection conn = DBUtil.getConnection();
		try {
			String sql = "delete from t_manager where id =?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bean.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
	}
}

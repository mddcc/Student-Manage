package com.gs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gs.utils.DBUtil;

public class Demo {
	public static void main(String[] args) {
		new Demo().query();;
	}
	
	/*
	 * 查询
	 */
	public ResultSet query(){
		Connection conn = DBUtil.getConnection();
		ResultSet rs =null;
		try {
			String sql = "select * from t_class where id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 5);
			rs = pstmt.executeQuery();
			while(rs.next()){
				rs.getInt("sid");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	/**
	 * 添加学生
	 */
	public void add(){
		Connection conn = DBUtil.getConnection();
		try {
			String sql = "insert into t_class (classname) values(?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "爱谁谁");
			int ifTrue = pstmt.executeUpdate();
			if(ifTrue>0){
				System.out.println("成功");
			}else{
				System.out.println("失败");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//修改
	public void update(){
		Connection conn = DBUtil.getConnection();
		try {
			String sql = "update t_class set classname=? where id=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "爱谁谁11");
			pstmt.setInt(2, 6);
			int ifTrue = pstmt.executeUpdate();
			if(ifTrue>0){
				System.out.println("成功");
			}else{
				System.out.println("失败");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//修改
	public void delete(){
		Connection conn = DBUtil.getConnection();
		try {
			String sql = "delete from t_class where id =?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 1);
			int ifTrue = pstmt.executeUpdate();
			if(ifTrue>0){
				System.out.println("成功");
			}else{
				System.out.println("失败");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

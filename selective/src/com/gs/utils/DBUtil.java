package com.gs.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static  String driverName = "com.mysql.jdbc.Driver";  //����JDBC����
	private static   String dbURL = "jdbc:mysql://106.14.140.102:3306/selectivedb?useUnicode=true&characterEncoding=UTF-8";  //���ӷ����������ݿ�
	private static   String userName = "root";  //Ĭ���û���
	private static   String userPwd = "root";  //����
	
	public static Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(dbURL,userName,userPwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void closeConnection(Connection conn){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

package com.gs.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.gs.bean.ClassBean;
import com.gs.utils.DBUtil;

/*
 * @author 
 * 班级管理
 * 
 */

public class SysClassDao 
{
	  //添加班级 
	public void add (ClassBean abc )
	   {
	       Connection conn = DBUtil.getConnection();
	       try {
		//	Statement ps =conn.createStatement();
			   String sql = "insert into t_class (classname) values(?)"  ; 

		          PreparedStatement   ps =  conn.prepareStatement(sql); 
			      ps.setString(1,abc.getClassname());   
			      ps.executeUpdate(); 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
	    
	        



	   }
	
	//修改班级
	public void update (ClassBean abc )
	   {
	       Connection conn = DBUtil.getConnection();
	       try {
		//	Statement ps =conn.createStatement();
			   String sql = "update t_class set classname = ? where id= ?  "  ; 

		          PreparedStatement   ps =  conn.prepareStatement(sql); 
			      ps.setString(1,abc.getClassname());
			      ps.setInt(2,abc.getId());
			      
			      ps.executeUpdate(); 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
	    
	        



	   }
	//删除班级
	
	public void delete (ClassBean abc )
	   {
	       Connection conn = DBUtil.getConnection();
	       try {
		//	Statement ps =conn.createStatement();
			   String sql = "delete from t_class where id=?"  ; 

		          PreparedStatement   ps =  conn.prepareStatement(sql); 
			      ps.setInt(1,abc.getId());
			    
			      ps.executeUpdate(); 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
	    
	        



	   }
	
	//查询班级
	public List select ()
	   {  List list = new ArrayList(); 
	       Connection conn = DBUtil.getConnection();
	       try {
		//	Statement ps =conn.createStatement();
			   String sql = "select * from t_class "  ; 

		          PreparedStatement   ps =  conn.prepareStatement(sql); 
			      
			    
		    ResultSet rs = ps.executeQuery();
		    while(rs.next())
		    {    int classid = rs.getInt(1);
		         String classname = rs.getString(2);
		         ClassBean abc =new ClassBean(classid,classname);
		         list.add(abc);
		    	
		    	
		    }
		   
			      
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
	    
	       return list ;  



	   }
	

	
	
	
	
	
	
}

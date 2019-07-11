package com.gs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gs.bean.ClassBean;
import com.gs.bean.SelectCourseView;
import com.gs.utils.DBUtil;

public class SysSelectCourse {
	
	
	/*
	 * 查询班级
	 *  */
		public List select ()
		   {  List list = new ArrayList(); 
		       Connection conn = DBUtil.getConnection();
		       try {
			//	Statement ps =conn.createStatement();
				   String sql = "select * from t_selectcourse "  ; 

			          PreparedStatement   ps =  conn.prepareStatement(sql); 
				      
				    
			    ResultSet rs = 	      ps.executeQuery();
			    while(rs.next())
			    {    int id = rs.getInt(1);
			         int sid = rs.getInt(2);
			         String sname = rs.getString(3);
			         int cid = rs.getInt(4);
			         String coursename =rs.getString(5);
			         int score = rs.getInt(6);
			         
			         
			         SelectCourseView abc =new SelectCourseView(id,sid,sname,cid,coursename,score);
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
	   
	/*
	 * 修改成绩
	 *  
	 */
		public void update (SelectCourseView scv )
		   {
		       Connection conn = DBUtil.getConnection();
		       try {
			//	Statement ps =conn.createStatement();
				   String sql = "update t_selectcourse set score = ? where sid= ?  "  ; 

			          PreparedStatement   ps =  conn.prepareStatement(sql); 
				      ps.setInt(1,scv.getScore());
				      ps.setInt(2,scv.getId());
				      
				      ps.executeUpdate(); 
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DBUtil.closeConnection(conn);
			}
		    
		        



		   }
	


		public void add (SelectCourseView scv )
		{
			Connection conn = DBUtil.getConnection();
			try {
				//	Statement ps =conn.createStatement();
				String sql = "update  t_selectcourse set score = ?  where cid =? and sid= ? "  ; 

				PreparedStatement   ps =  conn.prepareStatement(sql); 
				ps.setInt(1,scv.getScore());
				ps.setInt(2,scv.getCid());
				ps.setInt(3,scv.getSid());
				ps.executeUpdate(); 
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DBUtil.closeConnection(conn);
			}
			}

			}

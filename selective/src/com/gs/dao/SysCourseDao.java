package com.gs.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.gs.bean.Course;
import com.gs.bean.CourseView;
import com.gs.utils.DBUtil;
/**
 * 
 * @author 
 *课程管理
 */

public class SysCourseDao {
	public static void main(String[] args) {
		//new SysCourseDao().query();;

	}
	/*
	 * 查询课程
	 */
	public List select(){
		List list = new ArrayList();
		Connection conn = DBUtil.getConnection();
		try {
			Statement stm = conn.createStatement(); 
			String sql = "select * from t_course";
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				int cid = rs.getInt(1);
				String coursename = rs.getString(2);
				int credit= rs.getInt(3);
				String  ctime  = rs.getString(4);
				String caddress = rs.getString(5);
				String teacher = rs.getString(6);
				int limitnumber = rs.getInt(7);
				int truenumber = rs.getInt(8);
				CourseView bean = new CourseView(cid,coursename,credit,ctime,caddress,teacher,limitnumber,truenumber);
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
	/*
	 * 修改课程
	 */
	public void update(Course bean){
		Connection conn = DBUtil.getConnection();
		String sql = "update t_course set coursename=?,credit=?,ctime=?,caddress=?,teacher=?,limitnumber=?,truenumber=? where id=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getCoursename());
			pstmt.setInt(2, bean.getCredit());
			pstmt.setString(3, bean.getCtime());
			pstmt.setString(4, bean.getCaddress());
			pstmt.setInt(5, bean.getTeacher());
			pstmt.setInt(6, bean.getLimitnumber());
			pstmt.setInt(7, bean.getTurenumber());
			pstmt.setInt(8, bean.getCid());
			int ifTrue = pstmt.executeUpdate();
			if(ifTrue>0){
				System.out.println("成功");
			}else{
				System.out.println("失败");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
	}
	/*
	 * 删除课程
	 */
	public void delete(Course bean){
		Connection conn = DBUtil.getConnection();
		try {
			String sql = "delete from t_course where id =?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,bean.getCid());
			int ifTrue = pstmt.executeUpdate();
			if(ifTrue>0){
				System.out.println("成功");
			}else{
				System.out.println("失败");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
	}	
	/*
	 * 添加课程
	 */
	public void add(Course bean){
		Connection conn = DBUtil.getConnection();
		try {
			String sql = "insert into t_course(coursename,Credit,cTime,caddress,Teacher,Limitnumber,Truenumber) "
					+ "values(?,?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getCoursename());
			pstmt.setInt(2, bean.getCredit());
			pstmt.setString(3, bean.getCtime());
			pstmt.setString(4, bean.getCaddress());
			pstmt.setInt(5, bean.getTeacher());
			pstmt.setInt(6, bean.getLimitnumber());
			pstmt.setInt(7, bean.getTurenumber());
			int ifTrue = pstmt.executeUpdate();
			if(ifTrue>0){
				System.out.println("成功");
			}else{
				System.out.println("失败");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
	}
	
}


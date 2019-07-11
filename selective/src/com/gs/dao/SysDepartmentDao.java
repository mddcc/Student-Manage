package com.gs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gs.bean.Department;
import com.gs.utils.DBUtil;

/** 
 * @author 
 * ϵ������ӿ�
 */
public class SysDepartmentDao {
//	public static void main(String[] args) {
//		SysDepartmentDao depDao = new SysDepartmentDao();
//		depDao.query();
//		dapDao.add();
//	}
	
	/*
	 * ��װ  ����  չʾ
	 */
	
	public List query(){
		List list = new ArrayList();
		Connection conn = DBUtil.getConnection();
		try {
			Statement stm = conn.createStatement();
			String sql =  "select * from t_department";
			//�����
			ResultSet rs = stm.executeQuery(sql);
			System.out.println(rs);
			while(rs.next()){
				int id = rs.getInt(1);
				String depname = rs.getString(2);
				Department depbean = new Department(id,depname);
				list.add(depbean);
//				System.out.print(rs.getInt(1)+"   ");
//				System.out.println(rs.getString(2));
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
	 * ϵ������
	 */
	
	public void add(Department bean){
		Connection conn = DBUtil.getConnection();
		try {
			Statement stm = conn.createStatement();
			String sql = "insert into t_department (depname) values('"+bean.getDepname()+"')";
			stm.executeUpdate(sql); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
	}
	
	/*
	 * ϵ���޸�
	 */
	
	public void update(Department bean){
		Connection conn = DBUtil.getConnection();
		try {
			Statement stm = conn.createStatement();
			String Depname = bean.getDepname();
			int id = bean.getId();
			String sql = "update t_department set depname = '"+bean.getDepname()+"' where id = "+id+"";
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
	}
	
	
	/*
	 * ϵ��ɾ��
	 */
	public void delete(Department bean){
		Connection conn = DBUtil.getConnection();
		try {
			String sql = "delete from t_department where id =?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bean.getId());
			//pstmt.setString(2, bean.getDepname());
			int ifTrue = pstmt.executeUpdate();
			if(ifTrue>0){
				System.out.println("ɾ���ɹ�");
			}else{
				System.out.println("ɾ��ʧ��");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn);
		}
	}
	/*
	 * 
	 */
	public List<Department> select(){
		List<Department> list=new ArrayList<Department>();
		Connection conn = DBUtil.getConnection();
		try {
			Statement stm = conn.createStatement();
			String sql = "select * from t_department";
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				int id=rs.getInt(1);
				String depname=rs.getString(2);
				Department bean = new Department(id,depname);
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

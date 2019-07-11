 package com.gs.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.gs.bean.Course;
import com.gs.bean.Department;
import com.gs.bean.SelectCourse;
import com.gs.bean.Student;
import com.gs.bean.SelectCourseView;
import com.gs.dao.SelectCourseDao;

/**
 * 
 * @author
 * 学生成绩查看
 * “课程号 课程名 成绩”
 */
public class StuSearchScoreFrame extends JFrame {
	
	final JTable table = new JTable(); //表格 
	Vector colName = new Vector();//表格内容名称
	final DefaultTableModel dtm = new DefaultTableModel();//表控制模型
	
	/*
	 * 界面
	 */
	public StuSearchScoreFrame(){
		setResizable(false);
		setBounds(100, 100, 800, 500);
		JScrollPane sp = new JScrollPane(setTable());
		this.add(sp);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
	/*
	 * 表格重新查询，刷新作用
	 */
	public void refresh(){
		SelectCourseDao dao = new SelectCourseDao();
		Student bean = SelectiveMainFrame.student;
		int sid = bean.getSid();//获取学生ID
		List list = dao.select(sid);
		Vector data = showTable(list);
		dtm.setDataVector(data, colName);
		table.setModel(dtm);

	}
	
	
	/*
	 * 表格设置
	 */
	public JTable setTable(){
		JPanel jpanel = new JPanel();
		
		colName.add("课程号");
		colName.add("课程名");
		colName.add("成绩");

		refresh();
//		table.addMouseListener(new MouseAdapter() {
//			public void mouseClicked(java.awt.event.MouseEvent arg0){
//				int row = table.getSelectedRow();//选中哪一行
//				idTxt.setText(dtm.getValueAt(row, 0).toString());//强制转换为String，从底数0开始 
//				depTxt.setText((String)dtm.getValueAt(row, 1));
//			}
//		});
		return table;
	}

	/*
	 * 表格内数据
	 */
	public Vector showTable(List list){
		Vector data = new Vector();//大的数据
		for(int i=0;i<list.size();i++){
			SelectCourseView bean = (SelectCourseView)list.get(i);//为了得到getCoursename
			Vector vec = new Vector();
			vec.add(bean.getCid());
			vec.add(bean.getCoursename());
			vec.add(bean.getScore());
			data.add(vec);
		}
		return data;
	}
	
	
//	private JPanel contentPane;
//	/**
//	 * Create the frame.
//	 */
//	public StuSearchScoreFrame() {
//		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		setResizable(false);
//		setBounds(100, 100, 800, 500);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setLayout(new BorderLayout(0, 0));
//		setContentPane(contentPane);
//		setVisible(true);
//	}

}

package com.gs.view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.gs.bean.Course;
import com.gs.bean.CourseView;
import com.gs.bean.Department;
import com.gs.bean.SelectCourse;
import com.gs.bean.SelectCourseView;
import com.gs.bean.StudentView;
import com.gs.dao.StudentDao;
import com.gs.dao.SysCourseDao;
import com.gs.dao.TeacherDao;
/**
 * 
 * @author
 *教师管理-选课信息查看
 */
public class TeaSearchSelectFrame extends JFrame {

	JTable table = new JTable();//窗体
	Vector<String> colName = new Vector<String>();//头部名称
	DefaultTableModel dtm = new DefaultTableModel();
	JComboBox Coursenamecom = new JComboBox();//课程复选框
	/**
	 * 运行函数
	 */
	public TeaSearchSelectFrame() {
		setBounds(100, 100, 800, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		init();
		inittCoursenamecom();
		setVisible(true);
	}
	/**
	 * 界面分布
	 */
	public void init(){
		JScrollPane jsp = new JScrollPane(setTable());
		final JSplitPane sp = new JSplitPane
	(JSplitPane.VERTICAL_SPLIT,setInfo(),jsp);
		sp.addComponentListener(new ComponentAdapter() {  
            public void componentResized(ComponentEvent e) {  
            	sp.setDividerLocation(0.2);  
            	}  
		}); 
		add(sp);
	}
	/**
	 * 界面设置
	 * @return
	 */
	public JPanel setInfo(){
		JPanel jp = new JPanel();
		jp.setLayout(null);
		JLabel coursenameLabel = new JLabel("课程名称");//编号标签
		coursenameLabel.setBounds(20, 30, 60, 15);
		jp.add(coursenameLabel);
		/**
		 * 课程复选框
		 */
		Coursenamecom.setBounds(90, 28, 90, 20);
		jp.add(Coursenamecom);//课程复选框
		/**
		 * 搜索按钮
		 */
		
		JButton selectButton = new JButton("搜索");//搜索按钮
		selectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CourseView bean0 = (CourseView) Coursenamecom.getSelectedItem();
				int cid = bean0.getCid();
				
				TeacherDao dao = new TeacherDao();
				List list = dao.courseselect(cid);
				Vector data = showTable(list);
				dtm.setDataVector(data, colName);
				table.setModel(dtm);
			}
		});
		selectButton.setBounds(190, 27, 70, 23);
		jp.add(selectButton);
		return jp;
	}
	/**
	 * 表格
	 * @return
	 */
	public JTable setTable(){//表格头部名称
		colName.add("编号");
		colName.add("密码");
		colName.add("姓名");
		colName.add("性别");
		colName.add("年龄");
		colName.add("班级");
		colName.add("系别");

		return table;
	}
	
	/**
	 * 
	 * 显示表格
	 * 分批装入
	 */
	public Vector showTable(List list){
		Vector data = new Vector();
		for(int i=0;i<list.size();i++){
			StudentView bean = (StudentView)list.get(i);
			Vector vec= new Vector();
			vec.add(bean.getSid());
			vec.add(bean.getSname());
			vec.add(bean.getSpassword());
			vec.add(bean.getSsex());
			vec.add(bean.getSage());
			vec.add(bean.getClassname());
			vec.add(bean.getDepname());
			data.add(vec);
		}
		return data;
		
	}
	/*
	 * 下拉框
	 * */
	public void inittCoursenamecom(){
		SysCourseDao dao = new SysCourseDao();
		List list = dao.select();
		for(Object object : list){
			CourseView bean = (CourseView) object ;
			Coursenamecom.addItem(bean);
		}
	}
}

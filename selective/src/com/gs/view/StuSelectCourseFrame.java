package com.gs.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.gs.bean.CourseView;
import com.gs.bean.Student;
import com.gs.bean.TeacherView;
import com.gs.dao.StudentDao;
import com.gs.dao.SysCourseDao;
/**
 * 
 * @author 
 * 学生选课窗体
 */
public class StuSelectCourseFrame extends JFrame {

	private JPanel contentPane;
	private JTextField courseText;
	private JTable table = new JTable();// 表格
	Vector colName = new Vector();
	DefaultTableModel dtm = new DefaultTableModel();
	/**
	 * Create the frame.
	 */
	public StuSelectCourseFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 800, 500);
		setResizable(false);
		//setTable();
		init();
		//setInfo();
		setVisible(true);
	}
	public JPanel setInfo(){
		JPanel jp = new JPanel();
		jp.setLayout(null);
		JLabel lblNewLabel = new JLabel("课程编号");
		lblNewLabel.setBounds(10, 10, 65, 27);
		jp.add(lblNewLabel);
		
		courseText = new JTextField();
		courseText.setBounds(85, 13, 108, 21);
		jp.add(courseText);
		courseText.setColumns(10);
		
		JButton seleButton = new JButton("选课");
		seleButton.setBounds(226, 12, 93, 23);
		seleButton.addMouseListener(new MouseAdapter() {   //选课事件 
			
			 public void mouseClicked(MouseEvent e){
				    int cid = Integer.parseInt(courseText.getText());
				    Student bean = SelectiveMainFrame.student;
				    int sid = bean.getSid();
				    StudentDao dao = new StudentDao();
				    
				    int xuanzema = dao.getcountcid(cid,sid);
					System.out.println(xuanzema);
					if(xuanzema == 0) {
						 int i=dao.selective(sid, cid);
							refresh();
						    if(i==1){
						    	dao.addTruePeople(cid);
						    	//JOptionPane.showConfirmDialog(null, "选课成功");
						    	JOptionPane.showMessageDialog(null, "选课成功");
						    	refresh();
						    }else{
						    	//JOptionPane.showConfirmDialog(null, "选课失败");
						    	JOptionPane.showMessageDialog(null, "选课失败");
						    } 
					}else {
						JOptionPane.showMessageDialog(null, "请勿重复选课");
					}
   
				 }
			 });
		
		jp.add(seleButton);
	    return jp;
	}
	public  JTable setTable(){
		colName.add("编号");
		colName.add("名称");
		colName.add("学分");
		colName.add("上课时间");
		colName.add("上课地点");
		colName.add("任课教师");
		colName.add("限定人数");
		colName.add("选课人数");
		refresh();
		table.addMouseListener(new MouseAdapter(){
			public void mouseClicked(java.awt.event.MouseEvent arg0){
				int row = table.getSelectedRow();//选中一行
				courseText.setText(dtm.getValueAt(row, 0).toString());
			}		
		});
		return table;
	}
	public void refresh(){   //刷新表格
		SysCourseDao dao = new SysCourseDao();
		List list = dao.select();
		Vector data = showTable (list);
		dtm.setDataVector(data,colName);
		table.setModel(dtm);
	}
	public Vector showTable(List list){
		Vector data = new Vector();
		for(int i=0;i<list.size();i++){
			CourseView bean = (CourseView)list.get(i);
			Vector vec = new Vector();
			vec.add(bean.getCid());
			vec.add(bean.getCoursename());
			vec.add(bean.getCredit());
			vec.add(bean.getCtime());
			vec.add(bean.getCaddress());
			vec.add(bean.getTeacher());
			vec.add(bean.getLimitnumber());
			vec.add(bean.getTurenumber());
			data.add(vec);
		}
		return data;
	}
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
}
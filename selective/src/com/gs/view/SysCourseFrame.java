package com.gs.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import com.gs.bean.Course;
import com.gs.bean.CourseView;
import com.gs.bean.Department;
import com.gs.bean.Teacher;
import com.gs.bean.TeacherView;
import com.gs.dao.SysCourseDao;
import com.gs.dao.SysTeacherDao;
/**
 * 
 * @author 
 * 课程管理窗口
 */
public class SysCourseFrame extends JFrame {

	private JPanel contentPane;
	//JTextField idText = new JTextField();
	private JTextField cidtextField;//编号
	private JTextField caddressText; //教室
	private JTextField coursenameText;//课程名称
	private JTextField creditText;//学分
	private JTextField LimitnumberText;//限定人数
	private JTextField ctimeText;//上课时间
	private JTextField truenumberText;//已选人数
	private JComboBox teacherBox=new JComboBox();//教师
	private JTable table = new JTable();// 表格
	Vector colName = new Vector();
	DefaultTableModel dtm = new DefaultTableModel();
	
	

//	public SysCourseFrame() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 800, 500);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//	    setContentPane(contentPane);
//		setVisible(true);
//	}
	
	
	public SysCourseFrame(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 800, 500);
		//setTable();
		init();
		//setInfo();
		setVisible(true);
	}
	public JPanel setInfo(){
  
		JPanel jp = new JPanel();
		jp.setLayout(null);
		JButton CupdateButton = new JButton("修改");
		CupdateButton.addMouseListener(new MouseAdapter() {   //修改事件
			
			 public void mouseClicked(MouseEvent e){
				 //String coursename = coursenameText.getText();
				 int cid = Integer.parseInt(cidtextField.getText());
				 String coursename = coursenameText.getText();
				 int credit = Integer.parseInt(creditText.getText());
				 String ctime = ctimeText.getText();
				 String caddress = caddressText.getText();
				 TeacherView tbean = (TeacherView)teacherBox.getSelectedItem();
				 int teacher = tbean.getTid();
				 int limitnumber = Integer.parseInt(LimitnumberText.getText());
				 int truenumber = Integer.parseInt(truenumberText.getText()); 
				 Course bean = new Course(cid,coursename,credit,ctime,caddress,teacher,limitnumber,truenumber);
				 SysCourseDao dao = new SysCourseDao();
				 dao.update(bean);
				 refresh();
				 
			 }
		});
		CupdateButton.setBounds(21, 110, 93, 23);
		jp.add(CupdateButton);
		
		JButton CdeleteButton = new JButton("删除");
		CdeleteButton.addMouseListener(new MouseAdapter() {   //删除事件
			
			 public void mouseClicked(MouseEvent e){
				 int id = Integer.parseInt(cidtextField.getText());
				 Course bean = new Course();
				 bean.setCid(id);
				 SysCourseDao dao =new SysCourseDao();
				 dao.delete(bean);
				 refresh();
			 }
		});
		CdeleteButton.setBounds(136, 110, 93, 23);
		jp.add(CdeleteButton);
		
		JButton CaddButton = new JButton("新增");
		CaddButton.addMouseListener(new MouseAdapter() {   //新增事件
			
			 public void mouseClicked(MouseEvent e){
				 String coursename = coursenameText.getText();
				 int credit = Integer.parseInt(creditText.getText());
				 String ctime = ctimeText.getText();
				 String caddress = caddressText.getText();
				 TeacherView tbean = (TeacherView)teacherBox.getSelectedItem();
				 int teacher = tbean.getTid();
				 int limitnumber = Integer.parseInt(LimitnumberText.getText());
				 int truenumber = Integer.parseInt(truenumberText.getText());
			     SysCourseDao dao =new SysCourseDao();
			     Course bean = new Course();
			     bean.setCoursename(coursename);
			     bean.setCredit(credit);
			     bean.setCtime(ctime);
			     bean.setCaddress(caddress);
			     bean.setTeacher(teacher);
			     bean.setLimitnumber(limitnumber);
			     bean.setTurenumber(truenumber);
			     dao.add(bean);
			     refresh();
			 }
		});
		
		

		CaddButton.setBounds(249,110, 93, 23);
		jp.add(CaddButton);
		
		JLabel cidLabel = new JLabel("编号");
		cidLabel.setBounds(21, 23, 54, 15);
		jp.add(cidLabel);
		
		JLabel caddresslabel = new JLabel("上课地点");
		caddresslabel.setBounds(21, 61, 54, 15);
		jp.add(caddresslabel);
		
		cidtextField = new JTextField();
		cidtextField.setBounds(85, 21, 66, 18);
		cidtextField.setEditable(false);
		jp.add(cidtextField);
		cidtextField.setColumns(10);
		
		caddressText = new JTextField();
		caddressText.setBounds(85, 59, 66, 18);
		jp.add(caddressText);
		caddressText.setColumns(10);
		
		JLabel coursenamelabel = new JLabel("课程名称");
		coursenamelabel.setBounds(175, 23, 54, 15);
		jp.add(coursenamelabel);
		
		JLabel teacherLabel = new JLabel("任课教师");
		teacherLabel.setBounds(175, 61, 54, 15);
		jp.add(teacherLabel);
		
		teacherBox = new JComboBox();
		teacherBox.setBounds(239, 58, 78, 21);
		jp.add(teacherBox);

		
		coursenameText = new JTextField();
		coursenameText.setBounds(239, 21, 78, 18);
		jp.add(coursenameText);
		coursenameText.setColumns(10);
		
		JLabel creditlabel = new JLabel("学分");
		creditlabel.setBounds(343, 23, 54, 15);
		jp.add(creditlabel);
		
		JLabel limitnumberlabel = new JLabel("限定人数");
		limitnumberlabel.setBounds(343, 61, 54, 15);
		jp.add(limitnumberlabel);
		
		creditText = new JTextField();
		creditText.setBounds(397, 21, 66, 18);
		jp.add(creditText);
		creditText.setColumns(10);
		
		LimitnumberText = new JTextField();
		LimitnumberText.setBounds(397, 59, 66, 18);
		jp.add(LimitnumberText);
		LimitnumberText.setColumns(10);
		
		JLabel ctimelabel = new JLabel("上课时间");
		ctimelabel.setBounds(483, 23, 54, 15);
		jp.add(ctimelabel);
		
		JLabel truenumberlabel = new JLabel("选课人数");
		truenumberlabel.setBounds(483, 61, 54, 15);
		jp.add(truenumberlabel);
		
		ctimeText = new JTextField();
		ctimeText.setBounds(561, 21, 66, 18);
		jp.add(ctimeText);
		ctimeText.setColumns(10);
		
		truenumberText = new JTextField();
		truenumberText.setBounds(561, 59, 66, 18);
		jp.add(truenumberText);
		truenumberText.setColumns(10);
		initTeacherBox();  //教师下拉框
		
		return jp;
	}
	public void initTeacherBox(){             //教师下拉框
		SysTeacherDao dao = new SysTeacherDao();
		List teacherList = dao.select();
		for (Object object : teacherList){
			TeacherView bean = (TeacherView)object;
			teacherBox.addItem(bean);
		}
	}
	/*
	 * 表格
	 */
	public JTable setTable(){
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
				cidtextField.setText(dtm.getValueAt(row, 0).toString());
				coursenameText.setText((String)dtm.getValueAt(row, 1));
				creditText.setText(dtm.getValueAt(row, 2).toString());
				ctimeText.setText((String)dtm.getValueAt(row, 3));
				caddressText.setText((String)dtm.getValueAt(row, 4));
				
				String teacher =  ((String)dtm.getValueAt(row, 5));
				for(int i=0;i<teacherBox.getModel().getSize();i++){
					TeacherView dep = (TeacherView)teacherBox.getItemAt(i);
					if(teacher.equals(dep.getTname())){
						teacherBox.setSelectedIndex(i);
						break;
					}
				}
				LimitnumberText.setText(dtm.getValueAt(row, 6).toString());
				truenumberText.setText(dtm.getValueAt(row, 7).toString());
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
	(JSplitPane.VERTICAL_SPLIT,jsp,setInfo());
		sp.addComponentListener(new ComponentAdapter() {  
            public void componentResized(ComponentEvent e) {  
            	sp.setDividerLocation(0.6);  
    }  
		}); 
		add(sp);
	}
	/*
	 * main函数
	 */
    public static void main(String[] args) {
    	//SysCourseFrame course = new SysCourseFrame();
		new SysCourseFrame().setVisible(true);//窗口可见

	}
//    public JPanel setInfo(){
//    	JPanel jp = new JPanel();
//    	jp.setLayout(null);
//    	JLabel label1 = new JLabel("编号 ");
//    	label1.setBounds(50, 100, 40, 30);
//    	jp.add(label1);
//    	idText.setBounds(100, 50, 80, 30);
//    	jp.add(idText);
//    	
//    	JButton addBut = new JButton("新增");
//    	addBut.setBounds(150, 100, 40, 30);
//    	jp.add(addBut);
//		return jp;
//    	
//    }
}

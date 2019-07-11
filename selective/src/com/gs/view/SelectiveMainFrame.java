package com.gs.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.gs.bean.Manager;
import com.gs.bean.Student;
import com.gs.bean.Teacher;
/**
 * 
 * @author 
 * 主窗体
 */
public class SelectiveMainFrame extends JFrame {
	
	public static Student student; //学生类
	public static Teacher teacher; //教师类
	public static Manager manager; //管理员

	private JMenu managerMenu; //管理员菜单 
	private JMenu teacherMenu; //教师菜单
	private JMenu studentMenu; //学生菜单 
	
	private JMenuItem managerMenuItem ; //管理员管理菜单项
	private JMenuItem departmentMenuItem; //系部管理菜单项
	private JMenuItem classMenuItem; //班级管理菜单项
	private JMenuItem teacherMenuItem; //教师管理菜单项
	private JMenuItem courseMenuItem; //课程管理菜单项
	private JMenuItem studentMenuItem; //学生管理
	private JMenuItem logMenuItem; //日志管理
	private JMenuItem updateTpwdMenuItem; //修改密码
	private JMenuItem queryTeachMenuItem; //查看任课信息
	private JMenuItem querySelectMenuItem; //查看选课信息
	private JMenuItem ScoreMenuItem; //成绩管理
	private JMenuItem updateSpwdMenuItem; //密码修改菜单项 
	private JMenuItem selectCourseMenuItem; //选课菜单项
	private JMenuItem PersonalSelectMenuItem; //个人选课信息菜单项
	private JMenuItem queryScoreMenuItem; //成绩查询
	
	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public SelectiveMainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		//菜单条
		JMenuBar jmenuBar = getBar();
		setJMenuBar(jmenuBar);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setResizable(false);
		setVisible(true);
	}
	public JMenuBar getBar(){
		JMenuBar menuBar = new JMenuBar();
		managerMenu = new JMenu("管理员");
		menuBar.add(managerMenu);
		
		managerMenuItem = new JMenuItem("管理员管理");
		managerMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new SysManagerFrame();
			}
		});
		managerMenu.add(managerMenuItem);
		
		departmentMenuItem = new JMenuItem("系部管理");
		departmentMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new SysDepartmentFrame();
			}
		});
		managerMenu.add(departmentMenuItem);
		
		classMenuItem = new JMenuItem("班级管理");
		classMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new SysClassFrame();
			}
		});
		managerMenu.add(classMenuItem);
		
		teacherMenuItem = new JMenuItem("教师管理");
		teacherMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new SysTeacherFrame();
			}
		});
		managerMenu.add(teacherMenuItem);
		
		courseMenuItem = new JMenuItem("课程管理");
		courseMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new SysCourseFrame();
			}
		});
		managerMenu.add(courseMenuItem);
		
		studentMenuItem = new JMenuItem("学生管理");
		studentMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new SysStudentFrame();
			}
		});
		managerMenu.add(studentMenuItem);
		
		logMenuItem = new JMenuItem("日志管理");
		logMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new SysLogFrame();
			}
		});
		managerMenu.add(logMenuItem);
		
		teacherMenu = new JMenu("教师");
		menuBar.add(teacherMenu);
		
		updateTpwdMenuItem = new JMenuItem("修改密码");
		updateTpwdMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new TeaUpdatePwdFrame();
			}
		});
		teacherMenu.add(updateTpwdMenuItem);
		
		queryTeachMenuItem = new JMenuItem("查看任课信息");
		queryTeachMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new TeaSearchTeachFrame();
			}
		});
		teacherMenu.add(queryTeachMenuItem);
		
		querySelectMenuItem = new JMenuItem("查看选课信息");
		querySelectMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new TeaSearchSelectFrame();
			}
		});
		teacherMenu.add(querySelectMenuItem);
		
		ScoreMenuItem = new JMenuItem("成绩管理");
		ScoreMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new TeaScoreFrame();
			}
		});
		teacherMenu.add(ScoreMenuItem);
		
		studentMenu = new JMenu("学生");
		menuBar.add(studentMenu);
		
		updateSpwdMenuItem = new JMenuItem("修改密码");
		updateSpwdMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new StuUpdatePwdFrame();
			}
		});
		studentMenu.add(updateSpwdMenuItem);
		
		selectCourseMenuItem = new JMenuItem("选课");
		selectCourseMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new StuSelectCourseFrame();
			}
		});
		studentMenu.add(selectCourseMenuItem);
		
		PersonalSelectMenuItem = new JMenuItem("个人选课信息");
		PersonalSelectMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new StuSearchSelfSelectFrame();
			}
		});
		studentMenu.add(PersonalSelectMenuItem);
		
		queryScoreMenuItem = new JMenuItem("成绩查询");
		queryScoreMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new StuSearchScoreFrame();
			}
		});
		studentMenu.add(queryScoreMenuItem);
		
		managerMenu.setEnabled(false);
		teacherMenu.setEnabled(false);
		studentMenu.setEnabled(false);
		
		return menuBar;
	}
	/*
	 * 设置登录管理员信息
	 */
	public void adminSet(Manager admin){
		manager = admin;
		JOptionPane.showMessageDialog(this, "欢迎管理员,"+admin.getSysaccount());
		managerMenu.setEnabled(true);
	}
	/*
	 * 设置登录教师信息
	 */
	public void teaSet(Teacher tea){
		teacher = tea;
		JOptionPane.showMessageDialog(this, "欢迎教师,"+teacher.getTname());
		teacherMenu.setEnabled(true);
	}
	/*
	 * 设置登录学生信息
	 */
	public void stuSet(Student stu){
		student = stu;
		JOptionPane.showMessageDialog(this, "欢迎学生,"+stu.getSname());
		studentMenu.setEnabled(true);
	}
}

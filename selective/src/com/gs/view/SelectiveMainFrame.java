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
 * ������
 */
public class SelectiveMainFrame extends JFrame {
	
	public static Student student; //ѧ����
	public static Teacher teacher; //��ʦ��
	public static Manager manager; //����Ա

	private JMenu managerMenu; //����Ա�˵� 
	private JMenu teacherMenu; //��ʦ�˵�
	private JMenu studentMenu; //ѧ���˵� 
	
	private JMenuItem managerMenuItem ; //����Ա����˵���
	private JMenuItem departmentMenuItem; //ϵ������˵���
	private JMenuItem classMenuItem; //�༶����˵���
	private JMenuItem teacherMenuItem; //��ʦ����˵���
	private JMenuItem courseMenuItem; //�γ̹���˵���
	private JMenuItem studentMenuItem; //ѧ������
	private JMenuItem logMenuItem; //��־����
	private JMenuItem updateTpwdMenuItem; //�޸�����
	private JMenuItem queryTeachMenuItem; //�鿴�ο���Ϣ
	private JMenuItem querySelectMenuItem; //�鿴ѡ����Ϣ
	private JMenuItem ScoreMenuItem; //�ɼ�����
	private JMenuItem updateSpwdMenuItem; //�����޸Ĳ˵��� 
	private JMenuItem selectCourseMenuItem; //ѡ�β˵���
	private JMenuItem PersonalSelectMenuItem; //����ѡ����Ϣ�˵���
	private JMenuItem queryScoreMenuItem; //�ɼ���ѯ
	
	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public SelectiveMainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		//�˵���
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
		managerMenu = new JMenu("����Ա");
		menuBar.add(managerMenu);
		
		managerMenuItem = new JMenuItem("����Ա����");
		managerMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new SysManagerFrame();
			}
		});
		managerMenu.add(managerMenuItem);
		
		departmentMenuItem = new JMenuItem("ϵ������");
		departmentMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new SysDepartmentFrame();
			}
		});
		managerMenu.add(departmentMenuItem);
		
		classMenuItem = new JMenuItem("�༶����");
		classMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new SysClassFrame();
			}
		});
		managerMenu.add(classMenuItem);
		
		teacherMenuItem = new JMenuItem("��ʦ����");
		teacherMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new SysTeacherFrame();
			}
		});
		managerMenu.add(teacherMenuItem);
		
		courseMenuItem = new JMenuItem("�γ̹���");
		courseMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new SysCourseFrame();
			}
		});
		managerMenu.add(courseMenuItem);
		
		studentMenuItem = new JMenuItem("ѧ������");
		studentMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new SysStudentFrame();
			}
		});
		managerMenu.add(studentMenuItem);
		
		logMenuItem = new JMenuItem("��־����");
		logMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new SysLogFrame();
			}
		});
		managerMenu.add(logMenuItem);
		
		teacherMenu = new JMenu("��ʦ");
		menuBar.add(teacherMenu);
		
		updateTpwdMenuItem = new JMenuItem("�޸�����");
		updateTpwdMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new TeaUpdatePwdFrame();
			}
		});
		teacherMenu.add(updateTpwdMenuItem);
		
		queryTeachMenuItem = new JMenuItem("�鿴�ο���Ϣ");
		queryTeachMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new TeaSearchTeachFrame();
			}
		});
		teacherMenu.add(queryTeachMenuItem);
		
		querySelectMenuItem = new JMenuItem("�鿴ѡ����Ϣ");
		querySelectMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new TeaSearchSelectFrame();
			}
		});
		teacherMenu.add(querySelectMenuItem);
		
		ScoreMenuItem = new JMenuItem("�ɼ�����");
		ScoreMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new TeaScoreFrame();
			}
		});
		teacherMenu.add(ScoreMenuItem);
		
		studentMenu = new JMenu("ѧ��");
		menuBar.add(studentMenu);
		
		updateSpwdMenuItem = new JMenuItem("�޸�����");
		updateSpwdMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new StuUpdatePwdFrame();
			}
		});
		studentMenu.add(updateSpwdMenuItem);
		
		selectCourseMenuItem = new JMenuItem("ѡ��");
		selectCourseMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new StuSelectCourseFrame();
			}
		});
		studentMenu.add(selectCourseMenuItem);
		
		PersonalSelectMenuItem = new JMenuItem("����ѡ����Ϣ");
		PersonalSelectMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new StuSearchSelfSelectFrame();
			}
		});
		studentMenu.add(PersonalSelectMenuItem);
		
		queryScoreMenuItem = new JMenuItem("�ɼ���ѯ");
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
	 * ���õ�¼����Ա��Ϣ
	 */
	public void adminSet(Manager admin){
		manager = admin;
		JOptionPane.showMessageDialog(this, "��ӭ����Ա,"+admin.getSysaccount());
		managerMenu.setEnabled(true);
	}
	/*
	 * ���õ�¼��ʦ��Ϣ
	 */
	public void teaSet(Teacher tea){
		teacher = tea;
		JOptionPane.showMessageDialog(this, "��ӭ��ʦ,"+teacher.getTname());
		teacherMenu.setEnabled(true);
	}
	/*
	 * ���õ�¼ѧ����Ϣ
	 */
	public void stuSet(Student stu){
		student = stu;
		JOptionPane.showMessageDialog(this, "��ӭѧ��,"+stu.getSname());
		studentMenu.setEnabled(true);
	}
}

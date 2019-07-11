package com.gs.view;

import java.awt.event.MouseAdapter;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.gs.bean.Manager;
import com.gs.bean.Student;
import com.gs.bean.Teacher;
import com.gs.dao.StudentDao;
import com.gs.dao.SysLogDao;
import com.gs.dao.SysManagerDao;
import com.gs.dao.TeacherDao;
/**
 * 
 * @author 
 * 登录窗体
 */
public class LoginFrame extends JFrame{
	SysManagerDao adminDao = new SysManagerDao();
	TeacherDao teacherDao = new TeacherDao(); //声明事务
	StudentDao stuDao = new StudentDao(); //声明事务
	
	private JButton btnLogin; //登录按钮
    private JButton btnReset; //重置按钮
    private ButtonGroup buttonGroup; //单选按钮组
    private JLabel jLabel1; //标签
    private JLabel jLabel2; //标签
    private JRadioButton rdoManager; //管理员单选按钮
    private JRadioButton rdoStudent; //学生单选按钮
    private JRadioButton rdoTeacher; //教师单按钮
    private JPasswordField txtPassword; //密码框
    private JTextField txtUser; //用户名框
    public LoginFrame(){
    	this.initComponents();
    	this.setBounds(300, 200, 500, 300);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void initComponents() {

	        buttonGroup = new ButtonGroup();
	        jLabel1 = new JLabel();
	        txtUser = new JTextField();
	        jLabel2 = new JLabel();
	        txtPassword = new JPasswordField();
	        btnLogin = new JButton();
	        rdoManager = new JRadioButton();
	        rdoTeacher = new JRadioButton();
	        rdoStudent = new JRadioButton();
	        btnReset = new JButton();
	        setTitle("选课系统登录");
	        setResizable(false);
	        this.setLayout(null);
	        jLabel1.setIcon(new ImageIcon(getClass().getResource("/com/gs/source/user.JPG"))); // NOI18N
	        jLabel1.setText("用户名：");
	        jLabel1.setBounds(100, 50, 100, 30);
	        this.add(jLabel1);
	        txtUser.setBounds(200, 50, 150, 30);
	        this.add(txtUser);
	        jLabel2.setIcon(new ImageIcon(getClass().getResource("/com/gs/source/pwd.JPG"))); // NOI18N
	        jLabel2.setText("密  码：");
	        jLabel2.setBounds(100, 100, 100, 30);
	        this.add(jLabel2);
	        txtPassword.setBounds(200, 100, 150, 30);
	        this.add(txtPassword);

	        buttonGroup.add(rdoManager);
	        rdoManager.setSelected(true);
	        rdoManager.setText("管理员");
	        buttonGroup.add(rdoTeacher);
	        rdoTeacher.setText("教师");
	        buttonGroup.add(rdoStudent);
	        rdoStudent.setText("学生");
	        rdoManager.setBounds(100, 150, 100, 20);
	        this.add(rdoManager);
	        rdoTeacher.setBounds(200, 150, 100, 20);
	        this.add(rdoTeacher);
	        rdoStudent.setBounds(300, 150, 100, 20);
	        this.add(rdoStudent);
	        
	        btnLogin.setText("登录");
	        btnLogin.addMouseListener(new MouseAdapter() {
	        	public void mouseClicked(java.awt.event.MouseEvent arg0){
	        		if(rdoManager.isSelected()){
	        			Manager admin = adminDao.loginAdmin(txtUser.getText(), txtPassword.getText());
	        			if(admin.getSysaccount()==null){
	        				JOptionPane.showMessageDialog(null, "登录失败！！！");
	        				clearText();
	        				return;
	        			}
	        			new SelectiveMainFrame().adminSet(admin);
	        			new SysLogDao().addLog(admin.getSysaccount());
	        			dispose();
	        		}else if(rdoTeacher.isSelected()){
	        			Teacher tea = teacherDao.loginTea(txtUser.getText(), txtPassword.getText());
	        			if(tea.getTname()==null){
	        				JOptionPane.showMessageDialog(null, "登录失败！！！");
	        				clearText();
	        				return;
	        			}
	        			new SelectiveMainFrame().teaSet(tea);
	        			dispose();
	        		}else{
	        			Student stu = stuDao.loginStu(Integer.parseInt(txtUser.getText()), txtPassword.getText());
	        			if(stu.getSname()==null){
	        				JOptionPane.showMessageDialog(null, "登录失败！！！");
	        				clearText();
	        				return;
	        			}
	        			new SelectiveMainFrame().stuSet(stu);
	        			dispose();
	        		}
	        	}
			});
	        btnLogin.setIcon(new ImageIcon(getClass().getResource("/com/gs/source/dlbtn.JPG")));
	        btnLogin.setBounds(200, 200, 80, 30);
	        this.add(btnLogin);
	        setVisible(true);
	 }
	 /*
	  * 清空文本框
	  */
    public void clearText(){
    	txtPassword.setText("");
    	txtUser.setText("");
    }
	 public static void main(String[] args) {
		new LoginFrame();
	}
}

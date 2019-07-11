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
 * ��¼����
 */
public class LoginFrame extends JFrame{
	SysManagerDao adminDao = new SysManagerDao();
	TeacherDao teacherDao = new TeacherDao(); //��������
	StudentDao stuDao = new StudentDao(); //��������
	
	private JButton btnLogin; //��¼��ť
    private JButton btnReset; //���ð�ť
    private ButtonGroup buttonGroup; //��ѡ��ť��
    private JLabel jLabel1; //��ǩ
    private JLabel jLabel2; //��ǩ
    private JRadioButton rdoManager; //����Ա��ѡ��ť
    private JRadioButton rdoStudent; //ѧ����ѡ��ť
    private JRadioButton rdoTeacher; //��ʦ����ť
    private JPasswordField txtPassword; //�����
    private JTextField txtUser; //�û�����
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
	        setTitle("ѡ��ϵͳ��¼");
	        setResizable(false);
	        this.setLayout(null);
	        jLabel1.setIcon(new ImageIcon(getClass().getResource("/com/gs/source/user.JPG"))); // NOI18N
	        jLabel1.setText("�û�����");
	        jLabel1.setBounds(100, 50, 100, 30);
	        this.add(jLabel1);
	        txtUser.setBounds(200, 50, 150, 30);
	        this.add(txtUser);
	        jLabel2.setIcon(new ImageIcon(getClass().getResource("/com/gs/source/pwd.JPG"))); // NOI18N
	        jLabel2.setText("��  �룺");
	        jLabel2.setBounds(100, 100, 100, 30);
	        this.add(jLabel2);
	        txtPassword.setBounds(200, 100, 150, 30);
	        this.add(txtPassword);

	        buttonGroup.add(rdoManager);
	        rdoManager.setSelected(true);
	        rdoManager.setText("����Ա");
	        buttonGroup.add(rdoTeacher);
	        rdoTeacher.setText("��ʦ");
	        buttonGroup.add(rdoStudent);
	        rdoStudent.setText("ѧ��");
	        rdoManager.setBounds(100, 150, 100, 20);
	        this.add(rdoManager);
	        rdoTeacher.setBounds(200, 150, 100, 20);
	        this.add(rdoTeacher);
	        rdoStudent.setBounds(300, 150, 100, 20);
	        this.add(rdoStudent);
	        
	        btnLogin.setText("��¼");
	        btnLogin.addMouseListener(new MouseAdapter() {
	        	public void mouseClicked(java.awt.event.MouseEvent arg0){
	        		if(rdoManager.isSelected()){
	        			Manager admin = adminDao.loginAdmin(txtUser.getText(), txtPassword.getText());
	        			if(admin.getSysaccount()==null){
	        				JOptionPane.showMessageDialog(null, "��¼ʧ�ܣ�����");
	        				clearText();
	        				return;
	        			}
	        			new SelectiveMainFrame().adminSet(admin);
	        			new SysLogDao().addLog(admin.getSysaccount());
	        			dispose();
	        		}else if(rdoTeacher.isSelected()){
	        			Teacher tea = teacherDao.loginTea(txtUser.getText(), txtPassword.getText());
	        			if(tea.getTname()==null){
	        				JOptionPane.showMessageDialog(null, "��¼ʧ�ܣ�����");
	        				clearText();
	        				return;
	        			}
	        			new SelectiveMainFrame().teaSet(tea);
	        			dispose();
	        		}else{
	        			Student stu = stuDao.loginStu(Integer.parseInt(txtUser.getText()), txtPassword.getText());
	        			if(stu.getSname()==null){
	        				JOptionPane.showMessageDialog(null, "��¼ʧ�ܣ�����");
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
	  * ����ı���
	  */
    public void clearText(){
    	txtPassword.setText("");
    	txtUser.setText("");
    }
	 public static void main(String[] args) {
		new LoginFrame();
	}
}

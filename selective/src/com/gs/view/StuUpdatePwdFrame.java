package com.gs.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.gs.dao.StudentDao;
/**
 * 
 * @author 
 * 学生修改密码
 */
public class StuUpdatePwdFrame extends JFrame {

	private JPanel contentPane;
	private JPasswordField pwdTextField; //密码框
	private JPasswordField repeatPwdTextField; //确认密码输入框
	private JButton alterButton; //修改按钮
	/**
	 * Create the frame.
	 */
	public StuUpdatePwdFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 350, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel newPwdLabel = new JLabel("新密码");
		newPwdLabel.setBounds(34, 48, 54, 15);
		contentPane.add(newPwdLabel);
		
		JLabel repeatPwdLabel = new JLabel("确认密码");
		repeatPwdLabel.setBounds(34, 123, 54, 15);
		contentPane.add(repeatPwdLabel);
		
		pwdTextField = new JPasswordField();
		pwdTextField.setBounds(116, 45, 156, 21);
		contentPane.add(pwdTextField);
		pwdTextField.setColumns(10);
		
		repeatPwdTextField = new JPasswordField();
		repeatPwdTextField.setColumns(10);
		repeatPwdTextField.setBounds(116, 120, 156, 21);
		contentPane.add(repeatPwdTextField);
		
		alterButton = new JButton("修改");
		alterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(pwdTextField.getText().equals(repeatPwdTextField.getText())){
					int ifTrue = new StudentDao().updatePwd(
										SelectiveMainFrame.student.getSid(),
										repeatPwdTextField.getText()
									);
					if(ifTrue>0){
						JOptionPane.showMessageDialog(null, "修改成功!!!");
						dispose();
					}else{
						JOptionPane.showMessageDialog(null, "修改失败!!!");
						clearText();
					}
				}else{
					JOptionPane.showMessageDialog(null, "输入密码不一致!!!");
					clearText();
				}
					
			}
		});
		alterButton.setBounds(231, 179, 93, 23);
		contentPane.add(alterButton);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	/*
	 * 清空文本域
	 */
	public void clearText(){
		pwdTextField.setText("");
		repeatPwdTextField.setText("");
	}
	public static void main(String[] args) {
		new StuUpdatePwdFrame();
	}
}

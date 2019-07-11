package com.gs.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.gs.bean.Department;
import com.gs.bean.Manager;
import com.gs.bean.Teacher;
import com.gs.bean.TeacherView;
import com.gs.dao.SysManagerDao;
import com.gs.dao.SysTeacherDao;

/**
 * 
 * @author 
 * ����Ա�����ڲ�����
 */
public class SysManagerFrame extends JFrame {
	
	private JTextField sysidtextField;//����ı���ǩ
	private JTextField sysaccounttextField;//�˺��ı���ǩ
	private JTextField syspasswordtextField;//���������ǩ
	private JPanel contentPane;
	JTable table = new JTable();//����
	Vector<String> colName = new Vector<String>();//ͷ������
	DefaultTableModel dtm = new DefaultTableModel();
	/**
	 * ���к���
	 */
	public SysManagerFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setResizable(false);
		setVisible(true);
		
		init();
	}
	public static void main(String[] args) {
		new SysManagerFrame().setVisible(true);
	}

	/**
	 * ����ֲ�
	 */
	public void init(){
		JScrollPane jsp = new JScrollPane(setTable());
		final JSplitPane sp = new JSplitPane
	(JSplitPane.VERTICAL_SPLIT,jsp,setInfo());
		sp.addComponentListener(new ComponentAdapter() {  
            public void componentResized(ComponentEvent e) {  
            	sp.setDividerLocation(0.4);  
    }  
		}); 
		add(sp);
	}
	/**
	 * ��������
	 * @return
	 */
	public JPanel setInfo(){
		JPanel jp = new JPanel();
		jp.setLayout(null);
		JLabel sysidLabel = new JLabel("���");//��ű�ǩ
		sysidLabel.setBounds(70, 58, 30, 15);
		jp.add(sysidLabel);
		
		sysidtextField = new JTextField();//����ı���ǩ
		sysidtextField.setBounds(100, 55, 66, 21);
		jp.add(sysidtextField);
		sysidtextField.setColumns(10);
		sysidtextField.setEditable(false);
		/**
		 * �˺ű�ǩ���˺��ı�
		 */
		JLabel tpasswordLabel = new JLabel("�˺�");
		tpasswordLabel.setBounds(220, 58, 30, 15);
		jp.add(tpasswordLabel);
		
		sysaccounttextField = new JTextField();
		sysaccounttextField.setBounds(250, 55, 66, 21);
		jp.add(sysaccounttextField);
		sysaccounttextField.setColumns(10);
		/**
		 * ����
		 */
		JLabel syspasswordlabel = new JLabel("����");
		syspasswordlabel.setBounds(370, 58, 30, 15);
		jp.add(syspasswordlabel);
		
		syspasswordtextField = new JTextField();
		syspasswordtextField.setBounds(400, 55, 66, 21);
		jp.add(syspasswordtextField);
		syspasswordtextField.setColumns(10);
		
		/**
		 * ��ť
		 */
		JButton updateButton = new JButton("�޸�");//�޸İ�ť
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//�޸İ�ť�����¼�
				int sysid = Integer.parseInt(sysidtextField.getText());
				String sysaccount = sysaccounttextField.getText();
				String syspassword = syspasswordtextField.getText();
				Manager bean = new Manager(sysid,sysaccount,syspassword);
				SysManagerDao dao = new SysManagerDao();
				dao.update(bean);
				Refresh();
				clearText();
			}
		});
		updateButton.setBounds(70, 154, 96, 23);
		jp.add(updateButton);
		
		JButton deletebutton = new JButton("ɾ��");//ɾ����ť
		deletebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//ɾ�������¼�
				int sysid = Integer.parseInt(sysidtextField.getText());
				String sysaccount = sysaccounttextField.getText();
				String syspassword = syspasswordtextField.getText();
				Manager bean = new Manager(sysid,sysaccount,syspassword);
				SysManagerDao dao = new SysManagerDao();
				dao.delete(bean);
				Refresh();
				clearText();
			}
		});
		deletebutton.setBounds(170, 154, 96, 23);
		jp.add(deletebutton);
		
		JButton addbutton = new JButton("����");//������ť
		addbutton.addActionListener(new ActionListener() {//���������¼�
			public void actionPerformed(ActionEvent arg0) {
				//int sysid = Integer.parseInt(sysidtextField.getText());
				String sysaccount = sysaccounttextField.getText();
				String syspassword = syspasswordtextField.getText();
				Manager bean = new Manager();
				SysManagerDao dao = new SysManagerDao();
				bean.setSysaccount(sysaccount);
				bean.setSyspassword(syspassword);
				dao.add(bean);
				Refresh();
				clearText();
			}
		});
		addbutton.setBounds(270, 154, 96, 23);
		jp.add(addbutton);
		return jp;
	}
	/**
	 * ���
	 * @return
	 */
	public JTable setTable(){//���ͷ������
		colName.add("���");
		colName.add("�˺�");
		colName.add("����");
	
		Refresh();
		table.addMouseListener(new MouseAdapter() {//����¼�ѡ���Լ�����ֵ
			public void mouseClicked(java.awt.event.MouseEvent arg0){
				int row = table.getSelectedRow();//ѡ����һ��
				sysidtextField.setText(dtm.getValueAt(row, 0).toString());
				sysaccounttextField.setText((String)dtm.getValueAt(row, 1));
				syspasswordtextField.setText((String)dtm.getValueAt(row, 2));
				
			}
		});
		return table;
	}
	/**
	 * ˢ�±��
	 */
	public void Refresh(){
		SysManagerDao dao = new SysManagerDao();
		List list = dao.select();
		Vector data = showTable(list);
		dtm.setDataVector(data, colName);
		table.setModel(dtm);
	}
	/**
	 * 
	 * ��ʾ���
	 * ����װ��
	 */
	public Vector showTable(List list){
		Vector data = new Vector();
		for(int i=0;i<list.size();i++){
			Manager bean = (Manager)list.get(i);
			Vector vec= new Vector();
			vec.add(bean.getId());
			vec.add(bean.getSysaccount());
			vec.add(bean.getSyspassword());
			
			data.add(vec);
		}
		return data;
	}
	/*
	 * ����ı�
	 */
	public void clearText(){
		sysidtextField.setText("");
		sysaccounttextField.setText("");
		syspasswordtextField.setText("");
	}
}

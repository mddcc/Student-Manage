package com.gs.view;

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
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

import com.gs.bean.Department;
import com.gs.dao.SysDepartmentDao;

/**
 * 
 * @author 
 * ϵ���������
 */
public class SysDepartmentFrame extends JFrame {
	
	/*
	 * ȫ��
	 */
	JTextField idTxt = new JTextField();//���
	JTextField depTxt = new JTextField();//ϵ��
	private JTextComponent nameTxt;//���� �����¼� ȫ��
	JTable table = new JTable();//���
	Vector colName = new Vector();//����������� 
	DefaultTableModel dtm  = new DefaultTableModel();//�����ģ��
	/*
	 * ����
	 */
	public SysDepartmentFrame(){
		setResizable(false);
		setBounds(100, 100, 800, 500);
		init();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
	/*
	 * ��ť�����¼�
	 */
//	public void Mclick(){
//		String depname = depTxt.getText();
//		SysDepartmentDao dao = new SysDepartmentDao();
//		Department bean = new Department();
//		bean.setDepname(depname);
//		dao.add(bean);
//		refresh();
//	}
	
	/*
	 * �Ϸ����
	 */
	public JTable setTable(){
		colName.add("���");
		colName.add("ϵ��");
		refresh();
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent arg0){
				int row = table.getSelectedRow();//ѡ����һ��
				idTxt.setText(dtm.getValueAt(row, 0).toString());//ǿ��ת��ΪString���ӵ���0��ʼ 
				depTxt.setText((String)dtm.getValueAt(row, 1));
			}
		});
		return table;
	}
	
	/*
	 * ���·ֲ�
	 */
	public void init(){
		JScrollPane jsp = new JScrollPane(setTable());
		final JSplitPane sp = new JSplitPane
	(JSplitPane.VERTICAL_SPLIT,jsp,setInfo());
//		sp.setBounds(0, 0, 784, 462);
		sp.addComponentListener(new ComponentAdapter() {  
            public void componentResized(ComponentEvent e) {  
            	sp.setDividerLocation(0.4);  
    }  
		}); 
		getContentPane().add(sp);
	}
	
	/*
	 * չʾ�Ϸ����
	 */
	public Vector showTable(List list){
		Vector data = new Vector();//�������
		for(int i=0;i<list.size();i++){
			Department bean = (Department)list.get(i);
			Vector vec = new Vector();
			vec.add(bean.getId());
			vec.add(bean.getDepname());
			data.add(vec);
		}
		return data;
	}
	
	/*
	 * ������²�ѯ��ˢ������
	 */
	public void refresh(){
		SysDepartmentDao dao = new SysDepartmentDao();
		List list = dao.query();
		Vector data = showTable(list);
		dtm.setDataVector(data, colName);
		table.setModel(dtm);
	}
	
	public JPanel setInfo(){
		JPanel jp = new JPanel();
		jp.setBounds(0, 0, 782, 220);
		TitledBorder depnameTitle = new TitledBorder("�༭����");
		jp.setBorder(depnameTitle);
		jp.setLayout(null);
		
		/*
		 * ��ű�ǩ���ı���
		 */
		JLabel idlabel = new JLabel("���:");
		idlabel.setBounds(50, 70, 40, 30);
		jp.add(idlabel);
		idTxt.setEditable(false);
		idTxt.setBounds(100, 75, 216, 21);
		jp.add(idTxt);
		
		/*
		 * ϵ����ǩ���ı���
		 */
		JLabel deplabel = new JLabel("ϵ��:");
		deplabel.setBounds(430, 76, 150, 18);
		jp.add(deplabel);
		depTxt.setBounds(485, 76, 250, 21);
		jp.add(depTxt);
		
		
		
		/*
		 * ������ť
		 */
		JButton addBt = new JButton("����");
		addBt.addMouseListener(new MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent arg0){
//				Mclick();
				String depname = depTxt.getText();
				SysDepartmentDao dao = new SysDepartmentDao();
				Department bean = new Department();
				bean.setDepname(depname);
				dao.add(bean);
				refresh();
			}
		});
		addBt.setBounds(145, 170, 70, 30);
		jp.add(addBt);
		
		/*
		 * �޸İ�ť
		 */
		JButton updateBt = new JButton("�޸�");
		updateBt.addMouseListener(new MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent arg0){
//				Mclick();
				String depname = depTxt.getText();
				int id = Integer.parseInt(idTxt.getText());
				Department bean = new Department(id,depname);
				SysDepartmentDao dao = new SysDepartmentDao();
				dao.update(bean);
				refresh();
			}
		});
		updateBt.setBounds(355, 170, 70, 30);
		jp.add(updateBt);
		
		/*
		 * ɾ����ť
		 */
		JButton delBt = new JButton("ɾ��");
		delBt.addMouseListener(new MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent arg0){
//				Mclick();
				String depname = depTxt.getText();
				int id = Integer.parseInt(idTxt.getText());
				Department bean = new Department(id,depname);
				SysDepartmentDao dao = new SysDepartmentDao();
				dao.delete(bean);
				refresh();
			}
		});
		delBt.setBounds(560, 170, 70, 30);
		jp.add(delBt);
		
		return jp;
	}
	
}





























//
//import java.awt.*;
//
//import javax.swing.*;
//import javax.swing.border.TitledBorder;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.text.JTextComponent;
//
//import com.gs.bean.Department;
//import com.gs.dao.SysDepartmentDao;
//
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//import java.util.Vector;
//
//
///**
// * @
// * ϵ������
// */
//
//public class SysDepartmentFrame extends JFrame {
//	public SysDepartmentFrame() {
//	}
//	
//	/*
//	 * main����
//	 */
//	
//	public static void main(String[] args) {
//		
//		
//		new SysDepartmentFrame().setVisible(true); //�ɼ�����
//	}
//	
//	
////	
////	/**
////	 * Create the frame.
////	 */
////	public SysDepartmentFrame() {
////		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////		setBounds(100, 100, 800, 500);
////		contentPane = new JPanel();
////		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
////		contentPane.setLayout(new BorderLayout(0, 0));
////		setContentPane(contentPane);
////		
////		JLabel label = new JLabel("\u7F16\u53F7");
////		contentPane.add(label, BorderLayout.NORTH);
////		setVisible(true);
////	}
//	
//	/*
//	 * ȫ�ֱ���
//	 */
//	private JPanel contentPane;
//	JTextField idTxt = new JTextField();
//	private JTextField idtextField;  // ���
//	private JTextField depnametextField;//ϵ��
//	private JTextComponent nameTxt;//���� �����¼� ȫ��
//	JTable table = new JTable();
//	Vector colName = new Vector();
//	DefaultTableModel dtm  = new DefaultTableModel();
//	
//	/*
//	 * �����Ϸ����
//	 */
//	public JTable setTable(){ 
//		colName.add("���");
//		colName.add("ϵ��");
//		refresh();
//		return table;
//	}
//	
//	public void refresh(){
//		SysDepartmentDao dao = new SysDepartmentDao();
//		List list = dao.query();
//        Vector data = showTable(list);
//		dtm.setDataVector(data,colName);
//		table.setModel(dtm);
//	}
//	
//	/*
//	 * չʾ 
//	 */
//	public Vector showTable(List list){
//		Vector data = new Vector(); // ������ݿ�
//		for(int i=0;i<list.size();i++){ // ���ݿ��ڵ�������Ϣ
//			Department bean = (Department)list.get(i);
//			Vector vec = new Vector();
//			vec.add(bean.getId());
//			vec.add(bean.getDepname());
//			data.add(vec);
//		}
//		return data;
//	}
//	
//	public void init(){
//		JScrollPane jsp = new JScrollPane(setTable());
//		final JSplitPane sp = new JSplitPane
//	(JSplitPane.VERTICAL_SPLIT,jsp,setInfo());
//		sp.addComponentListener(new ComponentAdapter() {  
//            public void componentResized(ComponentEvent e) {  
//            	sp.setDividerLocation(0.4);  
//    }  
//		}); 
//		getContentPane().add(sp);
//	}
//	
//	
//	public JPanel setInfo(){
//		/*
//		 * ���ý����С
//		 */
//		this.setBounds(100, 100, 800, 500);
//		getContentPane().setLayout(null);
//		
//		/*
//		 * ��ű�ǩ
//		 */
//		JLabel idLabel = new JLabel("���:");
//		idLabel.setBounds(64, 310, 54, 15);
//		getContentPane().add(idLabel);
//		
//		/*
//		 * ����ı���
//		 */
//		idtextField = new JTextField();
//		idtextField.setBounds(95, 308, 181, 18);
//		getContentPane().add(idtextField);
//		idtextField.setColumns(10);
//		idtextField.setEditable(false);
//		
//		/*
//		 * ϵ����ǩ
//		 */
//		JLabel depnameLabel = new JLabel("ϵ��:");
//		depnameLabel.setBounds(413, 310, 54, 15);
//		getContentPane().add(depnameLabel);
//		
//		/*
//		 * ϵ���ı���
//		 */
//		depnametextField = new JTextField();
//		depnametextField.setBounds(454, 308, 188, 18);
//		getContentPane().add(depnametextField);
//		depnametextField.setColumns(10);
//		
//		/*
//		 * ���ϽǱ༭�����ǩ
//		 */
//		JLabel departmentlabel = new JLabel("�༭����");
//		departmentlabel.setBounds(10, 258, 54, 15);
//		getContentPane().add(departmentlabel);  // ���JFrame������壬�ٶ���������
//		
//		/*
//		 * �޸İ�ť
//		 */
//		JButton updateButton = new JButton("�޸�");
//		updateButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//			}
//		});
//		updateButton.setBounds(64, 376, 93, 23);
//		getContentPane().add(updateButton);
//		
//		/*
//		 * ������ť�������¼�
//		 */
//		JButton addButton = new JButton("����");
//		
////		addButton.addActionListener(new ActionListener() {
////			public void actionPerformed(ActionEvent e) {
////			}
////		});
//		addButton.addMouseListener(new MouseListener() {
//			
//			// ����   ��   �������¼�
//			public void mouseClicked(MouseEvent arg0) {
//				// TODO Auto-generated method stub
//				//String depname = nameTxt.getText();
//				String depname = depnametextField.getText();
//				SysDepartmentDao dao = new SysDepartmentDao();
//				Department bean = new Department();
//				bean.setDepname(depname);
//				dao.add(bean);
//				
//			}
//			
//			@Override
//			public void mouseReleased(MouseEvent arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void mousePressed(MouseEvent arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void mouseExited(MouseEvent arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void mouseEntered(MouseEvent arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			
//		});
//		addButton.setBounds(300, 376, 93, 23);
//		getContentPane().add(addButton);
//		
//		/*
//		 * ɾ����ť
//		 */
//		JButton deleteButton = new JButton("ɾ��");
//		deleteButton.setBounds(549, 376, 93, 23);
//		getContentPane().add(deleteButton);
//		return contentPane;
//		
//		
//	}
//}

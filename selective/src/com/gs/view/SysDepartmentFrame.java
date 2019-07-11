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
 * 系部管理界面
 */
public class SysDepartmentFrame extends JFrame {
	
	/*
	 * 全局
	 */
	JTextField idTxt = new JTextField();//编号
	JTextField depTxt = new JTextField();//系名
	private JTextComponent nameTxt;//新增 监听事件 全局
	JTable table = new JTable();//表格
	Vector colName = new Vector();//表格内容名称 
	DefaultTableModel dtm  = new DefaultTableModel();//表控制模型
	/*
	 * 界面
	 */
	public SysDepartmentFrame(){
		setResizable(false);
		setBounds(100, 100, 800, 500);
		init();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
	/*
	 * 按钮监听事件
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
	 * 上方表格
	 */
	public JTable setTable(){
		colName.add("编号");
		colName.add("系名");
		refresh();
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent arg0){
				int row = table.getSelectedRow();//选中哪一行
				idTxt.setText(dtm.getValueAt(row, 0).toString());//强制转换为String，从底数0开始 
				depTxt.setText((String)dtm.getValueAt(row, 1));
			}
		});
		return table;
	}
	
	/*
	 * 上下分层
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
	 * 展示上方表格
	 */
	public Vector showTable(List list){
		Vector data = new Vector();//大的数据
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
	 * 表格重新查询，刷新作用
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
		TitledBorder depnameTitle = new TitledBorder("编辑界面");
		jp.setBorder(depnameTitle);
		jp.setLayout(null);
		
		/*
		 * 编号标签及文本框
		 */
		JLabel idlabel = new JLabel("编号:");
		idlabel.setBounds(50, 70, 40, 30);
		jp.add(idlabel);
		idTxt.setEditable(false);
		idTxt.setBounds(100, 75, 216, 21);
		jp.add(idTxt);
		
		/*
		 * 系名标签及文本框
		 */
		JLabel deplabel = new JLabel("系名:");
		deplabel.setBounds(430, 76, 150, 18);
		jp.add(deplabel);
		depTxt.setBounds(485, 76, 250, 21);
		jp.add(depTxt);
		
		
		
		/*
		 * 新增按钮
		 */
		JButton addBt = new JButton("新增");
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
		 * 修改按钮
		 */
		JButton updateBt = new JButton("修改");
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
		 * 删除按钮
		 */
		JButton delBt = new JButton("删除");
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
// * 系部窗口
// */
//
//public class SysDepartmentFrame extends JFrame {
//	public SysDepartmentFrame() {
//	}
//	
//	/*
//	 * main函数
//	 */
//	
//	public static void main(String[] args) {
//		
//		
//		new SysDepartmentFrame().setVisible(true); //可见内容
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
//	 * 全局变量
//	 */
//	private JPanel contentPane;
//	JTextField idTxt = new JTextField();
//	private JTextField idtextField;  // 编号
//	private JTextField depnametextField;//系名
//	private JTextComponent nameTxt;//新增 监听事件 全局
//	JTable table = new JTable();
//	Vector colName = new Vector();
//	DefaultTableModel dtm  = new DefaultTableModel();
//	
//	/*
//	 * 设置上方表格
//	 */
//	public JTable setTable(){ 
//		colName.add("编号");
//		colName.add("系名");
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
//	 * 展示 
//	 */
//	public Vector showTable(List list){
//		Vector data = new Vector(); // 大的数据框
//		for(int i=0;i<list.size();i++){ // 数据框内的内容信息
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
//		 * 设置界面大小
//		 */
//		this.setBounds(100, 100, 800, 500);
//		getContentPane().setLayout(null);
//		
//		/*
//		 * 编号标签
//		 */
//		JLabel idLabel = new JLabel("编号:");
//		idLabel.setBounds(64, 310, 54, 15);
//		getContentPane().add(idLabel);
//		
//		/*
//		 * 编号文本框
//		 */
//		idtextField = new JTextField();
//		idtextField.setBounds(95, 308, 181, 18);
//		getContentPane().add(idtextField);
//		idtextField.setColumns(10);
//		idtextField.setEditable(false);
//		
//		/*
//		 * 系名标签
//		 */
//		JLabel depnameLabel = new JLabel("系名:");
//		depnameLabel.setBounds(413, 310, 54, 15);
//		getContentPane().add(depnameLabel);
//		
//		/*
//		 * 系名文本框
//		 */
//		depnametextField = new JTextField();
//		depnametextField.setBounds(454, 308, 188, 18);
//		getContentPane().add(depnametextField);
//		depnametextField.setColumns(10);
//		
//		/*
//		 * 左上角编辑界面标签
//		 */
//		JLabel departmentlabel = new JLabel("编辑界面");
//		departmentlabel.setBounds(10, 258, 54, 15);
//		getContentPane().add(departmentlabel);  // 获得JFrame内容面板，再对其加入组件
//		
//		/*
//		 * 修改按钮
//		 */
//		JButton updateButton = new JButton("修改");
//		updateButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//			}
//		});
//		updateButton.setBounds(64, 376, 93, 23);
//		getContentPane().add(updateButton);
//		
//		/*
//		 * 新增按钮及监听事件
//		 */
//		JButton addButton = new JButton("新增");
//		
////		addButton.addActionListener(new ActionListener() {
////			public void actionPerformed(ActionEvent e) {
////			}
////		});
//		addButton.addMouseListener(new MouseListener() {
//			
//			// 新增   的   鼠标监听事件
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
//		 * 删除按钮
//		 */
//		JButton deleteButton = new JButton("删除");
//		deleteButton.setBounds(549, 376, 93, 23);
//		getContentPane().add(deleteButton);
//		return contentPane;
//		
//		
//	}
//}

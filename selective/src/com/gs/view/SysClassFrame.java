package com.gs.view;
/**
 * @author 
 * 班级管理内部窗体
 */
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Color;

import javax.swing.JButton;

import com.gs.bean.ClassBean;
import com.gs.dao.SysClassDao;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SysClassFrame extends JFrame {

	private JPanel contentPane;     //编辑面板
	private JTextField idTxt;       //编号文本框
	private JTextField classTxt;   //班级文本框
	private JTable idClassTable;   //编号班级表
    private Vector  colName = new Vector(); //表格动态数组
    DefaultTableModel dtm = new DefaultTableModel() ; //表格模型
	
	public SysClassFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 800, 500);
		setVisible(true);
		init();
	}
	public void init(){                     
		
		JScrollPane jsp = new JScrollPane(setTable());
		final JSplitPane sp = new JSplitPane
	(JSplitPane.VERTICAL_SPLIT,jsp,contentPane());
		sp.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {  
            sp.setDividerLocation(0.4);  
    }}); 
	add(sp);
	}
	public JTable setTable()   
	
	{  idClassTable = new JTable();
	   colName.add("编号");
	   colName.add("班级名称");
	  refresh();
	  idClassTable.addMouseListener(new MouseAdapter() {
		  public void mouseClicked(java.awt.event.MouseEvent arg0){
			   int row = idClassTable.getSelectedRow();//选的哪一行
			   idTxt.setText(dtm.getValueAt(row, 0).toString());
			   classTxt.setText((String)dtm.getValueAt(row, 1));
		  }
		  
		  
	});
	   return idClassTable;
	}
	
	/*
	 * 表格重新查询
	 */
	public void refresh()
	{
		   SysClassDao dao =new SysClassDao(); 
		   List list =dao.select();
		   Vector data = showTable(list);
		   dtm.setDataVector(data, colName);
		   idClassTable.setModel(dtm);
		
		
	}
	public Vector showTable(List list)
	{
		//大的动态数组
		Vector data =new Vector(); 
		for(int i = 0 ; i<list.size();i++)
		{
			ClassBean bean = (ClassBean)list.get(i);  //第i个为object 类型需强制转换
			Vector vec =new Vector();  //内部小的动态数组
			vec.add(bean.getId());
			vec.add(bean.getClassname());
			data.add(vec);
		}
		return data ; 
	}
	/*
	 * 下半部分面板
	 */
	public JPanel contentPane()
	{     
		contentPane = new JPanel();
		contentPane.setLayout(null);
	    contentPane.setBounds(5, 271, 702, 189);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	
		
		
		JLabel idLabel = new JLabel("编号");  //编号标签
		idLabel.setBounds(67, 36, 66, 29);
		contentPane.add(idLabel);
		idLabel.setForeground(Color.BLACK);
		
		
		idTxt =new JTextField(); //编号文本框    
		idTxt.setBounds(144, 35, 137, 29);          
		contentPane.add(idTxt);
		idTxt.setColumns(10);
		idTxt.setEditable(false);
		
		
		JLabel classLabel = new JLabel("班级名称"); //班级标签
		classLabel.setBounds(436, 43, 54, 15);
		contentPane.add(classLabel);
		
	    classTxt =new JTextField(); 
		classTxt.setBounds(497, 33, 128, 28);    //班级文本框
		contentPane.add(classTxt);
		classTxt.setColumns(10);
		
		JButton addButton = new JButton("新增");   //新增按钮 
		addButton.setBounds(104, 102, 102, 53);
		contentPane.add(addButton);
		
		                                                      
		addButton.addMouseListener(new MouseListener(){   //新增按钮监听事件
			public void mouseClicked(MouseEvent arg0) {
				String classname = classTxt.getText();
				SysClassDao dao = new SysClassDao();
				ClassBean bean = new ClassBean(); 
				bean.setClassname(classname);
				dao.add(bean);
                refresh();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}});
		JButton updateButton = new JButton("修改");   //修改按钮
		updateButton.setBounds(294, 102, 101, 54);
		contentPane.add(updateButton);

		  updateButton.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
			    String classname = classTxt.getText(); 
			    int id =Integer.parseInt(idTxt.getText());
			    ClassBean bean = new ClassBean(id,classname);
			    SysClassDao dao = new SysClassDao() ; 
			    dao.update(bean);
			    refresh();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}});
		
		
		JButton deleteButton = new JButton("删除"); //删除按钮
		deleteButton.setBounds(494, 105, 102, 49);
		contentPane.add(deleteButton);
		  deleteButton.addMouseListener(new MouseListener(){

				@Override
				public void mouseClicked(MouseEvent arg0) {
				    String classname = classTxt.getText(); 
				    int id =Integer.parseInt(idTxt.getText());//获得的数据为string型需转换为int型
				    ClassBean bean = new ClassBean(id,classname);
				    SysClassDao dao = new SysClassDao() ; 
				    dao.delete(bean);
				    refresh();
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}});
		setVisible(true);
		return contentPane ; 
	}
}

package com.gs.view;
/**
 * @author 
 * �༶�����ڲ�����
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

	private JPanel contentPane;     //�༭���
	private JTextField idTxt;       //����ı���
	private JTextField classTxt;   //�༶�ı���
	private JTable idClassTable;   //��Ű༶��
    private Vector  colName = new Vector(); //���̬����
    DefaultTableModel dtm = new DefaultTableModel() ; //���ģ��
	
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
	   colName.add("���");
	   colName.add("�༶����");
	  refresh();
	  idClassTable.addMouseListener(new MouseAdapter() {
		  public void mouseClicked(java.awt.event.MouseEvent arg0){
			   int row = idClassTable.getSelectedRow();//ѡ����һ��
			   idTxt.setText(dtm.getValueAt(row, 0).toString());
			   classTxt.setText((String)dtm.getValueAt(row, 1));
		  }
		  
		  
	});
	   return idClassTable;
	}
	
	/*
	 * ������²�ѯ
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
		//��Ķ�̬����
		Vector data =new Vector(); 
		for(int i = 0 ; i<list.size();i++)
		{
			ClassBean bean = (ClassBean)list.get(i);  //��i��Ϊobject ������ǿ��ת��
			Vector vec =new Vector();  //�ڲ�С�Ķ�̬����
			vec.add(bean.getId());
			vec.add(bean.getClassname());
			data.add(vec);
		}
		return data ; 
	}
	/*
	 * �°벿�����
	 */
	public JPanel contentPane()
	{     
		contentPane = new JPanel();
		contentPane.setLayout(null);
	    contentPane.setBounds(5, 271, 702, 189);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	
		
		
		JLabel idLabel = new JLabel("���");  //��ű�ǩ
		idLabel.setBounds(67, 36, 66, 29);
		contentPane.add(idLabel);
		idLabel.setForeground(Color.BLACK);
		
		
		idTxt =new JTextField(); //����ı���    
		idTxt.setBounds(144, 35, 137, 29);          
		contentPane.add(idTxt);
		idTxt.setColumns(10);
		idTxt.setEditable(false);
		
		
		JLabel classLabel = new JLabel("�༶����"); //�༶��ǩ
		classLabel.setBounds(436, 43, 54, 15);
		contentPane.add(classLabel);
		
	    classTxt =new JTextField(); 
		classTxt.setBounds(497, 33, 128, 28);    //�༶�ı���
		contentPane.add(classTxt);
		classTxt.setColumns(10);
		
		JButton addButton = new JButton("����");   //������ť 
		addButton.setBounds(104, 102, 102, 53);
		contentPane.add(addButton);
		
		                                                      
		addButton.addMouseListener(new MouseListener(){   //������ť�����¼�
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
		JButton updateButton = new JButton("�޸�");   //�޸İ�ť
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
		
		
		JButton deleteButton = new JButton("ɾ��"); //ɾ����ť
		deleteButton.setBounds(494, 105, 102, 49);
		contentPane.add(deleteButton);
		  deleteButton.addMouseListener(new MouseListener(){

				@Override
				public void mouseClicked(MouseEvent arg0) {
				    String classname = classTxt.getText(); 
				    int id =Integer.parseInt(idTxt.getText());//��õ�����Ϊstring����ת��Ϊint��
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

package com.gs.view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.gs.bean.Course;
import com.gs.bean.CourseView;
import com.gs.bean.Department;
import com.gs.bean.SelectCourse;
import com.gs.bean.SelectCourseView;
import com.gs.bean.StudentView;
import com.gs.dao.StudentDao;
import com.gs.dao.SysCourseDao;
import com.gs.dao.TeacherDao;
/**
 * 
 * @author
 *��ʦ����-ѡ����Ϣ�鿴
 */
public class TeaSearchSelectFrame extends JFrame {

	JTable table = new JTable();//����
	Vector<String> colName = new Vector<String>();//ͷ������
	DefaultTableModel dtm = new DefaultTableModel();
	JComboBox Coursenamecom = new JComboBox();//�γ̸�ѡ��
	/**
	 * ���к���
	 */
	public TeaSearchSelectFrame() {
		setBounds(100, 100, 800, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		init();
		inittCoursenamecom();
		setVisible(true);
	}
	/**
	 * ����ֲ�
	 */
	public void init(){
		JScrollPane jsp = new JScrollPane(setTable());
		final JSplitPane sp = new JSplitPane
	(JSplitPane.VERTICAL_SPLIT,setInfo(),jsp);
		sp.addComponentListener(new ComponentAdapter() {  
            public void componentResized(ComponentEvent e) {  
            	sp.setDividerLocation(0.2);  
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
		JLabel coursenameLabel = new JLabel("�γ�����");//��ű�ǩ
		coursenameLabel.setBounds(20, 30, 60, 15);
		jp.add(coursenameLabel);
		/**
		 * �γ̸�ѡ��
		 */
		Coursenamecom.setBounds(90, 28, 90, 20);
		jp.add(Coursenamecom);//�γ̸�ѡ��
		/**
		 * ������ť
		 */
		
		JButton selectButton = new JButton("����");//������ť
		selectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CourseView bean0 = (CourseView) Coursenamecom.getSelectedItem();
				int cid = bean0.getCid();
				
				TeacherDao dao = new TeacherDao();
				List list = dao.courseselect(cid);
				Vector data = showTable(list);
				dtm.setDataVector(data, colName);
				table.setModel(dtm);
			}
		});
		selectButton.setBounds(190, 27, 70, 23);
		jp.add(selectButton);
		return jp;
	}
	/**
	 * ���
	 * @return
	 */
	public JTable setTable(){//���ͷ������
		colName.add("���");
		colName.add("����");
		colName.add("����");
		colName.add("�Ա�");
		colName.add("����");
		colName.add("�༶");
		colName.add("ϵ��");

		return table;
	}
	
	/**
	 * 
	 * ��ʾ���
	 * ����װ��
	 */
	public Vector showTable(List list){
		Vector data = new Vector();
		for(int i=0;i<list.size();i++){
			StudentView bean = (StudentView)list.get(i);
			Vector vec= new Vector();
			vec.add(bean.getSid());
			vec.add(bean.getSname());
			vec.add(bean.getSpassword());
			vec.add(bean.getSsex());
			vec.add(bean.getSage());
			vec.add(bean.getClassname());
			vec.add(bean.getDepname());
			data.add(vec);
		}
		return data;
		
	}
	/*
	 * ������
	 * */
	public void inittCoursenamecom(){
		SysCourseDao dao = new SysCourseDao();
		List list = dao.select();
		for(Object object : list){
			CourseView bean = (CourseView) object ;
			Coursenamecom.addItem(bean);
		}
	}
}

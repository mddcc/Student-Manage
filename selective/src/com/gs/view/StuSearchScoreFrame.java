 package com.gs.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.gs.bean.Course;
import com.gs.bean.Department;
import com.gs.bean.SelectCourse;
import com.gs.bean.Student;
import com.gs.bean.SelectCourseView;
import com.gs.dao.SelectCourseDao;

/**
 * 
 * @author
 * ѧ���ɼ��鿴
 * ���γ̺� �γ��� �ɼ���
 */
public class StuSearchScoreFrame extends JFrame {
	
	final JTable table = new JTable(); //��� 
	Vector colName = new Vector();//�����������
	final DefaultTableModel dtm = new DefaultTableModel();//�����ģ��
	
	/*
	 * ����
	 */
	public StuSearchScoreFrame(){
		setResizable(false);
		setBounds(100, 100, 800, 500);
		JScrollPane sp = new JScrollPane(setTable());
		this.add(sp);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
	/*
	 * ������²�ѯ��ˢ������
	 */
	public void refresh(){
		SelectCourseDao dao = new SelectCourseDao();
		Student bean = SelectiveMainFrame.student;
		int sid = bean.getSid();//��ȡѧ��ID
		List list = dao.select(sid);
		Vector data = showTable(list);
		dtm.setDataVector(data, colName);
		table.setModel(dtm);

	}
	
	
	/*
	 * �������
	 */
	public JTable setTable(){
		JPanel jpanel = new JPanel();
		
		colName.add("�γ̺�");
		colName.add("�γ���");
		colName.add("�ɼ�");

		refresh();
//		table.addMouseListener(new MouseAdapter() {
//			public void mouseClicked(java.awt.event.MouseEvent arg0){
//				int row = table.getSelectedRow();//ѡ����һ��
//				idTxt.setText(dtm.getValueAt(row, 0).toString());//ǿ��ת��ΪString���ӵ���0��ʼ 
//				depTxt.setText((String)dtm.getValueAt(row, 1));
//			}
//		});
		return table;
	}

	/*
	 * ���������
	 */
	public Vector showTable(List list){
		Vector data = new Vector();//�������
		for(int i=0;i<list.size();i++){
			SelectCourseView bean = (SelectCourseView)list.get(i);//Ϊ�˵õ�getCoursename
			Vector vec = new Vector();
			vec.add(bean.getCid());
			vec.add(bean.getCoursename());
			vec.add(bean.getScore());
			data.add(vec);
		}
		return data;
	}
	
	
//	private JPanel contentPane;
//	/**
//	 * Create the frame.
//	 */
//	public StuSearchScoreFrame() {
//		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		setResizable(false);
//		setBounds(100, 100, 800, 500);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setLayout(new BorderLayout(0, 0));
//		setContentPane(contentPane);
//		setVisible(true);
//	}

}

package com.gs.view;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.gs.dao.StudentDao;
/**
 * 
 * @author 
 * ѧ���鿴ѡ����Ϣ����
 */
public class StuSearchSelfSelectFrame extends JFrame {

	StudentDao dao = new StudentDao();
	private JPanel contentPane; //���
	private JTable table; //���
	private DefaultTableModel dtm; //���ģʽ
	private Vector colNames; //����
	
	/**
	 * Create the frame.
	 */
	public StuSearchSelfSelectFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 794, 472);
		contentPane.add(scrollPane);
		
		colNames = new Vector();
		colNames.add("���");
		colNames.add("����");
		colNames.add("ѧ��");
		colNames.add("�Ͽ�ʱ��");
		colNames.add("�Ͽεص�");
		colNames.add("�޶�����");
		colNames.add("ѡ������");
		table = new JTable();
		dtm = new DefaultTableModel(
					dao.selectCourseQuery(SelectiveMainFrame.student.getSid())
					,colNames
		);
		table.setModel(dtm);
		scrollPane.setViewportView(table);
		setResizable(false);
		setVisible(true);
	}
}

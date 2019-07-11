package com.gs.view;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.gs.dao.StudentDao;
import com.gs.dao.SysLogDao;
/**
 * 
 * @author 
 * �鿴��־��Ϣ����
 */
public class SysLogFrame extends JFrame {

	SysLogDao dao = new SysLogDao();
	private JPanel contentPane; //���
	private JTable table; //���
	private DefaultTableModel dtm; //���ģʽ
	private Vector colNames; //����
	/**
	 * Create the frame.
	 */
	public SysLogFrame() {
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
		colNames.add("��¼�˺�");
		colNames.add("��¼ʱ��");
		table = new JTable();
		dtm = new DefaultTableModel(
					dao.logQuery()
					,colNames
		);
		table.setModel(dtm);
		scrollPane.setViewportView(table);
		setResizable(false);
		setVisible(true);
	}

}

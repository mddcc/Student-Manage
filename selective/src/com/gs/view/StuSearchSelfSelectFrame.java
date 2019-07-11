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
 * 学生查看选课信息窗体
 */
public class StuSearchSelfSelectFrame extends JFrame {

	StudentDao dao = new StudentDao();
	private JPanel contentPane; //面板
	private JTable table; //表格
	private DefaultTableModel dtm; //表格模式
	private Vector colNames; //列名
	
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
		colNames.add("编号");
		colNames.add("名称");
		colNames.add("学分");
		colNames.add("上课时间");
		colNames.add("上课地点");
		colNames.add("限定人数");
		colNames.add("选课人数");
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

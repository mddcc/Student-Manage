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
 * 查看日志信息窗体
 */
public class SysLogFrame extends JFrame {

	SysLogDao dao = new SysLogDao();
	private JPanel contentPane; //面板
	private JTable table; //表格
	private DefaultTableModel dtm; //表格模式
	private Vector colNames; //列名
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
		colNames.add("编号");
		colNames.add("登录账号");
		colNames.add("登录时间");
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

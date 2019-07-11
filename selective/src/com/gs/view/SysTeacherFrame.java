package com.gs.view;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.gs.bean.Department;
import com.gs.bean.Teacher;
import com.gs.bean.TeacherView;
import com.gs.dao.SysDepartmentDao;
import com.gs.dao.SysTeacherDao;
/**
 * 
 * @author 
 *系统教师管理
 */
public class SysTeacherFrame extends JFrame{

	private JTextField tpasswordtextField;//密码文本标签
	private JTextField tnametextField;//姓名文本标签
	private JTextField tidtextField;//编号文本标签
	private JTextField tagetextField;//年龄文本标签
	private JTextField tjobtextField;//职业文本标签
	JTable table = new JTable();//窗体
	JComboBox<String> tsexcom = new JComboBox<String>();//性别复选框
	JComboBox<Department> tDepartmentcom = new JComboBox<Department>();//系别复选框
	Vector<String> colName = new Vector<String>();//头部名称
	DefaultTableModel dtm = new DefaultTableModel();
	
	/**
	 * 运行函数
	 */
	public SysTeacherFrame(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 800, 500);
		inittDepartmentcom();
		init();
		setVisible(true);
	}
	/**
	 * 界面分布
	 */
	public void init(){
		JScrollPane jsp = new JScrollPane(setTable());
		final JSplitPane sp = new JSplitPane
	(JSplitPane.VERTICAL_SPLIT,jsp,setInfo());
		sp.addComponentListener(new ComponentAdapter() {  
            public void componentResized(ComponentEvent e) {  
            	sp.setDividerLocation(0.4);  
    }  
		}); 
		add(sp);
	}
	/**
	 * 界面设置
	 * @return
	 */
	public JPanel setInfo(){
		JPanel jp = new JPanel();
		jp.setLayout(null);
		JLabel tidLabel = new JLabel("编号");//编号标签
		tidLabel.setBounds(70, 58, 30, 15);
		jp.add(tidLabel);
		
		tidtextField = new JTextField();//编号文本标签
		tidtextField.setBounds(100, 55, 66, 21);
		jp.add(tidtextField);
		tidtextField.setColumns(10);
		tidtextField.setEditable(false);
		/**
		 * 以下每组，一个标签，一个文本
		 */
		JLabel tpasswordLabel = new JLabel("密码");
		tpasswordLabel.setBounds(220, 58, 30, 15);
		jp.add(tpasswordLabel);
		
		tpasswordtextField = new JTextField();
		tpasswordtextField.setBounds(250, 55, 66, 21);
		jp.add(tpasswordtextField);
		tpasswordtextField.setColumns(10);
		
		JLabel tnamelabel = new JLabel("姓名");
		tnamelabel.setBounds(370, 58, 30, 15);
		jp.add(tnamelabel);
		
		tnametextField = new JTextField();
		tnametextField.setBounds(400, 55, 66, 21);
		jp.add(tnametextField);
		tnametextField.setColumns(10);
		
		JLabel tsexlabel = new JLabel("性别");
		tsexlabel.setBounds(520, 58, 30, 15);
		jp.add(tsexlabel);
		
		tagetextField = new JTextField();
		tagetextField.setColumns(10);
		tagetextField.setBounds(100, 107, 66, 21);
		jp.add(tagetextField);
		
		JLabel tagelabel = new JLabel("年龄");
		tagelabel.setBounds(70, 110, 30, 15);
		jp.add(tagelabel);
		
		JLabel tjoblabel = new JLabel("职位");
		tjoblabel.setBounds(220, 110, 30, 15);
		jp.add(tjoblabel);
		
		tjobtextField = new JTextField();
		tjobtextField.setColumns(10);
		tjobtextField.setBounds(250, 107, 66, 21);
		jp.add(tjobtextField);
		
		JLabel tDepartmentlabel = new JLabel("系别");
		tDepartmentlabel.setBounds(370, 110, 30, 15);
		jp.add(tDepartmentlabel);
		/**
		 * 复选框
		 */
		tsexcom.addItem("女");
		tsexcom.addItem("男");
		tsexcom.setBounds(550, 55, 97, 21);
		jp.add(tsexcom);//性别复选框
		
		
		tDepartmentcom.setBounds(400, 107, 97, 21);
		jp.add(tDepartmentcom);//系别复选框
		/**
		 * 按钮
		 */
		JButton updateButton = new JButton("修改");//修改按钮
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//修改按钮监听事件
				int tid = Integer.parseInt(tidtextField.getText());
				String tpassword = tpasswordtextField.getText();
				String tname = tnametextField.getText();
				int index = tsexcom.getSelectedIndex();
				int tsex = index==0?0:1;
				int tage = Integer.parseInt(tagetextField.getText());
				String tjob = tjobtextField.getText();
				Department bean0 = (Department)tDepartmentcom.getSelectedItem();
				int tdepartment = (bean0.getId());
				Teacher bean = new Teacher(tid,tpassword,tname,tsex,tage,tjob,tdepartment);
				SysTeacherDao dao = new SysTeacherDao();
				dao.update(bean);
				Refresh();
			}
		});
		updateButton.setBounds(70, 154, 96, 23);
		jp.add(updateButton);
		
		JButton deletebutton = new JButton("删除");//删除按钮
		deletebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//删除监听事件
				int tid = Integer.parseInt(tidtextField.getText());
				String tpassword = tpasswordtextField.getText();
				String tname = tnametextField.getText();
				int index = tsexcom.getSelectedIndex();
				int tsex = index==0?0:1;
				int tage = Integer.parseInt(tagetextField.getText());
				String tjob = tjobtextField.getText();
				Department bean0 = (Department)tDepartmentcom.getSelectedItem();
				int tdepartment = (bean0.getId());
				Teacher bean = new Teacher(tid,tpassword,tname,tsex,tage,tjob,tdepartment);
				SysTeacherDao dao = new SysTeacherDao();
				dao.delete(bean);
				Refresh();
			}
		});
		deletebutton.setBounds(170, 154, 96, 23);
		jp.add(deletebutton);
		
		JButton addbutton = new JButton("新增");//新增按钮
		addbutton.addActionListener(new ActionListener() {//新增监听事件
			public void actionPerformed(ActionEvent arg0) {
				//int tid = Integer.parseInt(tidtextField.getText());
				String tpassword = tpasswordtextField.getText();
				String tname = tnametextField.getText();
				int index = tsexcom.getSelectedIndex();
				int tsex = index==0?0:1;
				int tage = Integer.parseInt(tagetextField.getText());
				String tjob = tjobtextField.getText();
				Department bean0 = (Department)tDepartmentcom.getSelectedItem();
				int tdepartment = bean0.getId();
				SysTeacherDao dao = new SysTeacherDao();
				Teacher bean = new Teacher();
				bean.setTpassword(tpassword);
				bean.setTname(tname);
				bean.setTsex(tsex);
				bean.setTage(tage);
				bean.setTjob(tjob);
				bean.setTdepartment(tdepartment);
				dao.add(bean);
				Refresh();
			}
		});
		addbutton.setBounds(270, 154, 96, 23);
		jp.add(addbutton);
		return jp;
	}
	/**
	 * 表格
	 * @return
	 */
	public JTable setTable(){//表格头部名称
		colName.add("编号");
		colName.add("密码");
		colName.add("姓名");
		colName.add("性别");
		colName.add("年龄");
		colName.add("职位");
		colName.add("系别");
		Refresh();
		table.addMouseListener(new MouseAdapter() {//点击事件选中以及返回值
			public void mouseClicked(java.awt.event.MouseEvent arg0){
				int row = table.getSelectedRow();//选中哪一行
				tidtextField.setText(dtm.getValueAt(row, 0).toString());
				tpasswordtextField.setText((String)dtm.getValueAt(row, 1));
				tnametextField.setText((String)dtm.getValueAt(row, 2));
				tsexcom.setSelectedItem((String)dtm.getValueAt(row, 3));
				tagetextField.setText((String)dtm.getValueAt(row, 4).toString());
				tjobtextField.setText((String)dtm.getValueAt(row, 5).toString());
				String depname = ((String)dtm.getValueAt(row, 6));
				for(int i=0;i<tDepartmentcom.getModel().getSize();i++){
					Department dep = (Department)tDepartmentcom.getItemAt(i);
					if(depname.equals(dep.getDepname())){
						tDepartmentcom.setSelectedIndex(i);
						break;
					}
				}
			}
		});
		return table;
	}
	/**
	 * 刷新表格
	 */
	public void Refresh(){
		SysTeacherDao dao = new SysTeacherDao();
		List list = dao.select();
		Vector data = showTable(list);
		dtm.setDataVector(data, colName);
		table.setModel(dtm);
	}
	/**
	 * 
	 * 显示表格
	 * 分批装入
	 */
	public Vector showTable(List list){
		Vector data = new Vector();
		for(int i=0;i<list.size();i++){
			TeacherView bean = (TeacherView)list.get(i);
			Vector vec= new Vector();
			vec.add(bean.getTid());
			vec.add(bean.getTpassword());
			vec.add(bean.getTname());
			vec.add(bean.getTsex());
			vec.add(bean.getTage());
			vec.add(bean.getTjob());
			vec.add(bean.getDepname());
			data.add(vec);
		}
		return data;
		
	}
	/**
	 * 系别复杂复选框显示
	 */
	public void inittDepartmentcom(){
		SysDepartmentDao dao = new SysDepartmentDao();
		List list = dao.select();
		for(Object object : list){
			Department bean = (Department) object ;
			tDepartmentcom.addItem(bean);
		}
	}
	
}

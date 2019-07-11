package com.gs.view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.gs.bean.ClassBean;
import com.gs.bean.Department;
import com.gs.bean.Student;
import com.gs.bean.StudentView;
import com.gs.dao.SysStudentDao;
/**
 * 
 * @author 
 * 学生管理菜单项
 */
public class SysStudentFrame extends JFrame {
	SysStudentDao dao = new SysStudentDao(); //学生事务
	
	private JPanel contentPane; //主面板
	private JScrollPane stuScrollPane; //表格滚动面板
	private JPanel stuEditPanel; //编辑面板
	private JTable stuMsgTble; //学生信息表格	
	private JTextField sidTextField; //编号文本框	
	private JTextField sageTextfield; //年龄文本框
	private JTextField spasswordTextField; //密码文本框
	private JTextField snameTextField; //姓名文本框
	private JComboBox ssexComboBox; //性别下拉框
	private JComboBox sdeptComboBox; //系别下拉框
	private JComboBox sclassComboBox; //班级下拉框
	private JButton stuUpdate; //修改按钮
	private JButton stuAdd; //增加按钮
	private JButton stuDelete; //删除按钮
	
	private List<Department> depts = null; //系别集合
	private List<ClassBean> classes = null; //班级集合
	private Vector<Vector> stuv =null; //总查询结果
	private DefaultTableModel dfModel = null; //默认表格模式
	private Vector<String> colNames; //表格列名
	
	private int selectedRow = -1; //被选中的行(行号-1)
	private int selectedId; //选中行的id
	private String selectedPwd; //选中行的密码
	private String selectedName; //选中行的姓名
	private int selectedSex = -1; //被选中的性别(-1为没有选择)
	private int selectedAge; //选中的年龄
	private int selectedClassNo; //被选中的班级号
	private int selectedDeptNo; //被选中的系别编号
	private String selectedClassName; //默认被选中的班级名称
	private String selectedDeptName; //默认被选中的系别名称
	
	/**
	 * 创建窗体
	 */
	public SysStudentFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//初始化
		intit();
		//设置列表数据
		setTabList();
		//添加监听
		addListener();
		setVisible(true);
	}
	/*
	 * 初始化下拉框内容
	 */
	public void intit() {
		//设置表格标题
		colNames = new Vector();
		colNames.add("编号");
		colNames.add("密码");
		colNames.add("姓名");
		colNames.add("性别");
		colNames.add("年龄");
		colNames.add("班级");
		colNames.add("系别");
		//调用方法获取并添加面板
		stuScrollPane = stuPane();
		stuEditPanel = editPane();
		contentPane.add(stuScrollPane);
		contentPane.add(stuEditPanel);
		//查询数据库中的所有系别、班级,添加到下拉
		depts = dao.queryAllDepts();
		classes = dao.queryAllClass();
		for (Department dept : depts) {
			sdeptComboBox.addItem(dept);
		}
		for (ClassBean cls : classes) {
			sclassComboBox.addItem(cls);
		}
		//设置默认选中的系别、班级
		ClassBean cla = (ClassBean)sclassComboBox.getSelectedItem();
		Department dpt = (Department)sdeptComboBox.getSelectedItem();
		selectedDeptName = dpt.getDepname();
		selectedClassName = cla.getClassname();
		System.out.println(selectedDeptName);
		System.out.println(selectedClassName);
	}
	/*
	 * 设置表格数据
	 */
	public void setTabList() {
		stuv = dao.queryAllStudentView();
		dfModel.setDataVector(stuv, colNames);
	}
	/*
	 * 获取滚动面板及表格
	 */
	public JScrollPane stuPane(){
		JScrollPane stuPane = new JScrollPane();
		stuPane.setBounds(10, 10, 764, 254);
		//设置面板中的表格
		stuMsgTble = new JTable();
		stuv = dao.queryAllStudentView();
		dfModel = new DefaultTableModel(stuv,colNames);
		
		
		stuMsgTble.setModel(dfModel);
		stuPane.setViewportView(stuMsgTble);
		return stuPane;
	}
	/*
	 * 统一添加事件监听
	 */
	public void addListener(){
		//监听表格鼠标单机事件
		stuMsgTble.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedRow = stuMsgTble.getSelectedRow();
				//设置文本框值
				setTxtText();
			}
		});
		//监听系别下拉列表
		sdeptComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//获取选中的系别
				Department dp = (Department) sdeptComboBox.getSelectedItem();
				selectedDeptName = dp.getDepname();
				setTabList();
				System.out.println(selectedDeptName);
				System.out.println(stuv);
			}
		});
		//监听性别下拉列表
		ssexComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//获取选中的性别
				String sex = ssexComboBox.getSelectedItem().toString();
				if(sex.equals("男")) {
					selectedSex = 1;
				}else if(sex.equals("女")) {
					selectedSex = 0;
				}else {
					selectedSex = -1;
				}
				setTabList();
				System.out.println(selectedSex);
				System.out.println(stuv);	
			}
		});
		
		//监听班级下拉列表
		sclassComboBox.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				//获取选中的班级
				ClassBean se = (ClassBean) sclassComboBox.getSelectedItem();
				selectedClassName = se.getClassname();
				setTabList();
				System.out.println(selectedClassName);
				System.out.println(stuv);
			}
		});
		//监听更新按钮
		stuUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getTxtText();
				Student stu = new Student(
						selectedId,
						selectedName,
						selectedPwd,
						selectedSex,
						selectedAge,
						selectedClassNo,
						selectedDeptNo
				);
				int update = dao.update(stu);
				if(update>0){
					JOptionPane.showMessageDialog(null, "修改成功");
					setTabList();
					clearText();
				}else{
					JOptionPane.showMessageDialog(null, "修改失败");
				}
				
			}
		});
		//监听添加按钮
		stuAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getTxtText();
				Student stu = new Student(selectedId,
						selectedName,
						selectedPwd,
						selectedSex,
						selectedAge,
						selectedClassNo, selectedDeptNo);
				int insert = dao.insert(stu);
				if(insert>0){
					JOptionPane.showMessageDialog(null, "插入成功");
					setTabList();
					clearText();
				}else{
					JOptionPane.showMessageDialog(null, "插入失败");
				}
			}
		});
		//监听删除按钮
		stuDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int delete = dao.delete(Integer.parseInt(sidTextField.getText()));
				if(delete>0){
					JOptionPane.showMessageDialog(null, "删除成功!!!");
					setTabList();
					clearText();
				}else{
					JOptionPane.showMessageDialog(null, "删除失败!!!");
				}
			}
		});
	}
	
	/*
	 * 获取编辑面板及组件
	 */
	public JPanel editPane(){
		JPanel editPane= new JPanel();
		editPane.setBounds(10, 274, 764, 178);
		TitledBorder tb = new TitledBorder("编辑界面");
		editPane.setBorder(tb);
		editPane.setLayout(null);
		
		JLabel sidLabel = new JLabel("编号");
		sidLabel.setBounds(10, 29, 54, 15);
		editPane.add(sidLabel);
		
		JLabel sageLabel = new JLabel("年龄");
		sageLabel.setBounds(10, 75, 54, 15);
		editPane.add(sageLabel);
		
		JLabel ssexLabel = new JLabel("性别");
		ssexLabel.setBounds(592, 31, 54, 15);
		editPane.add(ssexLabel);
		
		JLabel spasswordLabel = new JLabel("密码");
		spasswordLabel.setBounds(209, 29, 54, 15);
		editPane.add(spasswordLabel);
		
		JLabel sclassLabel = new JLabel("班级");
		sclassLabel.setBounds(209, 75, 54, 15);
		editPane.add(sclassLabel);
		
		JLabel snameLabel = new JLabel("姓名");
		snameLabel.setBounds(401, 29, 54, 15);
		editPane.add(snameLabel);
		
		JLabel sdepartmentLabel = new JLabel("系部");
		sdepartmentLabel.setBounds(401, 75, 54, 15);
		editPane.add(sdepartmentLabel);
		
		sidTextField = new JTextField();
		sidTextField.setBounds(80, 26, 102, 21);
		editPane.add(sidTextField);
		sidTextField.setColumns(10);
		
		sageTextfield = new JTextField();
		sageTextfield.setBounds(80, 72, 102, 21);
		editPane.add(sageTextfield);
		sageTextfield.setColumns(10);
		
		spasswordTextField = new JTextField();
		spasswordTextField.setColumns(10);
		spasswordTextField.setBounds(273, 26, 102, 21);
		editPane.add(spasswordTextField);
		
		snameTextField = new JTextField();
		snameTextField.setColumns(10);
		snameTextField.setBounds(463, 26, 102, 21);
		editPane.add(snameTextField);
		
		sdeptComboBox = new JComboBox();
		sdeptComboBox.setBounds(463, 72, 100, 21);
		editPane.add(sdeptComboBox);
		
		ssexComboBox = new JComboBox();
		ssexComboBox.setBounds(639, 27, 100, 21);
		ssexComboBox.addItem("所有");
		ssexComboBox.addItem("男");
		ssexComboBox.addItem("女");
		editPane.add(ssexComboBox);

		sclassComboBox = new JComboBox();
		sclassComboBox.setBounds(273, 72, 100, 21);
		editPane.add(sclassComboBox);
		
		stuUpdate = new JButton("修改");
		stuUpdate.setBounds(495, 138, 80, 30);
		editPane.add(stuUpdate);
		
		stuDelete = new JButton("删除");
		stuDelete.setBounds(585, 138, 80, 30);
		editPane.add(stuDelete);
		
		stuAdd = new JButton("新增");
		stuAdd.setBounds(674, 138, 80, 30);
		editPane.add(stuAdd);
		
		return editPane;
	}
	/*
	 * 清空文本框
	 */
	public void clearText(){
		sidTextField.setText("");
		spasswordTextField.setText("");
		snameTextField.setText("");
		sageTextfield.setText("");
	}
	/*
	 * 获取文本框值
	 */
	public void getTxtText(){
		selectedId = Integer.parseInt(sidTextField.getText());
		selectedPwd = spasswordTextField.getText();
		selectedName = snameTextField.getText();
		if(ssexComboBox.getSelectedItem().equals("男")){
			selectedSex = 1;
		}else{
			selectedSex = 0;
		}
		selectedAge = Integer.parseInt(sageTextfield.getText());
		ClassBean se = (ClassBean) sclassComboBox.getSelectedItem();
		selectedClassNo = se.getId();
		Department dp = (Department) sdeptComboBox.getSelectedItem();
		selectedDeptNo = dp.getId();
	}
	
	/*
	 * 将选中行的值同步到文本框
	 */
	public void setTxtText(){
		//将学号同步到文本框中
		sidTextField.setText(stuMsgTble.getValueAt(selectedRow, 0)+"");
		//将密码同步到文本框中
		spasswordTextField.setText(stuMsgTble.getValueAt(selectedRow, 1)+"");
		//将姓名同步到文本框中
		snameTextField.setText(stuMsgTble.getValueAt(selectedRow, 2)+"");
		//将性别同步到下拉框
		ssexComboBox.setSelectedItem(stuMsgTble.getValueAt(selectedRow, 3));
		//将年龄同步到文本框
		sageTextfield.setText(stuMsgTble.getValueAt(selectedRow, 4)+"");
	}

	public static void main(String[] args) {
		new SysStudentFrame();
	}
}

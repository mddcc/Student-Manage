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
 * ѧ������˵���
 */
public class SysStudentFrame extends JFrame {
	SysStudentDao dao = new SysStudentDao(); //ѧ������
	
	private JPanel contentPane; //�����
	private JScrollPane stuScrollPane; //���������
	private JPanel stuEditPanel; //�༭���
	private JTable stuMsgTble; //ѧ����Ϣ���	
	private JTextField sidTextField; //����ı���	
	private JTextField sageTextfield; //�����ı���
	private JTextField spasswordTextField; //�����ı���
	private JTextField snameTextField; //�����ı���
	private JComboBox ssexComboBox; //�Ա�������
	private JComboBox sdeptComboBox; //ϵ��������
	private JComboBox sclassComboBox; //�༶������
	private JButton stuUpdate; //�޸İ�ť
	private JButton stuAdd; //���Ӱ�ť
	private JButton stuDelete; //ɾ����ť
	
	private List<Department> depts = null; //ϵ�𼯺�
	private List<ClassBean> classes = null; //�༶����
	private Vector<Vector> stuv =null; //�ܲ�ѯ���
	private DefaultTableModel dfModel = null; //Ĭ�ϱ��ģʽ
	private Vector<String> colNames; //�������
	
	private int selectedRow = -1; //��ѡ�е���(�к�-1)
	private int selectedId; //ѡ���е�id
	private String selectedPwd; //ѡ���е�����
	private String selectedName; //ѡ���е�����
	private int selectedSex = -1; //��ѡ�е��Ա�(-1Ϊû��ѡ��)
	private int selectedAge; //ѡ�е�����
	private int selectedClassNo; //��ѡ�еİ༶��
	private int selectedDeptNo; //��ѡ�е�ϵ����
	private String selectedClassName; //Ĭ�ϱ�ѡ�еİ༶����
	private String selectedDeptName; //Ĭ�ϱ�ѡ�е�ϵ������
	
	/**
	 * ��������
	 */
	public SysStudentFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//��ʼ��
		intit();
		//�����б�����
		setTabList();
		//��Ӽ���
		addListener();
		setVisible(true);
	}
	/*
	 * ��ʼ������������
	 */
	public void intit() {
		//���ñ�����
		colNames = new Vector();
		colNames.add("���");
		colNames.add("����");
		colNames.add("����");
		colNames.add("�Ա�");
		colNames.add("����");
		colNames.add("�༶");
		colNames.add("ϵ��");
		//���÷�����ȡ��������
		stuScrollPane = stuPane();
		stuEditPanel = editPane();
		contentPane.add(stuScrollPane);
		contentPane.add(stuEditPanel);
		//��ѯ���ݿ��е�����ϵ�𡢰༶,��ӵ�����
		depts = dao.queryAllDepts();
		classes = dao.queryAllClass();
		for (Department dept : depts) {
			sdeptComboBox.addItem(dept);
		}
		for (ClassBean cls : classes) {
			sclassComboBox.addItem(cls);
		}
		//����Ĭ��ѡ�е�ϵ�𡢰༶
		ClassBean cla = (ClassBean)sclassComboBox.getSelectedItem();
		Department dpt = (Department)sdeptComboBox.getSelectedItem();
		selectedDeptName = dpt.getDepname();
		selectedClassName = cla.getClassname();
		System.out.println(selectedDeptName);
		System.out.println(selectedClassName);
	}
	/*
	 * ���ñ������
	 */
	public void setTabList() {
		stuv = dao.queryAllStudentView();
		dfModel.setDataVector(stuv, colNames);
	}
	/*
	 * ��ȡ������弰���
	 */
	public JScrollPane stuPane(){
		JScrollPane stuPane = new JScrollPane();
		stuPane.setBounds(10, 10, 764, 254);
		//��������еı��
		stuMsgTble = new JTable();
		stuv = dao.queryAllStudentView();
		dfModel = new DefaultTableModel(stuv,colNames);
		
		
		stuMsgTble.setModel(dfModel);
		stuPane.setViewportView(stuMsgTble);
		return stuPane;
	}
	/*
	 * ͳһ����¼�����
	 */
	public void addListener(){
		//���������굥���¼�
		stuMsgTble.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedRow = stuMsgTble.getSelectedRow();
				//�����ı���ֵ
				setTxtText();
			}
		});
		//����ϵ�������б�
		sdeptComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//��ȡѡ�е�ϵ��
				Department dp = (Department) sdeptComboBox.getSelectedItem();
				selectedDeptName = dp.getDepname();
				setTabList();
				System.out.println(selectedDeptName);
				System.out.println(stuv);
			}
		});
		//�����Ա������б�
		ssexComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//��ȡѡ�е��Ա�
				String sex = ssexComboBox.getSelectedItem().toString();
				if(sex.equals("��")) {
					selectedSex = 1;
				}else if(sex.equals("Ů")) {
					selectedSex = 0;
				}else {
					selectedSex = -1;
				}
				setTabList();
				System.out.println(selectedSex);
				System.out.println(stuv);	
			}
		});
		
		//�����༶�����б�
		sclassComboBox.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				//��ȡѡ�еİ༶
				ClassBean se = (ClassBean) sclassComboBox.getSelectedItem();
				selectedClassName = se.getClassname();
				setTabList();
				System.out.println(selectedClassName);
				System.out.println(stuv);
			}
		});
		//�������°�ť
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
					JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
					setTabList();
					clearText();
				}else{
					JOptionPane.showMessageDialog(null, "�޸�ʧ��");
				}
				
			}
		});
		//������Ӱ�ť
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
					JOptionPane.showMessageDialog(null, "����ɹ�");
					setTabList();
					clearText();
				}else{
					JOptionPane.showMessageDialog(null, "����ʧ��");
				}
			}
		});
		//����ɾ����ť
		stuDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int delete = dao.delete(Integer.parseInt(sidTextField.getText()));
				if(delete>0){
					JOptionPane.showMessageDialog(null, "ɾ���ɹ�!!!");
					setTabList();
					clearText();
				}else{
					JOptionPane.showMessageDialog(null, "ɾ��ʧ��!!!");
				}
			}
		});
	}
	
	/*
	 * ��ȡ�༭��弰���
	 */
	public JPanel editPane(){
		JPanel editPane= new JPanel();
		editPane.setBounds(10, 274, 764, 178);
		TitledBorder tb = new TitledBorder("�༭����");
		editPane.setBorder(tb);
		editPane.setLayout(null);
		
		JLabel sidLabel = new JLabel("���");
		sidLabel.setBounds(10, 29, 54, 15);
		editPane.add(sidLabel);
		
		JLabel sageLabel = new JLabel("����");
		sageLabel.setBounds(10, 75, 54, 15);
		editPane.add(sageLabel);
		
		JLabel ssexLabel = new JLabel("�Ա�");
		ssexLabel.setBounds(592, 31, 54, 15);
		editPane.add(ssexLabel);
		
		JLabel spasswordLabel = new JLabel("����");
		spasswordLabel.setBounds(209, 29, 54, 15);
		editPane.add(spasswordLabel);
		
		JLabel sclassLabel = new JLabel("�༶");
		sclassLabel.setBounds(209, 75, 54, 15);
		editPane.add(sclassLabel);
		
		JLabel snameLabel = new JLabel("����");
		snameLabel.setBounds(401, 29, 54, 15);
		editPane.add(snameLabel);
		
		JLabel sdepartmentLabel = new JLabel("ϵ��");
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
		ssexComboBox.addItem("����");
		ssexComboBox.addItem("��");
		ssexComboBox.addItem("Ů");
		editPane.add(ssexComboBox);

		sclassComboBox = new JComboBox();
		sclassComboBox.setBounds(273, 72, 100, 21);
		editPane.add(sclassComboBox);
		
		stuUpdate = new JButton("�޸�");
		stuUpdate.setBounds(495, 138, 80, 30);
		editPane.add(stuUpdate);
		
		stuDelete = new JButton("ɾ��");
		stuDelete.setBounds(585, 138, 80, 30);
		editPane.add(stuDelete);
		
		stuAdd = new JButton("����");
		stuAdd.setBounds(674, 138, 80, 30);
		editPane.add(stuAdd);
		
		return editPane;
	}
	/*
	 * ����ı���
	 */
	public void clearText(){
		sidTextField.setText("");
		spasswordTextField.setText("");
		snameTextField.setText("");
		sageTextfield.setText("");
	}
	/*
	 * ��ȡ�ı���ֵ
	 */
	public void getTxtText(){
		selectedId = Integer.parseInt(sidTextField.getText());
		selectedPwd = spasswordTextField.getText();
		selectedName = snameTextField.getText();
		if(ssexComboBox.getSelectedItem().equals("��")){
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
	 * ��ѡ���е�ֵͬ�����ı���
	 */
	public void setTxtText(){
		//��ѧ��ͬ�����ı�����
		sidTextField.setText(stuMsgTble.getValueAt(selectedRow, 0)+"");
		//������ͬ�����ı�����
		spasswordTextField.setText(stuMsgTble.getValueAt(selectedRow, 1)+"");
		//������ͬ�����ı�����
		snameTextField.setText(stuMsgTble.getValueAt(selectedRow, 2)+"");
		//���Ա�ͬ����������
		ssexComboBox.setSelectedItem(stuMsgTble.getValueAt(selectedRow, 3));
		//������ͬ�����ı���
		sageTextfield.setText(stuMsgTble.getValueAt(selectedRow, 4)+"");
	}

	public static void main(String[] args) {
		new SysStudentFrame();
	}
}

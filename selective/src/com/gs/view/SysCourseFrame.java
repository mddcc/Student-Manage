package com.gs.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import com.gs.bean.Course;
import com.gs.bean.CourseView;
import com.gs.bean.Department;
import com.gs.bean.Teacher;
import com.gs.bean.TeacherView;
import com.gs.dao.SysCourseDao;
import com.gs.dao.SysTeacherDao;
/**
 * 
 * @author 
 * �γ̹�����
 */
public class SysCourseFrame extends JFrame {

	private JPanel contentPane;
	//JTextField idText = new JTextField();
	private JTextField cidtextField;//���
	private JTextField caddressText; //����
	private JTextField coursenameText;//�γ�����
	private JTextField creditText;//ѧ��
	private JTextField LimitnumberText;//�޶�����
	private JTextField ctimeText;//�Ͽ�ʱ��
	private JTextField truenumberText;//��ѡ����
	private JComboBox teacherBox=new JComboBox();//��ʦ
	private JTable table = new JTable();// ���
	Vector colName = new Vector();
	DefaultTableModel dtm = new DefaultTableModel();
	
	

//	public SysCourseFrame() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 800, 500);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//	    setContentPane(contentPane);
//		setVisible(true);
//	}
	
	
	public SysCourseFrame(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 800, 500);
		//setTable();
		init();
		//setInfo();
		setVisible(true);
	}
	public JPanel setInfo(){
  
		JPanel jp = new JPanel();
		jp.setLayout(null);
		JButton CupdateButton = new JButton("�޸�");
		CupdateButton.addMouseListener(new MouseAdapter() {   //�޸��¼�
			
			 public void mouseClicked(MouseEvent e){
				 //String coursename = coursenameText.getText();
				 int cid = Integer.parseInt(cidtextField.getText());
				 String coursename = coursenameText.getText();
				 int credit = Integer.parseInt(creditText.getText());
				 String ctime = ctimeText.getText();
				 String caddress = caddressText.getText();
				 TeacherView tbean = (TeacherView)teacherBox.getSelectedItem();
				 int teacher = tbean.getTid();
				 int limitnumber = Integer.parseInt(LimitnumberText.getText());
				 int truenumber = Integer.parseInt(truenumberText.getText()); 
				 Course bean = new Course(cid,coursename,credit,ctime,caddress,teacher,limitnumber,truenumber);
				 SysCourseDao dao = new SysCourseDao();
				 dao.update(bean);
				 refresh();
				 
			 }
		});
		CupdateButton.setBounds(21, 110, 93, 23);
		jp.add(CupdateButton);
		
		JButton CdeleteButton = new JButton("ɾ��");
		CdeleteButton.addMouseListener(new MouseAdapter() {   //ɾ���¼�
			
			 public void mouseClicked(MouseEvent e){
				 int id = Integer.parseInt(cidtextField.getText());
				 Course bean = new Course();
				 bean.setCid(id);
				 SysCourseDao dao =new SysCourseDao();
				 dao.delete(bean);
				 refresh();
			 }
		});
		CdeleteButton.setBounds(136, 110, 93, 23);
		jp.add(CdeleteButton);
		
		JButton CaddButton = new JButton("����");
		CaddButton.addMouseListener(new MouseAdapter() {   //�����¼�
			
			 public void mouseClicked(MouseEvent e){
				 String coursename = coursenameText.getText();
				 int credit = Integer.parseInt(creditText.getText());
				 String ctime = ctimeText.getText();
				 String caddress = caddressText.getText();
				 TeacherView tbean = (TeacherView)teacherBox.getSelectedItem();
				 int teacher = tbean.getTid();
				 int limitnumber = Integer.parseInt(LimitnumberText.getText());
				 int truenumber = Integer.parseInt(truenumberText.getText());
			     SysCourseDao dao =new SysCourseDao();
			     Course bean = new Course();
			     bean.setCoursename(coursename);
			     bean.setCredit(credit);
			     bean.setCtime(ctime);
			     bean.setCaddress(caddress);
			     bean.setTeacher(teacher);
			     bean.setLimitnumber(limitnumber);
			     bean.setTurenumber(truenumber);
			     dao.add(bean);
			     refresh();
			 }
		});
		
		

		CaddButton.setBounds(249,110, 93, 23);
		jp.add(CaddButton);
		
		JLabel cidLabel = new JLabel("���");
		cidLabel.setBounds(21, 23, 54, 15);
		jp.add(cidLabel);
		
		JLabel caddresslabel = new JLabel("�Ͽεص�");
		caddresslabel.setBounds(21, 61, 54, 15);
		jp.add(caddresslabel);
		
		cidtextField = new JTextField();
		cidtextField.setBounds(85, 21, 66, 18);
		cidtextField.setEditable(false);
		jp.add(cidtextField);
		cidtextField.setColumns(10);
		
		caddressText = new JTextField();
		caddressText.setBounds(85, 59, 66, 18);
		jp.add(caddressText);
		caddressText.setColumns(10);
		
		JLabel coursenamelabel = new JLabel("�γ�����");
		coursenamelabel.setBounds(175, 23, 54, 15);
		jp.add(coursenamelabel);
		
		JLabel teacherLabel = new JLabel("�ον�ʦ");
		teacherLabel.setBounds(175, 61, 54, 15);
		jp.add(teacherLabel);
		
		teacherBox = new JComboBox();
		teacherBox.setBounds(239, 58, 78, 21);
		jp.add(teacherBox);

		
		coursenameText = new JTextField();
		coursenameText.setBounds(239, 21, 78, 18);
		jp.add(coursenameText);
		coursenameText.setColumns(10);
		
		JLabel creditlabel = new JLabel("ѧ��");
		creditlabel.setBounds(343, 23, 54, 15);
		jp.add(creditlabel);
		
		JLabel limitnumberlabel = new JLabel("�޶�����");
		limitnumberlabel.setBounds(343, 61, 54, 15);
		jp.add(limitnumberlabel);
		
		creditText = new JTextField();
		creditText.setBounds(397, 21, 66, 18);
		jp.add(creditText);
		creditText.setColumns(10);
		
		LimitnumberText = new JTextField();
		LimitnumberText.setBounds(397, 59, 66, 18);
		jp.add(LimitnumberText);
		LimitnumberText.setColumns(10);
		
		JLabel ctimelabel = new JLabel("�Ͽ�ʱ��");
		ctimelabel.setBounds(483, 23, 54, 15);
		jp.add(ctimelabel);
		
		JLabel truenumberlabel = new JLabel("ѡ������");
		truenumberlabel.setBounds(483, 61, 54, 15);
		jp.add(truenumberlabel);
		
		ctimeText = new JTextField();
		ctimeText.setBounds(561, 21, 66, 18);
		jp.add(ctimeText);
		ctimeText.setColumns(10);
		
		truenumberText = new JTextField();
		truenumberText.setBounds(561, 59, 66, 18);
		jp.add(truenumberText);
		truenumberText.setColumns(10);
		initTeacherBox();  //��ʦ������
		
		return jp;
	}
	public void initTeacherBox(){             //��ʦ������
		SysTeacherDao dao = new SysTeacherDao();
		List teacherList = dao.select();
		for (Object object : teacherList){
			TeacherView bean = (TeacherView)object;
			teacherBox.addItem(bean);
		}
	}
	/*
	 * ���
	 */
	public JTable setTable(){
		colName.add("���");
		colName.add("����");
		colName.add("ѧ��");
		colName.add("�Ͽ�ʱ��");
		colName.add("�Ͽεص�");
		colName.add("�ον�ʦ");
		colName.add("�޶�����");
		colName.add("ѡ������");
		refresh();
		table.addMouseListener(new MouseAdapter(){
			public void mouseClicked(java.awt.event.MouseEvent arg0){
				int row = table.getSelectedRow();//ѡ��һ��
				cidtextField.setText(dtm.getValueAt(row, 0).toString());
				coursenameText.setText((String)dtm.getValueAt(row, 1));
				creditText.setText(dtm.getValueAt(row, 2).toString());
				ctimeText.setText((String)dtm.getValueAt(row, 3));
				caddressText.setText((String)dtm.getValueAt(row, 4));
				
				String teacher =  ((String)dtm.getValueAt(row, 5));
				for(int i=0;i<teacherBox.getModel().getSize();i++){
					TeacherView dep = (TeacherView)teacherBox.getItemAt(i);
					if(teacher.equals(dep.getTname())){
						teacherBox.setSelectedIndex(i);
						break;
					}
				}
				LimitnumberText.setText(dtm.getValueAt(row, 6).toString());
				truenumberText.setText(dtm.getValueAt(row, 7).toString());
			}
		});
		return table;
	}
	public void refresh(){   //ˢ�±��
		SysCourseDao dao = new SysCourseDao();
		List list = dao.select();
		Vector data = showTable (list);
		dtm.setDataVector(data,colName);
		table.setModel(dtm);
	}
	public Vector showTable(List list){
		Vector data = new Vector();
		for(int i=0;i<list.size();i++){
			CourseView bean = (CourseView)list.get(i);
			Vector vec = new Vector();
			vec.add(bean.getCid());
			vec.add(bean.getCoursename());
			vec.add(bean.getCredit());
			vec.add(bean.getCtime());
			vec.add(bean.getCaddress());
			vec.add(bean.getTeacher());
			vec.add(bean.getLimitnumber());
			vec.add(bean.getTurenumber());
			data.add(vec);
		}
		return data;
	}
	public void init(){
		JScrollPane jsp = new JScrollPane(setTable());
		final JSplitPane sp = new JSplitPane
	(JSplitPane.VERTICAL_SPLIT,jsp,setInfo());
		sp.addComponentListener(new ComponentAdapter() {  
            public void componentResized(ComponentEvent e) {  
            	sp.setDividerLocation(0.6);  
    }  
		}); 
		add(sp);
	}
	/*
	 * main����
	 */
    public static void main(String[] args) {
    	//SysCourseFrame course = new SysCourseFrame();
		new SysCourseFrame().setVisible(true);//���ڿɼ�

	}
//    public JPanel setInfo(){
//    	JPanel jp = new JPanel();
//    	jp.setLayout(null);
//    	JLabel label1 = new JLabel("��� ");
//    	label1.setBounds(50, 100, 40, 30);
//    	jp.add(label1);
//    	idText.setBounds(100, 50, 80, 30);
//    	jp.add(idText);
//    	
//    	JButton addBut = new JButton("����");
//    	addBut.setBounds(150, 100, 40, 30);
//    	jp.add(addBut);
//		return jp;
//    	
//    }
}

package com.gs.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.gs.bean.CourseView;
import com.gs.bean.Student;
import com.gs.bean.TeacherView;
import com.gs.dao.StudentDao;
import com.gs.dao.SysCourseDao;
/**
 * 
 * @author 
 * ѧ��ѡ�δ���
 */
public class StuSelectCourseFrame extends JFrame {

	private JPanel contentPane;
	private JTextField courseText;
	private JTable table = new JTable();// ���
	Vector colName = new Vector();
	DefaultTableModel dtm = new DefaultTableModel();
	/**
	 * Create the frame.
	 */
	public StuSelectCourseFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 800, 500);
		setResizable(false);
		//setTable();
		init();
		//setInfo();
		setVisible(true);
	}
	public JPanel setInfo(){
		JPanel jp = new JPanel();
		jp.setLayout(null);
		JLabel lblNewLabel = new JLabel("�γ̱��");
		lblNewLabel.setBounds(10, 10, 65, 27);
		jp.add(lblNewLabel);
		
		courseText = new JTextField();
		courseText.setBounds(85, 13, 108, 21);
		jp.add(courseText);
		courseText.setColumns(10);
		
		JButton seleButton = new JButton("ѡ��");
		seleButton.setBounds(226, 12, 93, 23);
		seleButton.addMouseListener(new MouseAdapter() {   //ѡ���¼� 
			
			 public void mouseClicked(MouseEvent e){
				    int cid = Integer.parseInt(courseText.getText());
				    Student bean = SelectiveMainFrame.student;
				    int sid = bean.getSid();
				    StudentDao dao = new StudentDao();
				    
				    int xuanzema = dao.getcountcid(cid,sid);
					System.out.println(xuanzema);
					if(xuanzema == 0) {
						 int i=dao.selective(sid, cid);
							refresh();
						    if(i==1){
						    	dao.addTruePeople(cid);
						    	//JOptionPane.showConfirmDialog(null, "ѡ�γɹ�");
						    	JOptionPane.showMessageDialog(null, "ѡ�γɹ�");
						    	refresh();
						    }else{
						    	//JOptionPane.showConfirmDialog(null, "ѡ��ʧ��");
						    	JOptionPane.showMessageDialog(null, "ѡ��ʧ��");
						    } 
					}else {
						JOptionPane.showMessageDialog(null, "�����ظ�ѡ��");
					}
   
				 }
			 });
		
		jp.add(seleButton);
	    return jp;
	}
	public  JTable setTable(){
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
				courseText.setText(dtm.getValueAt(row, 0).toString());
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
	(JSplitPane.VERTICAL_SPLIT,setInfo(),jsp);
		sp.addComponentListener(new ComponentAdapter() {  
            public void componentResized(ComponentEvent e) {  
            	sp.setDividerLocation(0.2);  
    }  
		}); 
		add(sp);
	}
}
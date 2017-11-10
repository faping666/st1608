package faping;
import java.awt.CardLayout;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * This code was edited or generated using CloudGarden's Jigloo
 * SWT/Swing GUI Builder, which is free for non-commercial
 * use. If Jigloo is being used commercially (ie, by a corporation,
 * company or business for any purpose whatever) then you
 * should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details.
 * Use of Jigloo implies acceptance of these licensing terms.
 * A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
 * THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
 * LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class SystemManager extends javax.swing.JPanel implements ActionListener,ItemListener{
	private JPanel jPanel1;
	private JLabel jLabel3;
	private JButton jButton1;
	private JTable jTable1;
	private JScrollPane jScrollPane1;
	private JComboBox jComboBox1;
	private JTextField etime;
	private JTextField btime;
	private JLabel jLabel2;
	private JLabel jLabel1;

	/**
	 * Auto-generated main method to display this 
	 * JPanel inside a new JFrame.
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new SystemManager());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	String item = "������ϸ";
	String btim;
	String etim;
	String etim1;
	StringBuffer sb ;


	/**
	 * ����ˢ�±��-���ۻ���
	 */
	public void Select() {
		Vector vector = new Vector();
		vector.add("��Ʒ����");
		vector.add("��Ʒ����");
		vector.add("��Ʒ���");
		vector.add("��Ʒ��λ");
		vector.add("��Ʒ����");
		vector.add("��������");
		vector.add("���۽��");
		Vector vector2 = DBManager.selectGID(btim,etim1);
		Vector v = new Vector();
		for (int i = 0; i < vector2.size(); i++) {
			v.add(DBManager.selectXSHZ(vector2.get(i).toString(), btim, etim1));
		}
		DefaultTableModel model = new DefaultTableModel(v, vector);
		jTable1.setModel(model);
	}



	/**
	 * ˢ��ȫ�����-���ۻ���
	 */
	public void SelectAll() {
		//	public void addall() {
		Vector vector = new Vector();
		vector.add("��Ʒ����");
		vector.add("��Ʒ����");
		vector.add("��Ʒ���");
		vector.add("��Ʒ��λ");
		vector.add("��Ʒ����");
		vector.add("��������");
		vector.add("���۽��");
		Vector vector2 = DBManager.selectGID();
		Vector v = new Vector();
		for (int i = 0; i < vector2.size(); i++) {
			v.add(DBManager.selectXSHZ(vector2.get(i).toString()));
		}
		DefaultTableModel model = new DefaultTableModel(v, vector);
		jTable1.setModel(model);
	}


	/**
	 * ˢ��ȫ�����--������ϸ
	 */
	public void addall() {
		Vector vector = new Vector();
		vector.add("����ʱ��");
		vector.add("��ˮ��");
		vector.add("��Ʒ����");
		vector.add("����");
		vector.add("���");
		vector.add("��λ");
		vector.add("��Ʒ����");
		vector.add("��������");
		vector.add("��������");
		vector.add("�������");
		vector.add("������");
		DefaultTableModel model = new DefaultTableModel(DBManager.selectjhmx(), vector);
		jTable1.setModel(model);
	}

	/**
	 * ����ˢ�±��--������ϸ
	 */
	public void add() {
		Vector vector = new Vector();
		vector.add("����ʱ��");
		vector.add("��ˮ��");
		vector.add("��Ʒ����");
		vector.add("����");
		vector.add("���");
		vector.add("��λ");
		vector.add("��Ʒ����");
		vector.add("��������");
		vector.add("��������");
		vector.add("�������");
		vector.add("������");
		DefaultTableModel model = new DefaultTableModel(DBManager.selectjhmx(btim,etim1), vector);
		jTable1.setModel(model);
	}



	public SystemManager() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			this.setLayout(null);
			setPreferredSize(new Dimension(680, 480));
			this.setBackground(new java.awt.Color(208,244,244));
			{
				jPanel1 = new JPanel();
				this.add(jPanel1);
				jPanel1.setBounds(0, 0, 680, 46);
				jPanel1.setLayout(null);
				jPanel1.setBackground(new java.awt.Color(239,239,223));
				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1);
					jLabel1.setBounds(0, 0, 109, 46);
					jLabel1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("imgs/mainlogo (8).jpg")));
				}
			}
			{
				jLabel2 = new JLabel();
				this.add(jLabel2);
				jLabel2.setText("\u67e5\u8be2");
				jLabel2.setBounds(34, 65, 46, 17);
			}
			{
				btime = new DatePicker();
				this.add(btime);
				btime.setBounds(80, 62, 107, 24);
				btime.setSize(110, 24);
				btime.setEditable(false);
			}
			{
				jLabel3 = new JLabel();
				this.add(jLabel3);
				jLabel3.setText("\u81f3");
				jLabel3.setBounds(205, 65, 25, 17);
			}
			{
				etime = new DatePicker();
				this.add(etime);
				etime.setBounds(248, 62, 109, 24);
				etime.setSize(110, 24);
				etime.setEditable(false);
			}
			{
				ComboBoxModel jComboBox1Model = 
					new DefaultComboBoxModel(
							new String[] { "������ϸ", "��������","������ϸ","���ۻ���" ,"��Ա��ֵ��ϸ"});
				jComboBox1 = new JComboBox();
				this.add(jComboBox1);
				jComboBox1.setModel(jComboBox1Model);
				jComboBox1.setBounds(406, 61, 109, 24);
				jComboBox1.addItemListener(this);
				jComboBox1.setSelectedIndex(0);
			}
			{
				jButton1 = new JButton();
				this.add(jButton1);
				jButton1.setText("\u786e\u5b9a");
				jButton1.setBounds(569, 62, 61, 24);
				jButton1.addActionListener(this);
			}
			{
				jScrollPane1 = new JScrollPane();
				this.add(jScrollPane1);
				jScrollPane1.setBounds(0, 101, 680, 334);
				{
					jTable1 = new JTable();
					jScrollPane1.setViewportView(jTable1);
					jTable1.setBounds(17, 253, 283, 156);
					addall();
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * ������ϸ
	 */
	public void settableXSMX() {
		Vector vector=new Vector();
		vector.add("����ʱ��");
		vector.add("������ˮ��");
		vector.add("��Ʒ����");
		vector.add("����");
		vector.add("���");
		vector.add("��λ");
		vector.add("��Ʒ����");
		vector.add("��������");
		vector.add("���۵���");
		vector.add("���۽��");
		vector.add("��Ա����");
		vector.add("����Ա");
		DefaultTableModel model=new DefaultTableModel(DBManager.xiaoshoumingxiselect(),vector);
		jTable1.setModel(model);
	}
	//	public void settableXSHZ() {
	//		Vector vector=new Vector();
	//		vector.add("��Ʒ����");
	//		vector.add("��Ʒ����");
	//		vector.add("��Ʒ���");
	//		vector.add("��Ʒ��λ");
	//		vector.add("��Ʒ����");
	//		vector.add("��������");
	//	    vector.add("���۽��");
	//        DefaultTableModel model=new DefaultTableModel(DBManager.xiaoshoumingxiselect(),vector);
	//		jTable1.setModel(model);
	//	}
	/**
	 * ��Ա��ֵ��ϸ
	 */
	public void settableHYCZMX() {
		Vector vector=new Vector();
		vector.add("��ֵʱ��");
		vector.add("��Ա����");
		vector.add("��Ա����");
		vector.add("��ֵ���");
		vector.add("����Ա");
		DefaultTableModel model=new DefaultTableModel(DBManager.huiyuanchongzhimingxiselect(),vector);
		jTable1.setModel(model);
	}
	/**
	 * ��������
	 */
	public void settableJHHZ() {
		Vector vector=new Vector();
		vector.add("��Ʒ����");
		vector.add("��Ʒ����");
		vector.add("��Ʒ���");
		vector.add("��Ʒ��λ");
		vector.add("��Ʒ����");
		vector.add("��������");
		vector.add("�������");

		DefaultTableModel model=new DefaultTableModel(DBManager.jinhuohuizongselect(),vector);
		jTable1.setModel(model);
	}

	/**
	 * ��ղ�ѯ��
	 */
	public void reset() {
		this.btime.setText("");
		this.etime.setText("");
	}
	int etimei = 0;
	int btimei = 0;
	/**
	 * ������ѯ�߼�
	 */
	public void selectinfo() {
		String etime1 = etim.replaceAll("-", "");//ȥ��ʱ���е�-
		String btime1 = btim.replaceAll("-","");
		btimei =Integer.parseInt(btime1);
		etimei = Integer.parseInt(etime1);
		sb = new StringBuffer(etim);
		sb.insert(10, " 23:59:59");
		etim1 = sb.toString();
		//		StringBuilder sb = new StringBuilder(etim1);//����һ��StringBuilder����
		//		sb.insert(4, "-");//��ָ����λ�ã������ַ��� -
		//		sb.insert(7, "-");
		//		etim1 = sb.toString();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object object = e.getSource();
		if (object==jButton1) {
			btim = btime.getText().toString().trim(); //��ȡ��ʼʱ��
			etim = etime.getText().toString().trim(); //��ȡ����ʱ��
			if (item.equals("������ϸ")) {
				if (btim.length()<=4||etim.length()<=4) {
					addall();
				} else {
					selectinfo();
					if (btimei>etimei) {
						selectinfo();
						reset();
					} else {	
						add();
						reset();
					} 
				}
			}
			else if (item.equals("���ۻ���")) {
				if (btim.length()<=4||etim.length()<=4) {
					SelectAll();
				} else {
					selectinfo();
					if (btimei>etimei) {
						JOptionPane.showMessageDialog(this, "              ��ѯʧ��!\n����ʱ�䲻��С�ڿ�ʼʱ��");
						reset();
					} else {
						Select();
						reset();
					} 
				}
			}else if (item.equals("��������")) {
				if (btim.length()<=4||etim.length()<=4) {
					settableJHHZ();
				} else {
					selectinfo();
					if (btimei>etimei) {
						JOptionPane.showMessageDialog(this, "              ��ѯʧ��!\n����ʱ�䲻��С�ڿ�ʼʱ��");
						reset();
					} else {
						Vector vector=new Vector();
						vector.add("��Ʒ����");
						vector.add("��Ʒ����");
						vector.add("��Ʒ���");
						vector.add("��Ʒ��λ");
						vector.add("��Ʒ����");
						vector.add("��������");
						vector.add("�������");
						DefaultTableModel model=new DefaultTableModel(DBManager.jinhuohuizongselect(btim, etim1),vector);
						jTable1.setModel(model);
						reset();
					} 
				}
			}else if (item.equals("������ϸ")) {
				if (btim.length()<=4||etim.length()<=4) {
					 settableXSMX();
				} else {
					selectinfo();
					if (btimei>etimei) {
						JOptionPane.showMessageDialog(this, "              ��ѯʧ��!\n����ʱ�䲻��С�ڿ�ʼʱ��");
						reset();
					} else {
						Vector vector=new Vector();
						vector.add("����ʱ��");
						vector.add("������ˮ��");
						vector.add("��Ʒ����");
						vector.add("����");
						vector.add("���");
						vector.add("��λ");
						vector.add("��Ʒ����");
						vector.add("��������");
						vector.add("���۵���");
						vector.add("���۽��");
						vector.add("��Ա����");
						vector.add("����Ա");
						DefaultTableModel model=new DefaultTableModel(DBManager.xiaoshoumingxiselect(btim, etim1),vector);
						jTable1.setModel(model);
						reset();
					} 
				}
			}else if (item.equals("��Ա��ֵ��ϸ")) {
				if (btim.length()<=4||etim.length()<=4) {
					settableHYCZMX();
				} else {
					selectinfo();
					if (btimei>etimei) {
						JOptionPane.showMessageDialog(this, "              ��ѯʧ��!\n����ʱ�䲻��С�ڿ�ʼʱ��");
						reset();
					} else {
						Vector vector=new Vector();
						vector.add("��ֵʱ��");
						vector.add("��Ա����");
						vector.add("��Ա����");
						vector.add("��ֵ���");
						vector.add("����Ա");
						DefaultTableModel model=new DefaultTableModel(DBManager.huiyuanchongzhimingxiselect(btim, etim1),vector);
						jTable1.setModel(model);
						reset();
					} 
				}
			}
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if (e.getStateChange()==ItemEvent.SELECTED) {
			//			item = e.getItem().toString();
			item = jComboBox1.getSelectedItem().toString();
			if (item.equals("������ϸ")) {
				addall();
			} else if (item.equals("���ۻ���")) {
				SelectAll();
			} else if (item.equals("��������")) {
				settableJHHZ();
			}else if (item.equals("������ϸ")) {
				settableXSMX();
			}else if (item.equals("��Ա��ֵ��ϸ")) {
				settableHYCZMX();
			}

		}
	}

}

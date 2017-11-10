package faping;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
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
public class VIP extends javax.swing.JPanel implements ActionListener,MouseListener,KeyListener,ItemListener{
	private JPanel jPanel1;
	private JScrollPane jScrollPane1;
	private JButton jButton1;
	private JLabel jLabel5;
	private JButton jButton2;
	private JTextField jTextField1;
	private JLabel jLabel9;
	private JLabel jLabel8;
	private JComboBox jComboBox1;
	private JLabel jLabel7;
	private JButton update;
	private JButton jButton3;
	private JTextField jTextField2;
	private JLabel jLabel10;
	private JButton reset;
	private JButton del;
	private JButton insert;
	private JTextField brith;
	private JTextField name;
	private JLabel jLabel6;
	private JTextField Tel;
	private JTextField VIPID;
	private JLabel jLabel4;
	private JLabel jLabel3;
	private JTextField select;
	private JLabel jLabel2;
	private JTable jTable1;
	private JLabel jLabel1;
	DatePicker datePicker = new DatePicker();
	String uid;
	String id ;
	String vname;
	String tel;
	double score;
	String birth;
	String score1;
	String inif;
	int vscore;
	int sscore;
	/**
	 * Auto-generated main method to display this 
	 * JPanel inside a new JFrame.
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new VIP());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public VIP() {
		super();
		initGUI();
		addall();
	}


	/**
	 * 刷新全部表格
	 */
	public void addall() {
		Vector vector = new Vector();
		vector.add("会员卡号");
		vector.add("姓名");
		vector.add("生日");
		vector.add("电话");
		vector.add("消费总金额");
		vector.add("积分");
		vector.add("消费次数");
		vector.add("积分率");
		vector.add("余额");
		DefaultTableModel model = new DefaultTableModel(DBManager.selectallvip(), vector);
		jTable1.setModel(model);
	}



	/**
	 * 条件刷新表格
	 */
	public void add() {
		Vector vector = new Vector();
		vector.add("会员卡号");
		vector.add("姓名");
		vector.add("生日");
		vector.add("电话");
		vector.add("消费总金额");
		vector.add("积分");
		vector.add("消费次数");
		vector.add("积分率");
		vector.add("余额");
		DefaultTableModel model = new DefaultTableModel(DBManager.selectvip(inif), vector);
		jTable1.setModel(model);
	}


	/**
	 * 模糊查询逻辑
	 */
	public void select() {
		inif = select.getText();
		DBManager.selectvip(inif);
		add();
	}
	private void initGUI() {
		try {
			this.setPreferredSize(new java.awt.Dimension(680, 480));
			this.setSize(680, 480);
			this.setLayout(null);
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
					jLabel1.setBounds(0, 0, 120, 46);
					jLabel1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("imgs/huiyuanguanli.jpg")));
				}
			}
			{
				jScrollPane1 = new JScrollPane();
				this.add(jScrollPane1);
				jScrollPane1.setBounds(0, 108, 680, 149);
				{

					jTable1 = new JTable();
					jScrollPane1.setViewportView(jTable1);
					jTable1.setBounds(84, 133, 229, 80);
					addall();
					jTable1.addMouseListener(this);
				}
			}
			{
				jLabel2 = new JLabel();
				this.add(jLabel2);
				jLabel2.setText("\u8f93\u5165\u5173\u952e\u5b57(\u5361\u53f7/\u59d3\u540d/\u7535\u8bdd)\uff1a");
				jLabel2.setBounds(83, 67, 184, 17);
			}
			{
				select = new JTextField();
				this.add(select);
				select.setBounds(285, 64, 180, 24);
				select.addKeyListener(this);
			}
			{
				jButton1 = new JButton();
				this.add(jButton1);
				jButton1.setText("\u67e5\u8be2");
				jButton1.setBounds(518, 64, 74, 24);
				jButton1.addActionListener(this);
			}
			{
				jLabel3 = new JLabel();
				this.add(jLabel3);
				jLabel3.setText("\u5361\u53f7\uff1a");
				jLabel3.setBounds(12, 285, 47, 17);
			}
			{
				jLabel4 = new JLabel();
				this.add(jLabel4);
				jLabel4.setText("\u7535\u8bdd\uff1a");
				jLabel4.setBounds(12, 327, 47, 17);
			}
			{
				VIPID = new JTextField();
				this.add(VIPID);
				VIPID.setBounds(57, 282, 100, 24);
			}
			{
				Tel = new JTextField();
				this.add(Tel);
				Tel.setBounds(57, 324, 100, 24);
			}
			{
				jLabel5 = new JLabel();
				this.add(jLabel5);
				jLabel5.setText("\u59d3\u540d\uff1a");
				jLabel5.setBounds(195, 285, 49, 17);
			}
			{
				jLabel6 = new JLabel();
				this.add(jLabel6);
				jLabel6.setText("\u751f\u65e5\uff1a");
				jLabel6.setBounds(195, 327, 49, 17);
			}
			{
				name = new JTextField();
				this.add(name);
				name.setBounds(256, 282, 100, 24);
			}
			{
				brith = new DatePicker();
				this.add(brith);
				brith.setBounds(256, 324, 100, 24);
				brith.setEditable(false);
			}
			{
				update = new JButton();
				this.add(update);
				update.setText("\u4fee\u6539");
				update.setBounds(593, 297, 60, 24);
				update.addActionListener(this);
			}
			{
				insert = new JButton();
				this.add(insert);
				insert.setText("\u6dfb\u52a0");
				insert.setBounds(459, 297, 60, 24);
				insert.addActionListener(this);
			}
			{
				del = new JButton();
				this.add(del);
				del.setText("\u5220\u9664");
				del.setBounds(459, 351, 60, 24);
				del.addActionListener(this);
			}
			{
				reset = new JButton();
				this.add(reset);
				reset.setText("\u6e05\u7a7a");
				reset.setBounds(593, 351, 60, 24);
				reset.addActionListener(this);
			}
			{
				jLabel7 = new JLabel();
				this.add(jLabel7);
				jLabel7.setText("\u79ef\u5206\u7387\uff1a");
				jLabel7.setBounds(189, 368, 55, 17);
			}
			{
				ComboBoxModel jComboBox1Model = 
					new DefaultComboBoxModel(
							new String[] { "1.0", "1.1" ,"1.2","1.5"});
				jComboBox1 = new JComboBox();
				this.add(jComboBox1);
				jComboBox1.setModel(jComboBox1Model);
				jComboBox1.setBounds(256, 368, 100, 24);
				jComboBox1.addItemListener(this);
			}
			{
				jLabel8 = new JLabel();
				this.add(jLabel8);
				jLabel8.setBounds(8, 407, 661, 61);
				jLabel8.setBorder(BorderFactory.createTitledBorder(null, "\u5145\u503c/\u5151\u5956", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft YaHei UI",1,12), new java.awt.Color(255,0,0)));
				jLabel8.setForeground(new java.awt.Color(0,0,255));
			}
			{
				jLabel9 = new JLabel();
				this.add(jLabel9);
				jLabel9.setText("\u8f93\u5165\u5151\u5956\u79ef\u5206:");
				jLabel9.setBounds(12, 433, 109, 17);
			}
			{
				jTextField1 = new JTextField();
				this.add(jTextField1);
				jTextField1.setBounds(99, 430, 105, 24);
			}
			{
				jButton2 = new JButton();
				this.add(jButton2);
				jButton2.setText("\u5151\u5956");
				jButton2.setBounds(213, 430, 62, 24);
				jButton2.addActionListener(this);
			}
			{
				jLabel10 = new JLabel();
				this.add(jLabel10);
				jLabel10.setText("\u8f93\u5165\u5145\u503c\u91d1\u989d:");
				jLabel10.setBounds(314, 433, 100, 17);
			}
			{
				jTextField2 = new JTextField();
				this.add(jTextField2);
				jTextField2.setBounds(406, 430, 94, 24);
			}
			{
				jButton3 = new JButton();
				this.add(jButton3);
				jButton3.setText("\u5145\u503c");
				jButton3.setBounds(530, 430, 66, 24);
				jButton3.addActionListener(this);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		id = VIPID.getText();
		vname = name.getText();
		tel = Tel.getText();
		score1 = jComboBox1.getSelectedItem().toString();
		score = Double.parseDouble(score1);
		birth = brith.getText();
		Object object = e.getSource();
		if (object==reset) {
			select.setText("");
			VIPID.setText("");
			Tel.setText("");
			name.setText("");
			brith.setText("");
			jComboBox1.setSelectedIndex(0);
			jTextField1.setText("");
			jTextField2.setText("");
			VIPID.setEditable(true);
		} else if (object==jButton2) {
			String str = jTextField1.getText().trim();
			if (str.equals("")) {
				JOptionPane.showMessageDialog(this, "兑换积分输入有误！");
			} else {
				try {
					while(!str.matches("\\d+"))
					{
						JOptionPane.showMessageDialog(this, "兑换积分输入有误！");
						jTextField1.setText("");
						return;
					}
				}catch (Exception e1) {
					// TODO: handle exception
				}	
				vscore = Integer.parseInt(str);
				if (vscore>sscore) {
					JOptionPane.showMessageDialog(this, "积分不足,兑换失败！");
					jTextField1.setText("");
				} else {
					DBManager.updatescore(id, vscore);
					JOptionPane.showMessageDialog(this, "兑换成功！");
					select.setText(id);
					select();
					select.setText("");
				}
			}
		} else if (object==del) {
			DBManager.delVIP(id);
			addall();
		}else if (object==jButton1) {
			select();
		}else if (object==jButton3) {
			String money = jTextField2.getText();
			if (money.trim().equals("")) {
				JOptionPane.showMessageDialog(this, "请输入正确的充值金额！");
			} else {
				try {
					while(!money.matches("\\d+"))
					{
						JOptionPane.showMessageDialog(this, "请输入正确的充值金额！");
						return;
					}
				}catch (Exception e1) {
					// TODO: handle exception
				}	
				double money1 = Double.parseDouble(money);

				if (money1<=0) {
					JOptionPane.showMessageDialog(this, "请输入正确的充值金额！");
				} else {			
					JOptionPane.showMessageDialog(this, "请确认\nVIP卡号:"+id+"\n充值金额:"+money);
					DBManager.vbalance(money1, id);
					DBManager.topUpVIP(id, DBManager.getDate(), money1, uid);
					JOptionPane.showMessageDialog(this, "充值成功！");
					select.setText(id);
					select();
					select.setText("");
				}
			}
		}
		else {
			if (id.trim().equals("")||vname.trim().equals("")||tel.trim().equals("")||birth.trim().equals("")) {
				JOptionPane.showMessageDialog(null, "选项不能为空！");
			} else {	
				if (object==insert) {
					try {
						while(!tel.matches("\\d+"))
						{
							JOptionPane.showMessageDialog(this, "请输入正确的电话！");
							return;
						}
					}catch (Exception e1) {
						// TODO: handle exception
					}	
					DBManager.insertVIP(id, vname, tel, score, birth);
					addall();
				} else if (object==update) {
					try {
						while(!tel.matches("\\d+"))
						{
							JOptionPane.showMessageDialog(this, "请输入正确的电话！");
							return;
						}
					}catch (Exception e1) {
						// TODO: handle exception
					}	
					DBManager.updateVIP(vname, tel, birth, score, id);
					addall();
				}
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = jTable1.getSelectedRow();
		id = (String) jTable1.getValueAt(row, 0);
		vname = jTable1.getValueAt(row, 1).toString();
		birth = jTable1.getValueAt(row, 2).toString();
		tel = jTable1.getValueAt(row, 3).toString();
		score1 = (String) jTable1.getValueAt(row, 7);
		String str = (String) jTable1.getValueAt(row, 5);
		sscore =Integer.parseInt(str);
		VIPID.setText(id);
		VIPID.setEditable(false);
		name.setText(vname);
		Tel.setText(tel);
		brith.setText(birth);
		if (score1.equals("1.0000")) {
			jComboBox1.setSelectedIndex(0);
		} else if (score1.equals("1.1000")) {
			jComboBox1.setSelectedIndex(1);
		}else if (score1.equals("1.2000")) {
			jComboBox1.setSelectedIndex(2);
		}else if (score1.equals("1.5000")) {
			jComboBox1.setSelectedIndex(3);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		select();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub

	}

}

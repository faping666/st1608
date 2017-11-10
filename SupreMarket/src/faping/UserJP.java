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
import javax.swing.JOptionPane;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
public class UserJP extends javax.swing.JPanel implements ActionListener,ItemListener,KeyListener,MouseListener{
	private JPanel jPanel1;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JButton update;
	private JButton reste;
	private JButton del;
	private JButton insert;
	private JTextField uid;
	private JScrollPane jScrollPane1;
	private JComboBox jComboBox1;
	private JTextField uuser;
	private JTextField upwd;
	private JLabel jLabel8;
	private JLabel jLabel7;
	private JLabel jLabel6;
	private JTable jTable1;
	private JPanel jPanel2;
	private JButton select;
	private JTextField uname;
	private JLabel jLabel2;
	private JLabel jLabel1;
	String name;
	String id;
	String pwd;
	String user;
	String job;
	int job1;
	String sname;
	String uid1;
	JFrame main;
	/**
	 * Auto-generated main method to display this 
	 * JPanel inside a new JFrame.
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new UserJP());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public UserJP() {
		super();
		initGUI();
		addall();
	}
	/**
	 * 刷新表格全部数据
	 */

	public void addall() {
		Vector vector = new Vector();
		vector.add("账号");
		vector.add("密码");
		vector.add("真实姓名");
		vector.add("角色");
		DefaultTableModel model = new DefaultTableModel(DBManager.selectuserall(), vector);
		jTable1.setModel(model);
	}

	/**
	 * 条件刷新表格数据
	 */

	public void add() {
		Vector vector = new Vector();
		vector.add("账号");
		vector.add("密码");
		vector.add("真实姓名");
		vector.add("角色");
		DefaultTableModel model = new DefaultTableModel(DBManager.selectuser(sname), vector);
		jTable1.setModel(model);
	}

	/**
	 * 模糊查询逻辑
	 */
	public void select() {
		sname = uname.getText().toString();
		DBManager.selectuser(sname);
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
				jPanel1.setBounds(0, 0, 680, 76);
				jPanel1.setSize(680, 46);
				jPanel1.setLayout(null);
				jPanel1.setBackground(new java.awt.Color(239,239,223));
				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1);
					jLabel1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("imgs/mainlogo (7).jpg")));
					jLabel1.setBounds(0, 0, 122, 44);
				}
			}
			{
				jLabel2 = new JLabel();
				this.add(jLabel2);
				jLabel2.setBounds(22, 78, 356, 375);
				jLabel2.setBorder(BorderFactory.createTitledBorder("用户信息"));
			}
			{
				jLabel3 = new JLabel();
				this.add(jLabel3);
				jLabel3.setText("\u8d26\u53f7\u6216\u59d3\u540d\uff1a");
				jLabel3.setBounds(39, 123, 82, 17);
			}
			{
				uname = new JTextField();
				this.add(uname);
				uname.setBounds(133, 120, 105, 24);
				uname.addKeyListener(this);
			}
			{
				select = new JButton();
				this.add(select);
				select.setText("\u67e5\u8be2");
				select.setBounds(260, 122, 70, 24);
				select.setSize(70, 24);
				select.addActionListener(this);
			}
			{
				jPanel2 = new JPanel();
				this.add(jPanel2);
				jPanel2.setBounds(27, 184, 351, 263);
				jPanel2.setLayout(null);
				{
					jScrollPane1 = new JScrollPane();
					jPanel2.add(jScrollPane1);
					jScrollPane1.setBounds(0, 0, 347, 263);
					{
						
						jTable1 = new JTable();
						jScrollPane1.setViewportView(jTable1);
						jTable1.setBounds(0, 0, 127, 105);
						addall();
						jTable1.addMouseListener(this);
					}
				}
			}
			{
				jLabel4 = new JLabel();
				this.add(jLabel4);
				jLabel4.setBounds(406, 78, 262, 361);
				jLabel4.setBorder(BorderFactory.createTitledBorder("资料维护"));
			}
			{
				jLabel5 = new JLabel();
				this.add(jLabel5);
				jLabel5.setText("\u8d26\u53f7\uff1a");
				jLabel5.setBounds(423, 155, 60, 17);
				jLabel5.setSize(50, 17);
			}
			{
				jLabel6 = new JLabel();
				this.add(jLabel6);
				jLabel6.setText("\u5bc6\u7801\uff1a");
				jLabel6.setBounds(423, 198, 50, 17);
			}
			{
				jLabel7 = new JLabel();
				this.add(jLabel7);
				jLabel7.setText("\u771f\u5b9e\u59d3\u540d\uff1a");
				jLabel7.setBounds(423, 234, 69, 17);
			}
			{
				jLabel8 = new JLabel();
				this.add(jLabel8);
				jLabel8.setText("\u89d2\u8272\uff1a");
				jLabel8.setBounds(423, 276, 50, 17);
			}
			{
				uid = new JTextField();
				this.add(uid);
				uid.setBounds(515, 152, 10, 24);
				uid.setSize(90, 24);
			}
			{
				upwd = new JTextField();
				this.add(upwd);
				upwd.setBounds(515, 197, 10, 24);
				upwd.setSize(90, 24);
			}
			{
				uuser = new JTextField();
				this.add(uuser);
				uuser.setBounds(515, 233, 10, 24);
				uuser.setSize(90, 24);
			}
			{
				ComboBoxModel jComboBox1Model =  
					new DefaultComboBoxModel(
							new String[] { "收银员", "管理员" });
				jComboBox1 = new JComboBox();
				this.add(jComboBox1);
				jComboBox1.setModel(jComboBox1Model);
				jComboBox1.setBounds(515, 274, 25, 24);
				jComboBox1.setSize(90, 24);
				jComboBox1.addItemListener(this);
			}
			{
				insert = new JButton();
				this.add(insert);
				insert.setText("\u6dfb\u52a0");
				insert.setBounds(440, 334, 38, 24);
				insert.setSize(70, 24);
				insert.setPreferredSize(new java.awt.Dimension(14, 7));
				insert.addActionListener(this);
			}
			{
				update = new JButton();
				this.add(update);
				update.setText("\u4fee\u6539");
				update.setBounds(544, 334, 38, 24);
				update.setSize(70, 24);
				update.setPreferredSize(new java.awt.Dimension(14, 7));
				update.addActionListener(this);
			}
			{
				del = new JButton();
				this.add(del);
				del.setText("\u5220\u9664");
				del.setBounds(440, 391, 38, 24);
				del.setSize(70, 24);
				del.setPreferredSize(new java.awt.Dimension(14, 7));
				del.addActionListener(this);
			}
			{
				reste = new JButton();
				this.add(reste);
				reste.setText("\u6e05\u7a7a");
				reste.setBounds(544, 391, 38, 24);
				reste.setSize(70, 24);
				reste.setPreferredSize(new java.awt.Dimension(14, 7));
				reste.addActionListener(this);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object object = e.getSource();
		id = uid.getText();
		pwd = upwd.getText();
		name = uuser.getText();
		job = jComboBox1.getSelectedItem().toString();
		if (object==reste) {
			uname.setText("");
			uid.setText("");
			upwd.setText("");
			uuser.setText("");
			jComboBox1.setSelectedIndex(0);
		} else if (object==del) {
			if (id.equals(uid1)) {
				JOptionPane.showMessageDialog(this, "当前登录账号不允许删除");
			} else {
			DBManager.deluser(id);
			addall();
			}
		}else if (object==select) {
			select();
		}else if (uname.getText().trim().equals("")&&uid.getText().trim().equals("")&&upwd.getText().trim().equals("")&&uuser.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "有选项未填！");

		}else {
			if (object==insert) {
				DBManager.insertsupp(id, pwd, name, job);
				addall();
				JOptionPane.showMessageDialog(this, "修改成功！");
			} else if (object==update) {
				DBManager.updateuser(pwd, name, job, id);
				addall();
				if (id.equals(uid1)&&job.equals("收银员")) {
					JOptionPane.showMessageDialog(this, "当前登录用户权限发生改变,确定后退出！");
//					main
					LoginJFrame login = new LoginJFrame();
					login.setVisible(true);
					main.setVisible(false);
					login.setLocationRelativeTo(null);
					return;
					
				}
			}
		}
	}
	

	@Override
	public void itemStateChanged(ItemEvent e) {
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
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = jTable1.getSelectedRow();
		id = jTable1.getValueAt(row, 0).toString();
		pwd = jTable1.getValueAt(row, 1).toString();
		user = jTable1.getValueAt(row, 2).toString();
		job = jTable1.getValueAt(row, 3).toString();

		uid.setText(id);
		upwd.setText(pwd);
		uuser.setText(user);
		if (job.equals("收银员")) {
			job1=0;
		} else {
			job1=1;
		}
		jComboBox1.setSelectedIndex(job1);
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

}

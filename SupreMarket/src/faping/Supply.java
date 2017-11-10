package faping;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

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
public class Supply extends javax.swing.JPanel implements ActionListener,KeyListener,MouseListener{
	private JPanel jPanel1;
	private JLabel jLabel3;
	private JScrollPane jScrollPane1;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JButton update;
	private JButton reset;
	private JButton del;
	private JButton insert;
	private JTextField GPuser;
	private JTextField GPadd;
	private JLabel jLabel7;
	private JLabel jLabel6;
	private JTextField GPtel;
	private JTextField GPname;
	private JTable jTable1;
	private JButton select;
	private JTextField inputsupp;
	private JLabel jLabel2;
	private JLabel jLabel1;
	String inputs;
	int gpid;
	String gpname ; 
	String gptel;
	String gpuser;
	String gpadd;

	/**
	 * Auto-generated main method to display this 
	 * JPanel inside a new JFrame.
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new Supply());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public Supply() {
		super();
		initGUI();
	}

	/**
	 * 刷新全部表格
	 */
	public void addall() {
		Vector vector = new Vector();
		vector.add("供货商编号");
		vector.add("供货商名称");
		vector.add("电话");
		vector.add("地址");
		vector.add("联系人");
		DefaultTableModel model = new DefaultTableModel(DBManager.selectallsup(), vector);
		jTable1.setModel(model);
	}

	/**
	 * 条件刷新表格
	 */
	public void add() {
		Vector vector = new Vector();
		vector.add("供货商编号");
		vector.add("供货商名称");
		vector.add("电话");
		vector.add("地址");
		vector.add("联系人");
		DefaultTableModel model = new DefaultTableModel(DBManager.selectsup(inputs), vector);
		jTable1.setModel(model);
	}

	/**
	 * 模糊查询逻辑
	 */
	public void select() {
		inputs = inputsupp.getText().toString();
		DBManager.selectsup(inputs);
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
					jLabel1.setBounds(0, 0, 108, 34);
					jLabel1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("imgs/gonghuoguanli.jpg")));
				}
			}
			{
				jLabel2 = new JLabel();
				this.add(jLabel2);
				jLabel2.setBounds(1, 51, 680, 268);
				jLabel2.setBorder(BorderFactory.createTitledBorder(""));
			}
			{
				jLabel3 = new JLabel();
				this.add(jLabel3);
				jLabel3.setText("\u8f93\u5165\u5173\u952e\u5b57(\u4f9b\u8d27\u5546\u540d\u79f0/\u7535\u8bdd):");
				jLabel3.setBounds(66, 84, 237, 17);
			}
			{
				inputsupp = new JTextField();
				this.add(inputsupp);
				inputsupp.setBounds(324, 80, 127, 24);
				inputsupp.addKeyListener(this);
			}
			{
				select = new JButton();
				this.add(select);
				select.setText("\u67e5\u8be2");
				select.setBounds(526, 83, 66, 24);
				select.addActionListener(this);
			}
			{
				jScrollPane1 = new JScrollPane();
				this.add(jScrollPane1);
				jScrollPane1.setBounds(0, 132, 680, 178);
				{
					jTable1 = new JTable();
					jScrollPane1.setViewportView(jTable1);
					jTable1.setBounds(3, 169, 306, 69);
					addall();
					jTable1.addMouseListener(this);
				}
			}
			{
				jLabel4 = new JLabel();
				this.add(jLabel4);
				jLabel4.setText("\u4f9b\u8d27\u5546\u540d\u79f0\uff1a");
				jLabel4.setBounds(39, 362, 86, 17);
			}
			{
				jLabel5 = new JLabel();
				this.add(jLabel5);
				jLabel5.setText("\u4f9b\u8d27\u5546\u7535\u8bdd\uff1a");
				jLabel5.setBounds(39, 406, 86, 17);
			}
			{
				GPname = new JTextField();
				this.add(GPname);
				GPname.setBounds(125, 359, 112, 24);
				GPname.setSize(100, 24);
				GPname.addActionListener(this);
			}
			{
				GPtel = new JTextField();
				this.add(GPtel);
				GPtel.setBounds(125, 403, 111, 24);
				GPtel.setSize(100, 24);
				GPtel.addActionListener(this);
			}
			{
				jLabel6 = new JLabel();
				this.add(jLabel6);
				jLabel6.setText("\u8054\u7cfb\u4eba\uff1a");
				jLabel6.setBounds(247, 407, 77, 17);
			}
			{
				jLabel7 = new JLabel();
				this.add(jLabel7);
				jLabel7.setText("\u5730\u5740\uff1a");
				jLabel7.setBounds(247, 362, 77, 17);
			}
			{
				GPadd = new JTextField();
				this.add(GPadd);
				GPadd.setBounds(304, 359, 100, 24);
				GPadd.addActionListener(this);
			}
			{
				GPuser = new JTextField();
				this.add(GPuser);
				GPuser.setBounds(305, 404, 100, 24);
				GPuser.addActionListener(this);
			}
			{
				insert = new JButton();
				this.add(insert);
				insert.setText("\u6dfb\u52a0");
				insert.setBounds(449, 352, 38, 24);
				insert.setSize(60, 24);
				insert.addActionListener(this);
			}
			{
				del = new JButton();
				this.add(del);
				del.setText("\u5220\u9664");
				del.setBounds(449, 404, 38, 24);
				del.setSize(60, 24);
				del.addActionListener(this);
			}
			{
				update = new JButton();
				this.add(update);
				update.setText("\u4fee\u6539");
				update.setBounds(544, 352, 38, 24);
				update.setSize(60, 24);
				update.addActionListener(this);
			}
			{
				reset = new JButton();
				this.add(reset);
				reset.setText("\u6e05\u7a7a");
				reset.setBounds(544, 404, 38, 24);
				reset.setSize(60, 24);
				reset.addActionListener(this);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		gpname = GPname.getText(); 
		gptel = GPtel.getText();
		gpuser = GPuser.getText();
		gpadd = GPadd.getText();
		Object object = e.getSource();
		if (object==select) {
			select();
		}else if (object==reset) {
			inputsupp.setText("");
			GPname.setText("");
			GPtel.setText("");
			GPuser.setText("");
			GPadd.setText("");
		} else if (object==del) {
			DBManager.delsup(gpid);
			addall();
		} else {
			if (gpname.trim().equals("")||gptel.trim().equals("")||gpuser.trim().equals("")) {
				JOptionPane.showMessageDialog(null, "有选项未填！");
			} else  {
				if (object==insert) {
					DBManager.Addsupply(gpname, gptel, gpadd, gpuser);
					addall();
				}else if (object==update) {
					DBManager.updatesup(gpid, gpname, gptel, gpadd, gpuser);
					addall();
					JOptionPane.showMessageDialog(this, "修改成功！");
				}
			}
		} 
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
		String sgpid = (jTable1.getValueAt(row, 0)).toString();
		gpid = Integer.parseInt(sgpid);
		gpname = jTable1.getValueAt(row, 1).toString();
		gptel = jTable1.getValueAt(row, 2).toString();
		gpadd = jTable1.getValueAt(row, 3).toString();
		gpuser = jTable1.getValueAt(row, 4).toString();
		GPname.setText(gpname);
		GPadd.setText(gpadd);
		GPtel.setText(gptel);
		GPuser.setText(gpuser);
		
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

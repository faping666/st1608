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

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.sun.org.apache.bcel.internal.generic.NEW;

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
public class Goods extends javax.swing.JPanel implements ActionListener,MouseListener,KeyListener,ItemListener{
	private JLabel jLabel1;
	private JTextField select;
	private JButton jButton1;
	private JLabel jLabel5;
	private JTextField spec;
	private JButton update;
	private JLabel jLabel11;
	private JTextField vprice;
	private JLabel jLabel10;
	private JTextField price;
	private JLabel jLabel9;
	private JComboBox units;
	private JTextField gname;
	private JButton del;
	private JLabel jLabel8;
	private JLabel jLabel7;
	private JLabel jLabel6;
	private JTextField cnumber;
	private JTextField bnumber;
	private JComboBox jComboBox1;
	private JTextField goodsid;
	private JLabel jLabel4;
	private JLabel jLabel3;
	private JLabel jLabel2;
	private JTable jTable1;
	private JScrollPane jScrollPane1;

	/**
	 * Auto-generated main method to display this 
	 * JPanel inside a new JFrame.
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new Goods());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * 刷新表格全部数据
	 */
	public void addall() {
		Vector vector = new Vector();
		vector.add("商品条码");
		vector.add("商品名称");
		vector.add("种类");
		vector.add("规格等级");
		vector.add("单位");
		vector.add("报警数量");
		vector.add("零售价");
		vector.add("会员价");
		vector.add("库存量");
		DefaultTableModel model = new DefaultTableModel(DBManager.selectgood(), vector);
		jTable1.setModel(model);
	}

	/**
	 * 条件刷新表格数据
	 */
	public void add() {
		Vector vector = new Vector();
		vector.add("商品条码");
		vector.add("商品名称");
		vector.add("种类");
		vector.add("规格等级");
		vector.add("单位");
		vector.add("报警数量");
		vector.add("零售价");
		vector.add("会员价");
		vector.add("库存量");
		DefaultTableModel model = new DefaultTableModel(DBManager.selectgoods(inif), vector);
		jTable1.setModel(model);
	}
	/**
	 * 刷新下拉单位
	 */
	public void update() {
		DefaultComboBoxModel model = new DefaultComboBoxModel(DBManager.selectgoodclass());
		jComboBox1.setModel(model);
	}
	
	/**
	 * 刷新下拉类别
	 */
	public void updateuni() {
		DefaultComboBoxModel model = new DefaultComboBoxModel(DBManager.selectgoodu());
		units.setModel(model);
	}
	/**
	 * 模糊查询逻辑
	 */
	public void select() {
		inif = select.getText();
		DBManager.selectgoods(inif);
		add();
	}

	public Goods() {
		super();
		initGUI();

	}

	private void initGUI() {
		try {
			this.setPreferredSize(new java.awt.Dimension(680, 410));
			this.setBackground(new java.awt.Color(208,244,244));
			this.setSize(680, 410);
			this.setLayout(null);
			{
				jLabel1 = new JLabel();
				this.add(jLabel1);
				jLabel1.setText("\u8f93\u5165\u67e5\u8be2\u5173\u952e\u5b57:");
				jLabel1.setBounds(43, 21, 94, 17);
			}
			{
				select = new JTextField();
				this.add(select);
				select.setBounds(141, 18, 296, 24);
				select.addKeyListener(this);
			}
			{
				jButton1 = new JButton();
				this.add(jButton1);
				jButton1.setText("\u67e5\u8be2");
				jButton1.setBounds(455, 18, 91, 24);
				jButton1.addActionListener(this);
			}
			{
				jScrollPane1 = new JScrollPane();
				this.add(jScrollPane1);
				jScrollPane1.setBounds(0, 62, 680, 162);
				{
					jTable1 = new JTable();
					jScrollPane1.setViewportView(jTable1);
					jTable1.setBounds(41, 106, 263, 79);
					jTable1.addMouseListener(this);
					addall();
				}
			}
			{
				jLabel2 = new JLabel();
				this.add(jLabel2);
				jLabel2.setText("\u5546\u54c1\u6761\u7801:");
				jLabel2.setBounds(26, 240, 59, 17);
			}
			{
				jLabel3 = new JLabel();
				this.add(jLabel3);
				jLabel3.setText("\u6240\u5c5e\u7c7b\u522b:");
				jLabel3.setBounds(26, 280, 59, 17);
			}
			{
				jLabel4 = new JLabel();
				this.add(jLabel4);
				jLabel4.setText("\u62a5\u8b66\u6570\u91cf:");
				jLabel4.setBounds(26, 320, 59, 17);
			}
			{
				jLabel5 = new JLabel();
				this.add(jLabel5);
				jLabel5.setText("\u5e93\u5b58\u91cf:");
				jLabel5.setBounds(26, 360, 59, 17);
			}
			{
				goodsid = new JTextField();
				this.add(goodsid);
				goodsid.setBounds(90, 237, 141, 24);
			}
			{
				
				jComboBox1 = new JComboBox();
				update();
				jComboBox1.addItemListener(this);
				this.add(jComboBox1);
				jComboBox1.setBounds(90, 276, 140, 24);
				//				jComboBox1.setSelectedIndex(1);
			}
			{
				bnumber = new JTextField();
				this.add(bnumber);
				bnumber.setBounds(90, 317, 140, 24);
			}
			{
				cnumber = new JTextField();
				this.add(cnumber);
				cnumber.setBounds(90, 358, 140, 24);
			}
			{
				jLabel6 = new JLabel();
				this.add(jLabel6);
				jLabel6.setText("\u5546\u54c1\u540d\u79f0:");
				jLabel6.setBounds(264, 240, 59, 17);
			}
			{
				jLabel7 = new JLabel();
				this.add(jLabel7);
				jLabel7.setText("\u8ba1\u91cf\u5355\u4f4d:");
				jLabel7.setBounds(264, 280, 59, 17);
			}
			{
				jLabel8 = new JLabel();
				this.add(jLabel8);
				jLabel8.setText("\u9500\u552e\u4ef7\u683c:");
				jLabel8.setBounds(264, 320, 59, 17);
			}
			{
				del = new JButton();
				this.add(del);
				del.setText("\u5220\u9664");
				del.setBounds(298, 358, 65, 24);
				del.addActionListener(this);
			}
			{
				gname = new JTextField();
				this.add(gname);
				gname.setBounds(329, 237, 325, 24);
			}
			{
				units = new JComboBox();
				updateuni();
				units.addItemListener(this);
				this.add(units);
				
				units.setBounds(329, 276, 108, 24);

			}
			{
				spec = new JTextField();
				this.add(spec);
				spec.setBounds(546, 277, 108, 24);
			}
			{
				jLabel9 = new JLabel();
				this.add(jLabel9);
				jLabel9.setText("\u7b49\u7ea7\u89c4\u683c:");
				jLabel9.setBounds(467, 280, 67, 17);
			}
			{
				price = new JTextField();
				this.add(price);
				price.setBounds(330, 317, 107, 24);
			}
			{
				jLabel10 = new JLabel();
				this.add(jLabel10);
				jLabel10.setText("\u4f1a\u5458\u4ef7\u683c:");
				jLabel10.setBounds(467, 320, 67, 17);
			}
			{
				vprice = new JTextField();
				this.add(vprice);
				vprice.setBounds(546, 317, 108, 24);
			}
			{
				update = new JButton();
				this.add(update);
				update.setText("\u4fee\u6539");
				update.setBounds(484, 358, 62, 24);
				update.addActionListener(this);
			}
			{
				jLabel11 = new JLabel();
				this.add(jLabel11);
				jLabel11.setText("\u652f\u6301\u6240\u6709\u4fe1\u606f\u67e5\u8be2(\u6761\u7801.\u5546\u54c1\u540d\u79f0.\u79cd\u7c7b.\u5355\u4f4d....)");
				jLabel11.setBounds(147, 42, 236, 17);
				jLabel11.setFont(new java.awt.Font("Microsoft YaHei UI",0,11));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	String gid;
	String name;
	String gclass;
	String gspec;
	String gunit;
	int numbuter;
	double gprice;
	double gvprice;
	int amount;
	String inif;
	String item;
	int gclass1;
	int gunit1;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object object = e.getSource();
		if (object==jButton1) {
			select();
		} else if (object==del) {
			DBManager.goodsdel(gid);
			addall();
		}else if (object==update) {
			gclass = jComboBox1.getSelectedItem().toString().trim();
			gunit = units.getSelectedItem().toString().trim();
			String num = bnumber.getText().trim();
			String gprice1 = price.getText().trim();
			String gvprice1 = vprice.getText().trim();
			name = gname.getText();
			gspec = spec.getText();
			if (num.equals("")||gprice1.equals("")||gvprice1.equals("")||name.equals("")||gspec.equals("")||gid.equals("")) {
				JOptionPane.showMessageDialog(this, "有选项未填！");
			} else {
				numbuter = Integer.parseInt(num);
				gprice = Double.parseDouble(gprice1);
				gvprice = Double.parseDouble(gvprice1);
			DBManager.updategoods(name, DBManager.selectgoodsclass(gclass), DBManager.selectgoodsunit(gunit), gspec, numbuter, gprice, gvprice, gid);
			addall();
		}
	}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = jTable1.getSelectedRow();
		gid = jTable1.getValueAt(row, 0).toString();
		name = jTable1.getValueAt(row, 1).toString();
		gclass = jTable1.getValueAt(row, 2).toString();
		gspec = jTable1.getValueAt(row, 3).toString();
		gunit = jTable1.getValueAt(row, 4).toString();
		String num = jTable1.getValueAt(row, 5).toString();
		numbuter = Integer.parseInt(num);
		String gprice1 = jTable1.getValueAt(row, 6).toString();
		gprice = Double.parseDouble(gprice1);
		String gvprice1 = jTable1.getValueAt(row, 7).toString();
		gvprice = Double.parseDouble(gvprice1);
		String amount1 = jTable1.getValueAt(row, 8).toString();
		amount = Integer.parseInt(amount1);
		goodsid.setText(gid);
		goodsid.setEditable(false);
		gname.setText(name);
		spec.setText(gspec);
		bnumber.setText(num);
		cnumber.setText(amount1);
		cnumber.setEditable(false);
		price.setText(gprice1);
		vprice.setText(gvprice1);
		jComboBox1.setSelectedItem(gclass);
		units.setSelectedItem(gunit);
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
		if (e.getStateChange()==ItemEvent.SELECTED) {
			item = e.getItem().toString();
		}

	}
}



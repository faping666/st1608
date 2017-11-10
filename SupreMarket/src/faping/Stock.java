package faping;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
public class Stock extends javax.swing.JPanel implements ItemListener,ActionListener,KeyListener{
	private JTextField spec;
	private JLabel jLabel20;
	private JLabel jLabel19;
	private JLabel jLabel18;
	private JLabel jLabel17;
	private JLabel jLabel16;
	private JLabel jLabel15;
	private JLabel show;
	private JButton jButton2;
	private JButton jButton1;
	private JTextField jprice;
	private JComboBox jComboBox2;
	private JLabel jLabel14;
	private JLabel jLabel13;
	private JTextField jnumputer;
	private JTextField jTextField1;
	private JLabel jLabel12;
	private JLabel jLabel11;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JTextField goodsid;
	private JLabel jLabel6;
	private JTextField gname;
	private JLabel jLabel21;
	private JLabel jLabel25;
	private JLabel jLabel24;
	private JLabel jLabel23;
	private JLabel jLabel22;
	private JComboBox units;
	private JLabel jLabel5;
	private JLabel jLabel9;
	private JLabel jLabel7;
	private JComboBox jComboBox1;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JTextField bnumber;
	private JLabel jLabel8;
	private JTextField price;
	private JLabel jLabel10;
	private JTextField cnumber;
	private JTextField vprice;
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
	String privoder;//供应商名称
	double jnumputer1; //进价
	int junmbuter; //进货数量
	int cnumputer;//库存
	boolean ishave = false;
	String wasteid;//流水号
	Vector vector = null;
	/**
	 * Auto-generated main method to display this 
	 * JPanel inside a new JFrame.
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new Stock());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	/**
	 * 刷新下拉
	 */
	public void update1() {
		DefaultComboBoxModel model = new DefaultComboBoxModel(DBManager.selectgoodclass());
		jComboBox1.setModel(model);
	}
	/**
	 * 刷新下拉单位
	 */
	public void updateunit() {
		DefaultComboBoxModel model = new DefaultComboBoxModel(DBManager.selectgoodu());
		units.setModel(model);
	}
	/**
	 * 刷新下拉供应商
	 */
	public void update() {
		DefaultComboBoxModel model = new DefaultComboBoxModel(DBManager.selectgoodsP());
		jComboBox2.setModel(model);
	}
	public Stock() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			this.setPreferredSize(new java.awt.Dimension(680, 410));
			this.setSize(680, 410);
			this.setLayout(null);
			this.setBackground(new java.awt.Color(208,244,244));


			{
				jLabel2 = new JLabel();
				this.add(jLabel2);
				jLabel2.setText("\u5546\u54c1\u6761\u7801:");
				jLabel2.setBounds(22, 67, 59, 17);
			}
			{
				jLabel3 = new JLabel();
				this.add(jLabel3);
				jLabel3.setText("\u6240\u5c5e\u7c7b\u522b:");
				jLabel3.setBounds(22, 107, 59, 17);
			}
			{
				jLabel4 = new JLabel();
				this.add(jLabel4);
				jLabel4.setText("\u62a5\u8b66\u6570\u91cf:");
				jLabel4.setBounds(22, 147, 59, 17);
			}
			{
				jLabel5 = new JLabel();
				this.add(jLabel5);
				jLabel5.setText("\u5e93\u5b58\u91cf:");
				jLabel5.setBounds(22, 187, 59, 17);
			}
			{
				goodsid = new JTextField();
				this.add(goodsid);
				goodsid.setBounds(101, 64, 141, 24);
				goodsid.addKeyListener(this);
			}
			{
				jComboBox1 = new JComboBox();
				update1();
				this.add(jComboBox1);
				jComboBox1.addItemListener(this);
				jComboBox1.setBounds(101, 103, 140, 24);
				jComboBox1.setSelectedIndex(0);
				jComboBox1.setEnabled(false);
			}
			{
				bnumber = new JTextField();
				this.add(bnumber);
				bnumber.setBounds(101, 144, 140, 24);
				bnumber.setEditable(false);
			}
			{
				cnumber = new JTextField();
				this.add(cnumber);
				cnumber.setBounds(101, 185, 140, 24);
				cnumber.setEditable(false);
			}
			{
				jLabel6 = new JLabel();
				this.add(jLabel6);
				jLabel6.setText("\u5546\u54c1\u540d\u79f0:");
				jLabel6.setBounds(260, 67, 59, 17);
			}
			{
				jLabel7 = new JLabel();
				this.add(jLabel7);
				jLabel7.setText("\u8ba1\u91cf\u5355\u4f4d:");
				jLabel7.setBounds(260, 107, 59, 17);
			}
			{
				jLabel8 = new JLabel();
				this.add(jLabel8);
				jLabel8.setText("\u9500\u552e\u4ef7\u683c:");
				jLabel8.setBounds(260, 147, 59, 17);
			}

			{
				gname = new JTextField();
				this.add(gname);
				gname.setBounds(325, 64, 325, 24);
				gname.setEditable(false);
			}
			{
				units = new JComboBox();
				updateunit();
				units.addItemListener(this);
				this.add(units);
				units.setBounds(325, 103, 108, 24);
				units.setEnabled(false);
			}
			{
				spec = new JTextField();
				this.add(spec);
				spec.setBounds(542, 104, 108, 24);
				spec.setEditable(false);
			}
			{
				jLabel9 = new JLabel();
				this.add(jLabel9);
				jLabel9.setText("\u7b49\u7ea7\u89c4\u683c:");
				jLabel9.setBounds(463, 107, 67, 17);
			}
			{
				price = new JTextField();
				this.add(price);
				price.setBounds(326, 144, 107, 24);
				price.setEditable(false);
			}
			{
				jLabel10 = new JLabel();
				this.add(jLabel10);
				jLabel10.setText("\u4f1a\u5458\u4ef7\u683c:");
				jLabel10.setBounds(463, 147, 67, 17);
			}
			{
				vprice = new JTextField();
				this.add(vprice);
				vprice.setBounds(542, 144, 108, 24);
				vprice.setEditable(false);
			}
			{
				jLabel1 = new JLabel();
				this.add(jLabel1);
				jLabel1.setText("\u8fdb\u8d27\u6d41\u6c34\u53f7:");
				jLabel1.setBounds(22, 237, 70, 17);
			}
			{
				jLabel11 = new JLabel();
				this.add(jLabel11);
				jLabel11.setText("\u8fdb\u8d27\u6570\u91cf:");
				jLabel11.setBounds(22, 282, 65, 17);
			}
			{
				jLabel12 = new JLabel();
				this.add(jLabel12);
				jLabel12.setBounds(0, 0, 106, 42);
				jLabel12.setIcon(new ImageIcon(getClass().getClassLoader().getResource("imgs/jinhuo.jpg")));
			}
			{
				jTextField1 = new JTextField();
				this.add(jTextField1);
				jTextField1.setBounds(101, 234, 140, 24);
				jTextField1.setEditable(false);
			}
			{
				jnumputer = new JTextField();
				this.add(jnumputer);
				jnumputer.setBounds(99, 280, 142, 24);
				jnumputer.setEditable(false);
			}
			{
				jLabel13 = new JLabel();
				this.add(jLabel13);
				jLabel13.setText("\u4f9b\u8d27\u5546:");
				jLabel13.setBounds(259, 237, 52, 17);
			}
			{
				jLabel14 = new JLabel();
				this.add(jLabel14);
				jLabel14.setText("\u8fdb\u8d27\u4ef7\u683c:");
				jLabel14.setBounds(259, 281, 66, 17);
			}
			{
				jComboBox2 = new JComboBox();
				jComboBox2.addItemListener(this);
				this.add(jComboBox2);
				jComboBox2.setBounds(326, 233, 156, 24);
				update();
				jComboBox2.setEnabled(false);
			}
			{
				jprice = new JTextField();
				this.add(jprice);
				jprice.setBounds(325, 275, 157, 24);
				jprice.setEditable(false);
			}
			{
				jButton1 = new JButton();
				this.add(jButton1);
				jButton1.setText("\u6dfb\u52a0");
				jButton1.setBounds(111, 338, 69, 24);
				jButton1.addActionListener(this);
				jButton1.setEnabled(false);
			}
			{
				jButton2 = new JButton();
				this.add(jButton2);
				jButton2.setText("\u6e05\u7a7a");
				jButton2.setBounds(286, 338, 66, 24);
				jButton2.setSize(69, 24);
				jButton2.addActionListener(this);
			}
			{
				show = new JLabel();
				this.add(show);
				show.setText("\u8bf7\u8f93\u5165\u6761\u7801\u6309Enter(\u56de\u8f66)\u7ee7\u7eed");
				show.setBounds(101, 46, 141, 17);
				show.setForeground(new java.awt.Color(255,0,0));
				show.setFont(new java.awt.Font("Microsoft YaHei UI",0,10));
			}
			{
				jLabel15 = new JLabel();
				this.add(jLabel15);
				jLabel15.setBounds(483, 237, 11, 11);
				jLabel15.setForeground(new java.awt.Color(255,0,0));
			}
			{
				jLabel16 = new JLabel();
				this.add(jLabel16);
				jLabel16.setBounds(242, 282, 10, 9);
				jLabel16.setForeground(new java.awt.Color(255,0,0));
			}
			{
				jLabel17 = new JLabel();
				this.add(jLabel17);
				jLabel17.setBounds(482, 278, 10, 12);
				jLabel17.setForeground(new java.awt.Color(255,0,0));
			}
			{
				jLabel18 = new JLabel();
				this.add(jLabel18);
				jLabel18.setForeground(new java.awt.Color(255,0,0));
				jLabel18.setBounds(483, 237, 11, 11);
			}
			{
				jLabel19 = new JLabel();
				this.add(jLabel19);
				jLabel19.setForeground(new java.awt.Color(255,0,0));
				jLabel19.setBounds(650, 148, 11, 11);
			}
			{
				jLabel20 = new JLabel();
				this.add(jLabel20);
				jLabel20.setForeground(new java.awt.Color(255,0,0));
				jLabel20.setBounds(243, 148, 11, 11);
			}
			{
				jLabel21 = new JLabel();
				this.add(jLabel21);
				jLabel21.setForeground(new java.awt.Color(255,0,0));
				jLabel21.setBounds(241, 107, 11, 11);
			}
			{
				jLabel22 = new JLabel();
				this.add(jLabel22);
				jLabel22.setForeground(new java.awt.Color(255,0,0));
				jLabel22.setBounds(434, 107, 11, 11);
			}
			{
				jLabel23 = new JLabel();
				this.add(jLabel23);
				jLabel23.setForeground(new java.awt.Color(255,0,0));
				jLabel23.setBounds(650, 108, 11, 11);
			}
			{
				jLabel24 = new JLabel();
				this.add(jLabel24);
				jLabel24.setForeground(new java.awt.Color(255,0,0));
				jLabel24.setBounds(652, 67, 11, 11);
			}
			{
				jLabel25 = new JLabel();
				this.add(jLabel25);
				jLabel25.setForeground(new java.awt.Color(255,0,0));
				jLabel25.setBounds(433, 148, 11, 11);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 重置事件
	 */
	public void reset() {
		jLabel15.setText("");
		jLabel16.setText("");
		jLabel17.setText("");
		jLabel18.setText("");
		jLabel19.setText("");
		jLabel20.setText("");
		jLabel21.setText("");
		jLabel22.setText("");
		jLabel23.setText("");
		jLabel24.setText("");
		jLabel25.setText("");
		goodsid.setEditable(true);
		show.setText("请输入条码按Enter(回车)继续");
		goodsid.setText("");
		jComboBox2.setEnabled(false);
		jnumputer.setEditable(false);
		jprice.setEditable(false);
		jComboBox1.setEnabled(false);
		gname.setEditable(false);
		units.setEnabled(false);
		vprice.setEditable(false);
		price.setEditable(false);
		spec.setEditable(false);
		bnumber.setEditable(false);
		jButton1.setEnabled(false);
		spec.setText("");
		gname.setText("");
		bnumber.setText("");
		price.setText("");
		vprice.setText("");
		cnumber.setText("");
		units.setSelectedIndex(0);
		jComboBox1.setSelectedIndex(0);
		jTextField1.setText("");
		jnumputer.setText("");
		jprice.setText("");
		jComboBox2.setSelectedIndex(0);
	}

	/**
	 * 商品条码查询逻辑
	 */
	public void selectgoods() {
		ishave = false;
		gid = goodsid.getText();
//		update();
//		updateunit();
//		update1();
		if (gid.trim().length()<6) {
			JOptionPane.showMessageDialog(this, "条码位数必须大于6位!");
		} else {	
			if (DBManager.selectgood(gid)!=null) {
				ishave = true;
				jButton1.setEnabled(true);
				jComboBox2.setEnabled(true);
				jnumputer.setEditable(true);
				jprice.setEditable(true);
				show.setText("已查询到商品,请录入相关信息");
				jLabel15.setText("*");
				jLabel16.setText("*");
				jLabel17.setText("*");
				vector = DBManager.selectgood(gid);
				spec.setText(vector.get(2).toString());
				gname.setText(vector.get(1).toString());
				bnumber.setText(vector.get(4).toString());
				price.setText(vector.get(5).toString());
				vprice.setText(vector.get(6).toString());
				cnumber.setText(vector.get(7).toString());
				int unit = Integer.parseInt(vector.get(3).toString());
				units.setSelectedItem(DBManager.selectgoodsuname(unit));
				int cid = Integer.parseInt(vector.get(0).toString());
				jComboBox1.setSelectedItem(DBManager.selectcname(cid));
				goodsid.setEditable(false);
			} else {
				show.setText("无记录,请录入相关信息");
				jButton1.setEnabled(true);
				goodsid.setEditable(false);
				jComboBox2.setEnabled(true);
				jnumputer.setEditable(true);
				jprice.setEditable(true);
				jComboBox1.setEnabled(true);
				gname.setEditable(true);
				units.setEnabled(true);
				vprice.setEditable(true);
				price.setEditable(true);
				spec.setEditable(true);
				bnumber.setEditable(true);
				jLabel15.setText("*");
				jLabel16.setText("*");
				jLabel17.setText("*");
				jLabel18.setText("*");
				jLabel19.setText("*");
				jLabel20.setText("*");
				jLabel21.setText("*");
				jLabel22.setText("*");
				jLabel23.setText("*");
				jLabel24.setText("*");
				jLabel25.setText("*");
			}
			jTextField1.setText(DBManager.getMaxid());
		}
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if (e.getStateChange()==ItemEvent.SELECTED) {
			item = e.getItem().toString();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object object = e.getSource();
		if (object==jButton1) {
			gclass = jComboBox1.getSelectedItem().toString();//获取类别
			gunit = units.getSelectedItem().toString();//获取单位
			String num = bnumber.getText().trim();
			String gprice1 = price.getText().trim();
			String gvprice1 = vprice.getText().trim();
			name = gname.getText().trim();//获取商品名称
			gspec = spec.getText().trim();//获取商品规格
			privoder =jComboBox2.getSelectedItem().toString(); //获取供应商下拉值
			String jnum =jprice.getText().trim();
			String nump = jnumputer.getText().trim();
			if (name.length()==0||gspec.length()==0||num.length()==0||gprice1.length()==0||gvprice1.length()==0||nump.length()==0||jnum.length()==0) {
				JOptionPane.showMessageDialog(this, "有必填项未填(带星号为必填项)!");
			} else {
				try {
					while(!jnum.matches("\\d+"))
					{
						JOptionPane.showMessageDialog(this, "数量或价格输入错误！");
						return;
					}
				}catch (Exception e1) {
					// TODO: handle exception
				}	
				try {
					while(!nump.matches("\\d+"))
					{
						JOptionPane.showMessageDialog(this, "数量或价格输入错误！");
						return;
					}
				}catch (Exception e1) {
					// TODO: handle exception
				}	
				numbuter = Integer.parseInt(num); //获取报警数量
				gprice = Double.parseDouble(gprice1);//获取价格
				gvprice = Double.parseDouble(gvprice1);//获取会员价格
				jnumputer1 = Double.parseDouble(jnum);//获取进价
				junmbuter = Integer.parseInt(nump);//获取进货数量
				if (jnumputer1<0||junmbuter<=0||gvprice<0||gprice<0||numbuter<=0) {
					JOptionPane.showMessageDialog(this, "进货价格或数量填写有误！");
				} else {
				if (ishave) {
					DBManager.updatecnumbuter(gid, junmbuter);
				} else {
					DBManager.insertgoods(gid, DBManager.selectgoodsclass(gclass), name, gspec, DBManager.selectgoodsunit(gunit), numbuter, gprice, gvprice, junmbuter);
				}
				wasteid = jTextField1.getText();//获取流水号
				DBManager.insetInStore(wasteid, gid, DBManager.selectPrivoder(privoder), DBManager.getDate(), junmbuter, jnumputer1);
				selectgoods();
				JOptionPane.showMessageDialog(this, "进货信息添加成功！\n商品名称："+gname.getText()+"\n当前库存："+cnumber.getText().toString());
				reset();
			}
			}
		}else if (object==jButton2) {
			reset();
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyChar() == KeyEvent.VK_ENTER ){
			selectgoods();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}

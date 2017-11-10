package faping;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.text.DecimalFormat;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.omg.CORBA.PUBLIC_MEMBER;

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
/**
 * 收银
 * @author songf
 *
 */
public class CashierJPanel extends javax.swing.JPanel implements KeyListener,ActionListener,MouseListener{
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JScrollPane jScrollPane1;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel12;
	private JLabel jLabel11;
	private JLabel jLabel10;
	private JLabel jLabel9;
	private JLabel MPrice;
	private JLabel jLabel8;
	private JLabel VBalance;
	private JLabel jLabel7;
	private JButton jButton1;
	private JLabel ConsumeScore;
	private JLabel jLabel6;
	private JLabel VName;
	private JTextField VIPID;
	private JPanel jPanel2;
	private JLabel jLabel1;
	private JPanel jPanel1;
	private JTable jTable1;
	private JTextField count;
	private JButton getmoney;
	private JTextField cash;
	private JLabel dibs;
	private JLabel jLabel14;
	private JLabel jLabel13;
	private JButton query;
	private JTextField CommodityID;
	Vector v1;
	private JLabel jLabel15;
	private JButton del;
	double price2; 
	boolean ishave = false;
	/**
	 * 商品单价
	 */
	double price;
	/**
	 * 会员单价
	 */
	double Vprice;
	/**
	 * 商品会员价格
	 */
	//	double VFmoney;
	/**
	 * 表格累加集合
	 */
	Vector v = new Vector();
	/**
	 * 商品会员总价
	 */
	double Vcoun1=0;
	/**
	 * 商品总价
	 */
	double count1 = 0;
	/**
	 * 单个商品数量
	 */
	int coun = 0;
	/**
	 * 商品总件数
	 */
	String count3 ;
	/**
	 * 实收金额
	 */
	double dcash = 0;

	/**
	 * 显示商品总价价格
	 */
	String str;
	/**
	 * 商品ID
	 */
	String gid;
	/**
	 * 当前登录账号
	 */
	String uid;

	/**
	 * 会员信息集合
	 */
	Vector vipinfo;
	/**
	 * 会员ID
	 */
	String Vid ;
	DefaultTableModel model;
	/**
	 * 表格的行
	 */
	int row = 0;
	/**
	 * Auto-generated main method to display this 
	 * JPanel inside a new JFrame.
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new CashierJPanel());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * 刷新表格
	 */
	public void selectAll() {
		//		jTable1 = new JTable();
		v1 = new Vector();
		v1.add("商品条码");
		v1.add("商品名称");
		v1.add("规格等级");
		v1.add("单位");
		v1.add("当前库存");
		v1.add("会员价");
		v1.add("零售价");
		v1.add("数量");
		v1.add("金额");
		//		jScrollPane1.setViewportView(jTable1);
		model = new DefaultTableModel(v, v1);
		jTable1.setModel(model);
	}
	public CashierJPanel() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			this.setPreferredSize(new java.awt.Dimension(680, 480));
			this.setSize(680, 480);
			this.setBackground(new java.awt.Color(208,244,244));
			this.setLayout(null);
			this.setFont(new java.awt.Font("Dialog",0,14));
			{
				jLabel2 = new JLabel();
				this.add(jLabel2);
				jLabel2.setText("\u8bf7\u8f93\u5165\u5546\u54c1\u6761\u7801\uff1a");
				jLabel2.setBounds(27, 66, 126, 22);
				jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI",1,14));
			}
			{
				CommodityID = new JTextField();
				this.add(CommodityID);
				CommodityID.setBounds(148, 67, 140, 24);
				CommodityID.addKeyListener(this);
			}
			{
				query = new JButton();
				this.add(query);
				query.setText("\u67e5\u8be2\u5546\u54c1");
				query.setBounds(443, 65, 90, 24);
				query.setFont(new java.awt.Font("Microsoft YaHei UI",1,14));
				query.addActionListener(this);
			}
			{
				jLabel3 = new JLabel();
				this.add(jLabel3);
				jLabel3.setText("\u6570\u91cf\uff1a");
				jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI",1,14));
				jLabel3.setBounds(308, 68, 54, 22);
			}
			{
				count = new JTextField();
				this.add(count);
				count.setText("1");
				count.setBounds(361, 66, 63, 24);
				count.addKeyListener(this);
			}
			{
				jScrollPane1 = new JScrollPane();
				this.add(jScrollPane1);
				jScrollPane1.setBounds(0, 107, 680, 209);
				{
					jTable1 = new JTable();
					//					v1 = new Vector();
					//					v1.add("商品条码");
					//					v1.add("商品名称");
					//					v1.add("规格等级");
					//					v1.add("单位");
					//					v1.add("当前库存");
					//					v1.add("会员价");
					//					v1.add("零售价");
					//					v1.add("数量");
					//					v1.add("金额");
					jScrollPane1.setViewportView(jTable1);
					selectAll();

					//					jScrollPane1.setViewportView(jTable1);
					//					model = new DefaultTableModel(v, v1);

					jTable1.addMouseListener(this);
				}
			}
			{
				jPanel1 = new JPanel();
				this.add(jPanel1);
				jPanel1.setBounds(0, 0, 680, 46);
				jPanel1.setLayout(null);
				jPanel1.setBackground(new java.awt.Color(239,235,223));
				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1);
					jLabel1.setBounds(0, 0, 104, 49);
					jLabel1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("imgs/q.jpg")));
					jLabel1.setBackground(new java.awt.Color(239,235,223));
				}
			}
			{
				jPanel2 = new JPanel();
				this.add(jPanel2);
				jPanel2.setBounds(0, 316, 680, 45);
				jPanel2.setBackground(new java.awt.Color(239,235,223));
				jPanel2.setLayout(null);
				{
					jLabel4 = new JLabel();
					jPanel2.add(jLabel4);
					jLabel4.setText("\u4f1a\u5458\u5361\u53f7\uff1a");
					jLabel4.setBounds(11, -2, 76, 43);
					jLabel4.setFont(new java.awt.Font("Microsoft YaHei UI",1,14));
				}
				{
					VIPID = new JTextField();
					jPanel2.add(VIPID);
					VIPID.setBounds(87, 9, 125, 24);
					VIPID.addKeyListener(this);

				}
				{
					jLabel5 = new JLabel();
					jPanel2.add(jLabel5);
					jLabel5.setText("\u59d3\u540d\uff1a");
					jLabel5.setBounds(213, 1, 42, 44);
					jLabel5.setFont(new java.awt.Font("Microsoft YaHei UI",1,14));
				}
				{
					VName = new JLabel();
					jPanel2.add(VName);
					VName.setBounds(258, 1, 69, 44);
					VName.setFont(new java.awt.Font("Microsoft YaHei UI",1,14));
					VName.setBackground(new java.awt.Color(255,0,0));
					VName.setForeground(new java.awt.Color(255,0,0));
				}
				{
					jLabel6 = new JLabel();
					jPanel2.add(jLabel6);
					jLabel6.setText("\u79ef\u5206\uff1a");
					jLabel6.setBounds(331, 0, 43, 46);
					jLabel6.setFont(new java.awt.Font("Microsoft YaHei UI",1,14));
				}
				{
					ConsumeScore = new JLabel();
					jPanel2.add(ConsumeScore);
					ConsumeScore.setBounds(374, 6, 78, 39);
				}
				{
					jButton1 = new JButton();
					jPanel2.add(jButton1);
					jButton1.setText("\u4f59\u989d\u7ed3\u8d26");
					jButton1.setBounds(576, 13, 93, 24);
					jButton1.setFont(new java.awt.Font("Microsoft YaHei UI",1,14));
					jButton1.setForeground(new java.awt.Color(0,0,0));
					jButton1.addActionListener(this);
				}
				{
					jLabel7 = new JLabel();
					jPanel2.add(jLabel7);
					jLabel7.setText("\u4f59\u989d\uff1a");
					jLabel7.setBounds(444, 1, 48, 45);
					jLabel7.setFont(new java.awt.Font("Microsoft YaHei UI",1,14));
				}
				{
					VBalance = new JLabel();
					jPanel2.add(VBalance);
					VBalance.setBounds(489, 4, 75, 41);
				}
			}
			{
				jLabel8 = new JLabel();
				this.add(jLabel8);
				jLabel8.setText("\u5171\u8ba1\uff1a\uffe5");
				jLabel8.setBounds(42, 373, 77, 47);
				jLabel8.setFont(new java.awt.Font("Microsoft YaHei UI",1,18));
			}
			{
				MPrice = new JLabel();
				this.add(MPrice);
				MPrice.setText("0.00");
				MPrice.setBounds(112, 375, 109, 45);
				MPrice.setFont(new java.awt.Font("Microsoft YaHei UI",1,18));
				MPrice.setForeground(new java.awt.Color(255,0,0));
			}
			{
				jLabel9 = new JLabel();
				this.add(jLabel9);
				jLabel9.setText("\u5143");
				jLabel9.setBounds(222, 373, 19, 45);
				jLabel9.setFont(new java.awt.Font("Microsoft YaHei UI",1,18));
			}
			{
				jLabel10 = new JLabel();
				this.add(jLabel10);
				jLabel10.setText("\u5b9e\u6536\uff1a\uffe5");
				jLabel10.setFont(new java.awt.Font("Microsoft YaHei UI",1,18));
				jLabel10.setBounds(363, 373, 77, 45);
			}
			{
				jLabel11 = new JLabel();
				this.add(jLabel11);
				jLabel11.setText("\u627e\u96f6\uff1a\uffe5");
				jLabel11.setFont(new java.awt.Font("Microsoft YaHei UI",1,18));
				jLabel11.setBounds(368, 434, 77, 45);
			}
			{
				jLabel12 = new JLabel();
				this.add(jLabel12);
				jLabel12.setText("\u5171\u6709\uff1a");
				jLabel12.setFont(new java.awt.Font("Microsoft YaHei UI",1,18));
				jLabel12.setBounds(42, 432, 57, 45);
			}
			{
				jLabel13 = new JLabel();
				this.add(jLabel13);
				jLabel13.setText("0");
				jLabel13.setFont(new java.awt.Font("Microsoft YaHei UI",1,18));
				jLabel13.setForeground(new java.awt.Color(255,0,0));
				jLabel13.setBounds(103, 432, 74, 45);

			}
			{
				jLabel14 = new JLabel();
				this.add(jLabel14);
				jLabel14.setText("\u4ef6\u5546\u54c1");
				jLabel14.setFont(new java.awt.Font("Microsoft YaHei UI",1,18));
				jLabel14.setBounds(193, 434, 71, 45);
			}
			{
				dibs = new JLabel();
				this.add(dibs);
				dibs.setText("0.00");
				dibs.setFont(new java.awt.Font("Microsoft YaHei UI",1,18));
				dibs.setForeground(new java.awt.Color(255,0,0));
				dibs.setBounds(457, 434, 74, 45);
			}
			{
				cash = new JTextField();
				this.add(cash);
				cash.setBounds(452, 382, 103, 26);
				cash.setForeground(new java.awt.Color(255,0,0));
				cash.setFont(new java.awt.Font("Microsoft YaHei UI",1,18));
				cash.addKeyListener(this);
			}
			{
				getmoney = new JButton();
				this.add(getmoney);
				getmoney.setText("\u73b0\u91d1\u7ed3\u8d26");
				getmoney.setBounds(554, 408, 114, 40);
				getmoney.setForeground(new java.awt.Color(50,255,150));
				getmoney.setFont(new java.awt.Font("Microsoft YaHei UI",1,18));
				getmoney.addActionListener(this);
			}
			{
				del = new JButton();
				this.add(del);
				del.setText("\u5220\u9664");
				del.setBounds(566, 65, 71, 24);
				del.setFont(new java.awt.Font("Microsoft YaHei UI",1,14));
				del.addActionListener(this);
				del.setEnabled(false);
			}
			{
				jLabel15 = new JLabel();
				this.add(jLabel15);
				jLabel15.setText("0.00");
				jLabel15.setFont(new java.awt.Font("Microsoft YaHei UI",1,18));
				jLabel15.setForeground(new java.awt.Color(255,0,0));
				jLabel15.setBounds(112, 375, 109, 45);
				jLabel15.setVisible(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		Object object = e.getSource();
		if (object==VIPID) {
			if(e.getKeyChar() == KeyEvent.VK_ENTER ){
				selectVIP();
			} 
		} else if(object==CommodityID||object==count) {
			if(e.getKeyChar() == KeyEvent.VK_ENTER ){
				selectgoods();
			}
		}else if (object==cash) {
			if(e.getKeyChar() == KeyEvent.VK_ENTER ){
				if (jLabel13.getText().toString().equals("0")) {
					JOptionPane.showMessageDialog(this, "没有任何商品！");
				} else {
					if (this.cash.getText().toString().length()!=0) {
						String cash = this.cash.getText();
						try {
							while(!cash.matches("\\d+"))
							{
								JOptionPane.showMessageDialog(this, "请输入正确的实收金额！");
								this.cash.setText("");
								return;
							}
						}catch (Exception e1) {
							// TODO: handle exception
						}	
						dcash = Double.parseDouble(cash);
						
						//判断是否是会员现金结账
						if (ishave||vipinf) {
							String coun = jLabel15.getText();
							count1 = Double.parseDouble(coun);
							if(dcash>=count1) {
								String ddibs = String.valueOf(DBManager.formart(dcash-count1));
								dibs.setText(ddibs);
								VcheckOut();
								reset();
							}else {
								JOptionPane.showMessageDialog(this, "请输入正确的实收金额！");
								this.cash.setText("");
							}
						} else {
							String coun = MPrice.getText();
							count1 = Double.parseDouble(coun);
							//获取实收金额
							if(dcash>=count1) {
								dibs.setText(DBManager.formart(dcash-count1));
								checkOut();
								reset();
							}else {
								JOptionPane.showMessageDialog(this, "请输入正确的实收金额！");
								this.cash.setText("");
							}
						}
					} else {
						JOptionPane.showMessageDialog(this, "请输入实收金额！");
					} 
				}
			}
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


	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		if (object==jButton1) {
			if (jLabel13.getText().toString().equals("0")) {
				JOptionPane.showMessageDialog(this, "没有任何商品！");
			} else {
				selectVIP();
				if (vipinf) {
					//获取会员数据
					String VBalance = this.VBalance.getText();
					//获取会员卡余额
					double dvbalance = Double.parseDouble(VBalance);
					double price = Double.parseDouble(str);
					//判断会员余额是否大于消费金额
					if (dvbalance>=price) {
						ishave = false;
						String vddibs = String.valueOf(dvbalance-price);
						VcheckOut();
						reset();
					} else {
						ishave = true;
						String vddibs = String.valueOf(-dvbalance-price);
						this.VBalance.setText("0.0");
						price =price-dvbalance;
						DBManager.formart(price);
						JOptionPane.showMessageDialog(null, "还有"+DBManager.formart(price)+"元,请用现金结账");
						double a = dcash-price;

						//						String price1 = String.valueOf(price);
						jLabel15.setText(DBManager.formart(price));

						//					dibs.setText(ddibs);

					}
				}
			}
		}else if (object==query) {
			selectgoods();
		} else if (object==getmoney) {
			if (jLabel13.getText().toString().equals("0")) {
				JOptionPane.showMessageDialog(this, "没有任何商品！");
			} else {
				if (this.cash.getText().toString().length()!=0) {
					String cash = this.cash.getText();
					try {
						while(!cash.matches("\\d+"))
						{
							JOptionPane.showMessageDialog(this, "请输入正确的实收金额！");
							this.cash.setText("");
							return;
						}
					}catch (Exception e1) {
						// TODO: handle exception
					}	
					dcash = Double.parseDouble(cash);
					
					//判断是否是会员现金结账
					if (ishave||vipinf) {
						String coun = jLabel15.getText();
						count1 = Double.parseDouble(coun);
						if(dcash>=count1) {
							String ddibs = String.valueOf(DBManager.formart(dcash-count1));
							dibs.setText(ddibs);
							VcheckOut();
							reset();
						}else {
							JOptionPane.showMessageDialog(this, "请输入正确的实收金额！");
							this.cash.setText("");
						}
					} else {
						String coun = MPrice.getText();
						count1 = Double.parseDouble(coun);
						//获取实收金额
						if(dcash>=count1) {
							dibs.setText(DBManager.formart(dcash-count1));
							checkOut();
							reset();
						}else {
							JOptionPane.showMessageDialog(this, "请输入正确的实收金额！");
							this.cash.setText("");
						}
					}
				} else {
					JOptionPane.showMessageDialog(this, "请输入实收金额！");
				} 
			}
		}else if (object==del) {
			model.removeRow(row);
			selectAll();
			count1=0;
			coun = 0;
			for (int j = 0; j < jTable1.getRowCount(); j++) {
				count1 = Double.parseDouble(jTable1.getValueAt(j, 8).toString())+count1;
				str = String.valueOf(DBManager.formart(count1));
				MPrice.setText(str);
				coun = Integer.parseInt(jTable1.getValueAt(j, 7).toString())+coun;
				count3 = String.valueOf(coun);
				jLabel13.setText(count3);
			}
			if (jTable1.getRowCount()==0) {
				MPrice.setText("0.00");
				jLabel15.setText("0.00");
				jLabel13.setText("");
			}
			del.setEnabled(false);
		}
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		row = jTable1.getSelectedRow();
		gid = jTable1.getValueAt(row, 0).toString();
		del.setEnabled(true);
		
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
	/**
	 * 查询商品并显示到前台
	 */
	public void selectgoods() {
		dibs.setText("0.00");
		String GId =CommodityID.getText();
		Vector vector = faping.DBManager.selectware(GId);
		String count = this.count.getText();
		if (vector==null) {
			JOptionPane.showMessageDialog(this, "未查询到商品信息，请确认条码是否正确！");
		} else {
			boolean b=false;
			int i=0;
			for ( i = 0; i < jTable1.getRowCount(); i++) {
				if(  jTable1.getValueAt(i, 0).equals(GId))
				{
					b=true;
					break;
				}
			}
			try {
				while(!count.matches("\\d+"))
				{
					JOptionPane.showMessageDialog(this, "请输入正确的商品数量！");
					this.count.setText("1");
					return;
				}
			}catch (Exception e) {
				// TODO: handle exception
			}	
			int cou = Integer.parseInt(count);
			if (cou<=0||!count.matches("\\d+")) {
				JOptionPane.showMessageDialog(this, "请输入正确的商品数量！");
				this.count.setText("1");
			} else {
				if (b) {
					int n=Integer.parseInt( jTable1.getValueAt(i, 7).toString());
					jTable1.setValueAt(cou+n, i, 7);
					double p=Double.parseDouble(  jTable1.getValueAt(i, 6).toString());
					jTable1.setValueAt(DBManager.formart((cou+n)*p),i, 8);
					count1=0;
					coun = 0;
					for (int j = 0; j < jTable1.getRowCount(); j++) {
						if (vipinf) {
							count1 = Double.parseDouble(jTable1.getValueAt(j, 5).toString())*Double.parseDouble(jTable1.getValueAt(j, 7).toString())+count1;
							str = String.valueOf(DBManager.formart(count1));
							jLabel15.setText(str);
							coun = Integer.parseInt(jTable1.getValueAt(j, 7).toString())+coun;
							count3 = String.valueOf(coun);
							jLabel13.setText(count3);
						} else {
							count1 = Double.parseDouble(jTable1.getValueAt(j, 6).toString())*Double.parseDouble(jTable1.getValueAt(j, 7).toString())+count1;
							str = String.valueOf(DBManager.formart(count1));
							MPrice.setText(str);
							coun = Integer.parseInt(jTable1.getValueAt(j, 7).toString())+coun;
							count3 = String.valueOf(coun);
							jLabel13.setText(count3);
						}
					}
				} else {
					//添加数量
					vector.add(count);
					//获取商品单价
					price =  (Double) vector.get(6);
					//获取商品会员单价
					//					Vprice = (Double) vector.get(5);
					//计算商品价格
					Double Fmoney = Double.parseDouble(count)*price;
					//格式化数字
					vector.add(DBManager.formart(Fmoney));
					v.add(vector);
					selectAll();
					count1=0;
					coun = 0;
					str = String.valueOf(DBManager.formart(price));
					MPrice.setText(str);
					jLabel13.setText(this.count.getText());
					for (int j = 0; j < jTable1.getRowCount(); j++) {
						if (vipinf) {
							count1 = Double.parseDouble(jTable1.getValueAt(j, 5).toString())*Double.parseDouble(jTable1.getValueAt(j, 7).toString())+count1;
							str = String.valueOf(DBManager.formart(count1));
							jLabel15.setText(str);
							coun = Integer.parseInt(jTable1.getValueAt(j, 7).toString())+coun;
							count3 = String.valueOf(coun);
							jLabel13.setText(count3);
						} else {
							count1 = Double.parseDouble(jTable1.getValueAt(j, 6).toString())*Double.parseDouble(jTable1.getValueAt(j, 7).toString())+count1;
							str = String.valueOf(DBManager.formart(count1));
							MPrice.setText(str);
							coun = Integer.parseInt(jTable1.getValueAt(j, 7).toString())+coun;
							count3 = String.valueOf(coun);
							jLabel13.setText(count3);
						}
					}
					jTable1.setModel(model);	
					//获取商品总价
//					Vcoun1 = Double.parseDouble(str);
				}
			}
		}

	}

	/**
	 * 非会员结账
	 */
	public void checkOut() {
		String vid = null;
		String maxid = DBManager.getMaxidXS();
		//添加销售表
		DBManager.insertSell(maxid,jTable1.getRowCount(), uid,vid);
		for (int j = 0; j < jTable1.getRowCount(); j++) {
			coun = 0;
			price = Double.parseDouble(jTable1.getValueAt(j, 6).toString());
			gid = jTable1.getValueAt(j, 0).toString();
			coun = Integer.parseInt(jTable1.getValueAt(j, 7).toString());
			//修改商品库存
			DBManager.modifyNO(gid, coun);
			//添加销售详情
			DBManager.insertSellDatal(maxid, gid, coun, price);
		}
		JOptionPane.showMessageDialog(this, "购买成功,小票打印中...");
		//		v=null;
		//		DefaultTableModel model = new DefaultTableModel(v, v1);
	}
	/**
	 * 会员结账
	 */
	public void VcheckOut() {
		selectVIP();
		String maxid = DBManager.getMaxidXS();
		//添加销售表
		DBManager.insertSell(maxid,jTable1.getRowCount(), uid ,Vid);
		for (int j = 0; j < jTable1.getRowCount(); j++) {
			coun = 0 ;
			price = Double.parseDouble(jTable1.getValueAt(j, 5).toString());
			gid = jTable1.getValueAt(j, 0).toString();
			coun = Integer.parseInt(jTable1.getValueAt(j, 7).toString());
			//修改商品库存
			DBManager.modifyNO(gid, coun);
			//添加销售详情
			DBManager.insertSellDatal(maxid, gid, coun, price);
		}
		double score = Double.parseDouble(vipinfo.get(3).toString()) ;
		double price = Double.parseDouble(str);
		if (ishave||vipinf) {
			DBManager.updateVipinfo1(price, score, vipinfo.get(4).toString());
		} else {
			DBManager.updateVipinfo(price, score, vipinfo.get(4).toString());
		}
		selectVIP();
		JOptionPane.showMessageDialog(this, "购买成功,小票打印中...");
	}
	boolean vipinf =false;
	/**
	 * 查询VIP信息
	 */
	public void selectVIP() {
		Vid = VIPID.getText().trim(); 
		vipinfo = faping.DBManager.selectVIP(Vid);
		if (vipinfo==null||Vid.equals("")) {
			JOptionPane.showMessageDialog(this, "未查询到会员信息！");
			VIPID.setText("");
		} else {
			vipinf = true;
			jLabel15.setVisible(true);
			MPrice.setVisible(false);
			VName.setText(vipinfo.get(0).toString());
			ConsumeScore.setText(vipinfo.get(1).toString());
			VBalance.setText(vipinfo.get(2).toString());
			count1 = 0;
			for (int j = 0; j < jTable1.getRowCount(); j++) {
				count1 = Double.parseDouble(jTable1.getValueAt(j, 5).toString())*Double.parseDouble(jTable1.getValueAt(j, 7).toString())+count1;
				str = String.valueOf(DBManager.formart(count1));
				jLabel15.setText(str);
			}
		}
	}
	/**
	 * 清空收银数据
	 */
	public void reset() {
		jLabel15.setVisible(false);
		MPrice.setVisible(true);
		CommodityID.setText("");
		count.setText("1");
		VIPID.setText("");
		VName.setText("");
		ConsumeScore.setText("");
		VBalance.setText("");
		MPrice.setText("0.00");
		cash.setText("");
		jLabel13.setText("");
		//		dibs.setText("0.00");
		//		v = new Vector();
		v.removeAllElements();
		vipinf = false;
		selectAll();
		ishave = false;
	}
}

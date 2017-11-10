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
	String item = "进货明细";
	String btim;
	String etim;
	String etim1;
	StringBuffer sb ;


	/**
	 * 条件刷新表格-销售汇总
	 */
	public void Select() {
		Vector vector = new Vector();
		vector.add("商品条码");
		vector.add("商品名称");
		vector.add("商品规格");
		vector.add("商品单位");
		vector.add("商品分类");
		vector.add("销售数量");
		vector.add("销售金额");
		Vector vector2 = DBManager.selectGID(btim,etim1);
		Vector v = new Vector();
		for (int i = 0; i < vector2.size(); i++) {
			v.add(DBManager.selectXSHZ(vector2.get(i).toString(), btim, etim1));
		}
		DefaultTableModel model = new DefaultTableModel(v, vector);
		jTable1.setModel(model);
	}



	/**
	 * 刷新全部表格-销售汇总
	 */
	public void SelectAll() {
		//	public void addall() {
		Vector vector = new Vector();
		vector.add("商品条码");
		vector.add("商品名称");
		vector.add("商品规格");
		vector.add("商品单位");
		vector.add("商品分类");
		vector.add("销售数量");
		vector.add("销售金额");
		Vector vector2 = DBManager.selectGID();
		Vector v = new Vector();
		for (int i = 0; i < vector2.size(); i++) {
			v.add(DBManager.selectXSHZ(vector2.get(i).toString()));
		}
		DefaultTableModel model = new DefaultTableModel(v, vector);
		jTable1.setModel(model);
	}


	/**
	 * 刷新全部表格--进货明细
	 */
	public void addall() {
		Vector vector = new Vector();
		vector.add("进货时间");
		vector.add("流水号");
		vector.add("商品条码");
		vector.add("名称");
		vector.add("规格");
		vector.add("单位");
		vector.add("商品分类");
		vector.add("进货数量");
		vector.add("进货单价");
		vector.add("供货金额");
		vector.add("供货商");
		DefaultTableModel model = new DefaultTableModel(DBManager.selectjhmx(), vector);
		jTable1.setModel(model);
	}

	/**
	 * 条件刷新表格--进货明细
	 */
	public void add() {
		Vector vector = new Vector();
		vector.add("进货时间");
		vector.add("流水号");
		vector.add("商品条码");
		vector.add("名称");
		vector.add("规格");
		vector.add("单位");
		vector.add("商品分类");
		vector.add("进货数量");
		vector.add("进货单价");
		vector.add("供货金额");
		vector.add("供货商");
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
							new String[] { "进货明细", "进货汇总","销售明细","销售汇总" ,"会员充值明细"});
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
	 * 销售明细
	 */
	public void settableXSMX() {
		Vector vector=new Vector();
		vector.add("销售时间");
		vector.add("销售流水号");
		vector.add("商品条码");
		vector.add("名称");
		vector.add("规格");
		vector.add("单位");
		vector.add("商品分类");
		vector.add("销售数量");
		vector.add("销售单价");
		vector.add("销售金额");
		vector.add("会员卡号");
		vector.add("收银员");
		DefaultTableModel model=new DefaultTableModel(DBManager.xiaoshoumingxiselect(),vector);
		jTable1.setModel(model);
	}
	//	public void settableXSHZ() {
	//		Vector vector=new Vector();
	//		vector.add("商品条码");
	//		vector.add("商品名称");
	//		vector.add("商品规格");
	//		vector.add("商品单位");
	//		vector.add("商品分类");
	//		vector.add("销售数量");
	//	    vector.add("销售金额");
	//        DefaultTableModel model=new DefaultTableModel(DBManager.xiaoshoumingxiselect(),vector);
	//		jTable1.setModel(model);
	//	}
	/**
	 * 会员充值明细
	 */
	public void settableHYCZMX() {
		Vector vector=new Vector();
		vector.add("充值时间");
		vector.add("会员卡号");
		vector.add("会员姓名");
		vector.add("充值金额");
		vector.add("操作员");
		DefaultTableModel model=new DefaultTableModel(DBManager.huiyuanchongzhimingxiselect(),vector);
		jTable1.setModel(model);
	}
	/**
	 * 进货汇总
	 */
	public void settableJHHZ() {
		Vector vector=new Vector();
		vector.add("商品条码");
		vector.add("商品名称");
		vector.add("商品规格");
		vector.add("商品单位");
		vector.add("商品分类");
		vector.add("进货数量");
		vector.add("进货金额");

		DefaultTableModel model=new DefaultTableModel(DBManager.jinhuohuizongselect(),vector);
		jTable1.setModel(model);
	}

	/**
	 * 清空查询框
	 */
	public void reset() {
		this.btime.setText("");
		this.etime.setText("");
	}
	int etimei = 0;
	int btimei = 0;
	/**
	 * 条件查询逻辑
	 */
	public void selectinfo() {
		String etime1 = etim.replaceAll("-", "");//去掉时间中的-
		String btime1 = btim.replaceAll("-","");
		btimei =Integer.parseInt(btime1);
		etimei = Integer.parseInt(etime1);
		sb = new StringBuffer(etim);
		sb.insert(10, " 23:59:59");
		etim1 = sb.toString();
		//		StringBuilder sb = new StringBuilder(etim1);//构造一个StringBuilder对象
		//		sb.insert(4, "-");//在指定的位置，插入字符串 -
		//		sb.insert(7, "-");
		//		etim1 = sb.toString();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object object = e.getSource();
		if (object==jButton1) {
			btim = btime.getText().toString().trim(); //获取开始时间
			etim = etime.getText().toString().trim(); //获取结束时间
			if (item.equals("进货明细")) {
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
			else if (item.equals("销售汇总")) {
				if (btim.length()<=4||etim.length()<=4) {
					SelectAll();
				} else {
					selectinfo();
					if (btimei>etimei) {
						JOptionPane.showMessageDialog(this, "              查询失败!\n结束时间不能小于开始时间");
						reset();
					} else {
						Select();
						reset();
					} 
				}
			}else if (item.equals("进货汇总")) {
				if (btim.length()<=4||etim.length()<=4) {
					settableJHHZ();
				} else {
					selectinfo();
					if (btimei>etimei) {
						JOptionPane.showMessageDialog(this, "              查询失败!\n结束时间不能小于开始时间");
						reset();
					} else {
						Vector vector=new Vector();
						vector.add("商品条码");
						vector.add("商品名称");
						vector.add("商品规格");
						vector.add("商品单位");
						vector.add("商品分类");
						vector.add("进货数量");
						vector.add("进货金额");
						DefaultTableModel model=new DefaultTableModel(DBManager.jinhuohuizongselect(btim, etim1),vector);
						jTable1.setModel(model);
						reset();
					} 
				}
			}else if (item.equals("销售明细")) {
				if (btim.length()<=4||etim.length()<=4) {
					 settableXSMX();
				} else {
					selectinfo();
					if (btimei>etimei) {
						JOptionPane.showMessageDialog(this, "              查询失败!\n结束时间不能小于开始时间");
						reset();
					} else {
						Vector vector=new Vector();
						vector.add("销售时间");
						vector.add("销售流水号");
						vector.add("商品条码");
						vector.add("名称");
						vector.add("规格");
						vector.add("单位");
						vector.add("商品分类");
						vector.add("销售数量");
						vector.add("销售单价");
						vector.add("销售金额");
						vector.add("会员卡号");
						vector.add("收银员");
						DefaultTableModel model=new DefaultTableModel(DBManager.xiaoshoumingxiselect(btim, etim1),vector);
						jTable1.setModel(model);
						reset();
					} 
				}
			}else if (item.equals("会员充值明细")) {
				if (btim.length()<=4||etim.length()<=4) {
					settableHYCZMX();
				} else {
					selectinfo();
					if (btimei>etimei) {
						JOptionPane.showMessageDialog(this, "              查询失败!\n结束时间不能小于开始时间");
						reset();
					} else {
						Vector vector=new Vector();
						vector.add("充值时间");
						vector.add("会员卡号");
						vector.add("会员姓名");
						vector.add("充值金额");
						vector.add("操作员");
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
			if (item.equals("进货明细")) {
				addall();
			} else if (item.equals("销售汇总")) {
				SelectAll();
			} else if (item.equals("进货汇总")) {
				settableJHHZ();
			}else if (item.equals("销售明细")) {
				settableXSMX();
			}else if (item.equals("会员充值明细")) {
				settableHYCZMX();
			}

		}
	}

}

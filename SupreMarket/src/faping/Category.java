package faping;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.BorderFactory;
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
/**
 * 类别管理
 * @author songf
 *
 */
public class Category extends javax.swing.JPanel implements ActionListener,MouseListener,KeyListener{
	private JPanel jPanel1;
	private JLabel jLabel3;
	private JTextField goods;
	private JButton jButton1;
	private JLabel jLabel5;
	private JButton reset;
	private JButton del;
	private JButton update;
	private JButton add;
	private JTextField jTextField1;
	private JLabel jLabel4;
	private JTable jTable1;
	private JScrollPane jScrollPane1;
	private JLabel jLabel2;
	private JLabel jLabel1;
	
	String inif;
	String goodsclass;
	String gid;
	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new Category());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	/**
	 * 刷新表格
	 */
	public void add(){
		Vector vector = new Vector();
		vector.add("类别编号");
		vector.add("类别名称");
		DefaultTableModel model = new DefaultTableModel(DBManager.selectclass(), vector);
		jTable1.setModel(model);	
	}
	
	/**
	 * 条件刷新表格
	 */
	public void add1() {
		Vector vector = new Vector();
		vector.add("类别编号");
		vector.add("类别名称");
		DefaultTableModel model = new DefaultTableModel(DBManager.selectc(inif), vector);
		jTable1.setModel(model);
	}
	public Category() {
		super();
		initGUI();
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
				jPanel1.setBackground(new java.awt.Color(239,239,223));
				jPanel1.setLayout(null);
				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1);
					jLabel1.setBounds(0, 0, 144, 46);
					jLabel1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("imgs/leibieguanli.jpg")));
				}
			}
			{
				jLabel2 = new JLabel();
				this.add(jLabel2);
				jLabel2.setBounds(30, 92, 399, 326);
				jLabel2.setBorder(BorderFactory.createTitledBorder("商品类别信息"));
			}
			{
				jLabel3 = new JLabel();
				this.add(jLabel3);
				jLabel3.setText("\u8f93\u5165\u7c7b\u522b\u540d\u79f0\u53ca\u7f16\u53f7:");
				jLabel3.setBounds(46, 134, 144, 17);
			}
			{
				goods = new JTextField();
				this.add(goods);
				goods.setBounds(198, 130, 104, 24);
				goods.addKeyListener(this);
			}
			{
				jButton1 = new JButton();
				this.add(jButton1);
				jButton1.setText("\u67e5\u8be2");
				jButton1.setBounds(328, 131, 63, 24);
				jButton1.addActionListener(this);
			}
			{
				jScrollPane1 = new JScrollPane();
				this.add(jScrollPane1);
				jScrollPane1.setBounds(35, 191, 389, 189);
				{
					jTable1 = new JTable();
					jScrollPane1.setViewportView(jTable1);
					jTable1.setBounds(38, 266, 233, 73);
					add();
					jTable1.addMouseListener(this);
				}
			}
			{
				jLabel4 = new JLabel();
				this.add(jLabel4);
				jLabel4.setBounds(452, 91, 207, 320);
				jLabel4.setBorder(BorderFactory.createTitledBorder("资料维护"));
			}
			{
				jLabel5 = new JLabel();
				this.add(jLabel5);
				jLabel5.setText("\u7c7b\u522b\u540d\u79f0:");
				jLabel5.setBounds(457, 168, 70, 17);
			}
			{
				jTextField1 = new JTextField();
				this.add(jTextField1);
				jTextField1.setBounds(539, 162, 113, 24);
			}
			{
				add = new JButton();
				this.add(add);
				add.setText("\u6dfb\u52a0");
				add.setBounds(464, 282, 64, 24);
				add.setSize(64, 24);
				add.addActionListener(this);
			}
			{
				update = new JButton();
				this.add(update);
				update.setText("\u4fee\u6539");
				update.setBounds(574, 283, 38, 24);
				update.setSize(64, 24);
				update.addActionListener(this);
			}
			{
				del = new JButton();
				this.add(del);
				del.setText("\u5220\u9664");
				del.setBounds(464, 345, 38, 24);
				del.setSize(64, 24);
				del.addActionListener(this);
			}
			{
				reset = new JButton();
				this.add(reset);
				reset.setText("\u6e05\u7a7a");
				reset.setBounds(577, 342, 38, 24);
				reset.setSize(64, 24);
				reset.addActionListener(this);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 模糊查询逻辑
	 */
	public void  select() {
		inif = goods.getText().toString();
		DBManager.selectc(inif);
		add1();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String name = jTextField1.getText().trim();
		Object object = e.getSource();
		if (object==jButton1) {
			select();
		}else if (object==del) {
			DBManager.delete(goodsclass);
			add();
		}else if (object==reset) {
			goods.setText("");
			jTextField1.setText("");	
		}else if (name.equals("")) {
			JOptionPane.showMessageDialog(this, "输入框为空！");
		} else {
		if (object==add) {
			DBManager.Addclass(name);
			add();	
		}else if (object==update) {
			int cid = Integer.parseInt(gid);
			DBManager.updateclass(name, cid);
			add();
		}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = jTable1.getSelectedRow();
		gid = jTable1.getValueAt(row, 0).toString();
	    goodsclass = jTable1.getValueAt(row, 1).toString();
	    jTextField1.setText(goodsclass);
    
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
		Object object = e.getSource();
		select();
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}

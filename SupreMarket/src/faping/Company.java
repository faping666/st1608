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
import javax.swing.border.BevelBorder;
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
 * 单位管理
 */
public class Company extends javax.swing.JPanel implements ActionListener,MouseListener,KeyListener{
	private JLabel jLabel1;
	private JScrollPane jScrollPane1;
	private JButton select;
	private JButton reset;
	private JButton del;
	private JButton updaty;
	private JButton insert;
	private JTextField jTextField1;
	private JLabel jLabel4;
	private JLabel jLabel3;
	private JTextField inputcid;
	private JLabel jLabel2;
	private JTable jTable1;
	String inif;
	String uid;
	private JLabel jLabel5;
	private JPanel jPanel1;
	String uname;

	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new Company());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	/**
	 * 刷新表格
	 */
	public void add() {
		Vector vector = new Vector();
		vector.add("编号");
		vector.add("单位名称");
		DefaultTableModel model = new DefaultTableModel(DBManager.selectUnit(), vector);
		jTable1.setModel(model);
	}
	
	
	/**
	 * 条件刷新表格
	 */
	public void add1() {
		Vector vector = new Vector();
		vector.add("类别编号");
		vector.add("类别名称");
		DefaultTableModel model = new DefaultTableModel(DBManager.selectuni(inif), vector);
		jTable1.setModel(model);
	}
	
	public Company() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			this.setPreferredSize(new java.awt.Dimension(680, 480));
			this.setSize(680, 480);
			this.setLayout(null);
			this.setBackground(new java.awt.Color(208,244,240));
			{
				jLabel1 = new JLabel();
				this.add(jLabel1);
				jLabel1.setBounds(41, 83, 377, 377);
				jLabel1.setBorder(BorderFactory.createTitledBorder("计量单位信息"));
			}
			{
				jScrollPane1 = new JScrollPane();
				this.add(jScrollPane1);
				jScrollPane1.setBounds(41, 191, 377, 192);
				{
					jTable1 = new JTable();
					jScrollPane1.setViewportView(jTable1);
					jTable1.setBounds(27, 245, 176, 65);
					add();
					jTable1.addMouseListener(this);
				}
			}
			{
				jLabel2 = new JLabel();
				this.add(jLabel2);
				jLabel2.setText("\u8f93\u5165\u8ba1\u91cf\u5355\u4f4d\u53ca\u7f16\u53f7:");
				jLabel2.setBounds(53, 127, 162, 17);
			}
			{
				inputcid = new JTextField();
				this.add(inputcid);
				inputcid.setBounds(177, 124, 124, 24);
				inputcid.addKeyListener(this);
			}
			{
				select = new JButton();
				this.add(select);
				select.setText("\u67e5\u8be2");
				select.setBounds(334, 124, 67, 24);
				select.addActionListener(this);
			}
			{
				jLabel3 = new JLabel();
				this.add(jLabel3);
				jLabel3.setBounds(430, 77, 226, 378);
				jLabel3.setBorder(BorderFactory.createTitledBorder("资料维护"));
			}
			{
				jLabel4 = new JLabel();
				this.add(jLabel4);
				jLabel4.setText("\u5355\u4f4d\u540d\u79f0:");
				jLabel4.setBounds(448, 171, 76, 17);
			}
			{
				jTextField1 = new JTextField();
				this.add(jTextField1);
				jTextField1.setBounds(515, 167, 116, 24);
			}
			{
				insert = new JButton();
				this.add(insert);
				insert.setText("\u6dfb\u52a0");
				insert.setBounds(464, 252, 64, 24);
				insert.addActionListener(this);
			}
			{
				updaty = new JButton();
				this.add(updaty);
				updaty.setText("\u4fee\u6539");
				updaty.setBounds(567, 252, 64, 24);
				updaty.addActionListener(this);
			}
			{
				del = new JButton();
				this.add(del);
				del.setText("\u5220\u9664");
				del.setBounds(461, 333, 64, 24);
				del.addActionListener(this);
			}
			{
				reset = new JButton();
				this.add(reset);
				reset.setText("\u6e05\u7a7a");
				reset.setBounds(568, 332, 64, 24);
				reset.addActionListener(this);
			}
			{
				jPanel1 = new JPanel();
				this.add(jPanel1);
				jPanel1.setBounds(0, 0, 680, 46);
				jPanel1.setLayout(null);
				jPanel1.setBackground(new java.awt.Color(239,239,223));
				{
					jLabel5 = new JLabel();
					jPanel1.add(jLabel5);
					jLabel5.setBounds(0, 0, 107, 46);
					jLabel5.setIcon(new ImageIcon(getClass().getClassLoader().getResource("imgs/danweiguanli.jpg")));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 模糊查询逻辑
	 */
	public void  select() {
		inif = inputcid.getText().toString();
		DBManager.selectc(inif);
		add1();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String uname = jTextField1.getText().trim();
		Object object = e.getSource();
		if (object==reset) {
			inputcid.setText("");
			jTextField1.setText("");
		}else if (object==select) {
			select();
		}else if (object==del) {
			DBManager.deleteunit(uname);
			add();
		}else if (uname.equals("")) {
			JOptionPane.showMessageDialog(this, "请输入数据！");
		} else {
		if (object==insert) {
			DBManager.AddUnit(uname);
			add();
		
		}else if (object==updaty) {
	
			DBManager.updateunit(uname, Integer.parseInt(uid));
			add();
		}
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = jTable1.getSelectedRow();
		uid = jTable1.getValueAt(row, 0).toString();
	    uname = jTable1.getValueAt(row, 1).toString();
	    jTextField1.setText(uname);
		
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

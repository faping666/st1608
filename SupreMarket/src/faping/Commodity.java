package faping;
import java.awt.CardLayout;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
public class Commodity extends javax.swing.JPanel implements ActionListener{
	private JPanel jPanel1;
	private JButton jButton1;
	private JPanel jPanel2;
	private JButton jButton2;
	private JLabel jLabel1;
	private CardLayout cardLayout;
	Stock stock;
	Goods goods;

	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new Commodity());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	/**
	 * 刷新下拉
	 */
	public void update() {
		goods.update();
		goods.updateuni();
		stock.update();
		stock.update1();
		stock.updateunit();
	}
	/**
	 * 添加卡式布局
	 */
	public void addJP() {
		CashierJPanel cash = new CashierJPanel();
		 goods = new Goods();
		stock = new Stock();
		jPanel2.add(stock, "jp1");
		jPanel2.add(goods, "jp2");
	}
	
	public Commodity() {
		super();
		initGUI();
		addJP();
		stock.update();
	}
	
	private void initGUI() {
		try {
			this.setPreferredSize(new java.awt.Dimension(680, 480));
			this.setSize(680, 480);
			this.setLayout(null);
			{
				jPanel1 = new JPanel();
				this.add(jPanel1);
				jPanel1.setBounds(0, 0, 680, 46);
				jPanel1.setBackground(new java.awt.Color(239,239,223));
				jPanel1.setLayout(null);
				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1);
					jLabel1.setBounds(0, 0, 122, 46);
					jLabel1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("imgs/shangpinguanli.jpg")));
				}
			}
			{
				jButton1 = new JButton();
				this.add(jButton1);
				jButton1.setText("\u8fdb\u8d27\u7ba1\u7406");
				jButton1.setBounds(0, 46, 88, 24);
//				jButton1.setSize(100, 24);
//				jButton1.setPreferredSize(new java.awt.Dimension(20, 10));
				jButton1.addActionListener(this);
			}
			{
				jButton2 = new JButton();
				this.add(jButton2);
				jButton2.setText("\u5546\u54c1\u4fe1\u606f\u7ef4\u62a4");
				jButton2.setBounds(99, 46, 120, 24);
				jButton2.addActionListener(this);
				
			}
			{
				jPanel2 = new JPanel();
				cardLayout = new CardLayout();
				jPanel2.setLayout(cardLayout);
				this.add(jPanel2);
				jPanel2.setBounds(0, 70, 680, 410);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object object = e.getSource();
		if (object==jButton1) {
			cardLayout.show(jPanel2, "jp1");
//			stock.update();
		} else if (object==jButton2) {
			cardLayout.show(jPanel2, "jp2");
			goods.addall();

		} 
	}

}

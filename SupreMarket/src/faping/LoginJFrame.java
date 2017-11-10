package faping;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


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
public class LoginJFrame extends javax.swing.JFrame implements ActionListener,KeyListener,ItemListener{
	private JButton jButton1;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private ButtonGroup buttonGroup1;
	private JPasswordField Password;
	private JTextField username;
	private JLabel jLabel2;
	private JLabel jLabel1;
	private JButton jButton2;
	String job;
	String job1;


	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				LoginJFrame inst = new LoginJFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public LoginJFrame() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("\u4e2d\u4fe1\u8d85\u5e02\u8d2d\u7269\u7cfb\u7edf");
			getContentPane().setBackground(new java.awt.Color(237,237,207));
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1);
				jButton1.setText("\u767b\u5f55");
				jButton1.setBounds(103, 248, 70, 30);
				jButton1.setFont(new java.awt.Font("Microsoft YaHei UI",0,14));
				jButton1.addActionListener(this);
			}
			{
				jButton2 = new JButton();
				getContentPane().add(jButton2);
				jButton2.setText("\u91cd\u586b");
				jButton2.setBounds(236, 248, 70, 30);
				jButton2.setFont(new java.awt.Font("Microsoft YaHei UI",0,14));
				jButton2.addActionListener(this);
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("\u8d26\u53f7:");
				jLabel1.setBounds(102, 140, 42, 26);
				jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI",0,14));
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("\u5bc6\u7801:");
				jLabel2.setBounds(102, 183, 42, 26);
				jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI",0,14));
			}
			{
				username = new JTextField();
				getContentPane().add(username);
				username.setBounds(156, 143, 150, 24);
			}
			{
				Password = new JPasswordField();
				getContentPane().add(Password);
				getContentPane().add(getJLabel3());
				Password.setBounds(156, 186, 150, 24);
				Password.addKeyListener(this);
			}
			pack();
			this.setSize(439, 359);
		} catch (Exception e) {
			//add your error handling code here
			e.printStackTrace();
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object object = e.getSource();
		if (object==jButton1) {
			buttonClick();
		} else if (object==jButton2) {
			username.setText("");
			Password.setText("");

		} 

	}

	private ButtonGroup getButtonGroup1() {
		if(buttonGroup1 == null) {
			buttonGroup1 = new ButtonGroup();
		}
		return buttonGroup1;
	}

	private JLabel getJLabel4() {
		if(jLabel4 == null) {
			jLabel4 = new JLabel();
			jLabel4.setText("jLabel4");
			jLabel4.setBounds(0, 0, 423, 95);
			jLabel4.setIcon(new ImageIcon(getClass().getClassLoader().getResource("imgs/top.jpg")));
		}
		return jLabel4;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		Object object = e.getSource();
		if(e.getKeyChar() == KeyEvent.VK_ENTER ){
			buttonClick();
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

	/**
	 * 登录逻辑事件
	 */
	@SuppressWarnings("deprecation")
	public void buttonClick() {	
		String uid = username.getText();
		String UPassword = Password.getText();
		if (uid.trim().equals("")||UPassword.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "账号或密码不能为空！");
		} else {	
			Vector v = faping.DBManager.Login(uid);
			//判断返回值是否为空
			if (v==null) {
				JOptionPane.showMessageDialog(null, "用户不存在！");
			} else {
				if (UPassword.equals(v.get(0).toString())) {
						MainJFrame inst = new MainJFrame();
						inst.setLocationRelativeTo(null);
						inst.setVisible(true);
						this.setVisible(false);
						inst.check(v.get(1).toString(),v.get(2).toString(),uid);
				} else{
					JOptionPane.showMessageDialog(null, "用户名或密码错误！");
				}
			}
		}
		}
	

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private JLabel getJLabel3() {
		if(jLabel3 == null) {
			jLabel3 = new JLabel();
			jLabel3.setText("jLabel3");
			jLabel3.setBounds(-6, 0, 429, 101);
			jLabel3.setIcon(new ImageIcon(getClass().getClassLoader().getResource("imgs/login.jpg")));
		}
		return jLabel3;
	}
}





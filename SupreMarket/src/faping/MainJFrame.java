package faping;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
public class MainJFrame extends javax.swing.JFrame implements ActionListener{
	private JButton Cashier;
	private JButton commodity;
	private JButton Supply;
	private JButton User;
	private JButton About;
	private JButton system1;
	private JButton Category;
	private JButton Company;
	private JButton member;
	private JLabel jLabel3;
	private JLabel jLabel2;
	private JLabel jLabel1;
	private JPanel MainJP;
	private JLabel jLabel4;
	private JLabel jLabel5;
	String user;
	CardLayout cardLayout ;
	String uid ;
	private JButton jButton1;
	VIP vip;
	UserJP user1;
	CashierJPanel cash;
	About about;
	Commodity commod;
	//	MainJFrame main = this;


	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainJFrame inst = new MainJFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	/**
	 * 获取管理员信息
	 * @param job 管理员种类
	 * @param username 管理员账号
	 */
	public void check(String job,String username,String uid) {
		jLabel2.setText(job+"："+username);
		this.uid = uid;
		cash.uid = uid;
		if (job.equals("收银员")) {
			commodity.setEnabled(false);
			Supply.setEnabled(false);
			User.setEnabled(false);
			About.setEnabled(false);
			system1.setEnabled(false);
			Category.setEnabled(false);
			Company.setEnabled(false);
			member.setEnabled(false);
		}
	}
	/**
	 * 获取系统时间
	 */
	public void setTimer() {	
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				Date date = new Date();
				DateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
				String time = format.format(date);
				jLabel5.setText(time);

				//				System.err.println(cash.gid );
			}
		}, 1000, 1000);
	}

	/**
	 * 系统注销
	 */
	public void logout() {
		this.setVisible(false);
		LoginJFrame loginJFrame = new LoginJFrame();
		loginJFrame.setVisible(true);
		loginJFrame.setLocationRelativeTo(null);
	}
	/**
	 * 添加卡式布局
	 */
	public void addJP() {
		cash = new CashierJPanel();
		Category cate  = new Category();
		Company comp = new Company();
		Supply supp = new Supply();
		user1 = new UserJP();
		commod = new Commodity();
		vip = new VIP();
		user1.main=this;
		SystemManager systemManager = new SystemManager();
		about = new About();
		about.main=this;
		MainJP.add(cash, "jp1");
		MainJP.add(commod, "jp2");
		MainJP.add(supp, "jp3");
		MainJP.add(vip, "jp4");
		MainJP.add(user1, "jp5");
		MainJP.add(comp, "jp6");
		MainJP.add(cate,"jp7");
		MainJP.add(systemManager, "jp8");
		MainJP.add(about, "jp9");
		cash.setPreferredSize(new java.awt.Dimension(680, 501));
		cash.setSize(680, 480);
	}

	public MainJFrame() {
		super();
		initGUI();
		setTimer();
		addJP();

	}
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			getContentPane().setForeground(new java.awt.Color(201,233,248));
			{
				Cashier = new JButton();
				getContentPane().add(Cashier);
				Cashier.setText("\u6536\u94f6");
				Cashier.setBounds(10, 75, 100, 40);
				Cashier.setIcon(new ImageIcon(getClass().getClassLoader().getResource("imgs/q.jpg")));
				Cashier.addActionListener(this);
			}
			{
				commodity = new JButton();
				getContentPane().add(commodity);
				commodity.setText("\u5546\u54c1\u7ba1\u7406");
				commodity.setBounds(10, 126, 100, 40);
				commodity.setIcon(new ImageIcon(getClass().getClassLoader().getResource("imgs/shangpinguanli.jpg")));
				commodity.addActionListener(this);
			}
			{
				Supply = new JButton();
				getContentPane().add(Supply);
				Supply.setText("\u4f9b\u8d27\u7ba1\u7406");
				Supply.setBounds(10, 177, 100, 40);
				Supply.setIcon(new ImageIcon(getClass().getClassLoader().getResource("imgs/gonghuoguanli.jpg")));
				Supply.addActionListener(this);
			}
			{
				member = new JButton();
				getContentPane().add(member);
				member.setText("\u4f1a\u5458\u7ba1\u7406");
				member.setBounds(10, 228, 100, 40);
				member.setIcon(new ImageIcon(getClass().getClassLoader().getResource("imgs/huiyuanguanli.jpg")));
				member.addActionListener(this);
			}
			{
				User = new JButton();
				getContentPane().add(User);
				User.setText("\u7528\u6237\u7ba1\u7406");
				User.setBounds(10, 279, 100, 40);
				User.setIcon(new ImageIcon(getClass().getClassLoader().getResource("imgs/mainlogo (7).jpg")));
				User.addActionListener(this);
			}
			{
				Company = new JButton();
				getContentPane().add(Company);
				Company.setText("\u5355\u4f4d\u7ba1\u7406");
				Company.setBounds(10, 330, 100, 40);
				Company.setIcon(new ImageIcon(getClass().getClassLoader().getResource("imgs/unit.jpg")));
				Company.addActionListener(this);
			}
			{
				Category = new JButton();
				getContentPane().add(Category);
				Category.setText("\u7c7b\u522b\u7ba1\u7406");
				Category.setBounds(10, 381, 100, 40);
				Category.setIcon(new ImageIcon(getClass().getClassLoader().getResource("imgs/leib.jpg")));
				Category.addActionListener(this);
			}
			{
				system1 = new JButton();
				getContentPane().add(system1);
				system1.setText("\u7cfb\u7edf\u7ba1\u7406");
				system1.setBounds(10, 432, 100, 40);
				system1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("imgs/mainlogo (8).jpg")));
				system1.addActionListener(this);
			}
			{
				About = new JButton();
				getContentPane().add(About);
				About.setText("\u5173\u4e8e\u7cfb\u7edf");
				About.setBounds(10, 483, 100, 40);
				About.setIcon(new ImageIcon(getClass().getClassLoader().getResource("imgs/guanyuxitong.jpg")));
				About.addActionListener(this);
			}
			{
				MainJP = new JPanel();
				cardLayout = new CardLayout();
				MainJP.setLayout(cardLayout);
				getContentPane().add(MainJP);
				MainJP.setBounds(115, 80, 670, 445);
				MainJP.setSize(680, 480);
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setBounds(7, -2, 789, 79);
				jLabel1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("imgs/mainlogo.jpg")));
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("\u663e\u793a\u5f53\u524d\u7528\u6237");
				jLabel2.setBounds(653, 560, 136, 22);
			}
			{
				jLabel5 = new JLabel();
				getContentPane().add(jLabel5);
				jLabel5.setForeground(new java.awt.Color(255,0,0));
				jLabel5.setBounds(344, 560, 204, 24);
				jLabel5.setText("\u65f6\u95f4");
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("\u6b22\u8fce\u4f7f\u7528\u4e2d\u4fe1\u8d85\u5e02\u6536\u94f6\u7cfb\u7edf");
				jLabel4.setBounds(71, 563, 202, 21);
			}
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1);
				jButton1.setText("\u6ce8\u9500");
				jButton1.setBounds(720, 12, 62, 24);
				jButton1.addActionListener(this);
			}
			pack();
			this.setSize(810, 623);
		} catch (Exception e) {
			//add your error handling code here
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object object = e.getSource();
		if (object==Cashier) {
			cardLayout.show(MainJP, "jp1");
		} else if (object==Category) {
			cardLayout.show(MainJP, "jp7");
		}else if (object==Company) {
			cardLayout.show(MainJP, "jp6");
		}else if (object==Supply) {
			cardLayout.show(MainJP, "jp3");
		}else if (object==User) {
			cardLayout.show(MainJP, "jp5");
			user1.uid1 = uid;
		}else if (object==member) {
			cardLayout.show(MainJP, "jp4");
			vip.uid = uid;
		}else if (object==commodity) {
			cardLayout.show(MainJP, "jp2");
			commod.update();
		}else if (object==system1) {
			cardLayout.show(MainJP, "jp8");
		}else if (object==About) {
			cardLayout.show(MainJP, "jp9");
		}else if (rootPaneCheckingEnabled) {
			logout();
		}

	}

}

package faping;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.JLabel;

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
public class About extends javax.swing.JPanel {
	private JLabel jLabel1;
	private JPanel jPanel1;
	MainJFrame main;
	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new About());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public About() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			this.setPreferredSize(new java.awt.Dimension(680, 480));
			this.setSize(680, 480);
			this.setLayout(null);
			{
				jPanel1 = new JPanel();
				this.add(jPanel1);
				jPanel1.setBounds(0, 0, 680, 480);
				jPanel1.setLayout(null);
				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1);
					jLabel1.setBounds(0, 0, 680, 480);
					jLabel1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Imgs/logo_bak.jpg")));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}

package Bank;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class AddAccount extends JFrame {

	private JPanel contentPane;

	/** 
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddAccount frame = new AddAccount();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
 
	/** 
	 * Create the frame.
	 */
	public AddAccount() {
		setTitle("Add Account");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JButton btnSavingaccount = new JButton("SavingsAcc");
		btnSavingaccount.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 17));
		btnSavingaccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Main.frameS.setVisible(true);  
			}
		});
		btnSavingaccount.setBounds(69, 67, 244, 23);
		contentPane.add(btnSavingaccount);
		
		JButton btnCurrentacc = new JButton("CurrentAcc");
		btnCurrentacc.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 17));
		btnCurrentacc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Main.frameC.setVisible(true);
			}
		});
		btnCurrentacc.setBounds(69, 120, 244, 23);
		contentPane.add(btnCurrentacc);
		
		JButton btnHome = new JButton("Home");
		btnHome.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 17));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Main.frame.setVisible(true);
			}
		});
		btnHome.setBounds(275, 196, 89, 23);
		contentPane.add(btnHome);
		
		JLabel lblEnterYourChoice = new JLabel("Enter Your Choice");
		lblEnterYourChoice.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblEnterYourChoice.setBounds(117, 11, 196, 29);
		contentPane.add(lblEnterYourChoice);
	}
}

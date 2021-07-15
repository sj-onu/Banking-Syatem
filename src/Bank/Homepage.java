package Bank;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

public class Homepage extends JFrame {
	static Bank bank=new Bank();
	static BankAccount[]accounts=new BankAccount[10];
	private JPanel contentPane;
 
	/**
	 * Launch the application. 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Homepage frame = new Homepage();
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
	public Homepage() {
		setFont(new Font("Corbel", Font.ITALIC, 16));
		setTitle("Banking System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddaccount = new JButton("AddAccount");
		btnAddaccount.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 17));
		btnAddaccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddAccount add = new AddAccount();
				add.setVisible(true);
				dispose();
			}
		});
		btnAddaccount.setBounds(131, 65, 150, 23);
		contentPane.add(btnAddaccount);
		
		JButton btnW = new JButton("WithdrawMoney");
		btnW.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 17));
		btnW.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WithdrawMoney with = new WithdrawMoney();
				with.setVisible(true);
			}
		});
		btnW.setBounds(131, 99, 150, 23);
		contentPane.add(btnW);
		
		JButton btnNewButton = new JButton("DepositeMoney");
		btnNewButton.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DepositeMoney dep= new DepositeMoney();
				dep.setVisible(true);
			}
		}); 
		btnNewButton.setBounds(132, 133, 149, 23);
		contentPane.add(btnNewButton); 
		
		JButton btnDisplay = new JButton("Display");
		btnDisplay.setIcon(null);
		btnDisplay.setHorizontalAlignment(SwingConstants.TRAILING);
		btnDisplay.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 17));
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Display frame = new Display();
				frame.setVisible(true);
				
			}
		});
		btnDisplay.setBounds(142, 166, 139, 23);
		contentPane.add(btnDisplay);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setForeground(Color.BLACK);
		btnExit.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 17));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ObjectOutputStream out=null;
				try {
					out = new ObjectOutputStream(new FileOutputStream(Main.fileName));
					out.writeObject(Main.bank);
					
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}finally {
					try {
						out.close();
					}catch(Exception e1) {
						System.out.println(e1.getMessage());
					}
				}
				System.exit(0);
			}
		});
		btnExit.setBounds(319, 227, 89, 23);
		contentPane.add(btnExit);
		
		JLabel lblBankManagementSystem = new JLabel("Bank ManageMent System");
		lblBankManagementSystem.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 17));
		lblBankManagementSystem.setBounds(98, 24, 243, 30);
		contentPane.add(lblBankManagementSystem);
	}
}

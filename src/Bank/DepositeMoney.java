package Bank;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;

public class DepositeMoney extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1; 

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepositeMoney frame = new DepositeMoney();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public DepositeMoney() {
		setFont(new Font("Baskerville Old Face", Font.BOLD | Font.ITALIC, 12));
		setTitle("Deposite Money");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.window);
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(6, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAccnum = new JLabel("Account Number");
		lblAccnum.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblAccnum.setBounds(10, 89, 112, 14);
		contentPane.add(lblAccnum);
		
		textField = new JTextField();
		textField.setBackground(SystemColor.info);
		textField.setBounds(157, 86, 96, 20); 
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblBalance = new JLabel("Balance");
		lblBalance.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblBalance.setBounds(10, 131, 72, 14);
		contentPane.add(lblBalance);
		
		textField_1 = new JTextField();
		textField_1.setBackground(SystemColor.info);
		textField_1.setBounds(157, 128, 96, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnDeposite = new JButton("Deposite");
		btnDeposite.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
		btnDeposite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String AccNum= textField.getText();
				double bal= Double.parseDouble(textField_1.getText());
				Main.bank.deposit(AccNum,bal);
				JOptionPane.showMessageDialog(null,"Successfully Deposited");
				
			}
			
		});
		btnDeposite.setBounds(164, 196, 89, 23);
		contentPane.add(btnDeposite);
		
		JButton btnHome = new JButton("Home");
		btnHome.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Main.frame.setVisible(true);
			}
		});
		btnHome.setBounds(10, 196, 89, 23);
		contentPane.add(btnHome);
		
		JButton btnNewButton = new JButton("Reset");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
			}
		});
		btnNewButton.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
		btnNewButton.setBounds(303, 196, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblDeposite = new JLabel("Deposite");
		lblDeposite.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 22));
		lblDeposite.setBounds(155, 11, 84, 30);
		contentPane.add(lblDeposite);
	}
}

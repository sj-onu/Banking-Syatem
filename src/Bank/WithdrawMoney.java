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

public class WithdrawMoney extends JFrame {

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
					WithdrawMoney frame = new WithdrawMoney();
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
	public WithdrawMoney() {
		setTitle("Withdraw Money");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAccountNumber = new JLabel("Account Number");
		lblAccountNumber.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblAccountNumber.setBounds(10, 83, 121, 14);
		contentPane.add(lblAccountNumber);
		
		textField = new JTextField();
		textField.setBounds(152, 80, 198, 20);
		textField.setBackground(SystemColor.info);
		contentPane.add(textField);
		textField.setColumns(12);
		
		
		JButton btnEnterTheInformetion = new JButton("Withdraw");
		btnEnterTheInformetion.setBounds(122, 227, 183, 23);
		btnEnterTheInformetion.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
		btnEnterTheInformetion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String AccNum= textField.getText();
				double bal= Double.parseDouble(textField_1.getText());
				Main.bank.withdraw(AccNum,bal);
				JOptionPane.showMessageDialog(null,"Successful");

				 
			}
		});
		contentPane.add(btnEnterTheInformetion);
		
		JLabel lblWithbal = new JLabel("WithBalance");
		lblWithbal.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblWithbal.setBounds(10, 136, 89, 14);
		contentPane.add(lblWithbal); 
		
		textField_1 = new JTextField();
		textField_1.setBounds(152, 133, 198, 20);
		textField_1.setBackground(SystemColor.info);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(335, 227, 89, 23);
		btnReset.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
			}
		});
		contentPane.add(btnReset);
		
		JButton btnHome = new JButton("Home");
		btnHome.setBounds(0, 227, 89, 23);
		btnHome.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Main.frame.setVisible(true); 

			}
		});
		contentPane.add(btnHome);
		
		JLabel lblWithdraw = new JLabel("Withdraw");
		lblWithdraw.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 20));
		lblWithdraw.setBounds(155, 11, 103, 38);
		contentPane.add(lblWithdraw);
		
		
	}
}

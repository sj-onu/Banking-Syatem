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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;

public class SavingsAcc extends JFrame {

	/**
	 * 
	 */
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SavingsAcc frame = new SavingsAcc();
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
	public SavingsAcc() {
		setTitle("Savings Account");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Member Name :");
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblName.setBounds(10, 77, 84, 14);
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(110, 74, 182, 20);
		textField.setBackground(SystemColor.info);
		contentPane.add(textField); 
		textField.setColumns(10);
		
		JLabel lblAccountBalance = new JLabel("Balance:");
		lblAccountBalance.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblAccountBalance.setBounds(10, 118, 84, 14);
		contentPane.add(lblAccountBalance);
		
		textField_1 = new JTextField();
		textField_1.setBounds(110, 115, 182, 20);
		textField_1.setBackground(SystemColor.info);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(110, 226, 89, 23);
		btnSave.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name= textField.getText();
				double Balance= Double.parseDouble(textField_1.getText());
				double MaxWithLim=Double.parseDouble(textField_2.getText());
				String id=Main.bank.addAccount(name,Balance,MaxWithLim);
				JOptionPane.showMessageDialog(null,"Saving Account is Created and Your Account Number is:"+id);

				ObjectOutputStream oos=null;
				try {
					oos=new ObjectOutputStream(new FileOutputStream(Main.fileName));
					oos.writeObject(Main.bank);
					
				}
				catch(Exception e2) {
					System.out.println(e2.getMessage()); 
					Main.bank = new Bank();
				}
				finally {
					try {
						oos.close();
						
					}
					catch(Exception e2) {
						System.out.println(e2.getMessage());
					}
				} 

				//dispose();
			} 
		});
		contentPane.add(btnSave);
		
		
		JLabel lblNewLabel = new JLabel("MaxWithLim :");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 164, 84, 14);
		contentPane.add(lblNewLabel);
		
		textField_2 = new JTextField();
		textField_2.setBounds(110, 161, 182, 20);
		textField_2.setBackground(SystemColor.info);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(225, 226, 89, 24);
		btnReset.setFont(new Font("Tempus Sans ITC", Font.BOLD, 16));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				
			}
		});
		contentPane.add(btnReset);
		
		JButton btnHome = new JButton("Home");
		btnHome.setBounds(0, 226, 89, 23);
		btnHome.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Main.frame.setVisible(true); 
				

			}
		});
		contentPane.add(btnHome);
		
		JLabel lblSavingsAccountCreate = new JLabel("Savings Account Create");
		lblSavingsAccountCreate.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 20));
		lblSavingsAccountCreate.setBackground(Color.GRAY);
		lblSavingsAccountCreate.setBounds(96, 11, 229, 32);
		contentPane.add(lblSavingsAccountCreate);
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
		btnNewButton.setBounds(335, 227, 89, 23);
		contentPane.add(btnNewButton);
	}
	}


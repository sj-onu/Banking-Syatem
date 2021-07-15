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

public class CurrentAcc extends JFrame {

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
					CurrentAcc frame = new CurrentAcc();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}); 
	}*/

	/**
	 * Create the frame.
	 */
	public CurrentAcc() {
		setTitle("Current Account");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMemberName = new JLabel("Member Name  :");
		lblMemberName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblMemberName.setBounds(4, 82, 112, 14);
		contentPane.add(lblMemberName);
		
		textField = new JTextField();
		textField.setBounds(142, 79, 171, 20);
		textField.setBackground(SystemColor.info);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(142, 118, 171, 20);
		textField_1.setBackground(SystemColor.info);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		 
		textField_2 = new JTextField();
		textField_2.setBounds(142, 155, 171, 20);
		textField_2.setBackground(SystemColor.info);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnCreate = new JButton("Create"); 
		btnCreate.setBounds(109, 226, 89, 23);
		btnCreate.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name= textField.getText();
				double bal= Double.parseDouble(textField_1.getText());
				String tdNum=textField_2.getText();
				String id=Main.bank.addAccount(name,bal,tdNum);
				JOptionPane.showMessageDialog(null, "Your Current Account is Created Successfully and your Account Number is :"+id);
				ObjectOutputStream oos=null;
				try {
					oos=new ObjectOutputStream(new FileOutputStream(Main.fileName));
					oos.writeObject(Main.bank);
					
				} 
				catch(Exception e1) {
					System.out.println(e1.getMessage());
					Main.bank = new Bank();
				}
				finally {
					try {
						oos.close();
						
					}
					catch(Exception e1) {
						System.out.println(e1.getMessage());
					}
				}
				//dispose();
			} 
			
		});
		contentPane.add(btnCreate);
		
		JLabel lblBalance = new JLabel("Balance");
		lblBalance.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblBalance.setBounds(10, 121, 75, 14);
		contentPane.add(lblBalance);
		
		JLabel lblTdnum = new JLabel("Trade License Number :");
		lblTdnum.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblTdnum.setBounds(10, 164, 122, 11);
		contentPane.add(lblTdnum);
		
		JButton btnHome = new JButton("Home");
		btnHome.setBounds(10, 227, 89, 23);
		btnHome.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Main.frame.setVisible(true); 
	
			}
		});
		contentPane.add(btnHome);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(225, 226, 89, 23);
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
			}
		});
		contentPane.add(btnReset);
		
		JLabel lblNewLabel = new JLabel("Current Account Create");
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(103, 11, 221, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnExit.setBounds(335, 228, 89, 23);
		contentPane.add(btnExit);
	}
}


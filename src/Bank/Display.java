package Bank;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.ListModel;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

public class Display extends JFrame {
	static Homepage bframe = new Homepage();

	private JPanel contentPane; 
	//JList<Object> list1 = null;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
	Display frame = new Display();
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
	public Display() {
		setTitle("Display");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 6, 7));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JList list = new JList();
		list.setBackground(new Color(240, 240, 240));
		list.setBounds(10, 45, 752, 312);
		contentPane.add(list);
		
		JButton btnShow = new JButton("Show");
		btnShow.setFont(new Font("Tempus Sans ITC", Font.BOLD, 12));
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.Account.clear();
				for(BankAccount acc: Main.bank.accounts) {
					Main.Account.addElement(acc.toString());
				}
				list.setModel(Main.Account);
			}
		});
		btnShow.setBounds(0, 11, 89, 23);
		contentPane.add(btnShow);
		
		
		JButton btnExiy = new JButton("Exit");
		btnExiy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExiy.setBounds(290, 207, 89, 23);
		contentPane.add(btnExiy);
		
		JButton btnHome = new JButton("Home");
		btnHome.setFont(new Font("Tempus Sans ITC", Font.BOLD, 12));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.frame.setVisible(true);
				dispose();
			}
		});
		btnHome.setBounds(335, 11, 89, 23);
		contentPane.add(btnHome);
	}
}

package Bank;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.swing.DefaultListModel;

public class Main {
	static Bank bank=new Bank();
	static ObjectInputStream ois=null;
	static String fileName= "account.text";
	static Homepage frame = new Homepage();
	static Bank frameb=new Bank();
	static AddAccount frameadd = new AddAccount();
	static SavingsAcc frameS = new SavingsAcc();
	static CurrentAcc frameC = new CurrentAcc();
	static WithdrawMoney framewith = new WithdrawMoney();
	static DepositeMoney framedip = new DepositeMoney();
	static Display framedisplay = new Display();
	static DefaultListModel<String> Account= new DefaultListModel<String>();	
	
	public static void main(String[] args) throws IOException
	{
		ObjectInputStream ois = null;
		
		try {
			ois = new ObjectInputStream(new FileInputStream(fileName));
			bank= (Bank)ois.readObject();
			
		}catch(Exception e){
			System.out.println(e.getMessage());
			bank= new Bank();
			
		}finally {
			try {
				ois.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
		
		frame.setVisible(true);
		
	}
}


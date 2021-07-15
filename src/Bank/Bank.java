package Bank;


import java.io.Serializable;
import java.util.ArrayList;
public class Bank implements Serializable{

	ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
	
	String addAccount(String name,double accBal, double minBal) {
		BankAccount acc= new BankAccount(name, accBal, minBal);
		accounts.add(acc);
		return acc.accountNumber;
	}
	
	String addAccount(String name,double accBal,double minBal,double maxWithlimit) {
		BankAccount save= new SavingsAccount(name,accBal,maxWithlimit);
		accounts.add(save);
		return save.accountNumber;
	}
	
	String addAccount(String name,double accBal,String tradeLicense) {
		BankAccount cur = new CurrentAccount(name,accBal,tradeLicense);
		accounts.add(cur);
		return cur.accountNumber;
	}
	
	BankAccount findAccount(String accNum) {
		for(int i=0;i<accounts.size();i++) {
			BankAccount facc = accounts.get(i);
			if(facc.accountNumber.equals(accNum))
				return facc;
		}
		
		return null;
	}
	
	public void deposit(String accNum, double amount) {
		BankAccount dep = findAccount(accNum);
		if(dep == null)
			System.out.println("Account is Not Found");
		else
			dep.deposit(amount);

	}
	
	public void withdraw(String accNum, double amount) {
		BankAccount with= findAccount(accNum);
		if(with == null)
			System.out.println("Account is Not Found");
		else
			with.withdraw(amount);

	}
	
	public void display() {
		for(BankAccount acc: accounts) {
			acc.display();
		}
	}
}

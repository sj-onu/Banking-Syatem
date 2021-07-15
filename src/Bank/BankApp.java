package Bank;
import java.io.Serializable;
import java.util.Scanner;

public class BankApp implements Serializable{
	public static void main(String args[]) {
		String Name;
		double amount;
		double accBalance;
		double minBalance;
		double maxWithLimit;
		String tradeLicense;
		String accountNumber;
		
		Scanner scan = new Scanner(System.in);
		Bank bank = new Bank();
		
		int n;
		
		while(true) {
			System.out.println("Press 1 to add new Account");
			System.out.println("Press 2 to Deposit in an existing Account");
			System.out.println("Press 3 to Withdraw from an Account");
			System.out.println("Press 4 Display the List of the Accounts");
			System.out.println("Press 0 to Exit");
			n = scan.nextInt();
			
			if(n==0)
				break;
			else if(n==1) {
				System.out.println("Enter the type of Account, Ex:savings/current");
				String type = scan.next();
				
				if(type.equalsIgnoreCase("savings")) {
					Name = scan.next();
					accBalance = scan.nextDouble();
					maxWithLimit = scan.nextDouble();
					
					String id = bank.addAccount(Name,accBalance,1000,maxWithLimit);
					System.out.println("Your Id for this Account is: "+id);
				}
				else if(type.equalsIgnoreCase("current")) {
					Name = scan.next();
					accBalance = scan.nextDouble();
					tradeLicense = scan.next();
					
					String id = bank.addAccount(Name,accBalance,tradeLicense);
					System.out.println("Your Id for this Account is: "+id);
				}
				else
					System.out.println("Invalid Account type");
			}
			else if(n==2) {
				accountNumber = scan.next();
				amount = scan.nextDouble();
				
				bank.deposit(accountNumber,amount);
			}
			else if(n==3) {
				accountNumber = scan.next();
				amount = scan.nextDouble();
				
				bank.withdraw(accountNumber,amount);
			}
			else if(n==4) {
				bank.display();
			}
			
		}
	}

}

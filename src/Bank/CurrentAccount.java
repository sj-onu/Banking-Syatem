package Bank;


import java.io.Serializable;
public class CurrentAccount extends BankAccount implements Serializable{
	String tradeLicenseNumber;
	
	public CurrentAccount(String name, double accBal, String tradeLicenseNumber) {
		super(name, accBal, 1000);
		this.tradeLicenseNumber = tradeLicenseNumber;
	}

}

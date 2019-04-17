package bankaccount;

public class CheckingAccount extends Account {
	
	// List properties specific for a checking account
	private int debitCardNumber;
	private int debitCardPIN;
	
	// Constructor to initialize checking account properties
	public CheckingAccount(String name, String sSN, double initDeposit) {
		super(name, sSN, initDeposit);
		accountNumber = "2" + accountNumber;
		setDebitCard();
	}
	
	@Override
	public void setRate() {
		rate = getBaseRate() * .15;
	}
	
	// Set specific properties for a checking account
	private void setDebitCard() {
		debitCardNumber  = (int)(Math.random() * Math.pow(10, 12));
		debitCardPIN = (int)(Math.random() * Math.pow(10, 4));
	}
	
	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println(
				"Your cheking account features:\n" +
				" Debit Card Number: " + debitCardNumber + "\n" +
				" Debit Card PIN: " + debitCardPIN
				);
	}
}

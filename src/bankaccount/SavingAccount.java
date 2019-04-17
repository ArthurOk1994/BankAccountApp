package bankaccount;

public class SavingAccount extends Account{
	
	// List properties specific for a saving account
	private int saftyDepositBoxID;
	private int saftyDepositBoxKey;
	
	// Constructor to initialize checking account properties
	public SavingAccount(String name, String sSN, double initDeposit) {
		super(name, sSN, initDeposit);
		accountNumber = "1" + accountNumber;
		setSaftyDepositBox();
	}
	
	@Override
	public void setRate() {
		rate = getBaseRate() - .25;
	}
	
	// Set specific properties for a saving account
	private void setSaftyDepositBox() {
		saftyDepositBoxID  = (int)(Math.random() * Math.pow(10, 3));
		saftyDepositBoxKey = (int)(Math.random() * Math.pow(10, 4));
	}
	
	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println(
				"Your saving account features:\n" +
				" Safety Deposit Box ID: " + saftyDepositBoxID + "\n" +
				" Safety Deposit Box Key: " + saftyDepositBoxKey
				);
	}
}

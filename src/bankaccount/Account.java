package bankaccount;

import java.text.DecimalFormat;

public abstract class Account implements IRate {
	
	private String name;
	private String sSN;
	private double balance;
	
	private static int index = 10000;
	protected String accountNumber;
	protected double rate;
	
	public Account(String name, String sSN, double initDeposit) {
		index ++;
		this.name = name;
		this.sSN = sSN;
		this.balance = initDeposit;
		this.accountNumber = setAccountNumber();
		setRate();
	}
	
	public abstract void setRate();
	
	// Set account number, according task
	private String setAccountNumber() {
		String lastTwoOfSSN = sSN.substring(sSN.length() - 2, sSN.length());
		int uniqueID = index;
		int randomNum = (int)(Math.random() * Math.pow(10, 3));
		return lastTwoOfSSN + uniqueID + randomNum;
	}
	
	// Set accrued interest
	public double setAccruedInterest() {
		double accruedInterest = balance * (rate/100);
		return accruedInterest;
	}
	
	// Inquire your balance after any years
	public void printBalanceToYear(int year) {
		double accruedInterest;
		for(int i = 1; i < year + 1; i ++) {
			accruedInterest = setAccruedInterest();
			balance = balance + accruedInterest;
			System.out.println("Your annual income: $" + setFormattedDouble(accruedInterest));
			System.out.println("Your deposit after " + i + " year: $" + setFormattedDouble(balance));
		}
	}
	
	// Make deposit
	public void deposit(double amount) {
		balance = balance + amount;
		printBalance();
	}
	
	// Make withdraw
	public void widthraw(double amount) {
		balance = balance - amount;
		printBalance();
		if(balance < amount) {
			System.out.println("You can't widthraw such money, your deposit is: $" + balance);
		}
			
	}
	
	// Make transfer
	public void transfer(String toWho, double amount) {
		balance = balance - amount;
		System.out.println("Transfering $" + amount + "to" + toWho);
		printBalance();
	}
	
	// Show current balance
	private void printBalance() {
		//formattedDoubleBallance = new DecimalFormat("#0.00").format(balance);
		System.out.println("Your balance: $" + setFormattedDouble(balance));
	}
	
	// Show info about account
	public void showInfo() {
		System.out.println(
				"Name: " + name + "\n" +
				"SSN: " + sSN + "\n" +
				"Account number: " + accountNumber + "\n" +
				"Balance: " + setFormattedDouble(balance) + "\n" +
				"Rate: " + rate + "%"
				);
	}
	
	// Round all double values to two decimal places
	private String setFormattedDouble(double number) {
		return new DecimalFormat("#0.00").format(number);
	}
	
}

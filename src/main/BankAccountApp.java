package main;

import java.util.List;

import bankaccount.Account;
import bankaccount.SavingAccount;
import utils.CSVReader;

public class BankAccountApp {
	
	public static void main(String[] args) {
		
		String file = "C:\\JavaProjects\\BankAccount\\NewBankAccounts.csv";
		List<String[]> newAccounts = utils.CSVReader.read(file);
		
		// print reading file 
		System.out.println("Read from file:");
		for(int i = 0; i < newAccounts.size(); i ++) {
			String[] arr = newAccounts.get(i);
			String formattedString = utils.CSVReader.toString(arr);
			System.out.println(formattedString);
			
		}
		// print info about account
		for(Account acc : CSVReader.accounts) {
			System.out.println("*****************************************");
			acc.showInfo();
		}
		
		// Some other features of app
		System.out.println("**********************************************");
		Account acc = new SavingAccount("Trisha Mill", "5675830485", 1000);
		//acc2.showInfo();
		acc.printBalanceToYear(2);
		acc.deposit(1500);
		acc.printBalanceToYear(3);
		acc.showInfo();
	}
	
}


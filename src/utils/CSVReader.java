package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import bankaccount.Account;
import bankaccount.CheckingAccount;
import bankaccount.SavingAccount;

public class CSVReader {
	
	public static List<Account> accounts = new LinkedList<Account>();
	
	// This function read data  from CSV file and return as a list
	public static List<String[]> read(String file){
		List<String[]> data = new LinkedList<String[]>();
		String[] dataRecords;
		String dataRow;;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while((dataRow = br.readLine()) != null) {
				dataRecords = dataRow.split(",");
				data.add(dataRecords);
			}
			br.close();
		} catch(FileNotFoundException ex) {
			ex.printStackTrace();
		} catch(IOException ex) {
			ex.printStackTrace();
		}
		return data;
	}
	
	public static String toString(String[] arr) {
		String name = arr[0];
		String sSN = arr[1];
		String accountType = arr[2];
		double initDeposit = Double.parseDouble(arr[3]);
		if(accountType.equals("Savings")) 
			accounts.add(new SavingAccount(name, sSN, initDeposit));
		else if(accountType.equals("Checking")) 
			accounts.add(new CheckingAccount(name, sSN, initDeposit));		
		else {
			System.out.println("ERROR: Cannot reading account type");
			return null;
		}		
		return "Name: " + name + "; " +
				"SSN: " + sSN + "; " +
				"Account type: " + accountType + "; " +
				"Deposit $" + initDeposit;
	}
}
package com.techelevator.view;


import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;


import com.techelevator.tenmo.models.Accounts;
import com.techelevator.tenmo.models.User;
import com.techelevator.tenmo.services.UserService;

public class ConsoleService {

	private PrintWriter out;
	private Scanner in;
UserService userService;


	public ConsoleService(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output, true);
		this.in = new Scanner(input);
	}

	public Object getChoiceFromOptions(Object[] options) {
		Object choice = null;
		while (choice == null) {
			displayMenuOptions(options);
			choice = getChoiceFromUserInput(options);
		}
		out.println();
		return choice;
	}

	private Object getChoiceFromUserInput(Object[] options) {
		Object choice = null;
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.valueOf(userInput);
			if (selectedOption > 0 && selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			}
		} catch (NumberFormatException e) {
			// eat the exception, an error message will be displayed below since choice will be null
		}
		if (choice == null) {
			out.println("\n*** " + userInput + " is not a valid option ***\n");
		} 
		return choice;
	}

	private void displayMenuOptions(Object[] options) {
		out.println();
		for (int i = 0; i < options.length; i++) {
			int optionNum = i + 1;
			out.println(optionNum + ") " + options[i]);
		}
		out.print("\nPlease choose an option >>> ");
		out.flush();
	}

	public String getUserInput(String prompt) {
		out.print(prompt+": ");
		out.flush();
		return in.nextLine();
	}

	public void listUsers(User[] user) {
		System.out.println("--------------------------------------------");
		System.out.println(String.format("%1$-12s", "User Id") + String.format("%1$-12s", "Name"));
		System.out.println("--------------------------------------------");
		for (User users : user) {
			System.out.println(String.format("%1$-12s", users.getId()) + String.format("%1$-12s", users.getUsername()));
		}
		System.out.println("--------------------------------------------");
		
	}
	
	public int sendBucks() {
		System.out.println("Enter ID of user you are sending to (0 to cancel): ");
		Scanner scanner = new Scanner(System.in);
		int idInput = scanner.nextInt();
		scanner.nextLine();
		return idInput;
	}
	
	public double amountToSend() {
		System.out.println("Enter amount: $");
		Scanner scanner = new Scanner(System.in);
		String amountInput = scanner.nextLine();
		Double amount = Double.parseDouble(amountInput);
		return amount;
	}
	
	
	
	public Integer getUserInputInteger(String prompt) {
		Integer result = null;
		do {
			out.print(prompt+": ");
			out.flush();
			String userInput = in.nextLine();
			try {
				result = Integer.parseInt(userInput);
			} catch(NumberFormatException e) {
				out.println("\n*** " + userInput + " is not valid ***\n");
			}
		} while(result == null);
		return result;
	}
	
	
	public void viewBalance(Accounts currentBalance) {
		System.out.println("Your current account balance is: ");
	}
	
	
	
	 }
	
	


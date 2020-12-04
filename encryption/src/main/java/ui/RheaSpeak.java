package ui;

import encyptionTypes.Caesar;

import java.util.Random;
import java.util.Scanner;

public class RheaSpeak {

	public static void main(String[] args) {
		
		Scanner userInput = new Scanner(System.in);
		
		System.out.println("Welcome to RheaSpeak!\n\nWith RheaSpeak you can encrypt your messages "
				+ "using the cipher method of your choice!\n");
		
		System.out.println("Please enter the message you would like to encrypt:\n");
		String message = userInput.nextLine();
		
		boolean check = true;
		
		do {
			System.out.println("\nWhich encryption method would you like to use?\n");
			System.out.println("(1)Caesar");
			
			while (!userInput.hasNextInt()) {
				String input = userInput.next();
				System.out.print("\nPlease enter an integer: \n");
			}
			int cipher = userInput.nextInt();
			
			switch (cipher) {
			
				case 1:
					Caesar caesar = new Caesar();
				
					System.out.print("\nPlease enter a key as an integer or type '00' and we'll "
							+ "generate one for you!\n");
				
					while (!userInput.hasNextInt()) {
						String input = userInput.next();
						System.out.print("Please enter an integer\n");
					}
					int userKey = userInput.nextInt();
				
					if (userKey == 00) {
						int autoKey = caesar.generateKey();
						String encrypted = caesar.encrypt(message, autoKey);
						
						System.out.println("\nMessage");
						System.out.println("-------\n");
						System.out.println(encrypted + "\n\nYour key: " + autoKey);
					}
					else {
						String encrypted = caesar.encrypt(message, userKey);
						
						System.out.println("\nMessage");
						System.out.println("-------\n");
						System.out.println(encrypted + "\n\nYour key: " + userKey);
						System.out.println("------------");
					}
					check = false;
					break;
					
				default:
					System.out.println("\nPlease choose a valid option\n");
					System.out.println("----------------------------");
			}

			
		} while (check);
		
		userInput.close();
	}

}

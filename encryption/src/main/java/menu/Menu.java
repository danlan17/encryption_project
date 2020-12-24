package menu;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import encyption.Caesar;
import encyption.Substitution;
import encyption.Vigenere;

public class Menu {

	private Scanner in;
	private PrintWriter out;
	private String message;
	
	public Menu(InputStream in, OutputStream out) {
		this.in = new Scanner(in);
		this.out = new PrintWriter(out);
	}
	
	public String getChoice(String[] options) {
		
		String choice = null;
		
		while (choice == null) {
			displayOptions(options);
			choice = userChoice(options);
		}
		return choice;
	}
	
	private void displayOptions(String[] options) {
		
		out.println();
		for (int i=0; i < options.length; i++) {
			int num = i + 1;
			out.println(num + ") " + options[i]);
		}
		out.println("\nPlease Choose An Option >>>");
		out.flush();
	}
	
	private String userChoice(String[] options) {
		
		String choice = null;
		String input = in.nextLine();
		
		try {
			int selected = Integer.valueOf(input);
			
			if (selected > 0 && selected <= options.length) {
				choice = options[selected - 1];
			}
		}
		catch (NumberFormatException e) {
		}
		
		if (choice == null) {
			out.println("\nInvalid Option");
			out.flush();
		}
		return choice;
	}
	
	public void getMessage() {
		
		String message = null;
		
		while (message == null || message.isEmpty() || message.isBlank()) {
			
			out.println("\nPlease enter the message you would like to encrypt: ");
			out.flush();
			message = in.nextLine();
		}
		this.message = message;
		out.println("\nMessage Successfully Entered");
		out.flush();
	}
	
	private void displayEncrypted(String encrypted, String key) {
		
		out.println("\nMessage");
		out.println("-----------------------\n");
		out.println(encrypted + "\n\nYour key: " + key);
		out.println("-----------------------");
		out.flush();
	}
	
	public void callCipher(String selection) {
		
		if (selection.equals("Caesar")) {
			
			Caesar caesar = new Caesar();
			out.print("\nPlease enter a key as an integer or enter '00' and we'll "
					+ "generate one for you!\n");
			out.flush();
			
			boolean valid = false;
			int key = 0;
			
			while (!valid) {
				try {
					key = Integer.parseInt(in.nextLine());
					valid = true;
				}
				catch (NumberFormatException ex) {
					out.println("\nInvalid Key");
					out.flush();
				}
			}
			out.println("\nKey Successfully Entered");
			out.flush();
			
			caesar.setKey(key);
			int userKey = caesar.getKey();
			String encrypted = caesar.encrypt(this.message);
			displayEncrypted(encrypted, String.valueOf(userKey));
		}
		else if (selection.equals("Substitution")) {
			
			Substitution sub = new Substitution();
			String encrypted = sub.encrypt(this.message);
			String userKey = sub.getAlphaKey().toString().toUpperCase() + "\n          ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			displayEncrypted(encrypted, userKey);
		}
		else if (selection.equals("Vigenere")) {
			
			out.println("\nNote: all non-alphabet characters and spaces will be removed from original message");
			out.flush();
			
			Vigenere vig = new Vigenere();
			String formattedMessage = vig.formatMessage(this.message);
			String userKey = null;
			boolean auto = false;
			
			while (userKey == null || userKey.isEmpty() || userKey.isBlank()) {
				out.println("\nPlease enter a word or string of letters as a key. Or enter '00' "
						+ "and we'll generate one for you! (Note: non-alphabet characters and spaces "
						+ "will be removed from the key)\n");
				out.flush();
				
				String input = in.nextLine();
				
				if (input.equals("00")) {
					vig.generateKey();
					userKey = vig.getKey();
					auto = true;
				}
				else if (!input.matches(".*[A-Za-z]+.*")) {
					out.println("\nKey must have at least one alphabet character.");
					userKey = null;
				}
				else {
					userKey = input;
				}		
			}
			
			if (!auto) {
				userKey = vig.formatKey(userKey, formattedMessage);
			}
		
			String encrypted = vig.encrypt(formattedMessage);
			displayEncrypted(encrypted, userKey);
		}
	}
	
	
	
}

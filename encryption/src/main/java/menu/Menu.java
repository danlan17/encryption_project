package menu;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import encyption.Caesar;
import encyption.Substitution;

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
			System.out.println("\nInvalid Option");
		}
		return choice;
	}
	
	public void getMessage() {
		
		String message = null;
		
		while (message == null || message.isEmpty() || message.isBlank()) {
			System.out.println("\nPlease enter the message you would like to encrypt: ");
			message = in.nextLine();
		}
		this.message = message;
		System.out.println("\nMessage Successfully Entered");
		
	}
	
	private void displayEncrypted(String encrypted, String key) {
		
		System.out.println("\nMessage");
		System.out.println("-----------------------\n");
		System.out.println(encrypted + "\n\nYour key: " + key);
		System.out.println("-----------------------");
	}
	
	public void callCipher(String selection) {
		
		if (selection.equals("Caesar")) {
			Caesar caesar = new Caesar();
			System.out.print("\nPlease enter a key as an integer or enter '00' and we'll "
					+ "generate one for you!\n");
			
			boolean valid = false;
			int key = 0;
			
			while (!valid) {
				try {
					key = Integer.parseInt(in.nextLine());
					valid = true;
				}
				catch (NumberFormatException ex) {
				}
				if (!valid) {
					System.out.println("\nInvalid Key");
				}
			}
			System.out.println("\nKey Successfully Entered");
			
			caesar.setKey(key);
			int userKey = caesar.getKey();
			String encrypted = caesar.encrypt(this.message);
			displayEncrypted(encrypted, String.valueOf(userKey));
		}
		else if (selection.equals("Substitution")) {
			Substitution sub = new Substitution();
			String encrypted = sub.encrypt(this.message);
			String userKey = sub.getAlphaKey().toString() + "\n          abcdefghijklmnopqrstuvwxyz";
			displayEncrypted(encrypted, userKey);
		}
	}
	
	
	
}

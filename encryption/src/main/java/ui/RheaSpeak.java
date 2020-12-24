package ui;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import encyption.Caesar;
import menu.Menu;

public class RheaSpeak {
	
	private String[] MAIN_MENU = {"Encrypt A New Message", "Exit"};
	private String[] CIPHER_OPTIONS = {"Caesar", "Substitution", "Vigenere", "Back"};
	private Menu menu;
	
	public RheaSpeak(Menu menu) {
		this.menu = menu;
	}
	
	public void run() {
		
		System.out.println("Welcome to RheaSpeak!\n\nWith RheaSpeak you can encrypt your messages "
				+ "using the cipher method of your choice!");
		
		while (true) {
			
			 String choice = menu.getChoice(MAIN_MENU);
			 
			 if (choice.equals("Encrypt A New Message")) {
				 
				 menu.getMessage();
				 System.out.println("\nWhich cipher method would you like to use?");
				 String selection = "";
				 
				 while (!selection.equals("Back")) {
					 
					selection = menu.getChoice(CIPHER_OPTIONS);
					
					if (!selection.equals("Back")) {
						menu.callCipher(selection);
					}
				 }
			 }
			 else if (choice.equals("Exit")) {
				 
				 System.out.println("\nThank you for using RheaSpeak!");
				 System.exit(0);
			 }
		}
	}

	public static void main(String[] args) {
		
		Menu menu = new Menu(System.in, System.out);
		RheaSpeak cli = new RheaSpeak(menu);
		cli.run();
		
	}

}

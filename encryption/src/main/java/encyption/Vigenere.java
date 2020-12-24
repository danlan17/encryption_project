package encyption;

import java.util.Random;

public class Vigenere implements Cipher{
	
	private String key;
	private String userMessage;

	public String getKey() {
		return key;
	}

	@Override
	public void generateKey() {
		Random r = new Random();
		int len = this.userMessage.length();
		StringBuilder autoKey = new StringBuilder(len);
		
		for (int i = 0; i < len; i++) {
			char let = (char)(r.nextInt(26) + 65);
			autoKey.append(let);
		}
		this.key = autoKey.toString();
	}
	
	@Override
	public String encrypt(String text) {
		StringBuilder newMessage = new StringBuilder(text.length());
		
		for (int i = 0; i < text.length(); i++) {
			
			int origin = text.charAt(i) - 65;
			int k = this.key.charAt(i) - 65;
			char let = (char)((origin + k) % 26 + 65);
			newMessage.append(let);
		}
		return newMessage.toString();
	}

	public String formatMessage(String message) {
		String formatted = message.replaceAll("[^A-Za-z]+", "").toUpperCase();
		this.userMessage = formatted;
		
		return formatted;
	}

	public String formatKey(String key, String message) {
		
		String stripped = key.replaceAll("[^A-Za-z]", "").toUpperCase();
		StringBuilder newKey = new StringBuilder(message.length());
		
		int p = 0;
		
		for (int i = 0; i < message.length(); i++) {
			newKey.append(stripped.charAt(p++));
			
			if (p == stripped.length()) {
				p = 0;
			}
		}
		String formattedKey = newKey.toString();
		this.key = formattedKey;
		
		if (stripped.length() < message.length()) {
			return stripped;
		}
		return formattedKey;
	}
}

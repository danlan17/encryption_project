package encyptionTypes;

import java.util.Random;

public class Caesar {
	
	public int generateKey() {
		Random r = new Random();
		int key = r.nextInt(27);
		return key;
	}
	
	public String encrypt(String text, int key) {
		
		if (text == null || text.isEmpty()) {
			return "Text is required";
		}
		
		StringBuilder newStr = new StringBuilder();
		
		for (int i=0; i < text.length(); i++) {
			char let = text.charAt(i);
			newStr.append(caesarMachine(let, key));
		}
		return newStr.toString();
	}
	
	public char caesarMachine(char letter, int key) {
		
		int ascii = letter;
		char newChar = letter;
		int trueKey = key;
		if (trueKey < 0) {
			trueKey = 26 + trueKey % -26;
		}
		if (Character.isLetter(letter)) {
			if (Character.isUpperCase(letter)) {
				//A-Z = 65-90
				ascii = (ascii - 65 + trueKey) % 26 + 65;
				newChar = (char) ascii;
			}
			else {
				//a-z = 97-122
				ascii = (ascii - 97 + trueKey) % 26 + 97;
				newChar = (char) ascii;
			}
		}
		return newChar;
	}
}

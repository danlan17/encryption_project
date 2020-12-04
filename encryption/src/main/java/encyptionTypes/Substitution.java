package encyptionTypes;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Substitution {
	
	private StringBuilder alphaKey = new StringBuilder(26);
	private Map<Character, Character> keyMap = new HashMap<>();
	List<Character> alphabet = new ArrayList<>();
	
	public StringBuilder getAlphaKey() {
		
		return this.alphaKey;
	}
	
	public void generateMap() {
		
		for (int i=0; i < 26; i++) {
			alphabet.add((char)(97+i));
		}

		Collections.shuffle(alphabet);
		
		for (int i=0; i < 26; i++) {
		
			char letter = (char) (97 + i);
			char subLet = this.alphabet.get(i);
			
			keyMap.put(letter, subLet);
			this.alphaKey.append(subLet);
		}
	}
	
	public StringBuilder encrypt(String text) {
		
		generateMap();
		StringBuilder encrypted = new StringBuilder();
		
		for (int i=0; i < text.length(); i++) {
			char letter = text.charAt(i);
			
			if (Character.isLetter(letter)) {
				if (Character.isLowerCase(letter)) {
					encrypted.append(keyMap.get(letter));
				}
				else {
					int ascii = letter + 32;
					char lower = keyMap.get((char) ascii);
					int subAscii = lower - 32;
					encrypted.append((char) subAscii);
				}
			}
			else {
				encrypted.append(letter);
			}
		}
		
		return encrypted;
	}
}

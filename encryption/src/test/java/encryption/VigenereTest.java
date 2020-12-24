package encryption;

import static org.junit.Assert.*;

import org.junit.Test;

import encyption.Vigenere;

public class VigenereTest {

	private Vigenere vig = new Vigenere();
	private static String TEST = "This is a 'test' message!?";
	
	@Test
	public void formatMessageTest() {
		
		String expected = "THISISATESTMESSAGE";
		String actual = vig.formatMessage(TEST);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void formatKeyTest() {
		
		String key = "this is a 'key'!?";
		String key2 = "this key is way too long don't you think?";
		String message = vig.formatMessage(TEST);
		String actual = vig.formatKey(key, message);
		String actual2 = vig.formatKey(key2, message);
		String expected = "THISISAKEY";
		String expected2 = "THISKEYISWAYTOOLON";
		
		assertEquals(expected, actual);
		assertEquals(expected2, actual2);	
	}
	
	@Test
	public void generateKeyTest() {
		
		String message = vig.formatMessage(TEST);
		vig.generateKey();
		String key = vig.getKey();
		String formatted = vig.formatKey(key, message);
		
		assertEquals(message.length(), key.length());
		assertEquals(key, formatted);
	}
	
	@Test
	public void encryptTest() {
		String message = "CRYPTOISSHORTFORCRYPTOGRAPHY";
		String key = vig.formatKey("ABCD", message);
		
		String expected = "CSASTPKVSIQUTGQUCSASTPIUAQJB";
		String actual = vig.encrypt(message);
		
		assertEquals(expected, actual);
	}

}

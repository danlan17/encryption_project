package encryption;

import static org.junit.Assert.*;

import org.junit.Test;

import encyption.Substitution;

public class SubstitutionTest {

	private Substitution test;
	
	@Test
	public void testGenerateKey() {
		
		test = new Substitution();
		test.generateKey();
		
		StringBuilder key = new StringBuilder(26);
		StringBuilder alpha = test.getAlphaKey();
		
		for (int i=0; i < alpha.length(); i++) {
			key.append(test.getKeyMap().get(alpha.charAt(i)));
		}
		
		assertFalse(key.equals(alpha));
	}

	@Test
	public void testEncrypt() {
		
		test = new Substitution();
		
		String message = "Hi, this test message should come out scrambled.";
		String message2 = "";
		String message3 = null;
		String actual = test.encrypt(message);
		String actual2 = test.encrypt(message2);
		String actual3 = test.encrypt(message3);
		
		assertFalse(actual.equals(message));
		assertEquals(actual2, "Text is required");
		assertEquals(actual3, "Text is required");
	}
}

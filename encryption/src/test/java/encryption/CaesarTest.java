package encryption;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import encyption.Caesar;

public class CaesarTest {

	
	@Test
	public void testGenerateKey() {
		
		Caesar test = new Caesar();
		test.generateKey();
	
		Assert.assertTrue(test.getKey() >= 0 && test.getKey() <= 26);
	}
	
	@Test
	public void testCaesarMachine() {
//		Checks for correct return on lower/upper cases, edge of
//		normal key values, outside of normal key values, negative
//		key values, and return non-alphabet characters unmodified
		
		Caesar test = new Caesar();
		
		assertEquals('a', test.caesarMachine('z', 1));
		assertEquals('D', test.caesarMachine('C', 1));
		assertEquals('M', test.caesarMachine('P', -3));
		assertEquals('Z', test.caesarMachine('A', -53));
		assertEquals('i', test.caesarMachine('i', 26));
		assertEquals('O', test.caesarMachine('N', 53));
		assertEquals(' ', test.caesarMachine(' ', 5));
		assertEquals('!', test.caesarMachine('!', 7));
		assertEquals('5', test.caesarMachine('5', 10));
	}
	
	@Test
	public void testEncrypt() {
//		Checks if encrypt() returns correct chars from caesarMachine()
//		and correctly builds chars back into StringBuilder
		
		Caesar test = new Caesar();
		
		test.setKey(5);
		String actual1 = test.encrypt("Hi! My name is Dan.");
		assertEquals("Mn! Rd sfrj nx Ifs.", actual1);
		
		test.setKey(1);
		String actual2 = test.encrypt("HAL");
		assertEquals("IBM", actual2);
		

		 
		
		
	}
}
	

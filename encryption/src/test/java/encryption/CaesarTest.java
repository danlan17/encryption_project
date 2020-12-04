package encryption;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import encyptionTypes.Caesar;

public class CaesarTest {

	
	@Test
	public void testGenerateKey() {
		
		Caesar test = new Caesar();
	
		Assert.assertTrue(test.generateKey() >= 0 && test.generateKey() <= 26);
	}
	
	@Test
	public void testCaesarMachine() {
		
		Caesar test = new Caesar();
		
		/*Checks for correct return on lower/upper cases, edge of
		 *normal key values, outside of normal key values, negative
		 *key values, and return non-alphabet characters unmodified
		 */
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
		
		Caesar test = new Caesar();
		
		String actual1 = test.encrypt("Hi! My name is Dan.", 5);
		String actual2 = test.encrypt("HAL", 1);
		
		/*Checks if conversion returns correct chars from caesarMachine()
		 *and correctly concatenates chars back into string
		 */
		assertEquals("Mn! Rd sfrj nx Ifs.", actual1);
		assertEquals("IBM", actual2);
	}
}
	

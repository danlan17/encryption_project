package encyption;

public interface Cipher {

	void generateKey();
	String encrypt(String message);
}

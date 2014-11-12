package generator;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import exceptions.UnsupportedCryptographyException;

import message.HashedMessage;

public class HashGenerator {
	public HashedMessage hash(String text) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] digest = md.digest(text.getBytes("UTF-8"));
			return new HashedMessage(digest);
		} 
		catch (NoSuchAlgorithmException e) {
			throw new UnsupportedCryptographyException(e);
		} 
		catch (UnsupportedEncodingException e) {
			throw new UnsupportedCryptographyException(e);
		}
	}
}

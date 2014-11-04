package symmetric;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;

import exceptions.CryptographicOperationException;
import exceptions.UnsupportedCryptographyException;

import message.EncryptedMessage;

import key.IV;
import key.SymmetricKey;

public class Encryptor {
	private SymmetricKey key;
	
	public Encryptor(SymmetricKey key) {
		this.key = key;
	}
	
	public EncryptedMessage encrypt(byte[] bytes) throws CryptographicOperationException {
		try {
			IV iv = new IV();
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, key.getKey(), new IvParameterSpec(iv.getBytes()));
			byte[] ciphertext = cipher.doFinal(bytes);
			return new EncryptedMessage(iv, ciphertext);
		}
		catch (NoSuchAlgorithmException e) {
			throw new UnsupportedCryptographyException(e);
		}
		catch (NoSuchPaddingException e) {
			throw new UnsupportedCryptographyException(e);
		}
		catch (InvalidAlgorithmParameterException e) {
			throw new UnsupportedCryptographyException(e);
		}
		catch (InvalidKeyException e) {
			throw new CryptographicOperationException(e);
		}
		catch (IllegalBlockSizeException e) {
			throw new CryptographicOperationException(e);
		}
		catch (BadPaddingException e) {
			throw new CryptographicOperationException(e);
		}
	}
	
	public EncryptedMessage encrypt(String plaintext) throws CryptographicOperationException {
		try {
			byte[] plainBytes = plaintext.getBytes("UTF-8");
			return encrypt(plainBytes);
		}
		catch (UnsupportedEncodingException e) {
			throw new UnsupportedCryptographyException(e);
		}
	}
}

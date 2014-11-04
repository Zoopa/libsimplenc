package symmetric;

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

import key.SymmetricKey;

import message.DecryptedMessage;
import message.EncryptedMessage;

public class Decryptor {
	private SymmetricKey key;
	
	public Decryptor(SymmetricKey key) {
		this.key = key;
	}
	
	public DecryptedMessage decrypt(EncryptedMessage encryptedMsg) throws CryptographicOperationException {
		try {
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, key.getKey(), new IvParameterSpec(encryptedMsg.getIv().getBytes()));
			byte[] plaintext = cipher.doFinal(encryptedMsg.getBytes());
			return new DecryptedMessage(plaintext);
		}
		catch(NoSuchAlgorithmException e) {
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
}

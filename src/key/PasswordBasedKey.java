package key;

import java.security.GeneralSecurityException;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import password.Password;
import password.Salt;

public class PasswordBasedKey extends SymmetricKey{
	private final static int PBKDF2_ITERATIONS = 10000;
	private final static int PBKDF2_BIT_LENGTH = 256;
	private Salt salt;
	
	public PasswordBasedKey(Password password, Salt salt) {
		this.salt = salt;
		key = pbkdf2(password, salt);
	}
	
	public Salt getSalt() {
		return salt;
	}
	
	private SecretKey pbkdf2(Password password, Salt salt) {
	    try {
	        PBEKeySpec spec = new PBEKeySpec(password.getChars(), salt.getBytes(), PBKDF2_ITERATIONS, PBKDF2_BIT_LENGTH);
	        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
	        byte[] hash = skf.generateSecret(spec).getEncoded();
	        return new SecretKeySpec(hash, "AES");
	    }
	    catch(GeneralSecurityException gse) {
	    	throw new UnsupportedOperationException(gse);
	    }
	}
}

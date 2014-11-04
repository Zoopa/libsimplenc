package key;

import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;

public class RandomKey extends SymmetricKey{
	
	public RandomKey() {
		try {
			KeyGenerator gen = KeyGenerator.getInstance("AES");
			gen.init(256);
			key = gen.generateKey();
		}
		catch(NoSuchAlgorithmException nsae) {
			throw new UnsupportedOperationException(nsae);
		}
	}
}

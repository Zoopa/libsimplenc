package key;

import javax.crypto.SecretKey;

public abstract class SymmetricKey {
	protected final static int KEY_LENGTH_BITS = 256;
	protected SecretKey key;
	
	public SecretKey getKey() {
		return key;
	}
}

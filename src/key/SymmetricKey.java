package key;

import javax.crypto.SecretKey;

public abstract class SymmetricKey {
	protected SecretKey key;
	
	public SecretKey getKey() {
		return key;
	}
}

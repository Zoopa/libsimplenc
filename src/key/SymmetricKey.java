package key;

import interfaces.HexPrintable;

import javax.crypto.SecretKey;

import util.HexUtil;

public abstract class SymmetricKey implements HexPrintable{
	protected final static int KEY_LENGTH_BITS = 256;
	protected SecretKey key;
	
	public SecretKey getKey() {
		return key;
	}
	
	@Override
	public String getHexString() {
		return HexUtil.toHex(key.getEncoded());
	}
}

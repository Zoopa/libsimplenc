package generator;

import interfaces.HexPrintable;

import java.security.SecureRandom;

import util.HexUtil;

public abstract class RandomByteGenerator implements HexPrintable{
	protected byte[] bytes;
	
	public RandomByteGenerator(int bits) {
		bytes = new byte[bits / 8];
		SecureRandom secran = new SecureRandom();
        secran.nextBytes(bytes);
	}
	
	public byte[] getBytes() {
		return bytes;
	}
	
	@Override
	public String getHexString() {
		return HexUtil.toHexString(bytes);
	}
}

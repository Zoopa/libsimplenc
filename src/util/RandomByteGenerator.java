package util;

import java.security.SecureRandom;

public abstract class RandomByteGenerator {
	protected byte[] bytes;
	
	public RandomByteGenerator(int bits) {
		bytes = new byte[bits / 8];
		SecureRandom secran = new SecureRandom();
        secran.nextBytes(bytes);
	}
	
	public byte[] getBytes() {
		return bytes;
	}
}

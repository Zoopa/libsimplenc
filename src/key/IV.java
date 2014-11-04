package key;

import util.RandomByteGenerator;

public class IV extends RandomByteGenerator{
	//Use 128 bits because AES blocks are 128 bits
	private final static int IV_LENGTH_BITS = 128;
	
	public IV() {
		super(IV_LENGTH_BITS);
	}
}

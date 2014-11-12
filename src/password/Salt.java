package password;

import generator.RandomByteGenerator;

public class Salt extends RandomByteGenerator{
	//NIST recommends 128 bits or more
	private final static int SALT_LENGTH_BITS = 128;
	
	public Salt() {
		super(SALT_LENGTH_BITS);
	}
}

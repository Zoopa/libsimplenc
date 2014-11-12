package message;

import key.IV;

public class EncryptedMessage extends Message{
	private IV iv;
	
	public EncryptedMessage(IV iv, byte[] ciphertext) {
		this.iv = iv;
		this.bytes = ciphertext;
	}
	
	public IV getIv() {
		return iv;
	}
}

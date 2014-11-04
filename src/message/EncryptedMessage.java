package message;

import key.IV;
import util.HexUtil;

public class EncryptedMessage extends Message{
	private IV iv;
	
	public EncryptedMessage(IV iv, byte[] ciphertext) {
		this.iv = iv;
		this.bytes = ciphertext;
	}
	
	public IV getIv() {
		return iv;
	}
	
	@Override
	public String toString() {
		return "{MSG:" + HexUtil.toHex(bytes) + ", IV:" + HexUtil.toHex(iv.getBytes()) + "}";
 	}
}

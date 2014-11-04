package message;

import java.io.UnsupportedEncodingException;

import util.HexUtil;

public class DecryptedMessage extends Message{
	
	public DecryptedMessage(byte[] plaintext) {
		this.bytes = plaintext;
	}
	
	public String getString() {
		try {
			return new String(bytes, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return new String(bytes);
		}
	}
	
	public String getHexString() {
		return HexUtil.toHex(bytes);
	}
}

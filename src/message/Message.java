package message;

import interfaces.HexPrintable;
import util.HexUtil;

public abstract class Message implements HexPrintable{
	protected byte[] bytes;

	public byte[] getBytes() {
		return bytes;
	}
	
	@Override
	public String getHexString() {
		return HexUtil.toHexString(bytes);
	}
}

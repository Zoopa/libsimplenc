package message;

public class HashedMessage extends Message{
	public HashedMessage(byte[] hash) {
		this.bytes = hash;
	}
}

package util;

public class HexUtil {
	private final static char[] hexArray = "0123456789ABCDEF".toCharArray();
	
	//http://stackoverflow.com/a/9855338
	public static String toHex(byte[] bytes) {
	    char[] hexChars = new char[bytes.length * 2];
	    
	    for ( int j = 0; j < bytes.length; j++ ) {
	        int v = bytes[j] & 0xFF;
	        hexChars[j * 2] = hexArray[v >>> 4];
	        hexChars[j * 2 + 1] = hexArray[v & 0x0F];
	    }
	    
	    return new String(hexChars);
	}
}

package util;

public class HexUtil {
	private final static char[] hexArray = "0123456789ABCDEF".toCharArray();
	
	//http://stackoverflow.com/a/9855338
	public static String toHexString(byte[] bytes) {
	    char[] hexChars = new char[bytes.length * 2];
	    
	    for ( int j = 0; j < bytes.length; j++ ) {
	        int v = bytes[j] & 0xFF;
	        hexChars[j * 2] = hexArray[v >>> 4];
	        hexChars[j * 2 + 1] = hexArray[v & 0x0F];
	    }
	    
	    return new String(hexChars);
	}
	
	//http://stackoverflow.com/a/140861
	public static byte[] fromHexString(String hexString) {
		int len = hexString.length();
	    byte[] data = new byte[len / 2];
	    
	    for (int i = 0; i < len; i += 2) {
	        data[i / 2] = (byte) ((Character.digit(hexString.charAt(i), 16) << 4) + Character.digit(hexString.charAt(i+1), 16));
	    }
	    
	    return data;
	}
}

package password;

public class Password {
	private char[] password;
	
	public Password(char[] password) {
		this.password = password.clone();
	}
	
	public char[] getChars() {
		return password;
	}
	
	public void clear() {
		for(int i = 0; i < password.length; i++) {
			password[i] = 0;
		}
	}
}

package main;

import password.Password;
import password.Salt;
import exceptions.CryptographicOperationException;
import message.EncryptedMessage;

import symmetric.Decryptor;
import symmetric.Encryptor;
import util.HexUtil;

import key.PasswordBasedKey;
import key.RandomKey;

public class Main {
	public static void main(String[] args){
		new Main();
	}

	public Main(){
		try {
			System.out.println("\nTesting Keys\n=======");
			
			for(int i = 0; i < 5; i++) {
				RandomKey r = new RandomKey();
				System.out.println("RandomKey  " + (i+1) + ":" + HexUtil.toHex(r.getKey().getEncoded()));

				Salt s = new Salt();
				Password pwd = new Password("test".toCharArray());
				PasswordBasedKey p = new PasswordBasedKey(pwd, s);
				System.out.println("PasswordBasedKey  " + (i+1) + ":" + HexUtil.toHex(p.getKey().getEncoded()));
			}
			
			System.out.println("\nEncryption and Decryption with PasswordBasedKey\n=======");

			Salt salt = new Salt();
			Password password = new Password("MyPasswd12".toCharArray());
			PasswordBasedKey passwordBasedKey = new PasswordBasedKey(password, salt);
			password.clear();
			
			Encryptor enc1 = new Encryptor(passwordBasedKey);
			Decryptor dec1 = new Decryptor(passwordBasedKey);
			
			EncryptedMessage msg = enc1.encrypt("This is a test 1");
			System.out.println(msg);
			System.out.println(dec1.decrypt(msg).getString());

			msg = enc1.encrypt(new byte[] {1, 2, 3, 4});
			System.out.println(msg);
			System.out.println(dec1.decrypt(msg).getHexString());

			System.out.println("\nEncryption and Decryption with RandomKey\n=======");
			
			RandomKey randomKey = new RandomKey();
			Encryptor enc2 = new Encryptor(randomKey);
			Decryptor dec2 = new Decryptor(randomKey);
			
			msg = enc2.encrypt("This is a test 2");
			System.out.println(msg);
			System.out.println(dec2.decrypt(msg).getString());
			
			msg = enc2.encrypt(new byte[] {-1, -2, -3, -4});
			System.out.println(msg);
			System.out.println(dec2.decrypt(msg).getHexString());
			
		} catch (CryptographicOperationException e) {
			e.printStackTrace();
		}
	}
}

package main;

import password.Password;
import password.Salt;
import exceptions.CryptographicOperationException;
import generator.HashGenerator;
import message.EncryptedMessage;
import message.HashedMessage;

import symmetric.Decryptor;
import symmetric.Encryptor;

import key.PasswordBasedKey;
import key.RandomKey;

public class Main {
	public static void main(String[] args){
		new Main();
	}

	public Main(){
		try {			
			/*
			 * Encryption / decryption with password-based key
			 */
			System.out.println("\n=======\nEncryption and Decryption using PasswordBasedKey\n=======");

			Salt salt = new Salt();
			
			Password password = new Password("MyPasswd12".toCharArray());
			PasswordBasedKey passwordBasedKey = new PasswordBasedKey(password, salt);
			password.clear();
			
			Encryptor enc1 = new Encryptor(passwordBasedKey);
			Decryptor dec1 = new Decryptor(passwordBasedKey);
			
			System.out.println("Salt: " + salt.getHexString());
			System.out.println("Key: " + passwordBasedKey.getHexString());

			System.out.println("\nwith String\n=======");
			
			EncryptedMessage msg1 = enc1.encrypt("This is a test 1");
			System.out.println("IV: " + msg1.getIv().getHexString());
			System.out.println("Ciphertext: " + msg1.getHexString());
			System.out.println("Plaintext: " + dec1.decrypt(msg1).getString());

			System.out.println("\nwith Bytes\n=======");

			msg1 = enc1.encrypt(new byte[] {1, 2, 3, 4});
			System.out.println("IV: " + msg1.getIv().getHexString());
			System.out.println("Ciphertext: " + msg1.getHexString());
			System.out.println("Plaintext: " + dec1.decrypt(msg1).getHexString());
			
			/*
			 * Encryption / decryption with random key
			 */
			System.out.println("\n\n=======\nEncryption and Decryption using RandomKey\n=======");
			
			RandomKey randomKey = new RandomKey();
			Encryptor enc2 = new Encryptor(randomKey);
			Decryptor dec2 = new Decryptor(randomKey);
			
			System.out.println("Key: " + randomKey.getHexString());

			System.out.println("\nwith String\n=======");
			
			EncryptedMessage msg2 = enc2.encrypt("This is a test 2");
			System.out.println("IV: " + msg2.getIv().getHexString());
			System.out.println("Ciphertext: " + msg2.getHexString());
			System.out.println("Plaintext: " + dec2.decrypt(msg2).getString());

			System.out.println("\nwith Bytes\n=======");
			msg2 = enc2.encrypt(new byte[] {-1, -2, -3, -4});
			System.out.println("IV: " + msg2.getIv().getHexString());
			System.out.println("Ciphertext: " + msg2.getHexString());
			System.out.println("Plaintext: " + dec2.decrypt(msg2).getHexString());
			
			/*
			 * Hashing
			 */
			System.out.println("\n\n=======\nHashing\n=======");
			HashGenerator hashGen = new HashGenerator();
			HashedMessage msg3 = hashGen.hash("hello");
			System.out.println("Hash: " + msg3.getHexString());
			
		} catch (CryptographicOperationException e) {
			e.printStackTrace();
		}
	}
}

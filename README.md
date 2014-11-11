libsimplenc
===========

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

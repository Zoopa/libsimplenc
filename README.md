libsimplenc
===========

**With a password-based key**:

```java
Salt salt = new Salt();
Password password = new Password("MyPasswd12".toCharArray());
PasswordBasedKey passwordBasedKey = new PasswordBasedKey(password, salt);
password.clear();

Encryptor enc1 = new Encryptor(passwordBasedKey);
Decryptor dec1 = new Decryptor(passwordBasedKey);

//Encrypt a string
EncryptedMessage msg = enc1.encrypt("This is a test 1");

//Decrypt and print as string
System.out.println(dec1.decrypt(msg).getString());

//Encrypt bytes
msg = enc1.encrypt(new byte[] {1, 2, 3, 4});

//Decrypt and print as hex
System.out.println(dec1.decrypt(msg).getHexString());
```

**With a randomly generated key**:

```java
RandomKey randomKey = new RandomKey();
Encryptor enc = new Encryptor(randomKey);
Decryptor dec = new Decryptor(randomKey);

//Encrypt a string
msg = enc.encrypt("This is a test 2");

//Decrypt and print as string
System.out.println(dec.decrypt(msg).getString());

Encrypt bytes
msg = enc.encrypt(new byte[] {-1, -2, -3, -4});

//Decrypt and print as hex
System.out.println(dec.decrypt(msg).getHexString());
```

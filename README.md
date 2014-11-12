libsimplenc
===========

An attempt to make encryption easier using some default parameters. At the moment, chosen settings are:

- Encryption with AES-CBC with 256 bit keys
- Key derivation with PBKDF2 (HMAC-SHA1 with 10k iterations)
- SecureRandom for IV / Salt (128 bits each)
- SHA-256 Hashing
- Treat all strings as UTF-8

These settings were chosen to support both Desktop and Android applications.

**Encryption / decryption with a password-based key**:

```java
Salt salt = new Salt();
Password password = new Password("MyPasswd12".toCharArray());
PasswordBasedKey passwordBasedKey = new PasswordBasedKey(password, salt);
password.clear();

Encryptor enc = new Encryptor(passwordBasedKey);
Decryptor dec = new Decryptor(passwordBasedKey);

//Encrypt a string
EncryptedMessage msg = enc.encrypt("This is a test 1");

//Decrypt and print as string
System.out.println( dec.decrypt(msg).getString() );

//Encrypt bytes
msg = enc.encrypt(new byte[] {1, 2, 3, 4});

//Decrypt and print as hex
System.out.println( dec.decrypt(msg).getHexString() );
```

**Encryption / decryption with a randomly generated key**:

```java
RandomKey randomKey = new RandomKey();
Encryptor enc = new Encryptor(randomKey);
Decryptor dec = new Decryptor(randomKey);

//Encrypt a string
EncryptedMessage msg = enc.encrypt("This is a test 2");

//Decrypt and print as string
System.out.println( dec.decrypt(msg).getString() );

//Encrypt bytes
msg = enc.encrypt(new byte[] {-1, -2, -3, -4});

//Decrypt and print as hex
System.out.println( dec.decrypt(msg).getHexString() );
```

**Hashing**

```java
HashGenerator hashGen = new HashGenerator();
HashedMessage msg = hashGen.hash("hello");

//Print hash as hex
System.out.println( msg.getHexString() );
```

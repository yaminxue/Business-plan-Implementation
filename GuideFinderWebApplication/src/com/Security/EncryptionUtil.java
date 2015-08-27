package com.Security;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

public class EncryptionUtil {
	private  KeyGenerator keyGen;
	private  Key key;
	private  Cipher cypher;
	
	public EncryptionUtil() throws Exception{
		keyGen=KeyGenerator.getInstance("AES");
		keyGen.init(128);
	    key=keyGen.generateKey();
		cypher=Cipher.getInstance("AES/ECB/PKCS5Padding");
		
	}
	public String encrypt(String text) throws Exception{
		
		byte[] bytes=text.getBytes("ISO-8859-1");
		//Encrypt
		cypher.init(Cipher.ENCRYPT_MODE, key);
		byte[] cypherText=cypher.doFinal(text.getBytes());
		return new String(cypherText,"ISO-8859-1");
		
	}
	public String decrypt(String text) throws Exception{
		cypher.init(Cipher.DECRYPT_MODE, key);
		byte[] OriginalText=cypher.doFinal(text.getBytes("ISO-8859-1"));
		return new String(OriginalText,"ISO-8859-1");
	}
	
//	public static void main(String[] args) throws Exception{
//		EncryptionUtil en=new EncryptionUtil();
//		String b=en.encrypt("fuck!");
//		
//		System.out.println(b);
//		b=en.decrypt(b);
//		
//		System.out.println(b);
//	}

}

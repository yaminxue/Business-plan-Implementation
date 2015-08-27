package com.Junit4.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.Security.AESUtil;

public class AESUtilTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
		String s="test";
		String encryptResult=AESUtil.encrypt(s);
		System.out.println(encryptResult);
		String decryptResult=AESUtil.decrypt(encryptResult);
		assertEquals(s,decryptResult);
				
				
	}

}

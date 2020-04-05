package com.laon.common.encrypt;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class SHAEncrypt {
	private static String encryptType = "SHA-512";
	
	public static String getSha512(String password) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance(encryptType); // SHA-512방식으로 객체생성
		}catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		byte[] passwordBytes = password.getBytes();
		md.update(passwordBytes); // 암호화
		byte[] encryptPasswordBytes = md.digest(); // 암호화된 바이트배열
		return Base64.getEncoder().encodeToString(encryptPasswordBytes); //Base64방식으로 변환
	}
}

package com.laon.common.encrypt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class AESEncrypt {
	private String keyName = "secretKey.bs";
	private static SecretKey key = null;
	private static String encryptType = "AES";
	
	public AESEncrypt(String path) {
		File file = new File(path +"/"+keyName);
		if (file.exists()) {
			ObjectInputStream ois = null;
			try {
				ois = new ObjectInputStream(new FileInputStream(file));
				key = (SecretKey) ois.readObject();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}else {
			key = generateKey(128,encryptType);
			saveKeytoFile(key, path);
		}
	}
	
	
	private SecretKey generateKey(int bit, String encryptType) {
		SecureRandom random = new SecureRandom();
		SecretKey key = null;
		try {
			KeyGenerator keygen = KeyGenerator.getInstance(encryptType);
			keygen.init(bit, random);
			key = keygen.generateKey();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return key;
	}
	
	private void saveKeytoFile(Object key,String path) {
		File file = new File(path+"/"+keyName);
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(key);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static String encrypt(String str) {
		String encryptStr = "";
		try {
			byte[] strBytes = str.getBytes();
			Cipher ciph = Cipher.getInstance(encryptType);
			ciph.init(Cipher.ENCRYPT_MODE, key);
			byte[] encryptStrBytes = ciph.doFinal(strBytes);
			encryptStr = Base64.getEncoder().encodeToString(encryptStrBytes);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return encryptStr;
	}
	
	public static String decrypt(String base64encryptStr) {
		String str = "";
		try {
			byte[] encryctStrBytes = Base64.getDecoder().decode(base64encryptStr);
			Cipher ciph = Cipher.getInstance(encryptType);
			ciph.init(Cipher.DECRYPT_MODE, key);
			byte[] strBytes = ciph.doFinal(encryctStrBytes);
			str = new String(strBytes);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return str;
		
	}
}

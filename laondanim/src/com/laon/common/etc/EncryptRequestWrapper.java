package com.laon.common.etc;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import com.laon.common.CommonKey;
import com.laon.common.encrypt.AESEncrypt;
import com.laon.common.key.UserKey;
import com.laon.user.model.vo.User;

import static com.laon.common.encrypt.SHAEncrypt.*;

public class EncryptRequestWrapper extends HttpServletRequestWrapper {

	public EncryptRequestWrapper(HttpServletRequest request) {
		super(request);
	}

	@Override 
	public String getParameter(String keyName) {
		String value = "";
		if(keyName != null) {
		if(keyName.equals(UserKey.PASSWORD)) {
			System.out.println("암호화 되기전 "+super.getParameter(keyName));
			value = getSha512(super.getParameter(keyName));
			System.out.println("암호화된 후 " + value);
		}else if(keyName.equals(UserKey.EMAIL)) {
			AESEncrypt.encrypt(super.getParameter(keyName));
		}else if(keyName.equals(UserKey.PHONE)) {
			AESEncrypt.encrypt(super.getParameter(keyName));			
		}else {
			value = super.getParameter(keyName);
		}
	}
		return value;
	}
}

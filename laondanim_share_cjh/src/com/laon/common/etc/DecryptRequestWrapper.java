package com.laon.common.etc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import com.laon.common.encrypt.AESEncrypt;
import com.laon.user.model.vo.User;

public class DecryptRequestWrapper extends HttpServletRequestWrapper{

	public DecryptRequestWrapper(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setAttribute(String name, Object o) {
		// TODO Auto-generated method stub
		
		if(o instanceof List) {
			List list = (List)o;
			if(!list.isEmpty()) {
				if(list.get(0) instanceof User) {
					for (Object object : list) {
						User user = (User)object;
						user.setEmail(AESEncrypt.decrypt(user.getEmail()));
						user.setPhone(AESEncrypt.decrypt(user.getPhone()));
					}
				}
			}
		}else if(o instanceof User) {
			User user = (User)o;
			user.setEmail(AESEncrypt.decrypt(user.getEmail()));
			user.setPhone(AESEncrypt.decrypt(user.getPhone()));
		}
		
		super.setAttribute(name, o);
	}

	
	
	

}

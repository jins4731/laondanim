package com.laon.common.template;

import static com.laon.common.template.MsgTemplate.sendMSG;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.laon.common.PictureKey;
import com.laon.common.etc.MyFileRenamePolicy;
import com.laon.common.robot.LaonRobot;
import com.laon.etc.model.service.EtcService;
import com.laon.etc.model.vo.Picture;
import com.oreilly.servlet.MultipartRequest;


public class MultiPartFormTemplate {
	public static <E> E mulitPartProcess(HttpServletRequest request,HttpServletResponse response,String path, E item) {
		// LaonRobot 인터페이스 구현 객체만 실행가능
		LaonRobot<E> robot = null;
		if (item instanceof LaonRobot) {
			robot = (LaonRobot<E>)item;
		}else {
			System.out.println("LaonRobot 인터페이스 구현 Item이 아닙니다.");
			return null;
		}
		
		
		if(!ServletFileUpload.isMultipartContent(request)) {
			try {
				sendMSG("입력 오류입니다.", "/views/common/msg.jsp", request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		String saveDir = request.getServletContext().getRealPath("path");
		int maxSize = 1024*1024*10;
		String encoding = "UTF-8";
		
		
		MultipartRequest mr;
		Picture picture = new Picture();
		try {
			mr = new MultipartRequest(request, saveDir, maxSize,encoding, new MyFileRenamePolicy());
			picture = picture.mrProcess(picture, mr, null);
			item = robot.mrProcess(item, mr,picture);
			
			System.out.println("원본파일 이름 : " + picture.getImage());
			System.out.println("수정된 파일이름 : " + mr.getFilesystemName(PictureKey.IMAGE));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return item;
		
		
	
		
		
		
		
	}
}

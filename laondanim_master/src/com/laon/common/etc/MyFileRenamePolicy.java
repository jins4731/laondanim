package com.laon.common.etc;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRenamePolicy implements FileRenamePolicy {
	private static Map<String,String> map = new HashMap();
	@Override
	public File rename(File oldFile) {
		File newFile = null;
		do {
			long currentTime = System.currentTimeMillis();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddssSSS");
			int random = (int) (Math.random() * 1000);

			String oldName = oldFile.getName();
			String extendName = "";
			int dotIndex = oldName.lastIndexOf(".");
			extendName = oldName.substring(dotIndex);
			String fileName = sdf.format(new Date(currentTime)) + "_" + random + extendName;
			String folderPath = oldFile.getParent();
			newFile = new File(folderPath, fileName);

		} while (!overlapCheck(newFile));
		
		System.out.println("oldFile : " +oldFile.getName() + " newFile : " +  newFile.getName());
		map.put(oldFile.getName(), newFile.getName());
		return newFile;
	}
	
	
	public static Map<String, String> getMap() {
		return map;
	}


	public static void setMap(Map<String, String> map) {
		map = map;
	}


	private boolean overlapCheck(File file) {
		try {
			return file.createNewFile();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}

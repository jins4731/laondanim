package com.laon.common.etc;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRenamePolicy implements FileRenamePolicy {

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

		return newFile;
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

package com.exam.upload;

import java.util.Calendar;

import org.springframework.stereotype.Service;

@Service
public class FileRenamePolicy
{
	public String renameFile(String filename)
	{	
		//특수문자 이용
		//String[] fileNameElement = filename.split("[.]"); //1
		String[] fileNameElement = filename.split("\\."); //2
		System.out.println(" renameFile : " + filename + " " + fileNameElement.length);

		String ext = fileNameElement[fileNameElement.length - 1];		
		
		// 타임스탬프
		// Calendar.getInstance().getTimeInMillis();
		// new Date().getTime()
		String newTime = String.valueOf(Calendar.getInstance().getTimeInMillis());
		String originName = filename.substring(0, filename.length() - 1 - ext.length());
		
		String newName = String.format("%s_%s.%s", originName, newTime, ext);
		
		
//		System.out.println(" originName : " + originName);
//		System.out.println(" newTime : " + newTime);
//		System.out.println(" ext : " + ext);
//		System.out.println(" newName : " + newName);
		
		return newName;
	}
}

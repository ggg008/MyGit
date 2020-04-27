package com.album.subController;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class FileRenamePolicy
{
	public String renameFile(String filename)
	{	
		String[] fileNameElement = filename.split(".");
		String ext = fileNameElement[fileNameElement.length - 1];
		
		Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
		
		String newName = String.format("%s_%s.%s", filename.substring(0, filename.length() - ext.length()), timestamp, ext);
		
		return newName;
	}
}

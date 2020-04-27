package models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

public class ClientFileInfoDAO
{
	/*
	CREATE TABLE StudentInfo(
	stuID VARCHAR(10) NOT NULL UNIQUE KEY,      
	name VARCHAR(10),         
	jumin BIGINT(13) UNSIGNED NOT NULL PRIMARY KEY,
	phoneNumber VARCHAR(11),
	homeAddress VARCHAR(100),
	ps varchar(10000),
	joindate date,
	ipAddress varchar(20)
	);
	
	INSERT INTO StudentInfo VALUES ('testID', '김정은', 8511111234567, '01012341234', '평양시 15호 관저', '북한의 지배자', '2019-12-17');
	
	UPDATE studentinfo SET joindate=STR_TO_DATE ('17-12-2019','%d-%m-%Y');
	*/
	
	
	public StringBuffer readFile(File file) {
		BufferedReader br = null;
		
		StringBuffer result = new StringBuffer();
		try {
			br = new BufferedReader(new FileReader(file));
			
			String line = null;
			while( ( line = br.readLine() ) != null ) {
				result.append( line + "\n");
			}
		} catch( FileNotFoundException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch( IOException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if( br != null) try { br.close(); } catch( IOException e ) {} 
		}
		
		return result;
	}
	
	public FileInfoTO uploadFile(File file)
	{
		FileInfoTO newFileInfo = new FileInfoTO();
		
		newFileInfo.setFileFullPath(file.getAbsolutePath());
		newFileInfo.setFileName(file.getName());
		
		String uploadDate = String.format("%d-%d-%d", 
				Calendar.getInstance().get(Calendar.YEAR), 
				Calendar.getInstance().get(Calendar.MONTH), 
				Calendar.getInstance().get(Calendar.DAY_OF_MONTH) 
				);
		newFileInfo.setUploadDate(uploadDate);
		newFileInfo.setDownloadNum(String.valueOf(0));
		
		
		return newFileInfo;
	}
	
}

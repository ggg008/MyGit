package models;

import java.util.Properties;

public class FileInfoTO
{
	private int fileKey;
	private String fileFullPath;
	private String fileName;
	private String downloadNum;
	private String uploadDate;


	public FileInfoTO()
	{
		// TODO Auto-generated constructor stub

	}

	public FileInfoTO(Properties props)
	{
		// TODO Auto-generated constructor stub


		if (props.getProperty("fileKey") != null)
			fileKey = Integer.parseInt(props.getProperty("fileKey"));
		
		fileFullPath = "";

		if (props.getProperty("fileName") != null)
			fileName = props.getProperty("fileName");

		if (props.getProperty("downloadNum") != null)
			downloadNum = props.getProperty("downloadNum");

		if (props.getProperty("uploadDate") != null)
			uploadDate = props.getProperty("uploadDate");
	}
	

	public void setFileInfoTO(FileInfoTO newInfo)
	{
		fileFullPath = newInfo.fileFullPath;
		fileName = newInfo.fileName;
		downloadNum = newInfo.downloadNum;
		uploadDate = newInfo.uploadDate;
	}
	
	public int getFileKey()
	{
		return fileKey;
	}
	
	public void setFileKey(int key)
	{
		this.fileKey = key;
	}
	
	public String getFileFullPath()
	{
		return fileFullPath;
	}
	public void setFileFullPath(String fileFullPath)
	{
		this.fileFullPath = fileFullPath;
	}
	public String getFileName()
	{
		return fileName;
	}
	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}
	public String getDownloadNum()
	{
		return downloadNum;
	}
	public void setDownloadNum(String downloadNum)
	{
		this.downloadNum = downloadNum;
	}
	public String getUploadDate()
	{
		return uploadDate;
	}
	public void setUploadDate(String uploadDate)
	{
		this.uploadDate = uploadDate;
	}
	
}

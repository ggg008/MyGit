package com.album.model;

public class AlbumMemberTO
{
	private String id = "";
	private String name = "";
	private String pw = "";
	private String mail = "";
		
	
	public AlbumMemberTO(String id, String name, String pw, String mail)
	{
		super();
		this.id = id;
		this.name = name;
		this.pw = pw;
		this.mail = mail;
	}
	
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}	
	public String getName()
	{
		return name;
	}	
	public void setName(String name)
	{
		this.name = name;
	}
	public String getPw()
	{
		return pw;
	}
	public void setPw(String pw)
	{
		this.pw = pw;
	}
	public String getMail()
	{
		return mail;
	}
	public void setMail(String mail)
	{
		this.mail = mail;
	}
}


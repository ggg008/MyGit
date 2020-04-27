package models;

import java.util.Properties;

public class StudentInfoTO
{
	private int stuNum = 0;

	private String stuID;
	private String name;
	private String jumin;
	private String phoneNumber;
	private String homeAddress;
	private String ps;
	private String joinDate;

	private String ipAddress = "";
	private boolean isConnect = false;

	public StudentInfoTO()
	{
		// TODO Auto-generated constructor stub

	}

	public StudentInfoTO(Properties props)
	{
		// TODO Auto-generated constructor stub

		if (props.getProperty("stuID") != null)
			stuID = props.getProperty("stuID");
		name = props.getProperty("name");

		if (props.getProperty("jumin") != null)
			jumin = props.getProperty("jumin");

		phoneNumber = props.getProperty("phoneNumber");
		homeAddress = props.getProperty("homeAddress");
		ps = props.getProperty("ps");
		joinDate = props.getProperty("joinDate");

		if (props.getProperty("isConnect") != null)
			isConnect = Boolean.valueOf(props.getProperty("isConnect"));

		if (props.getProperty("ipAddress") != null)
			ipAddress = props.getProperty("ipAddress");
	}

	public void setStudentInfoTO(StudentInfoTO newInfo)
	{

		stuID = newInfo.stuID;
		name = newInfo.name;
		jumin = newInfo.jumin;

		phoneNumber = newInfo.phoneNumber;
		homeAddress = newInfo.homeAddress;
		ps = newInfo.ps;
		joinDate = newInfo.joinDate;
		if (newInfo.ipAddress != null && !newInfo.ipAddress.equals(""))
			ipAddress = newInfo.ipAddress;
	}

	public int getStuNum()
	{
		return stuNum;
	}

	public void setStuNum(int stuNum)
	{
		this.stuNum = stuNum;
	}

	public String getStuID()
	{
		return stuID;
	}

	public void setStuID(String stuID)
	{
		this.stuID = stuID;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getJumin()
	{
		return jumin;
	}

	public void setJumin(String jumin)
	{
		this.jumin = jumin;
	}

	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	public String getHomeAddress()
	{
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress)
	{
		this.homeAddress = homeAddress;
	}

	public String getPs()
	{
		return ps;
	}

	public void setPs(String ps)
	{
		this.ps = ps;
	}

	public String getJoinDate()
	{
		return joinDate;
	}

	public void setJoinDate(String joinDate)
	{
		this.joinDate = joinDate;
	}

	public String getIpAddress()
	{
		return ipAddress;
	}

	public void setIpAddress(String ipAddress)
	{
		if(ipAddress == null)
			ipAddress = "";
		this.ipAddress = ipAddress;
	}

	public boolean isConnect()
	{
		return isConnect;
	}

	public void setConnect(boolean isConnect)
	{
		this.isConnect = isConnect;
	}

}

package day17_Java.arrayList;

public class Student
{
	private String seq;
	private String name;
	private String phone;
	private String age;
	private String region;
	
	public Student(String seq, String name, String phone, String age, String region)
	{
		this.seq = seq;
		this.name = name;
		this.phone = phone;
		this.age = age;
		this.region = region;
	}
	
	public String getSeq()
	{
		return seq;
	}
	public String getName()
	{
		return name;
	}
	public String getPhone()
	{
		return phone;
	}
	public String getAge()
	{
		return age;
	}
	public String getRegion()
	{
		return region;
	}
	
	
}

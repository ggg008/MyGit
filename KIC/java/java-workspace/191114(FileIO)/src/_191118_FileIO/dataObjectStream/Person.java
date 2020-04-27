package _191118_FileIO.dataObjectStream;

import java.io.Serializable;

public class Person implements Serializable//직렬화 할꺼다
{//직렬화 데이터만 남기고 메서드를 전부 제거
	
//	private static final long sera
	
	private String name;
	private String phone;
	private int age;
	transient private String address;//민감한 데이터 직렬화 제외
	
	public Person(String name, String phone, int age, String address)
	{
		this.name = name;
		this.phone = phone;
		this.age = age;
		this.address = address;
	}

	public String getName()
	{
		return name;
	}

	public String getPhone()
	{
		return phone;
	}

	public int getAge()
	{
		return age;
	}

	public String getAddress()
	{
		return address;
	}
	
}

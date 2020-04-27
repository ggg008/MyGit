package com.naver;

public class Day11_Student {	
	private String hakbun;
	private String name;
	private int age;
	private double height;
	
	public Day11_Student()
	{
	}
	
	/**
	 * @param hakbun
	 * @param name
	 * @param age
	 * @param height
	 */	
	public Day11_Student(String hakbun, String name, int age, double height) {
		this.hakbun = hakbun;
		this.name = name;
		this.age = age;
		this.height = height;
	}
	
	public Day11_Student(String name) {		
		this.name = name;		
		
	}

	public String getHakbun() {
		return hakbun;
	}

	public void setHakbun(String hakbun) {
		this.hakbun = hakbun;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}	
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		
		boolean result = false;
		Day11_Student s = (Day11_Student)obj;
		if(s.name.equals(this.name) && s.age == this.age ) {
			result = true;			
		}
		return result;
		
	}

	@Override
	public String toString() {
//		return "Day11_Student [hakbun=" + hakbun + ", name=" + name + ", age=" + age + ", height=" + height + "]";
		return "im overrided toString(). my Name is " + this.getClass().getName();
	}
	
//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return "Day11_Student [name : " + name +", hakbun :"+ hakbun +"]"; 
//	}
	
}

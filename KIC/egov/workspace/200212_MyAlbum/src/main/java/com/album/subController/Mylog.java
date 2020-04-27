package com.album.subController;

public class Mylog
{
	public static void simpleLog(String ...logs)
	{		
		System.out.print(" 호출");
		for(String log : logs) {
			System.out.print(" " + log);
		}
		System.out.println();
	}
	
	public static void callMethodLog(Object classObj)
	{
		System.out.printf(" 호출 %s %s \n", classObj.getClass().getName(), new Throwable().getStackTrace()[1].getMethodName());
	}
}

package com.exam.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController2
{
	@Autowired
	private TestMapper testMapper;
	
	@RequestMapping(value="/jdbc2.do")
	public String jdbc2()
	{
		String result = testMapper.selectNow();
		System.out.println(result);
		
		return "jdbc2";
	}
}

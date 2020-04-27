package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConfigController2
{	
	@RequestMapping("/list2.do")
	private String handleRequest2()
	{
		System.out
				.println(" 호출 " + this.getClass().getName() + " " + new Throwable().getStackTrace()[0].getMethodName());

		return "listview2";
	}
}

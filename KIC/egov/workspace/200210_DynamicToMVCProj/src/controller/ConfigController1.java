package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConfigController1
{
//	@RequestMapping("/list1.do")
//	private String handleRequest1()
//	{
//		System.out
//				.println(" 호출 " + this.getClass().getName() + " " + new Throwable().getStackTrace()[0].getMethodName());
//
//		return "listview1";
//	}	
	
	@RequestMapping("/list1.do")
	private ModelAndView handleRequest1()
	{
		System.out
				.println(" 호출 " + this.getClass().getName() + " " + new Throwable().getStackTrace()[0].getMethodName());

		return new ModelAndView("listview1");
	}	
}

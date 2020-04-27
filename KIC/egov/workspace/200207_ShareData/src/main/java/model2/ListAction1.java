package model2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import share.ShareClass;

public class ListAction1 implements Controller
{
	private ShareClass shareClass;

	public void setShareClass(ShareClass shareClass)
	{
		this.shareClass = shareClass;
	}

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		System.out.println("ListAction1 호출");
		
		System.out.println("data1 : " + shareClass.getShareData1());
		
		shareClass.setShareData1("ListAction1에서 변경");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("listview1");
		
		return modelAndView;
	}

}

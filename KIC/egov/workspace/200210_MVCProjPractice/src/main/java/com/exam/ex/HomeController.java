package com.exam.ex;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController
{
	@RequestMapping("/write.do")
	public ModelAndView handleReqWriteDo()
	{
		System.out
				.println(" 호출 " + this.getClass().getName() + " " + new Throwable().getStackTrace()[0].getMethodName());

		return new ModelAndView("write");
	}

	@RequestMapping(value = "/write_ok.do")
	public String handleReqWriteOkDoRSM(@RequestParam(value = "data", defaultValue = "nothing") String pData,
			Model model, Model model2)// 두개를 집어넣어도 문제없음
	{
		System.out.printf(" 호출 %s %s %s \n", this.getClass().getName(),
				new Throwable().getStackTrace()[0].getMethodName(), pData);

		model.addAttribute("data", pData);

		return "write_ok";
	}

}

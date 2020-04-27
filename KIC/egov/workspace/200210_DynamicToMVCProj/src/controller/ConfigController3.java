package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board")
public class ConfigController3
{
	@RequestMapping("/write.do")
	public ModelAndView handleReqWriteDo()
	{
		System.out
				.println(" 호출 " + this.getClass().getName() + " " + new Throwable().getStackTrace()[0].getMethodName());

		return new ModelAndView("write");
	}

	/*
	 * 각종 옵션이 많다
	 */

	// Get Post 나누기 가능
	/*
	 * @RequestMapping(value="/write_ok.do", method=RequestMethod.GET) public
	 * ModelAndView handleReqWriteOkDoGet() { System.out .println(" 호출 " +
	 * this.getClass().getName() + " " + new
	 * Throwable().getStackTrace()[0].getMethodName());
	 * 
	 * return new ModelAndView("write_ok"); }
	 * 
	 * @RequestMapping(value="/write_ok.do", method=RequestMethod.POST) public
	 * ModelAndView handleReqWriteOkDoPost() { System.out .println(" 호출 " +
	 * this.getClass().getName() + " " + new
	 * Throwable().getStackTrace()[0].getMethodName());
	 * 
	 * return new ModelAndView("write_ok"); }
	 */

	// @RequestMapping(value="/write_ok.do")
	// public ModelAndView handleReqWriteOkDo(HttpServletRequest req,
	// HttpServletResponse res)
	// {
	// System.out
	// .printf(" 호출 %s %s %s \n", this.getClass().getName(), new
	// Throwable().getStackTrace()[0].getMethodName(), req.getParameter("data"));
	//
	// return new ModelAndView("write_ok");
	// }

	// @RequestMapping(value="/write_ok.do")
	// public ModelAndView handleReqWriteOkDoPara(String data)
	// {
	// System.out
	// .printf(" 호출 %s %s %s \n", this.getClass().getName(), new
	// Throwable().getStackTrace()[0].getMethodName(), data);
	//
	// return new ModelAndView("write_ok");
	// }

	// 초기값-디폴트값 가능
	// @RequestMapping(value="/write_ok.do")
	// public ModelAndView handleReqWriteOkDoParam(@RequestParam("data") String
	// pData)
	// {
	// System.out
	// .printf(" 호출 %s %s %s \n", this.getClass().getName(), new
	// Throwable().getStackTrace()[0].getMethodName(), pData);
	//
	// ModelAndView modelAndView = new ModelAndView();
	// modelAndView.setViewName("write_ok");
	// modelAndView.addObject("data", pData);
	//
	// return modelAndView;
	// }

	// 스트링일시 데이터 전달 처리
	// @RequestMapping(value="/write_ok.do")
	// public String handleReqWriteOkDoRS(HttpServletRequest req,
	// HttpServletResponse res)
	// {
	// String data = req.getParameter("data");
	//
	// System.out
	// .printf(" 호출 %s %s %s \n", this.getClass().getName(), new
	// Throwable().getStackTrace()[0].getMethodName(), data);
	//
	// req.setAttribute("data", data);
	//
	// return "write_ok";
	// }

	@RequestMapping(value = "/write_ok.do")
	public String handleReqWriteOkDoRSM(@RequestParam(value = "data", defaultValue = "nothing") String pData,
			Model model, Model model2)// 두개를 집어넣어도 문제없음
	{
		System.out.printf(" 호출 %s %s %s \n", this.getClass().getName(),
				new Throwable().getStackTrace()[0].getMethodName(), pData);

		model.addAttribute("data", pData);

		return "write_ok";		
	}

	@RequestMapping(value = "/naver.do")
	public String handleReqRedirect()
	{
		System.out.printf(" 호출 %s %s \n", this.getClass().getName(),
				new Throwable().getStackTrace()[0].getMethodName());

		return "redirect:https://www.naver.com";
		// return
		// "redirect:http://localhost:8080/200210_DynamicToMVCProjPractice/board/write.do";
	}

}

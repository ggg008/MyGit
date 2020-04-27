package com.exam.subController;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.exam.model.BoardDAO;
import com.exam.model.BoardListTO;
import com.exam.model.BoardTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController
{

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model)
	{
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping(value = "/delete.do")
	public ModelAndView handleRequestDel(@RequestParam(value = "cpage") String pCpage,
			@RequestParam(value = "seq") String pSeq)
	{
		System.out.printf(" 호출 %s %s \n", this.getClass().getName(),
				new Throwable().getStackTrace()[0].getMethodName());

		String cpage = pCpage;

		BoardTO to = new BoardTO();
		to.setSeq(pSeq);

		BoardDAO dao = new BoardDAO();
		to = dao.boardDelete(to);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board_delete1");
		modelAndView.addObject("cpage", cpage);
		modelAndView.addObject("to", to);

		return modelAndView;
	}

	@RequestMapping(value = "/delete_ok.do")
	public ModelAndView handleRequestDelOk(@RequestParam(value = "seq") String pSeq,
			@RequestParam(value = "password") String pPassword)
	{
		System.out.printf(" 호출 %s %s \n", this.getClass().getName(),
				new Throwable().getStackTrace()[0].getMethodName());

		BoardTO to = new BoardTO();
		to.setSeq(pSeq);
		to.setPassword(pPassword);

		BoardDAO dao = new BoardDAO();
		int flag = dao.boardDeleteOk(to);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board_delete1_ok");
		modelAndView.addObject("flag", flag);

		return modelAndView;
	}

	@RequestMapping(value = "/list.do")
	public ModelAndView handleRequestList(@RequestParam(value = "cpage", defaultValue = "1") int pCpage)
	{
		System.out.printf(" 호출 %s %s \n", this.getClass().getName(),
				new Throwable().getStackTrace()[0].getMethodName());

		// int cpage = 1;
		// if (pCpage != null && !pCpage.equals("")) {
		// cpage = Integer.parseInt(pCpage);
		// }

		int cpage = pCpage;

		BoardListTO listTO = new BoardListTO();
		listTO.setCpage(cpage);

		BoardDAO dao = new BoardDAO();
		listTO = dao.boardList(listTO);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board_list1");
		modelAndView.addObject("listTO", listTO);

		return modelAndView;
	}

	@RequestMapping(value = "/modify.do")
	public ModelAndView handleRequestModify(@RequestParam(value = "cpage", defaultValue = "1") String pCpage,
			String seq)
	{

		System.out.printf(" 호출 %s %s %s \n", this.getClass().getName(),
				new Throwable().getStackTrace()[0].getMethodName(), seq);

		String cpage = pCpage;

		BoardTO to = new BoardTO();
		to.setSeq(seq);

		BoardDAO dao = new BoardDAO();
		to = dao.boardModify(to);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board_modify1");
		modelAndView.addObject("cpage", cpage);
		modelAndView.addObject("to", to);

		return modelAndView;
	}

	@RequestMapping(value = "/modify_ok.do")
	public ModelAndView handleRequestModifyOk(HttpServletRequest arg0, HttpServletResponse arg1)
	{

		System.out.printf(" 호출 %s %s \n", this.getClass().getName(),
				new Throwable().getStackTrace()[0].getMethodName());

		String cpage = arg0.getParameter("cpage");

		BoardTO to = new BoardTO();

		String mail = "";
		if (!arg0.getParameter("mail1").equals("") && !arg0.getParameter("mail2").equals("")) {
			mail = arg0.getParameter("mail1") + "@" + arg0.getParameter("mail2");
		}

		to.setSeq(arg0.getParameter("seq"));
		to.setSubject(arg0.getParameter("subject"));
		to.setMail(mail);
		to.setPassword(arg0.getParameter("password"));
		to.setContent(arg0.getParameter("content"));

		BoardDAO dao = new BoardDAO();
		int flag = dao.boardModifyOk(to);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board_modify1_ok");
		modelAndView.addObject("cpage", cpage);
		modelAndView.addObject("to", to);
		modelAndView.addObject("flag", flag);

		return modelAndView;
	}

	@RequestMapping(value = "/view.do")
	public ModelAndView handleRequestView(HttpServletRequest arg0, HttpServletResponse arg1)
	{

		System.out.printf(" 호출 %s %s \n", this.getClass().getName(),
				new Throwable().getStackTrace()[0].getMethodName());

		String cpage = arg0.getParameter("cpage");

		BoardTO to = new BoardTO();
		to.setSeq(arg0.getParameter("seq"));

		BoardDAO dao = new BoardDAO();
		to = dao.boardView(to);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board_view1");
		modelAndView.addObject("cpage", cpage);
		modelAndView.addObject("to", to);

		return modelAndView;
	}

	@RequestMapping(value = "/write.do")
	public ModelAndView handleRequestWrite(HttpServletRequest arg0, HttpServletResponse arg1)
	{

		System.out.printf(" 호출 %s %s \n", this.getClass().getName(),
				new Throwable().getStackTrace()[0].getMethodName());

		String cpage = arg0.getParameter("cpage");

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board_write1");
		modelAndView.addObject("cpage", cpage);

		return modelAndView;
	}

	@RequestMapping(value = "/write_ok.do")
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1)
	{

		System.out.printf(" 호출 %s %s \n", this.getClass().getName(),
				new Throwable().getStackTrace()[0].getMethodName());

		String mail = "";
		if (!arg0.getParameter("mail1").equals("") && !arg0.getParameter("mail2").equals("")) {
			mail = arg0.getParameter("mail1") + "@" + arg0.getParameter("mail2");
		}

		BoardTO to = new BoardTO();
		to.setSubject(arg0.getParameter("subject"));
		to.setWriter(arg0.getParameter("writer"));
		to.setMail(mail);
		to.setPassword(arg0.getParameter("password"));
		to.setContent(arg0.getParameter("content"));
		to.setWip(arg0.getRemoteAddr());

		BoardDAO dao = new BoardDAO();
		int flag = dao.boardWriteOk(to);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board_write1_ok");
		modelAndView.addObject("flag", flag);

		return modelAndView;
	}
}

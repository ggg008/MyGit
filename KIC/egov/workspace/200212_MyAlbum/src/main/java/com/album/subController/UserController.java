package com.album.subController;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.album.model.AlbumBoardDAO;
import com.album.model.AlbumBoardListTO;
import com.album.model.AlbumMemberTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class UserController
{

	private AlbumMemberTO fixedUser = new AlbumMemberTO("asd", "anonym", "123", "test@naver.com");

	@RequestMapping(value = "/login.do")
	public ModelAndView login(HttpServletRequest request)
	{
		Mylog.callMethodLog(this);

		int cpage = 1;
		if (request.getParameter("cpage") != null && !request.getParameter("cpage").equals("")) {
			cpage = Integer.parseInt(request.getParameter("cpage"));
		}

		AlbumBoardListTO listTO = new AlbumBoardListTO();
		listTO.setCpage(cpage);

		AlbumBoardDAO dao = new AlbumBoardDAO();
		listTO = dao.boardList(listTO);

		request.getParameter("login");
		request.getParameter("password");
		String curPageUrl = request.getParameter("curPageUrl");

		HttpSession session = request.getSession();
		ModelAndView modelAndView = new ModelAndView();
		if (fixedUser.getId().equals(request.getParameter("id"))
				&& fixedUser.getPw().equals(request.getParameter("password"))) {
			session.setAttribute("album_loginUser", fixedUser);
			session.setAttribute("album_isLogin", true);
		} else {

			modelAndView.setViewName("message");
			modelAndView.addObject("msg", "아이디와 비밀번호를 확인하시기 바랍니다.");
			return modelAndView;

		}

		String[] arrUrl = curPageUrl.split("/");

		if (arrUrl[4].contains("write.do") || arrUrl[4].contains("delet.do") || arrUrl[4].contains("modify.do")) {
			curPageUrl = String.format("%s/%s/%s/%s/%s", arrUrl[0], arrUrl[1], arrUrl[2], arrUrl[3], "list.do");
		}
		System.out.println(curPageUrl);

		modelAndView.setViewName("redirect:" + curPageUrl);

		return modelAndView;
	}

	@RequestMapping(value = "/logout.do")
	public String logout(HttpServletRequest request)
	{
		Mylog.callMethodLog(this);

		HttpSession session = request.getSession();
		session.setAttribute("album_loginUser", "");
		session.setAttribute("album_isLogin", false);

		String curPageUrl = request.getParameter("curPageUrl");

		String[] arrUrl = curPageUrl.split("/");

		if (arrUrl[4].contains("write.do") || arrUrl[4].contains("delet.do") || arrUrl[4].contains("modify.do")) {
			curPageUrl = String.format("%s/%s/%s/%s/%s", arrUrl[0], arrUrl[1], arrUrl[2], arrUrl[3], "list.do");
		}
		System.out.println(curPageUrl);

		return "redirect:" + curPageUrl;
	}

	public void sendMail(String toMail, String toName, String subject, String content)
	{

		try {
			// 환경변수 설정
			Properties props = new Properties();
			props.put("mail.smtp.stattls.enable", "true");
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "465");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

			// 인증
			// MyAuth auth = new MyAuth(fromMail, password);
			// 세션 : 하나의 접속
			Session session = Session.getDefaultInstance(props, new Authenticator()
			{
				@Override
				protected PasswordAuthentication getPasswordAuthentication()
				{
					// TODO Auto-generated method stub
					return new PasswordAuthentication("gg008gg@gmail.com", "120976gg");
					// return new PasswordAuthentication("kictest99@gmail.com", "!A@S#D$F");
				}
			});

			// 메세지
			MimeMessage msg = new MimeMessage(session);
			msg.setHeader("Content-type", "text/html;charset=utf-8");
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toMail, toName, "utf-8"));
			msg.setSubject(subject);
			msg.setContent(content, "text/html;charset=utf-8");
			msg.setSentDate(new java.util.Date());

			Transport.send(msg);

			System.out.println("전송완료");

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/member_search.do")
	public String userIDPWSearch()
	{
		Mylog.callMethodLog(this);

		return "member_search1";
	}

	@RequestMapping(value = "/member_write1.do")
	public String userJoin()
	{
		Mylog.callMethodLog(this);

		return "member_write1";
	}

	@RequestMapping(value = "/member_write1_ok.do")
	public String userJoinOk(HttpServletRequest request)
	{
		Mylog.callMethodLog(this);

		this.fixedUser.setId(request.getParameter("id"));
		this.fixedUser.setName(request.getParameter("writer"));
		this.fixedUser.setPw(request.getParameter("password"));
		this.fixedUser.setMail(String.format("%s@%s", request.getParameter("mail1"), request.getParameter("mail2")));

		HttpSession session = request.getSession();
		session.setAttribute("album_loginUser", fixedUser);
		session.setAttribute("album_isLogin", true);
		
		String URL = String.format("%s://%s:%s%s%s", request.getScheme(), request.getServerName(),
				request.getServerPort(), request.getContextPath(), "/list.do");
		
		System.out.println(URL);
		
		return "redirect:" + URL;
	}
	
	@RequestMapping(value = "/member_modify1.do")
	public String userModify(HttpServletRequest request)
	{
		Mylog.callMethodLog(this);

		return "member_modify1";
	}

	@RequestMapping(value = "/member_modify1_ok.do")
	public String userModifyOk(HttpServletRequest request)
	{
		Mylog.callMethodLog(this);

		this.fixedUser.setId(request.getParameter("id"));
		this.fixedUser.setName(request.getParameter("writer"));
		this.fixedUser.setPw(request.getParameter("password"));
		this.fixedUser.setMail(String.format("%s@%s", request.getParameter("mail1"), request.getParameter("mail2")));

		HttpSession session = request.getSession();
		session.setAttribute("album_loginUser", fixedUser);
		session.setAttribute("album_isLogin", true);
		
		String URL = String.format("%s://%s:%s%s%s", request.getScheme(), request.getServerName(),
				request.getServerPort(), request.getContextPath(), "/list.do");
		
		System.out.println(URL);
		
		return "redirect:" + URL;
	}

	@RequestMapping(value = "/search_ok.do")
	public ModelAndView userSearch(HttpServletRequest request)
	{
		Mylog.callMethodLog(this);

		String id = request.getParameter("id");
		String mail = String.format("%s@%s", request.getParameter("mail1"), request.getParameter("mail2"));

		this.fixedUser.setMail(mail);

		int checkExistUser = 0;
		String msg = "정보를 정확하게 기입바랍니다.";

		if (this.fixedUser.getId().equals(id) && this.fixedUser.getMail().equals(mail)) {

			checkExistUser = 1;

			String subject = "비밀번호 찾기";
			String content = String.format("%s 님의 비밀번호는 %s 입니다", this.fixedUser.getId(), this.fixedUser.getPw());

			msg = "비밀번호 확인 메일을 보냈습니다.";

			sendMail(mail, id, subject, content);
		}

		ModelAndView modelAndView = new ModelAndView("member_search1_ok");
		modelAndView.addObject("checkExistUser", checkExistUser);
		modelAndView.addObject("msg", msg);

		return modelAndView;
	}

}

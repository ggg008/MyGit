package _191213_Mail;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.Scanner;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender
{
	//구글 이메일
	private static String fromMail = "";
	//이메일 비밀번호
	private static String password = "";

	public static void setMailInfo(String fromMail, String password)
	{
		MailSender.fromMail = fromMail + "@gmail.com";
		MailSender.password = password;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("지메일 입력 : ");
		String fromMail = sc.nextLine();
		System.out.print("암호 입력 : ");
		String password = sc.nextLine();
		
		setMailInfo(fromMail, password);
		
		// 보낼 이메일
		String toMail = "ggg008@naver.com";
		// 보내는 메일에 기입될 사람 이름
		String toName = "ㅇㅇㅇ";
		
		String subject = "메일 제목";
		String content = "<html><head></head> "
				+ "<body><font color='blue'><h2>안녕</h2>메일<br></font>"
				+ "<img src ='https://imgnews.pstatic.net/image/001/2019/12/13/PCM20190517000110054_P2_20191213153414592.jpg?type=w647'>"
				+ "</body></html>";
		
		MailSender mailSender = new MailSender();
		mailSender.sendMail(toMail, toName, subject, content);
		
		sc.close();

	}
	
	public void sendMail(String toMail, String toName, String subject, String content) {
		
		try {
			//환경변수 설정
			Properties props = new Properties();
			props.put("mail.smtp.stattls.enable", "true");
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "465");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			
			//인증
			MyAuth auth = new MyAuth(fromMail, password);
			//세션 : 하나의 접속
			Session session = Session.getDefaultInstance(props, auth);
			
			//메세지
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

}

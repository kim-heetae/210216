package book.ch5;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
	public static void main(String[] args) {
		String smtpServer = "smtp.naver.com";
		final String sendId = "rlaxo96";
		final String sendPass = "비밀번호";
		String sendEmailAddress = "rlaxo96@naver.com";
		int smtpPort=465;
		
		//받는 분
		String receiveEmailAddress="snu9451@gmail.com";
		String subject="안녕하세요. 강감찬입니다.";
		String content="안녕하세요. 학습용3으로 이메일 보내기3 연습 중입니다.";
		
		
		Properties props = System.getProperties();
		props.put("mail.smtp.host", smtpServer);
		props.put("mail.smtp.port", smtpPort);
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.ssl.enable", true);
		props.put("mail.smtp.ssl.trust", smtpServer);
		
		Session session5 = Session.getDefaultInstance(props, new Authenticator(){
			protected PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication(sendId, sendPass);
			}
		});
		//session2.setDebug(true);
		try{
			Message mimeMessage = new MimeMessage(session5);
			mimeMessage.setFrom(new InternetAddress(sendEmailAddress));
			mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(receiveEmailAddress));
			mimeMessage.setSubject(subject);
			mimeMessage.setText(content);
			Transport.send(mimeMessage);
			System.out.print("message sent successfully..."); 
		} catch (AddressException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		} catch (MessagingException e) { 
			// TODO Auto-generated catch block 
			e.printStackTrace(); 
		} 			
	}

}
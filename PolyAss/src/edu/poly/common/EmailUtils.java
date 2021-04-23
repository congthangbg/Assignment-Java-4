package edu.poly.common;

import java.util.List;
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

import edu.poly.dao.UserDao;
import edu.poly.domain.Email;
import edu.poly.entity.User;
import edu.poly.utils.HibernateUtils;

public class EmailUtils {
	public static void send(Email email, HttpServletRequest request) {

		// Get properties object
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", MailConfig.HOST_NAME);
		props.put("mail.smtp.socketFactory.port", MailConfig.SSL_PORT);
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.port", MailConfig.SSL_PORT);

		// get Session
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email.getFrom(), email.getFromPassword());
			}
		});

		// compose message
		try {
			MimeMessage message = new MimeMessage(session);
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(MailConfig.RECEIVE_EMAIL));
			message.setSubject("Testing Subject");
			StringBuilder sb = new StringBuilder();
			sb.append("Dear Ms/Mr. <br>");
			sb.append("the video is more interesting and I want to share with you! <br>");
			sb.append("Admin : Cong Thang <br>");
			UserDao userDao = new UserDao();
			List<User> list = userDao.findAll2();
			String userId = request.getParameter("userId");
//			System.out.println(userId);
//			User user = userDao.findById(userId);
//
//			for (User u : list) {
//				if (u.getUserId() == user.getUserId()) {
//
//					sb.append("Mat khau cua ban la : " + user.getPassword());
//				}
//			}
			message.setText(sb.toString());

			// send message
			Transport.send(message);

			System.out.println("Message sent successfully");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
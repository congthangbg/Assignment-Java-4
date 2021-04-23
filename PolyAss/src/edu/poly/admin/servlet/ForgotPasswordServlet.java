package edu.poly.admin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.poly.common.EmailUtils;
import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.dao.UserDao;
import edu.poly.domain.Email;
import edu.poly.entity.User;

/**
 * Servlet implementation class ForgotPasswordServlet
 */
@WebServlet("/ForgotPasswordAdmin")
public class ForgotPasswordServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PageInfo.prepareAndForward(request, response, PageType.FORGOT_PASSWORD_MANAGEMENT_PAGE);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String emailAddress=request.getParameter("email");
			String userId=request.getParameter("userId");
			
			UserDao userDao=new UserDao();
			User user=userDao.findByUserIdAndEmail(userId, emailAddress);

			if(user ==null) {
				request.setAttribute("error", "UserId or Email are incorrect");
			}else {
				Email email=new Email();
				email.setFrom("congthangbg1@gmail.com");
				email.setFromPassword("congthang1");
				email.setTo(emailAddress);
				email.setSubject("Forhot password function");
				
				StringBuilder sb=new StringBuilder();
				sb.append("Dear").append(userId).append("<br>");
				sb.append("You are used the forgot password function. <br>");
				
				email.setContent(sb.toString());
				EmailUtils.send(email,request);
				
				request.setAttribute("message", "Email sent to the email Address");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error",e.getMessage());
		}
		PageInfo.prepareAndForward(request, response, PageType.FORGOT_PASSWORD_MANAGEMENT_PAGE);
	}

}

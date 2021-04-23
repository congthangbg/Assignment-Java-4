package edu.poly.views.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import edu.poly.common.CookieUtils;
import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.common.SessionUtils;
import edu.poly.dao.UserDao;
import edu.poly.domain.LoginForm;
import edu.poly.entity.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId=CookieUtils.getCookie("userId", request);
		
		if(userId ==null) {
			PageInfo.prepareAndForwardView(request, response, PageType.SITE_LOGIN_PAGE);
		return;
		}
		SessionUtils.addSession(request, "userId", userId);
		request.getRequestDispatcher("/HomePageServlet").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			LoginForm form = new LoginForm();
			BeanUtils.populate(form, request.getParameterMap());
			
			UserDao userDao=new UserDao();
			User user=userDao.findById(form.getUserId());

			if(user != null && user.getPassword().equals(form.getPassword())) {
				SessionUtils.addSession(request, "userId", user.getUserId());
				
				if(form.isRemember()) {
		 			CookieUtils.addCookie("userId", form.getUserId(), 24, response);
				}else {
					CookieUtils.addCookie("userId", form.getUserId(), 0, response);
				}
				if(user.isAdmin()) {
					request.setAttribute("isLogin", true);
					request.setAttribute("userId", user.getUserId());
					request.getRequestDispatcher("/HomeAdminServlet").forward(request, response);
				}else {
					request.setAttribute("isLogin", true);
					request.setAttribute("userId", user.getUserId());
					request.getRequestDispatcher("/HomePageServlet").forward(request, response);
				}
			
				return;
			}
			request.setAttribute("error", "invalid userId or Password");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		PageInfo.prepareAndForwardView(request, response, PageType.SITE_LOGIN_PAGE);
	}

}

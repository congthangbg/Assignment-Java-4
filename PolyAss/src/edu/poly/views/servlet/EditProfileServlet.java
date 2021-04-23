package edu.poly.views.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.common.SessionUtils;
import edu.poly.dao.UserDao;
import edu.poly.entity.User;
import edu.poly.utils.CheckData;

/**
 * Servlet implementation class EditProfileServlet
 */
@WebServlet("/user/EditProfile")
public class EditProfileServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId=SessionUtils.getLoginUser(request);
		
		if(userId== null) {
			PageInfo.prepareAndForwardView(request, response, PageType.SITE_LOGIN_PAGE);
			return;
		}
		try {
			UserDao dao=new UserDao();
			User user=dao.findById(userId);
			request.setAttribute("user", user);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		
		PageInfo.prepareAndForwardView(request, response, PageType.SITE_EDIT_PROFILE_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user=new User();
		UserDao dao=new UserDao();
		boolean check = true;
		try {
			BeanUtils.populate(user, request.getParameterMap());
				if (CheckData.isNull(request.getParameter("fullname"))) {
				check = false;
				request.setAttribute("user", user);
				request.setAttribute("error", "Chưa nhập Fullname !");
			} else if (CheckData.isNull(request.getParameter("password"))) {
				check = false;
				request.setAttribute("user", user);
				request.setAttribute("error", "Chưa nhập password !");
			} else if (CheckData.isNull(request.getParameter("email"))) {
				check = false;
				request.setAttribute("user", user);
				request.setAttribute("error", "Chưa nhập email !");
			}
				if (check == true) {
					
					
					String userId=SessionUtils.getLoginUser(request);
					User oldUser=dao.findById(userId);
					
					user.setAdmin(oldUser.isAdmin());
					dao.update(user);
					request.setAttribute("message", "User update success!!!");
					request.setAttribute("user", user);
				}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		PageInfo.prepareAndForwardView(request, response, PageType.SITE_EDIT_PROFILE_PAGE);
	}

}

package edu.poly.views.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.dao.UserDao;
import edu.poly.entity.User;
import edu.poly.utils.CheckData;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/Registration")
public class RegisterServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PageInfo.prepareAndForwardView(request, response, PageType.SITE_REGISTATION_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user=new User();
		boolean check = true;
		UserDao udao=new UserDao();
		try {
			BeanUtils.populate(user, request.getParameterMap());
			if (CheckData.isNull(request.getParameter("userId"))) {
				check = false;
				request.setAttribute("error", "Chưa nhập UserId !");
			} else if (CheckData.isNull(request.getParameter("fullname"))) {
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
			List<User> list = udao.findAll2();

			for (User user2 : list) {
				if (CheckData.isExist(user.getUserId(), user2.getUserId())) {
					check = false;
					request.setAttribute("user", user);
					request.setAttribute("error", "User id đã tồn tại!");
				}
			}
			if (check == true) {
				udao.insert(user);
				request.setAttribute("user", user);
				request.setAttribute("message", "Registration success!!!");
				PageInfo.prepareAndForwardView(request, response, PageType.SITE_LOGIN_PAGE);
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		PageInfo.prepareAndForwardView(request, response, PageType.SITE_REGISTATION_PAGE);
	}

}

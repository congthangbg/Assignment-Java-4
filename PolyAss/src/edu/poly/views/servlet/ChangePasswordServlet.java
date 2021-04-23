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
import edu.poly.domain.ChangePassword;
import edu.poly.entity.User;

/**
 * Servlet implementation class ChangePasswordServlet
 */
@WebServlet("/user/ChangePassword")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = SessionUtils.getLoginUser(request);

		if (userId == null) {
			request.getRequestDispatcher("/Login").forward(request, response);
			return;
		}
		request.setAttribute("userId", userId);
		PageInfo.prepareAndForwardView(request, response, PageType.SITE_CHANGE_PASSWORD_PAGE);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String userId = SessionUtils.getLoginUser(request);
			ChangePassword form = new ChangePassword();
			UserDao userDao = new UserDao();
			User user = userDao.findById(userId);

			BeanUtils.populate(form, request.getParameterMap());
			request.setAttribute("userId", userId);

			if  (form.getCurrentPassw().equals("")){
				request.setAttribute("error", "Chưa nhập mật khẩu hiện tại");
				
			} else if (!form.getCurrentPassw().equals(user.getPassword())) {
				
				request.setAttribute("error", "Mật khẩu hiện tại không đúng!!!");
			} else if (!form.getConfirmPassw().equals(form.getPassword())) {
				request.setAttribute("error", "Mật khẩu không trung nhau!!!");
			} else if (form.getPassword().equals("")) {
				
				request.setAttribute("error", "Chưa nhập mật khẩu mới");
			} else {
				UserDao dao = new UserDao();
				dao.changePassword(form.getUserId(), form.getCurrentPassw(), form.getPassword());
				request.setAttribute("message", "Thay đổi mật khẩu thành công !!!");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		PageInfo.prepareAndForwardView(request, response, PageType.SITE_CHANGE_PASSWORD_PAGE);
	}

}

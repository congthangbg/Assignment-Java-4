package edu.poly.views.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.poly.common.CookieUtils;
import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.common.SessionUtils;
import edu.poly.dao.VideoDao;
import edu.poly.entity.Video;

/**
 * Servlet implementation class HomePageServlet
 */
@WebServlet("/HomePageServlet")
public class HomePageServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			VideoDao videoDao=new VideoDao();
			String pageStr = request.getParameter("page");
			String limitStr = request.getParameter("limit");

				int page1 = pageStr == null ? 1 : Integer.parseInt(pageStr);
				int limit = limitStr == null ? 8 : Integer.parseInt(limitStr);
				if (page1 < 1) {
					page1 = 1;
				}
				if (page1 >= limit - 1) {
					page1 = limit-1;
				}
				int offset = limit * (page1 - 1);
			List<Video> list=videoDao.findPaga(offset, limit);
			request.setAttribute("page1", page1);
			request.setAttribute("listVideo", list);
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error HomePage : "+e.getMessage());
		}
		
		PageInfo.prepareAndForwardView(request, response, PageType.SITE_HOME_PAGE);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

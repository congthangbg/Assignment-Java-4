package edu.poly.views.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.common.SessionUtils;
import edu.poly.dao.FavoriteDao;
import edu.poly.dao.VideoDao;
import edu.poly.entity.Favorite;
import edu.poly.entity.Video;

/**
 * Servlet implementation class MyFavoriteServlet
 */
@WebServlet("/user/MyFavoriteServlet")
public class MyFavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			VideoDao videoDao = new VideoDao();
			String pageStr = request.getParameter("page");
			String limitStr = request.getParameter("limit");
			String userId = SessionUtils.getLoginUser(request);

			
			int page1 = pageStr == null ? 1 : Integer.parseInt(pageStr);
			int limit = limitStr == null ? 8 : Integer.parseInt(limitStr);
			if (page1 < 1) {
				page1 = 1;
			}
			if (page1 >= limit - 1) {
				page1 = limit - 1;
			}
			int offset = limit * (page1 - 1);
			FavoriteDao fdao = new FavoriteDao();
			List<Favorite> listF = fdao.findAllLike(userId,offset,limit);
			 List<Video> listVideo=new ArrayList<>();
	
				for (Favorite favorite : listF) {
					listVideo.add(favorite.getVideo()) ;
				}
	
			request.setAttribute("page1", page1);
			 request.setAttribute("listVideo", listVideo);
			

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error HomePage : " + e.getMessage());
		}
		
		PageInfo.prepareAndForwardView(request, response, PageType.SITE_FAVORITE_PAGE);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

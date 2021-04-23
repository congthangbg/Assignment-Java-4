package edu.poly.views.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.poly.common.SessionUtils;
import edu.poly.dao.FavoriteDao;
import edu.poly.dao.VideoDao;
import edu.poly.entity.Favorite;
import edu.poly.entity.User;
import edu.poly.entity.Video;

/**
 * Servlet implementation class LikeVideoServlet
 */
@WebServlet("/user/LikeVideoUser")
public class LikeVideoServlet extends HttpServlet {
boolean check=true;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!SessionUtils.isLogin(request)) {
			response.sendRedirect("Login");
			return;
		}
		String page=request.getParameter("page");
		String videoId=request.getParameter("videoId");
		FavoriteDao fdao=new FavoriteDao();
		if(videoId==null) {
			check=false;
			response.sendRedirect("/HomePageServlet");
			return;
		}
		List<Favorite> list=fdao.findAll();
		for (Favorite favorite : list) {
			if(favorite.getVideo().getVideoId()== videoId && favorite.getVideo().getVideoId().length()>1) {
				request.setAttribute("message", "bạn đã like video này !!!!");
				check=false;
				return;
			}
		}
		try {
			if(check=true) {
				Favorite favorite=new Favorite();
				Video video=new Video();
				video.setVideoId(videoId);
				favorite.setVideo(video);
				
				String userId=SessionUtils.getLoginUser(request);
				User user= new User();
				user.setUserId(userId);
				favorite.setUser(user);
				
				favorite.setLikeDate(new Date());
				
				fdao.insert(favorite);
				 
				VideoDao vdao=new VideoDao();
				Video video2=vdao.findById(videoId);
				request.setAttribute("message", "Bạn đã like video "+ video2.getTitle() );
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		if (page==null) {
			page="/HomePageServlet";
		}
	
		request.getRequestDispatcher(page).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
		
	}

}

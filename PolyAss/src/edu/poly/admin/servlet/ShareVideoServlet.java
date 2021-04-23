package edu.poly.admin.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.poly.common.EmailUtils;
import edu.poly.common.PageInfo;
import edu.poly.common.PageType;
import edu.poly.common.SessionUtils;
import edu.poly.dao.ShareDao;
import edu.poly.dao.UserDao;
import edu.poly.domain.Email;
import edu.poly.entity.Share;
import edu.poly.entity.User;
import edu.poly.entity.Video;

/**
 * Servlet implementation class ShareVideoServlet
 */
@WebServlet("/admin/ShareVideoAdmin")
public class ShareVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!SessionUtils.isLogin(request)) {
			response.sendRedirect("Login");
			return;
		}
		
		String videoId=request.getParameter("videoId");
		
		if(videoId == null) {
			response.sendRedirect("/HomeAdminServlet");
			return;
		}
		request.setAttribute("videoId", videoId);
		PageInfo.prepareAndForward(request, response, PageType.SHARE_VIDEO_MANAGEMENT);
	 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

				try {
					String emailAddress=request.getParameter("email");
					String videoId=request.getParameter("videoId");
					
					System.out.println(videoId);
					
					if(videoId ==null) {
						request.setAttribute("error", "videoId is null");
					}else {
						Email email=new Email();
						email.setFrom("congthangbg1@gmail.com");
						email.setFromPassword("congthang1");
						email.setTo(emailAddress);
						email.setSubject("Share favorite video");
					
						email.setContent("Content");
						EmailUtils.send(email,request);
						
						ShareDao shareDao=new ShareDao();
						Share share=new Share();
						
						share.setEmail(emailAddress);
						share.setShareDate(new Date());
						
						String userId=SessionUtils.getLoginUser(request);
						User user=new User();
						user.setUserId(userId);
						
						share.setUser(user);
						Video video=new Video();
						video.setVideoId(videoId);
						share.setVideo(video);
						
						shareDao.insert(share);
						
						
						request.setAttribute("message", "Video link has been sent");
					}
					
					
				} catch (Exception e) {
					e.printStackTrace();
					request.setAttribute("error",e.getMessage());
				}
				PageInfo.prepareAndForward(request, response, PageType.SHARE_VIDEO_MANAGEMENT);
			}	
	}


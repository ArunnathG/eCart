package com.shopping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shopping.model.Videos;




@Controller
public class adminHomeController {

	@RequestMapping("/adminhome")
	public void adminHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
	
		if ( request.getParameter("action") != null) {
			String action = request.getParameter("action");
			if(action.equalsIgnoreCase("delete")) {
				int id = Integer.parseInt(request.getParameter("id"));
				List<Videos> videos =(List<Videos>) session.getAttribute("videos");
				videos.remove(id);
				session.setAttribute("videos", videos);
				request.getRequestDispatcher("adminHome.jsp").forward(request, response);
			}
		} else {
			request.getRequestDispatcher("adminHome.jsp").forward(request, response);
		}
		
	}
	
	
	@RequestMapping("/addvideo")
	public String addVideo() 
	{
		return "addVideos.jsp";
	}
	
	@RequestMapping(value="/addvideo", method=RequestMethod.POST)
	public void addVideo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		int price = Integer.parseInt(request.getParameter("price"));
		
		HttpSession session = request.getSession();
		System.out.println("beforeee"+ session.getAttribute("videos"));
		if( session.getAttribute("videos") == null || ((List<Videos>) session.getAttribute("videos")).size() == 0)  {
			
			List<Videos> video = new ArrayList<Videos>();
			video.add(new Videos(1, description, name, price) );
			session.setAttribute("videos", video);
		} else {
			List<Videos> videos =(List<Videos>) session.getAttribute("videos");
			int id = videos.get(videos.size() - 1).getId();
			videos.add(new Videos( id+1, description, name, price) );
			session.setAttribute("videos", videos);
		
		}
		response.sendRedirect("./adminhome");
	}
	
	
}

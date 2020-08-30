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
	public String adminHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
	
		if ( request.getParameter("action") != null) {
			String action = request.getParameter("action");
			if(action.equalsIgnoreCase("delete")) {
				int id = Integer.parseInt(request.getParameter("id"));
				List<Videos> videos =(List<Videos>) session.getAttribute("videos");
				videos.remove(id);
				session.setAttribute("videos", videos);
				response.sendRedirect("adminhome");
			}
		} 
		
		List<Videos> videos =(List<Videos>) session.getAttribute("videos");
		session.setAttribute("videos", videos);
		return "adminHome.jsp";
		
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
		
		int price = Integer.parseInt(request.getParameter("price"));
		
		String fieldError = validateAddVideo(name, price);
	
		
		HttpSession session = request.getSession();
		if(fieldError == "")
		{
			if( session.getAttribute("videos") == null || ((List<Videos>) session.getAttribute("videos")).size() == 0)  {
				
				List<Videos> video = new ArrayList<Videos>();
				if(request.getParameter("description") != null) 
				{
					video.add(new Videos(1, "", name, price) );
				} else {
					String description = request.getParameter("description");
					video.add(new Videos(1, description, name, price) );
				}
			
				session.setAttribute("videos", video);
				response.sendRedirect("./adminhome");
			} else {
				List<Videos> videos =(List<Videos>) session.getAttribute("videos");
				
				String Error = videoCheck(videos, name);
				
				if(Error == "")
				{
					int id = videos.get(videos.size() - 1).getId();
					if(request.getParameter("description") != null) 
					{
						videos.add(new Videos(id+1, "", name, price) );
					} else {
						String description = request.getParameter("description");
						videos.add(new Videos( id+1,description, name, price) );
					}
					
					session.setAttribute("videos", videos);
					response.sendRedirect("./adminhome");
				} else {
					request.setAttribute("addVideosError", Error);
					request.getRequestDispatcher("addVideos.jsp").forward(request, response);
				}
			
			}
		} else {
			
			request.setAttribute("addVideosError", fieldError);
			request.getRequestDispatcher("addVideos.jsp").forward(request, response);
		}
		
		
	}
	
	private String validateAddVideo(String name, int price)
	{
		String error = "";
		
		if( name.length() < 5 || price==0 || Integer.toString(price).length() > 4 )
		{
			error = "invalid data";
		}
	
		return error;
	}
	
	private String videoCheck(List<Videos> videos, String name)
	{
		String error = "";
		for(int i=0; i < videos.size(); i++) {
		
			if(videos.get(i).getName().contains(name) ) {
				return 	error = "invalid data";
			}
		}
		return error;
	}
	
	
}

package com.shopping;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shopping.model.Videos;
import com.shopping.services.getVideosService;



@Controller
public class LoginController 
{

	@RequestMapping("/login")
	public String login() 
	{
		return "login.jsp";
	}
	
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public void authentication(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		String userid = request.getParameter("userName");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession();
		
		if (session != null) {
			String registeredUserId = (String) session.getAttribute("registerUserid");
			String registeredPassword = (String) session.getAttribute("registerPassword");
			
			if((userid.equals(registeredUserId) & password.equals(registeredPassword)) || (userid.equals("admin") & password.equals("admin"))) {
				
				session.setAttribute("userid", userid);

				response.sendRedirect("./userHome");
			} else {
				String loginError = "Invalid data";
				request.setAttribute("loginError", loginError);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
		
		
	}
	

	
	
}

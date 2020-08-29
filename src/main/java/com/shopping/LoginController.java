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

import com.shopping.model.Users;
import com.shopping.model.Videos;



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
		String loginError = "Invalid data";
			
			if((userid.equals("admin") & password.equals("admin@123"))) 
			{
				session.setAttribute("adminid", userid);

				response.sendRedirect("./adminhome");
			}
			else if(session.getAttribute("users") != null)
			{
				List<Users> users =(List<Users>) session.getAttribute("users");
				Boolean validUser = false;
				
				for(int i=0; i < users.size(); i++) {
					
					if(users.get(i).getUserName().contains(userid) & users.get(i).getPassword().contains(password) ) {
						
						validUser = true;
					}
				}
				
				if(validUser) 
				{
					session.setAttribute("userid", userid);

					response.sendRedirect("./userhome");
				} 
				else {
					
					request.setAttribute("loginError", loginError);
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			} else {
				request.setAttribute("loginError", loginError);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			
	}
	

	
	
}

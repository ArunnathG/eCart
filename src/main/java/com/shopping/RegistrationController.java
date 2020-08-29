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

import com.shopping.model.CartItems;
import com.shopping.model.Users;
import com.shopping.model.Videos;

@Controller 
public class RegistrationController {

	@RequestMapping("/register")
	public String displayRegistration()
	{
		return "registration.jsp";
	}
	
	@RequestMapping(value="/register",  method=RequestMethod.POST)
	public void submitRegistration(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		String registerUserid = request.getParameter("userName");
		String registerPassword = request.getParameter("password");
		String registerEmail = request.getParameter("email");
		String registerConfirmPassword = request.getParameter("confirmPassword");
		
		String Error = validateRegistration(registerEmail,registerConfirmPassword, registerPassword,  registerUserid);
		System.out.println("errrr"+ Error);
		if(Error == "")
		{
			HttpSession session = request.getSession(false);
			if(session.getAttribute("users") == null)
			{
				List<Users> users = new ArrayList<Users>();
				users.add(new Users(registerUserid, registerPassword));
				session.setAttribute("users", users);
				response.sendRedirect("login");
			} else {
				List<Users> users =(List<Users>) session.getAttribute("users");
				String error = registrationCheck(users,registerUserid, registerPassword );
				
				if (error == "")
				{
					users.add(new Users(registerUserid, registerPassword));
					session.setAttribute("users", users);
					session.setAttribute("registeremail", registerEmail);
					response.sendRedirect("login");
				} else {
					request.setAttribute("registrationError", error);
					request.getRequestDispatcher("registration.jsp").forward(request, response);
				}
				
			}
			
		} else {
			
			request.setAttribute("registrationError", Error);
			request.getRequestDispatcher("registration.jsp").forward(request, response);
		}
			
	}
	
	private String registrationCheck(List<Users> users, String userId, String password)
	{
		String error = "";
		for(int i=0; i < users.size(); i++) {
			
			if(users.get(i).getUserName().contains(userId) & users.get(i).getPassword().contains(password) ) {
				
				error = "invalid data";
			}
		}
		return error;
	}
	
	public String validateRegistration(String email, String confirmPassword, String password, String userId) {
		String Error = "";
		
		if(!password.equals(confirmPassword) || password.length() < 3 || password.length() > 9
				
				|| userId.length() < 3 || userId.length() > 8)
		{
			Error = "invalid data";
		}
		
		return Error;
	}
}

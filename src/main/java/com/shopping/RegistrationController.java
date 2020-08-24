package com.shopping;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
			
			session.setAttribute("registerUserid", registerUserid);
			session.setAttribute("registerPassword", registerPassword);
			session.setAttribute("registeremail", registerEmail);
			response.sendRedirect("login");
		} else {
			
			request.setAttribute("registrationError", Error);
			request.getRequestDispatcher("registration.jsp").forward(request, response);
		}
			
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

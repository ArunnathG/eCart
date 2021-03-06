package com.shopping;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class LogOutController {

	@RequestMapping("/logout")
	public void logOut(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		HttpSession session = request.getSession(false);
		
		if(session.getAttribute("userid") != null) {
			session.removeAttribute("userid");
		}
		

		if(session.getAttribute("adminid") != null) {
			session.removeAttribute("adminid");
		}
		
		response.sendRedirect("./login");
	}
}

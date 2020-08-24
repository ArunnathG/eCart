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
import org.springframework.web.servlet.ModelAndView;

import com.shopping.model.Videos;

import com.shopping.model.CartItems;


@Controller
public class UserHomeController {

	@RequestMapping("/userhome")
	public String userHome(HttpServletRequest request, HttpServletResponse response)
	{
		if ( request.getParameter("action") != null) {
			String action = request.getParameter("action");
			if(action.equalsIgnoreCase("add")) {
				int id = Integer.parseInt(request.getParameter("id"));
				HttpSession session = request.getSession();
				List<Videos> videos =(List<Videos>) session.getAttribute("videos");
				System.out.println("id" + id);
				Videos cartVideo = videos.get(id-1);
				
				
				if(session.getAttribute("cartItems") == null) {
					List<CartItems> cart = new ArrayList<CartItems>();
					cart.add(new CartItems(cartVideo, 1));
					
					session.setAttribute("cartItems", cart);
					session.setAttribute("totalCount", getCount(cart));
					session.setAttribute("totalPrice", getTotalPrice(cart));
				} else {
				
					List<CartItems> cart =(List<CartItems>) session.getAttribute("cartItems");
					int index = isExist(cart, id);
					
					if (index == -1) {
						cart.add(new CartItems(cartVideo, 1));
					} else {
						int quantity = cart.get(index).getQuantity() + 1;
						
						
						cart.get(index).setQuantity(quantity);
					}
				
					session.setAttribute("cartItems", cart);
					session.setAttribute("totalCount", getCount(cart));
					session.setAttribute("totalPrice", getTotalPrice(cart));
				}
				
				
				return "userHome.jsp";
			}
		}
		return "userHome.jsp";
	}
	

private int isExist(List<CartItems> cart , int id) {
		
		for(int i=0; i < cart.size(); i++) {
			
			if(cart.get(i).getVideo().getId() == id) {
				return i;
			}
		}
		return -1;
	}


private int getCount(List<CartItems> cart) {
	int totalQuantity = 0;
	for(int i=0; i < cart.size(); i++) 
		
		totalQuantity += cart.get(i).getQuantity();
		return totalQuantity;
	
}

private int getTotalPrice(List<CartItems> cart) {
	int totalPrice = 0;
	for(int i=0; i < cart.size(); i++) 
		
		totalPrice += cart.get(i).getVideo().getPrice() * cart.get(i).getQuantity();
		return totalPrice;
	
}

	@RequestMapping("/checkout")
	public String checkOut(HttpServletRequest request, HttpServletResponse response) {
		if ( request.getParameter("action") != null) {
			String action = request.getParameter("action");
			if(action.equalsIgnoreCase("delete")) {
				int id = Integer.parseInt(request.getParameter("id"));
				HttpSession session = request.getSession();
				List<CartItems> cart =(List<CartItems>) session.getAttribute("cartItems");
				cart.remove(id);
				session.setAttribute("cartItems", cart);
				session.setAttribute("totalCount", getCount((List<CartItems>) session.getAttribute("cartItems")));
				session.setAttribute("totalPrice", getTotalPrice((List<CartItems>) session.getAttribute("cartItems")));
			}
		}
		return "checkout.jsp";
	}
}

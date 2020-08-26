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

import com.shopping.model.CartItems;
import com.shopping.model.Orders;


@Controller
public class UserHomeController {

	@RequestMapping("/userhome")
	public String userHome(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		if ( request.getParameter("action") != null) {
			String action = request.getParameter("action");
			if(action.equalsIgnoreCase("add")) {
				int id = Integer.parseInt(request.getParameter("id"));
				HttpSession session = request.getSession();
				List<Videos> videos =(List<Videos>) session.getAttribute("videos");
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
				response.sendRedirect("userhome");
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
	public String checkOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		HttpSession session = request.getSession();
		if ( request.getParameter("action") != null) {
			String action = request.getParameter("action");
			if(action.equalsIgnoreCase("delete")) {
				int id = Integer.parseInt(request.getParameter("id"));
				
				List<CartItems> cart =(List<CartItems>) session.getAttribute("cartItems");
				cart.remove(id);
				session.setAttribute("cartItems", cart);
				session.setAttribute("totalCount", getCount((List<CartItems>) session.getAttribute("cartItems")));
				session.setAttribute("totalPrice", getTotalPrice((List<CartItems>) session.getAttribute("cartItems")));
			}
			response.sendRedirect("checkout");
		}
		List<CartItems> cart =(List<CartItems>) session.getAttribute("cartItems");
		session.setAttribute("cartItems", cart);
		return "checkout.jsp";
	}
	@RequestMapping("/ordercreation")
	public String orderCreation()
	{
		return "createOrder.jsp";
	}
	
	@RequestMapping(value="/ordercreation",  method=RequestMethod.POST)
	public ModelAndView ordercreation(HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession session = request.getSession();
		int totalItems = (int) session.getAttribute("totalCount");
		int totalCost = (int) session.getAttribute("totalPrice");
		String orderId = "INV-";
		
		
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		String pin = request.getParameter("pinCode");
		
		String Error = validateOrder(name,address, city, country, pin);
		ModelAndView mv = new ModelAndView();
		mv.setViewName( "createOrder.jsp");
		if(Error == "") 
		{
			if(session.getAttribute("orders") == null) {
				
				
				List<Orders> orders = new ArrayList<Orders>();
				
				orders.add(new Orders(orderId, totalItems, totalCost));
				
				session.setAttribute("orders", orders);
				
			} else {
				
				
				List<Orders> orders = (List<Orders>) session.getAttribute("orders");
			
				orders.add(new Orders(orderId, totalItems, totalCost));
				session.setAttribute("orders", orders);
			}
			session.removeAttribute("cartItems");
			session.removeAttribute("totalCount");
			session.removeAttribute("totalPrice");
			String orderSuccess = "Order placed successfully";
		
			
			mv.addObject("orderSuccess", orderSuccess);
		} else {
			mv.addObject("orderError", Error);
		}
		
		return mv;
	}
	
	
	@RequestMapping("/myaccount")
	public String myaccount()
	{
		return "account.jsp";
	}
	
	public String validateOrder(String name, String address, String city, String country, String pin) {
		String Error = "";
		
		if(name.length() < 5 || address.length() < 5 || city.length() < 5 || country.length() < 5
				
				|| pin.length() < 5 || pin.length()  > 6)
		{
			Error = "invalid data";
		}
		
		return Error;
	}
}

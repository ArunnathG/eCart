package com.shopping.model;

import java.util.List;

public class Users {
	
	private String userName;
	private String password;
	private Orders orders;
	private List<CartItems> cart;
	
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	public List<CartItems> getCart() {
		return cart;
	}
	public void setCart(List<CartItems> cart) {
		this.cart = cart;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

}

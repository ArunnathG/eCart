package com.shopping.model;

import java.util.List;

public class Orders {

	private String name;
	private String address;
	private String city;
	private String country;
	private String orderId;
	private int totalItems;
	private int totalCost;
	
	public Orders(String orderId, int totalItems, int totalCost) {
		super();
		this.orderId = orderId;
		this.totalItems = totalItems;
		this.totalCost = totalCost;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public int getTotalItems() {
		return totalItems;
	}
	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}
	public int getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public List<CartItems> getCartItems() {
		return cartItems;
	}
	public void setCartItems(List<CartItems> cartItems) {
		this.cartItems = cartItems;
	}
	private String pin;
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	private List<CartItems> cartItems;
	
}

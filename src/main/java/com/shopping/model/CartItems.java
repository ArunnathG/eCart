package com.shopping.model;

import com.shopping.model.Videos;

public class CartItems {


	
	public Videos getVideo() {
		return video;
	}

	public void setVideo(Videos video) {
		this.video = video;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
private Videos video;
	
	private int quantity;
	public CartItems(Videos video, int quantity) {
		super();
		// TODO Auto-generated constructor stub
		this.video = video;
		this.quantity = quantity;
	}
	
	public CartItems() {
		super();
	}
}

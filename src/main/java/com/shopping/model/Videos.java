package com.shopping.model;

public class Videos {


public Integer getId(){return id;}
public void setId(Integer id) {
	// TODO Auto-generated method stub
{this.id = id;}
}

public Videos(Integer id, String description, String name, Integer price) {
	super();
	this.id = id;
	this.description = description;
	this.name = name;
	this.price = price;
}
public String getName(){return name;}

public void setName(String name) {
	// TODO Auto-generated method stub
	{this.name = name;}
}


public Integer getPrice(){return price;}
public void setPrice(Integer price) {
	// TODO Auto-generated method stub
	{this.price = price;}
}

private Integer id;
private String description;
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}

private String name;
private Integer price;
}

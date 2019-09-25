package com.cognizant.truyum.model;

import java.util.ArrayList;

public class Cart
{
	ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
	
	private double total;
	
	public ArrayList<MenuItem> getMenuItems() 
	{
		return menuItems;
	}
	
	public void setMenuItems(ArrayList<MenuItem> menuItems) 
	{
		this.menuItems = menuItems;
	}
	public Cart(ArrayList<MenuItem> obj, double total)
	{
		super();
		this.menuItems = obj;
		this.total = total;
	}
	public double getTotal()
	{
		return total;
	}
	public void setTotal(double total) 
	{
		
		this.total = total; 
	}
	
	
}
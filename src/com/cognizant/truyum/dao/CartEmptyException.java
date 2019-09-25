package com.cognizant.truyum.dao;

public class CartEmptyException extends Exception
{
	public CartEmptyException() 
	{
		super();
		System.out.println("Cart is Empty");
	}

}
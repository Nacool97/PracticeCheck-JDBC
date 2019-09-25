package com.cognizant.truyum.dao;

import java.util.ArrayList;



public class CartDaoSqlImplTest  {

	public static void main(String[] args) {
		CartDaoSqlImplTest c=new CartDaoSqlImplTest();
		//c.testAddCartItem();
		/*try {
			c.testGetAllCartItems();
			
		} catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		c.testRemoveCartItem();
		}
	public void testAddCartItem() {
		// TODO Auto-generated method stub
		CartDaoSqlImpl s=new CartDaoSqlImpl();
		s.addCartItem((long)1,(long)1);
		
	}

	
	public void testGetAllCartItems() throws CartEmptyException {
		// TODO Auto-generated method stub
		CartDaoSqlImpl s=new CartDaoSqlImpl();
		s.getAllCartItems((long)1);
		
	}


	public void testRemoveCartItem() {
		// TODO Auto-generated method stub
		CartDaoSqlImpl s=new CartDaoSqlImpl();
		s.removeCartItem((long)1, (long)1);
	}

}

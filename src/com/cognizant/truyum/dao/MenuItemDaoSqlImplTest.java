package com.cognizant.truyum.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cognizant.truyum.model.MenuItem;

public class MenuItemDaoSqlImplTest {

public static void main(String[] args) {
	MenuItemDaoSqlImplTest m=new MenuItemDaoSqlImplTest();
    //m.testGetMenuItemListAdmin();
	//m.testGetMenuItemListCustomer();
	MenuItemDaoSqlImpl m1=new MenuItemDaoSqlImpl();
	
	  MenuItem mm=m1.getMenuItem((long)(2));
	  try {
		m1.editMenuItem(mm);
		 MenuItem mm1=m1.getMenuItem((long)(2));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	public void testGetMenuItemListAdmin() {
		// TODO Auto-generated method stub
		MenuItemDaoSqlImpl m=new MenuItemDaoSqlImpl();
		m.getMenuItemListAdmin();
		
	}


	public void testGetMenuItemListCustomer() {
		// TODO Auto-generated method stub
		MenuItemDaoSqlImpl m=new MenuItemDaoSqlImpl();
		m.getMenuItemListCustomer();
		
	}

	
	
	public MenuItem testGetMenuItem(long menuItemId) {
		// TODO Auto-generated method stub
		MenuItemDaoSqlImpl m=new MenuItemDaoSqlImpl();
		
		m.getMenuItem(menuItemId);
		return null;
	}
	
	
	
	public void testModifyMenuItem(MenuItem menuItem) {
		// TODO Auto-generated method stub
		
	}

}

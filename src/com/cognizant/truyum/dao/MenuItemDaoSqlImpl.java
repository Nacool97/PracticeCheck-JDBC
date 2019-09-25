package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImpl implements MenuItemDao {

	@Override
	public ArrayList<MenuItem> getMenuItemListAdmin() {
		// TODO Auto-generated method stub
		ArrayList<MenuItem> menuItemList=null;
		
		try {
		Connection con=ConnectionHandler.getConnection();
		
		
		menuItemList=new ArrayList<MenuItem>();
		PreparedStatement stmt=con.prepareStatement("select * from menu_item");  
		
		ResultSet rs = stmt.executeQuery();  
		
		
		while(rs.next()){
			
		//MenuItem menuItem=new MenuItem(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5));  
		//menuItemList.add(menuItem);
		 
		
	
		String active=rs.getString(4);
		//System.out.println(active);
		boolean b=true;
		if(active.equals("Yes")){
			b=true;
			
		}
		if(active.equals("No")){
			b=false;
			
		}
		MenuItem menuItem=new MenuItem((long)rs.getInt(1),rs.getString(2),rs.getFloat(3),b,rs.getDate(5),rs.getString(6),rs.getBoolean(7));
		System.out.println(menuItem);
		menuItemList.add(menuItem);
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return menuItemList;
	}

	@Override
	public ArrayList<MenuItem> getMenuItemListCustomer() {
		// TODO Auto-generated method stub
		ArrayList<MenuItem> menuItemList = null;
		System.out.println("dsjk");
		try {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		Date todayy = Calendar.getInstance().getTime();
		String today = simpleDateFormat.format(date);
		Date Today = DateUtil.convertToDate(today);
		
		Connection con=ConnectionHandler.getConnection();
		menuItemList=new ArrayList<MenuItem>();
		PreparedStatement stmt=con.prepareStatement("select * from menu_item where me_active='Yes' and DATE(`me_date_of_launch`) <= CURDATE()");  
		ResultSet rs=stmt.executeQuery();  
		while(rs.next()){
			long id;
			String name;
			float price;
			String active;
			Date dateOfLaunch;
			String category;
		    boolean freeDelivery;
            id=(long)rs.getInt(1);
            name=rs.getString(2);
            price=rs.getFloat(3);
            active=rs.getString(4);
            boolean b=true;
    		if(active.equals("YES")){
    			b=true;
    			
    		}
    		if(active.equals("NO")){
    			b=false;
    			
    		}
            dateOfLaunch=rs.getDate(5);
            category=rs.getString(6);
            freeDelivery=rs.getBoolean(7);
		MenuItem menuItem=new MenuItem(id,name,price,b,dateOfLaunch,category,freeDelivery); 
		System.out.println(menuItem);
		menuItemList.add(menuItem);
		} 
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menuItemList;
	}

	
	@Override
	public MenuItem getMenuItem(long menuItemId) {
		// TODO Auto-generated method stub
		Connection con=ConnectionHandler.getConnection();
		MenuItem menuItem=null;
		try {
		long menuItemIdd=menuItemId;
		PreparedStatement stmt;
		
			stmt = con.prepareStatement("select * from menu_item where me_id='"+menuItemIdd+"'");
		
		ResultSet rs=stmt.executeQuery(); 
		while(rs.next()){
			
			//MenuItem menuItem=new MenuItem(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5));  
			//menuItemList.add(menuItem);
			 
			
		
			String active=rs.getString(4);
			//System.out.println(active);
			boolean b=true;
			if(active.equals("Yes")){
				b=true;
				
			}
			if(active.equals("No")){
				b=false;
				
			}
			/*System.out.print("id= "+rs.getInt(1));
			System.out.print("name= "+rs.getString(2));
			System.out.print("price= "+rs.getFloat(3));
			System.out.print("active=" +b);
			System.out.print("date="+rs.getDate(5));
			System.out.print("category="+rs.getString(6));
			System.out.print("freeDelievery="+rs.getBoolean(7));*/
			menuItem=new MenuItem((long)rs.getInt(1),rs.getString(2),rs.getFloat(3),b,rs.getDate(5),rs.getString(6),rs.getBoolean(7));
			System.out.println(menuItem);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return menuItem;
	}
	
	public void editMenuItem(MenuItem menuItem) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionHandler.getConnection();
		 boolean active=menuItem.isActive();
		 boolean freeDelivery=menuItem.isFreeDelivery();
		 String sactive;
		 String sfreeDelivery;
 		if(active){
 			sactive="Yes";
 			
 		}
 		else{
 			sactive="No";
 		}
 		if(freeDelivery){
 			sfreeDelivery="Yes";
 			
 		}
 		else{
 			sfreeDelivery="No";
 		}
 		
		try {
			//datee = DateUtil.convertToDate(strDate);
			long id=menuItem.getId();
			PreparedStatement stmt = con.prepareStatement("update menu_item set me_name='"+menuItem.getName()+"',me_free_delivery='"+sfreeDelivery+"',me_price='"+menuItem.getPrice()+"',me_active='"+sactive+"',me_date_of_launch='"+convertDateToSQLDate(menuItem.getDateOfLaunch())+"',me_category='"+menuItem.getCategory()+"' where me_id='"+id+"'");
			
			  int row = stmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
java.sql.Date convertDateToSQLDate (java.util.Date date) {
		
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		return sqlDate;
		
	}
	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		// TODO Auto-generated method stub
		
	}

}

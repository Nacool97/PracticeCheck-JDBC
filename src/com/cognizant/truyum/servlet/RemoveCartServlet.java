package com.cognizant.truyum.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.truyum.dao.CartDao;

import com.cognizant.truyum.dao.CartDaoSqlImpl;
import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;

@WebServlet("/RemoveCart")
public class RemoveCartServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		long userId=1;
	    String menuId=request.getParameter("id");
	    long menuItemId=Long.parseLong(menuId);
	    CartDaoSqlImpl ct=new CartDaoSqlImpl();
	     ct.removeCartItem(userId,menuItemId);
	  
	   try {
		   ArrayList<MenuItem> menuItemList=ct.getAllCartItems(userId);
		   System.out.println("msamsm "+menuItemList);
		   if(menuItemList.isEmpty()){
			   RequestDispatcher rd=request.getRequestDispatcher("cart-empty.jsp");
				rd.forward(request, response); 
		   }
		   else{
		     double total=ct.price;
		     int totall=(int)total;
			 request.setAttribute("totalobj", totall);
		   request.setAttribute("removeCartItemStatus",true);
	       request.setAttribute("menuItemListobj", menuItemList);
	       RequestDispatcher rd=request.getRequestDispatcher("cart.jsp");
	   
		rd.forward(request, response);
		   }
	   }catch(CartEmptyException e){
		   RequestDispatcher rd=request.getRequestDispatcher("cart-empty.jsp");
			rd.forward(request, response); 
	   }
		   
	   }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
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
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

/**
 * Servlet implementation class ShowCartServlet
 */
@WebServlet("/ShowCart")
public class ShowCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ShowCartServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		long userId=1;
		CartDaoSqlImpl c=new CartDaoSqlImpl();
		try {
			ArrayList<MenuItem> menuItemList=c.getAllCartItems(userId);
			  if(menuItemList.isEmpty()){
				   RequestDispatcher rd=request.getRequestDispatcher("cart-empty.jsp");
					rd.forward(request, response); 
			   }
			  else{
			double total=c.price;
			int totall=(int)total;
			 request.setAttribute("totalobj", totall);
		    request.setAttribute("menuItemListobj", menuItemList);
		    RequestDispatcher rd=request.getRequestDispatcher("cart.jsp");
		    rd.forward(request, response);
			  }
		    }catch(Exception cs){
			  RequestDispatcher rd=request.getRequestDispatcher("cart-empty.jsp");
			  rd.forward(request, response);
		    
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
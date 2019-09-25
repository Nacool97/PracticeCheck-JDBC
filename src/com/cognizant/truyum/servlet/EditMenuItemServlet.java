package com.cognizant.truyum.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.dao.MenuItemDaoSqlImpl;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

@WebServlet("/EditMenuItem")
public class EditMenuItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public EditMenuItemServlet() {
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		try {
			MenuItemDaoSqlImpl menuItemobj=new MenuItemDaoSqlImpl();
			String name=request.getParameter("fname");
			String price=request.getParameter("fprice");
			String active=request.getParameter("inStock");
			String date=request.getParameter("date");
			String category=request.getParameter("category");
			String freeDelievery=request.getParameter("freeDelievery");
			System.out.println(freeDelievery);
            String id=request.getParameter("id");
            long menuItemId=Long.parseLong(id);
			float fprice=Float.parseFloat(price);
			boolean bactive=false;
			System.out.println("kya "+active);
			if(active.equals("Yes")) {
				bactive=true;
			}
			if(active.equals("No")) {
				bactive=false;
			}
			System.out.println(active+" "+bactive);
			boolean bfreeDelievery=false;
			if(freeDelievery!=null) {
			 bfreeDelievery=true;
			}
			else{
				 bfreeDelievery=false;
			}
			System.out.println(DateUtil.convertToDate(date));
			System.out.println(bfreeDelievery);
			
			MenuItem mfreeDelievery=new MenuItem(menuItemId,name,fprice,bactive, DateUtil.convertToDate(date),category,bfreeDelievery);
		    menuItemobj.editMenuItem(mfreeDelievery);
		    RequestDispatcher rd=request.getRequestDispatcher("edit-menu-item-status.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
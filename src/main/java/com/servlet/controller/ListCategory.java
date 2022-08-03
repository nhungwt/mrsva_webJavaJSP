package com.servlet.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.dao.CategoryDAO;
import com.servlet.model.Category;
import com.servlet.model.Product;

/**
 * Servlet implementation class List
 */
@WebServlet(name = "list", urlPatterns = { "/list" })
public class ListCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		CategoryDAO cd = new CategoryDAO();
		ArrayList<Category> list = cd.getAll();
		request.setAttribute("list", list);
		
		String id_raw = request.getParameter("key");
		try {
			int cid = (id_raw==null)? 0: Integer.parseInt(id_raw);
			ArrayList<Product> ds = cd.getAllProductById(cid);
			request.setAttribute("listProducts", ds);
			request.setAttribute("cid", cid);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		
	}

}

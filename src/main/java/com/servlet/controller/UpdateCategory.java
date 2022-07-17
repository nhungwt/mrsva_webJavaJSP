package com.servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.dao.CategoryDAO;
import com.servlet.model.Category;

/**
 * Servlet implementation class UpdateCategory
 */
@WebServlet(name = "updateCategory", urlPatterns = { "/updateCategory" })
public class UpdateCategory extends HttpServlet {

	static CategoryDAO cd = new CategoryDAO();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		int id = Integer.parseInt(request.getParameter("id"));
//		CategoryDAO cd = new CategoryDAO();
		Category c = cd.getCategoryById(id);
		request.setAttribute("category", c);
		request.getRequestDispatcher("updateCategory.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String describe = request.getParameter("describe");
		Category c = new Category(id, name, describe);
		cd.updateCategory(c);
		response.sendRedirect("list");
	}

}

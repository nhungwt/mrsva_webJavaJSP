package com.servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.dao.UserDAO;
import com.servlet.model.User;

/**
 * Servlet implementation class editUserServlet
 */
@WebServlet("/editUserServlet")
public class editUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String username  = request.getParameter("username");
//		String pass  = request.getParameter("pass");
		UserDAO uD = new UserDAO();
		User u = uD.getUserByUsername(username);
		request.setAttribute("user", u);
		request.getRequestDispatcher("editUser.jsp").forward(request, response);
		 
	} 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String username  = request.getParameter("username");
		String pass  = request.getParameter("pass");
		UserDAO uD = new UserDAO();
		User u = uD.getUserByUsername(username);
		u.setPass(pass);
		uD.editUser(u);
		request.setAttribute("user", u);
		request.getRequestDispatcher("editUser.jsp").forward(request, response);
	}

}

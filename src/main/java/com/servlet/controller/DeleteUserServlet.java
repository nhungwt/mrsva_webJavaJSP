package com.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.dao.UserDAO;
import com.servlet.model.User;

/**
 * Servlet implementation class DeleteUserServlet
 */
@WebServlet("/delete")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String username = request.getParameter("username");
		UserDAO uDAO = new UserDAO();
		uDAO.deleteUser(username);
		response.sendRedirect("db-connect");
//		PrintWriter out = response.getWriter();
//		
//		  response.setContentType( "text/html;charset=UTF-8" );
//		  out.println( "<HTML>" );
//		  out.println( "<HEAD>" );
//		  out.println( "<TITLE>Stop job</TITLE>" );
//		  out.println( "</HEAD>" );
//		  out.println( "<body>" );
//		  out.println( "<h1>Hello Nhung sdgvs</h1>" );
//		  out.println( "</body>" );
//		  out.println( "</HTML>" );

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package com.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.dao.UserDAO;
import com.servlet.model.User;

/**
 * Servlet implementation class DBConnectServlet
 */
@WebServlet("/db-connect")
public class DBConnectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBConnectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO u = new UserDAO();
		ArrayList<User> arr = u.getAll();
		request.setAttribute("data", arr);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		

//		PrintWriter out = response.getWriter();
//		
//		  response.setContentType( "text/html;charset=UTF-8" );
//		  out.println( "<HTML>" );
//		  out.println( "<HEAD>" );
//		  out.println( "<TITLE>Stop job</TITLE>" );
//		  out.println( "</HEAD>" );
//		  out.println( "<body>" );
//		  out.println( "<h1>Hello Nhung db contewct</h1>" );
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

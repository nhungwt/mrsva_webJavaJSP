package com.servlet.controller;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.servlet.dao.ReadFile;

/**
 * Servlet implementation class ReadFileServlet
 */
@WebServlet("/read-file")
public class ReadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	int count;
	private ReadFile dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadFileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());

		  // Set a cookie for the user, so that the counter does not increate
        // every time the user press refresh
        HttpSession session = request.getSession(true);
        // Set the session valid for 5 secs
        session.setMaxInactiveInterval(5);
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        if (session.isNew()) {
            count++;
        }
        out.println("This site has been accessed " + count + " times.");
	}
	
	@Override
    public void init() throws ServletException {
        dao = new ReadFile();
        try {
            count = dao.getCount();
        } catch (Exception e) {
            getServletContext().log("An exception occurred in FileCounter", e);
            throw new ServletException("An exception occurred in FileCounter"
                    + e.getMessage());
        }
    }
	 public void destroy() {
	        super.destroy();
	        try {
	            dao.save(count);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Nhung: ");
//		doGet(request, response);
//	}

}

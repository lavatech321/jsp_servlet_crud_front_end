package com.newtest.controller;

import com.newtest.model.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="deleteuser", urlPatterns="/deleteuser")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
    	System.out.println(request.getParameter("id"));
    	int result = UserModel.delete(request.getParameter("id"));
    	response.sendRedirect("/newtest/viewuser");
	}

}

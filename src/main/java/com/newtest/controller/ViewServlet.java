package com.newtest.controller;

import com.newtest.bean.*;
import java.util.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.newtest.model.EmployeeModel;

@WebServlet(name="view", urlPatterns="/view")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
    	System.out.println("touched view");
    	System.out.println("ID:" + request.getParameter("id"));
    	String id = request.getParameter("id");
    	if (id != null && !id.isEmpty()) {
    		EmployeeBean b1 = EmployeeModel.viewEmp(id);
    		request.setAttribute("empBean", b1);
    	}
    		
    	List l1 = EmployeeModel.listID();
    	request.setAttribute("list", l1);
		request.getRequestDispatcher("/WEB-INF/jsp/views/view.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}

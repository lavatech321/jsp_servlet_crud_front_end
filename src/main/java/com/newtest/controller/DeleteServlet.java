package com.newtest.controller;

import com.newtest.model.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import com.newtest.bean.EmployeeBean;
import com.newtest.model.EmployeeModel;

@WebServlet(name="delete",urlPatterns="/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
    	String id = request.getParameter("eid");
		if (id != null && !id.isEmpty()) {
			EmployeeBean b1 =  EmployeeModel.viewEmp(id);
			request.setAttribute("b1", b1);
		}
		ArrayList l1 = EmployeeModel.listID();
		request.setAttribute("list", l1);
    	request.getRequestDispatcher("/WEB-INF/jsp/views/delete.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int result = EmployeeModel.delete( Integer.parseInt(request.getParameter("eid")));
		EmployeeBean b1 = null;
		request.setAttribute("b1", b1);
		response.sendRedirect("/newtest/delete");
	}
}

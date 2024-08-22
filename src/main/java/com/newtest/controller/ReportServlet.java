package com.newtest.controller;

import java.util.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import com.newtest.model.EmployeeModel;

@WebServlet(name="report", urlPatterns="/report")
public class ReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
    	ArrayList l1 = EmployeeModel.empReport();
    	request.setAttribute("list", l1);
		request.getRequestDispatcher("/WEB-INF/jsp/views/report.jsp").forward(request, response);
	}

}

package com.newtest.controller;

import com.newtest.bean.*;
import com.newtest.model.UserModel;
import com.newtest.utility.ServletUtility;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name="login", urlPatterns="/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.getRequestDispatcher("/WEB-INF/jsp/views/login.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession(true);
		UserBean bean;
		bean = UserModel.login(username,password);
		if (bean != null) {
			session.setAttribute("user", bean);
			response.sendRedirect("/newtest/home");
	    }
		else {
			ServletUtility.setErrorMessage("Invalid Username or Password!", request);
			request.getRequestDispatcher("/WEB-INF/jsp/views/login.jsp").forward(request, response);
		}
	}

}

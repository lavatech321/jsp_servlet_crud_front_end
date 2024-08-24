package com.newtest.controller;

import com.newtest.bean.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.newtest.model.UserModel;

@WebServlet(name="adduser", urlPatterns="/adduser")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/views/add_users.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String rpassword = request.getParameter("rpassword");
		String spassword;
		if (password.equals(rpassword)) {
			spassword = password;
		}
		else {
			System.out.println("Password does not match");
		}
		int id = UserModel.computeID();
		UserBean bean = new UserBean();
		bean.setId(id);
		bean.setUsername(username);
		bean.setPassword(password);
		int result = UserModel.addUser(bean);
		doGet(request, response);
	}
}

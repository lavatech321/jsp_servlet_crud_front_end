package com.newtest.controller;

import com.newtest.utility.*;
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
		
		String username="", password="", rpassword=request.getParameter("rpassword");
		int id = UserModel.computeID();
		UserBean bean = new UserBean();
		
		if ( DataValidator.isUsername(request.getParameter("username")) ) {
			username = request.getParameter("username");
			bean.setUsername(username);
		}
		else {
			ServletUtility.setErrorMessage("Invalid username!", request);
			doGet(request, response);
		}
		
		if ( DataValidator.isPassword(request.getParameter("password"))  ) {
			password = request.getParameter("password");
		}
		else {
			ServletUtility.setErrorMessage("Invalid password!", request);
			doGet(request, response);
		}
		
		if (password.equals(rpassword)) {
			bean.setPassword(password);
		}
		else {
			ServletUtility.setErrorMessage("Password does not match!", request);
			doGet(request, response);
		}
		
		bean.setId(id);
		int result = UserModel.addUser(bean);
		if (result == 1) {
            ServletUtility.setSuccessMessage("User record added sucsessfully!", request);
        }
        else {
            ServletUtility.setErrorMessage("User record not added successfully!", request);
        }
		doGet(request, response);
	}
}

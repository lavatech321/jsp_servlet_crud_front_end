package com.newtest.controller;

import com.newtest.bean.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.newtest.model.UserModel;


@WebServlet(name="edituser", urlPatterns="/edituser")
public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserBean bean = UserModel.viewUser(request.getParameter("id")) ;
		request.setAttribute("bean", bean);
		request.getRequestDispatcher("/WEB-INF/jsp/views/edit_users.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

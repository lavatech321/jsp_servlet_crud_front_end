package com.newtest.controller;

import com.newtest.bean.*;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

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
		UserBean bean = new UserBean();
        String password = request.getParameter("password");
        String rpassword = request.getParameter("rpassword");
		String username = request.getParameter("username");
        String spassword;
        if (password.equals(rpassword)) {
    			spassword = password;
    			bean.setUsername(username);
    			bean.setPassword(spassword);
    			int result = UserModel.update(bean);
    			System.out.println("Password updated successfully");
    			response.sendRedirect("/newtest/home");
    		}
    	else {
    			System.out.println("Password does not match");
    			response.sendRedirect("/newtest/home");
    	}
	}
}

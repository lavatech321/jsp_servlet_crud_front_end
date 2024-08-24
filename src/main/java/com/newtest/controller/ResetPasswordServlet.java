package com.newtest.controller;

import com.newtest.bean.*;
import com.newtest.model.UserModel;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name="reset_password", urlPatterns="/reset_password")
public class ResetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

    	UserBean bean = new UserBean();
        String token = request.getParameter("token");
        String password = request.getParameter("password");
        String rpassword = request.getParameter("rpassword");
		String username = request.getParameter("username");
        String spassword;
		
        ServletContext context = getServletContext();
        
        // Verify the token
        Map tokenStorage = (Map) context.getAttribute("tokenStorage");
        String email = (String) tokenStorage.get(token);
        if (email != null) {
            // Update the user's password in the database
    		if (password.equals(rpassword)) {
    			spassword = password;
    			bean.setUsername(username);
    			bean.setPassword(spassword);
    			int result = UserModel.update(bean);
    			response.sendRedirect("/newtest/login");
    		}
    		else {
    			System.out.println("Password does not match");
    		}
    		  
            // Remove the token so it can't be used again
            tokenStorage.remove(token);
            // Inform the user that their password has been reset
            System.out.println("Password reset successfully!");
        } else {
        	System.out.println("Invalid or expired token.");
        }
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/template/reset_password.jsp").forward(request, response);
	}
}

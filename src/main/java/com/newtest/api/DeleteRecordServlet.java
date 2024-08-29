package com.newtest.api;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.newtest.utility.JDBCDataSource;

@WebServlet(name="apidelete",urlPatterns="/api/delete")
public class DeleteRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
    	int id;
    	
    	
    	try(Connection conn = JDBCDataSource.getConnection();
        		PreparedStatement ps = conn.prepareStatement(
	            		"delete from EMPLOYEE "
	            		+ "where id=? "
	            );) {
    		
    		if (request.getParameter("id") != null ) {
        		id = Integer.parseInt(request.getParameter("id"));
        	}
        	else {
        		id = (Integer) null;
        	}
        	ps.setInt(1, id);
        		
        	int rows = ps.executeUpdate();
        	response.setContentType("application/json");
                
            if (rows > 0) {
                    out.println("{\"message\": \"Employee record deleted successfully\"}");
                } else {
                    out.println("{\"error\": \"Failed to delete employee record\"}");
                }
            } catch (Exception e) {
            	out.println("{\"error\": \"Failed to delete employee record\"}");
                e.printStackTrace();
            }
	}

}

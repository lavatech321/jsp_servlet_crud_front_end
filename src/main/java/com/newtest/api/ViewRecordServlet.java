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
import java.sql.ResultSet;

import com.newtest.utility.JDBCDataSource;

@WebServlet(name="apiview", urlPatterns="/api/view")
public class ViewRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
    	int id;
    	try(Connection conn = JDBCDataSource.getConnection();
    		PreparedStatement ps = conn.prepareStatement("select * from EMPLOYEE where id=?");) {
        	
        	if (request.getParameter("id") != null ) {
        		id = Integer.parseInt(request.getParameter("id"));
        	}
        	else {
        		id = (Integer) null;
        	}
        	ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
        	response.setContentType("application/json");
        	
            if (rs.next()) {
                out.println("{");
                out.println("\"id\": " + rs.getInt("id") + ",");
                out.println("\"fname\": \"" + rs.getString("fname") + "\",");
                out.println("\"lname\": \"" + rs.getString("lname") + "\",");
                out.println("\"username\": \"" + rs.getString("username") + "\",");
                out.println("\"email\": \"" + rs.getString("email") + "\"");
                out.println("\"address\": \"" + rs.getString("address") + "\"");
                out.println("\"phno\": \"" + rs.getString("phno") + "\"");
                out.println("\"country\": \"" + rs.getString("country") + "\"");
                out.println("\"state\": \"" + rs.getString("state") + "\"");
                out.println("\"remote\": \"" + rs.getInt("remote") + "\"");
                out.println("\"zip\": \"" + rs.getInt("zip") + "\"");
                out.println("\"jobtype\": \"" + rs.getString("jobtype") + "\"");
                out.println("}");
            } else {
            	out.println("{\"error\": \"Failed to fetch employee record\"}");
            }
         } 
    	catch (Exception e) {
            	out.println("{\"error\": \"Failed to fetch employee record\"}");
                e.printStackTrace();
         }
		
	}

}

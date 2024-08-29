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
import java.sql.Statement;

import com.newtest.utility.JDBCDataSource;


// http://localhost:8084/newtest/api/create?id=1&fname=raj&lname=sharma&username=rsharma&email=r@gmail.com&address=XYZ&phno=3412341234&country=India&state=Maharashtra&phno=1234567890&zip=41023&remote=0&jobtype=permanent
@WebServlet(name="create", urlPatterns="/api/create")
public class CreateRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	PrintWriter out = response.getWriter();
    	int id, zip, remote;
    	
    	String fname = request.getParameter("fname");
    	String lname = request.getParameter("lname");
    	String username = request.getParameter("username");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phno = request.getParameter("phno");
        String country = request.getParameter("country");
        String state = request.getParameter("state");

        if (request.getParameter("zip") != null ) {
        	zip = Integer.parseInt(request.getParameter("zip"));
        }
        else {
        	zip = 0;
        }
        
        if (request.getParameter("remote") != null ) {
        	remote = Integer.parseInt(request.getParameter("remote"));
        }
        else {
        	remote = 0;
        }
        
        String jobtype = request.getParameter("jobtype");
        try(Connection conn = JDBCDataSource.getConnection();
        		PreparedStatement ps = conn.prepareStatement("INSERT INTO EMPLOYEE VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");) {
        	
        	if (request.getParameter("id") != null ) {
        		id = Integer.parseInt(request.getParameter("id"));
        	}
        	else {
        		id = (Integer) null;
        	}
        		ps.setInt(1, id);
        		ps.setString(2, fname);
        		ps.setString(3, lname);
        		ps.setString(4, username);
        		ps.setString(5, email);
        		ps.setString(6, address);
        		ps.setString(7, phno);
        		ps.setString(8, country);
        		ps.setString(9, state);
        		ps.setInt(10, zip);
        		ps.setInt(11, remote);
        		ps.setString(12, jobtype);
        		ps.setString(13, null);
        		
        		int rows = ps.executeUpdate();
        		response.setContentType("application/json");
                
                if (rows > 0) {
                    out.println("{\"message\": \"Employee record created successfully\"}");
                } else {
                    out.println("{\"error\": \"Failed to create employee record\"}");
                }
            } catch (Exception e) {
            	out.println("{\"error\": \"Failed to create employee record\"}");
                e.printStackTrace();
            }
    }
}

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

//http://localhost:8084/newtest/api/update?id=1&fname=raj&lname=sharma&username=rsharma&email=r@gmail.com&address=XYZ&phno=3412341234&country=India&state=Maharashtra&phno=1234567890&zip=41023&remote=0&jobtype=permanent
@WebServlet(name="apiupdate",urlPatterns="/api/update")
public class UpdateRecordServlet extends HttpServlet {
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
	        		PreparedStatement ps = conn.prepareStatement(
		            		"update EMPLOYEE set "
		            		+ "fname=? ,"
		            		+ "lname=? ,"
		            		+ "username=? ,"
		            		+ "email=? ,"
		            		+ "address=? ,"
		            		+ "phno=? ,"
		            		+ "country=? ,"
		            		+ "state=? ,"
		            		+ "remote=? ,"
		            		+ "zip=? ,"
		            		+ "jobtype=? "
		            		+ "where id=? "
		            );) {
	        	
	        	if (request.getParameter("id") != null ) {
		    		id = Integer.parseInt(request.getParameter("id"));
		    	}
		    	else {
		    		id = (Integer) null;
		    	}
		    	
	        		ps.setInt(12, id);
	        		ps.setString(1, fname);
	        		ps.setString(2, lname);
	        		ps.setString(3, username);
	        		ps.setString(4, email);
	        		ps.setString(5, address);
	        		ps.setString(6, phno);
	        		ps.setString(7, country);
	        		ps.setString(8, state);
	        		ps.setInt(9, zip);
	        		ps.setInt(10, remote);
	        		ps.setString(11, jobtype);
	        		
	        		int rows = ps.executeUpdate();
	        		response.setContentType("application/json");
	                
	                if (rows > 0) {
	                    out.println("{\"message\": \"Employee record updated successfully\"}");
	                } else {
	                    out.println("{\"error\": \"Failed to update employee record\"}");
	                }
	            } catch (Exception e) {
	            	out.println("{\"error\": \"Failed to update employee record\"}");
	                e.printStackTrace();
	            }
	    }

}

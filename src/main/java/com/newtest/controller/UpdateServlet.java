package com.newtest.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import com.newtest.bean.EmployeeBean;
import com.newtest.model.EmployeeModel;

@MultipartConfig
@WebServlet(name="update", urlPatterns="/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("eid");
		if (id != null && !id.isEmpty()) {
			EmployeeBean b1 =  EmployeeModel.viewEmp(id);
			request.setAttribute("b1", b1);
		}
		ArrayList l1 = EmployeeModel.listID();
		request.setAttribute("list", l1);
		request.getRequestDispatcher("/WEB-INF/jsp/views/update.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EmployeeBean bean = new EmployeeBean();
		bean.setFname(request.getParameter("fname"));
		bean.setLname(request.getParameter("lname"));
		bean.setUsername(request.getParameter("username"));
		bean.setEmail(request.getParameter("email"));
		bean.setAddress(request.getParameter("address"));
		bean.setPhno(request.getParameter("phno"));
		bean.setCountry(request.getParameter("country"));
		bean.setState(request.getParameter("state"));
		bean.setId(Integer.parseInt(request.getParameter("updateid")));
		bean.setZip(Integer.parseInt(request.getParameter("zip")));
		bean.setJobtype(request.getParameter("jobtype"));
		String remote = request.getParameter("remote");
		
		if (remote == null ) {
        	bean.setRemote(0);
        }
        else {
        	bean.setRemote(1);
        }
		System.out.println("Poocha yaha 2");
		// Get image
        Blob blob = null;
        Part filepart;
        try {
	            filepart = request.getPart("profile");
	            System.out.println("File part is: "+filepart);
	            InputStream inputStream = null;
	            inputStream = filepart.getInputStream();
	            System.out.println("here");
	            byte[] b = new byte[inputStream.available()];
	            System.out.println(b);
	            inputStream.read(b);
	            try {
	                blob = new SerialBlob(b);
	            } 
	            catch (Exception e) {
	                System.out.println("Blob error");
	            } 
            	bean.setProfile(blob);
            	System.out.println("Me:"+bean.getProfile());
	        } 
        catch (Exception e) {
        	System.out.println("Caugth here:");
	        e.printStackTrace();
	    }
		
		int result = EmployeeModel.update(bean);
		response.sendRedirect("/newtest/update");
	}
}

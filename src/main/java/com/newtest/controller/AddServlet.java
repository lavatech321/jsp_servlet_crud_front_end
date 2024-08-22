package com.newtest.controller;

import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import java.sql.Blob;
import com.newtest.model.*;
import com.newtest.bean.*;
import java.beans.beancontext.BeanContext;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="add",urlPatterns="/add")
@MultipartConfig(maxFileSize = 16177215)
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/views/add.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeBean bean = new EmployeeBean();
		int id = EmployeeModel.computeID();
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phno = request.getParameter("phno");
        String country = request.getParameter("country");
        String state = request.getParameter("state");
        int zip = Integer.parseInt(request.getParameter("zip"));
        String remote = request.getParameter("remote");
        String jobtype = request.getParameter("jobtype");
        
        // Get image
        Blob blob = null;
        Part filepart;
        try {
            filepart = request.getPart("profile");
        
            InputStream inputStream = null;
        
            inputStream = filepart.getInputStream();
            byte[] b = new byte[inputStream.available()];
            System.out.println(b);
            inputStream.read(b);
            try {
                blob = new SerialBlob(b);
            } catch (SerialException e) {
                
                e.printStackTrace();
            } catch (SQLException e) {
                
                e.printStackTrace();
            }
            System.out.println(blob);
            bean.setProfile(blob);
        } catch (Exception e) {
            e.printStackTrace();
        }
        bean.setFname(fname);        
        bean.setLname(lname);
        bean.setUsername(username);
        bean.setId(id);
        bean.setEmail(email);
        bean.setAddress(address);
        bean.setPhno(phno);
        bean.setCountry(country);
        bean.setState(state);
        bean.setZip(zip);
        bean.setJobtype(jobtype);
        if (remote == null ) {
        	bean.setRemote(0);
        }
        else {
        	bean.setRemote(1);
        }
        
        long pk = EmployeeModel.add(bean);
        if (pk == 1) {
        	System.out.println("Record inserted successfully");
        }
        else {
        	System.out.println("Record not inserted");
        }
        
        doGet(request, response);
	}
}

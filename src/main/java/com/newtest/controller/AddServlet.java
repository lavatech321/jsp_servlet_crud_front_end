package com.newtest.controller;

import com.newtest.model.*;
import com.newtest.bean.*;
import java.beans.beancontext.BeanContext;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

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
        EmployeeModel model = new EmployeeModel();
        
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phno = request.getParameter("phno");
        String country = request.getParameter("country");
        String state = request.getParameter("state");
        int zip = Integer.parseInt(request.getParameter("zip"));
        String status = request.getParameter(request.getParameter("status1"));
        String jobtype = request.getParameter(request.getParameter("credit"));
        
        System.out.println(fname);
        System.out.println(lname);
        System.out.println(username);
        System.out.println(email);
        System.out.println(address);
        System.out.println(phno);
        System.out.println(country);
        System.out.println(state);
        System.out.println(zip);
        System.out.println(status);
        System.out.println(jobtype);
        
        Blob blob = null;
        Part filepart;
        try {
            filepart = request.getPart("pic");
        
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
            
            bean.setFname(fname);
            bean.setLname(lname);
            bean.setUsername(username);
            bean.setEmail(email);
            bean.setAddress(address);
            bean.setPhno(phno);
            bean.setCountry(country);
            bean.setState(state);
            bean.setZip(zip);
            bean.setStatus(status);
            bean.setJobtype(jobtype);
            bean.setPic(blob);
            long pk = model.add(bean);
        } catch (Exception e) {
        
            e.printStackTrace();
        }
        System.out.println("Record added");
        doGet(request, response);

	}

}

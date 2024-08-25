package com.newtest.controller;

import com.newtest.utility.*;
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
		String fname, lname, username, email, phno;
		int zip;
		int id = EmployeeModel.computeID();
		
		if ( DataValidator.isFname(request.getParameter("fname")) ) {
			fname = request.getParameter("fname");
			bean.setFname(fname);
		}
		else {
			ServletUtility.setErrorMessage("Invalid first name!", request);
		    request.getRequestDispatcher("/WEB-INF/jsp/views/add.jsp").forward(request, response);
		}
		
		if ( DataValidator.isLname(request.getParameter("lname")) ) {
			lname = request.getParameter("lname");
			bean.setLname(lname);
		}
		else {
			ServletUtility.setErrorMessage("Invalid last name!", request);
		    request.getRequestDispatcher("/WEB-INF/jsp/views/add.jsp").forward(request, response);
		}
		
		if ( DataValidator.isUsername(request.getParameter("username")) ) {
			username = request.getParameter("username");
			bean.setUsername(username);
		}
		else {
			ServletUtility.setErrorMessage("Invalid username!", request);
		    request.getRequestDispatcher("/WEB-INF/jsp/views/add.jsp").forward(request, response);
		}
		
		if ( DataValidator.isEmail(request.getParameter("email")) ) {
			email = request.getParameter("email");
			bean.setEmail(email);
		}
		else {
			ServletUtility.setErrorMessage("Invalid email!", request);
		    request.getRequestDispatcher("/WEB-INF/jsp/views/add.jsp").forward(request, response);
		}
		
		if ( DataValidator.isPhno(request.getParameter("phno")) ) {
			phno = request.getParameter("phno");
			bean.setPhno(phno);
		}
		else {
			ServletUtility.setErrorMessage("Invalid Phone number!", request);
		    request.getRequestDispatcher("/WEB-INF/jsp/views/add.jsp").forward(request, response);
		}
        
        if ( DataValidator.isZip(Integer.parseInt(request.getParameter("zip"))) ) {
			zip = Integer.parseInt(request.getParameter("zip"));
			bean.setZip(zip);
		}
		else {
			ServletUtility.setErrorMessage("Invalid zip code!", request);
		    request.getRequestDispatcher("/WEB-INF/jsp/views/add.jsp").forward(request, response);
		}
        
        // Get image
        Blob blob = null;
        Part filepart;
        try {
            filepart = request.getPart("profile");
        
            InputStream inputStream = null;
        
            inputStream = filepart.getInputStream();
            byte[] b = new byte[inputStream.available()];
            inputStream.read(b);
            try {
                blob = new SerialBlob(b);
            } catch (Exception e) {
                e.printStackTrace();
            }
            bean.setProfile(blob);
        } catch (Exception e) {
            e.printStackTrace();
        }

        bean.setId(id);
        
        String address = request.getParameter("address");
        bean.setAddress(address);

        String country = request.getParameter("country");
        String state = request.getParameter("state");
        bean.setCountry(country);
        bean.setState(state);
        
        String remote = request.getParameter("remote");
        String jobtype = request.getParameter("jobtype");
        bean.setJobtype(jobtype);
        if (remote == null ) {
        	bean.setRemote(0);
        }
        else {
        	bean.setRemote(1);
        }
        
        long pk = EmployeeModel.add(bean);
        if (pk == 1) {
            ServletUtility.setSuccessMessage("Employee record added sucsessfully!", request);
        }
        else {
            ServletUtility.setErrorMessage("Employee record not added successfully!", request);
        }
        request.getRequestDispatcher("/WEB-INF/jsp/views/add.jsp").forward(request, response);
	}
}

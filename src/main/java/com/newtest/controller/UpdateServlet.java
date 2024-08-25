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
import com.newtest.utility.DataValidator;
import com.newtest.utility.ServletUtility;



@WebServlet(name="update", urlPatterns="/update")
@MultipartConfig(maxFileSize = 16177215)
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
		String fname, lname, username, email, phno;
		int zip;
		
		if ( DataValidator.isFname(request.getParameter("fname")) ) {
			fname = request.getParameter("fname");
			bean.setFname(fname);
		}
		else {
			ServletUtility.setErrorMessage("Invalid first name! Record not updated", request);
			doGet(request,response);
		}
		
		if ( DataValidator.isLname(request.getParameter("lname")) ) {
			lname = request.getParameter("lname");
			bean.setLname(lname);
		}
		else {
			ServletUtility.setErrorMessage("Invalid last name! Record not updated", request);
			doGet(request,response);
		}
		
		if ( DataValidator.isUsername(request.getParameter("username")) ) {
			username = request.getParameter("username");
			bean.setUsername(username);
		}
		else {
			ServletUtility.setErrorMessage("Invalid username! Record not updated", request);
			doGet(request,response);
		}
		
		if ( DataValidator.isEmail(request.getParameter("email")) ) {
			email = request.getParameter("email");
			bean.setEmail(email);
		}
		else {
			ServletUtility.setErrorMessage("Invalid email! Record not updated", request);
			doGet(request,response);
		}

		if ( DataValidator.isPhno(request.getParameter("phno")) ) {
			phno = request.getParameter("phno");
			bean.setPhno(phno);
		}
		else {
			ServletUtility.setErrorMessage("Invalid Phone number! Record not updated", request);
			doGet(request,response);
		}
        
		if ( DataValidator.isZip(Integer.parseInt(request.getParameter("zip"))) ) {
			zip = Integer.parseInt(request.getParameter("zip"));
			bean.setZip(zip);
		}
		else {
			ServletUtility.setErrorMessage("Invalid zip code! Record not updated", request);
			doGet(request,response);
		}
        
		
		bean.setAddress(request.getParameter("address"));
		bean.setCountry(request.getParameter("country"));
		bean.setState(request.getParameter("state"));
		bean.setId(Integer.parseInt(request.getParameter("updateid")));
		bean.setJobtype(request.getParameter("jobtype"));
		String remote = request.getParameter("remote");
		
		if (remote == null ) {
        	bean.setRemote(0);
        }
        else {
        	bean.setRemote(1);
        }
        Blob blob = null;
        Part filepart;
        try {
	            filepart = request.getPart("profile");
	            if (filepart != null && filepart.getSize() > 0) {
	            	System.out.println(filepart);
	            	System.out.println("Filepart is not null");
	            	InputStream inputStream = filepart.getInputStream();
	            	byte[] b = new byte[inputStream.available()];
	            	inputStream.read(b);
		            try {
		                blob = new SerialBlob(b);
		            } 
		            catch (Exception e) {
		                System.out.println("Blob error");
		            } 
	            	bean.setProfile(blob);
	            }
	            else {
	            	bean.setProfile(null);
	            }
	            
	        } 
        catch (Exception e) {
	        e.printStackTrace();
	    }
		
		int result = EmployeeModel.update(bean);
		if (result == 1) {
            ServletUtility.setSuccessMessage("Employee record updated sucsessfully!", request);
        }
        else {
            ServletUtility.setErrorMessage("Employee record not updated successfully!", request);
        }
		
		doGet(request,response);
	}
}

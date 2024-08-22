package com.newtest.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.newtest.bean.EmployeeBean;
import com.newtest.utility.JDBCDataSource;



@WebServlet(name="image", urlPatterns="/image")
public class ViewImage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        response.setContentType("image/jpg");
        int id = Integer.parseInt(request.getParameter("eid"));
		Connection conn = null;
    	EmployeeBean bean = new EmployeeBean();
    	try {
			conn = JDBCDataSource.getConnection();
			Statement stat = conn.createStatement();
			String q1 = "select * from EMPLOYEE where id="+id;
			ResultSet rs = stat.executeQuery(q1);
			if (rs.next()) {
				System.out.println(rs.getString(2));
				byte[] imageData = rs.getBytes(13);
				ServletOutputStream os = response.getOutputStream();
				os.write(imageData);
				os.flush();
				os.close();
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}

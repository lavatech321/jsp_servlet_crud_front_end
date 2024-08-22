package com.newtest.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Arrays;

import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "DatabaseInitServlet", urlPatterns = {}, loadOnStartup = 1)
public class DatabaseInitServlet extends HttpServlet {
    //private JDBCDataSource dataSource;

    @Override
    public void init() throws ServletException {
        try {
            //Context initialContext = new InitialContext();
            //Context envContext = (Context) initialContext.lookup("java:/comp/env");
            //dataSource = (JDBCDataSource) envContext.lookup("jdbc/MyDB");
            createSchema();
        } catch (Exception e) {
            throw new ServletException("Error initializing database schema", e);
        }
    }
    
    private void createSchema() {
        try (Connection conn = JDBCDataSource.getConnection();
             Statement stmt = conn.createStatement();
             InputStream input = getServletContext().getResourceAsStream("/WEB-INF/sql/schema.sql");
             BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {

            StringBuilder sql = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sql.append(line).append("\n");
            }
            // Split SQL script into individual statements
            String[] sqlStatements = sql.toString().split(";");

            // Execute each SQL statement
            for (String statement : sqlStatements) {
            	System.out.println(statement);
                if (!statement.trim().isEmpty()) {
                    stmt.executeUpdate(statement.trim());
                }
            }

            System.out.println("Database schema created successfully");
        }
        catch (Exception e) {
        	System.out.println(e.getMessage());
        }
    }
}

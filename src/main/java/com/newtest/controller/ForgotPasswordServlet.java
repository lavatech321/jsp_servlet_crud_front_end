package com.newtest.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@WebServlet(name="forgot_password", urlPatterns="/forgot_password")
public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/template/forgot_password.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
        String email = request.getParameter("email");        
        
        Map<String, String> tokenStorage = new HashMap<>();
        ServletContext context = getServletContext();
        
        String token = UUID.randomUUID().toString();
        tokenStorage.put(token, email);
        context.setAttribute("tokenStorage", tokenStorage);
        
        String resetLink = "http://localhost:8084/newtest/reset_password?token="+token+"&username="+username;
        sendEmail(email, resetLink, username);
		request.getRequestDispatcher("/WEB-INF/jsp/template/forgot_password.jsp").forward(request, response);
	}
	
	
    private void sendEmail(String to, String resetLink, String username) {
        String from = "kripakoth@gmail.com";
        String host = "smtp.gmail.com";
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("kripakoth@gmail.com", "qrwg rarq ilcr clfo");
            }
        });
        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("Password Reset Request");

            // Now set the actual message
            message.setText("Hello " + username + "! \n \tTo reset your password, click the link below:\n" + resetLink);

            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

}

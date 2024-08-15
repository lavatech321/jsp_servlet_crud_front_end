<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setAttribute("title","Home Page"); %>
<% request.setAttribute("contentpage","/WEB-INF/jsp/content/home_content.jsp"); %>
<%@ include file="/WEB-INF/jsp/template/layout.jsp" %>
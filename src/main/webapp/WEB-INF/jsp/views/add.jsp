<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setAttribute("title","New Employee"); %>
<% request.setAttribute("contentpage","/WEB-INF/jsp/content/add_content.jsp"); %>
<%@ include file="/WEB-INF/jsp/template/layout.jsp" %>
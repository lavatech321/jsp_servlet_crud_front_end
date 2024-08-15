<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css">
	    <link href="css/bootstrap.min.css" rel="stylesheet">
	    <link href="css/dashboard.css" rel="stylesheet">
	    <link href="css/form-validation.css" rel="stylesheet">
		<title><%= request.getAttribute("title") %></title>
	</head>
<body>
	<%@ include file="/WEB-INF/jsp/template/header.jsp" %>
	<div class="container-fluid">
      <div class="row">
        <%@ include file="/WEB-INF/jsp/template/sidebar.jsp" %>
    	<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
			<c:import url="${contentpage}"></c:import>
		</main>
      </div>
    </div>
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js"></script>
</body>
</html>
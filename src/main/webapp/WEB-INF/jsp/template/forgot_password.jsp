<%@page import="com.newtest.utility.ServletUtility"%>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="https://getbootstrap.com/docs/4.0/assets/img/favicons/favicon.ico">

    <title>Forgot Password</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.0/examples/floating-labels/">

    <!-- Bootstrap core CSS -->
    <link href="https://getbootstrap.com/docs/4.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="https://getbootstrap.com/docs/4.0/examples/floating-labels/floating-labels.css" rel="stylesheet">
  </head>

  <body>
    <form class="form-signin" method="post" action="/newtest/forgot_password">
      <div class="text-center mb-4">
        <!--  <img class="mb-4" src="https://getbootstrap.com/docs/4.0/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">  -->
        <h1 class="h3 mb-3 font-weight-normal">Password Recovery</h1>
      </div>


        <% if ( ! ServletUtility.getSuccessMessage(request).equals("") ) { %>
        
	        <div class="alert alert-success">
			  <%=ServletUtility.getSuccessMessage(request)%>
			</div>
	        
	    <% } %>
	     
	     <% if ( !ServletUtility.getErrorMessage(request).equals("") ) { %>
	        
	        <div class="alert alert-danger">
			  <%=ServletUtility.getErrorMessage(request)%>
			</div>
		
		<% } %>


		<div class="form-label-group">
        	<input type="text" class="form-control" placeholder="username" name="username" required autofocus>
        	<label>Username</label>
      	</div>
		
      <div class="form-label-group">
        <input type="email" class="form-control" placeholder="email" name="email" required autofocus>
        <label>Email</label>
      </div>

      <button class="btn btn-lg btn-primary btn-block" type="submit">Reset Password</button>
    </form>
  </body>
</html>

<%@page import="com.newtest.utility.ServletUtility"%>


<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
            <h1 class="h2">Add User</h1>
  </div>
  
        <div class="col-md-8 order-md-1">
        
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
		        
        
          <form class="needs-validation" novalidate method="post" action="/newtest/adduser">
            
            <div class="mb-3">
              <label for="email">Username</label>
              <input type="text" class="form-control" name="username">
            </div>

            <div class="mb-3">
              <label for="email">Password</label>
              <input type="email" class="form-control" name="password">
            </div>
            
            <div class="mb-3">
              <label for="email">Repeat Password</label>
              <input type="email" class="form-control" name="rpassword">
            </div>
            
            <hr class="mb-4">
            <button class="btn btn-primary" type="submit">Create</button>
          </form>
            
            <hr class="mb-4">
</div>
        
        

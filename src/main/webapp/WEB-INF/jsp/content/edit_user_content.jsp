<jsp:useBean id="bean" class="com.newtest.bean.UserBean" scope="request"></jsp:useBean>

<% 

  	session = request.getSession(false);
    if (session == null || session.getAttribute("user") == null) {
  %>
  
    	<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
        <h4 class="h4">Please Login or Sign in to continue.</h4>
		</div>
  <%	
    }
    else {
%>


<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
            <h1 class="h2">Edit User</h1>
  </div>
  
        <div class="col-md-8 order-md-1">
          <form class="needs-validation" novalidate method="post" action="/newtest/edituser">
            
            <div class="mb-3">
              <label for="email">Email</label>
              <input type="text" class="form-control" name="username" value=<%= bean.getUsername() %> readonly >
              <div class="invalid-feedback">
                Please enter a valid email address.
              </div>
            </div>

            <div class="mb-3">
              <label for="email">Change Password</label>
              <input type="email" class="form-control" name="password">
              <div class="invalid-feedback">
                Please enter a valid password.
              </div>
            </div>
            
            <div class="mb-3">
              <label for="email">Repeat Password</label>
              <input type="email" class="form-control" name="rpassword">
              <div class="invalid-feedback">
                Please enter a valid password.
              </div>
            </div>
            
            <hr class="mb-4">
            <button class="btn btn-primary" type="submit">Update</button>
          </form>
            
            <hr class="mb-4">
</div>

   <%	} %>        
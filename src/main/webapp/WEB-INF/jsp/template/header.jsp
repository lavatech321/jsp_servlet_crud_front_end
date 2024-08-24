<%@ page import="com.newtest.bean.*" %>
 
    <nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0">
      <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">Company name</a>
      <input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search">
      <% 
      // HttpSession session = request.getSession();
      UserBean user = (UserBean) session.getAttribute("user");

      if (user != null) { %>

      	<div class="dropdown">
		  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		    Namaste, <%= user.getUsername() %> !
		  </button>
		  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
		    <a class="dropdown-item" href="<%= request.getContextPath() %>/logout">Log Out</a>
		    <a class="dropdown-item" href="<%= request.getContextPath() %>/viewuser">View Users</a>
		    <a class="dropdown-item" href="<%= request.getContextPath() %>/adduser">Add Users</a>
		  </div>
		</div>
      
      <% } else { %>
      
        <a class="nav-link btn-primary mr-2" href="<%= request.getContextPath() %>/adduser">SignIn</a>
      	<a class="nav-link btn-primary mr-2" href="<%= request.getContextPath() %>/login">LogIn</a>
      
      <% } %>	
      
    </nav>

    <nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0">
      <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">Company name</a>
      <input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search">
      
      
      	<div class="dropdown">
		  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		    Hi, Admin!
		  </button>
		  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
		    <a class="dropdown-item" href="#">SignOut</a>
		    <a class="dropdown-item" href="<%= request.getContextPath() %>/viewuser">View Users</a>
		    <a class="dropdown-item" href="<%= request.getContextPath() %>/adduser">Add Users</a>
		  </div>
		</div>
      
        <a class="nav-link btn-primary" href="<%= request.getContextPath() %>/signup">SignIn</a>
      
    </nav>

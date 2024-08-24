
<%@ page import="java.util.*" %>
<%@ page import="com.newtest.bean.*" %>

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
            <h1 class="h2">Delete Employee</h1>
            
            <div class="dropdown">
			  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown">
			    Select Employee ID
			  </button>
			  
			  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
			  
			  <%
			  
			  ArrayList l1 = (ArrayList) request.getAttribute("list");
			  for(int i=0; i<l1.size(); i++) {
				  out.println("<a class='dropdown-item' href='/newtest/delete?eid=" + l1.get(i)  + "'>" + l1.get(i) + "</a>" ); 
			  }
			  %>
			  </div>
			</div>
            
  </div>
  
  
  	<% 
  	// <jsp:useBean id="b1" class="com.newtest.bean.EmployeeBean" scope="request"></jsp:useBean>  	
  	// Not needed below as we have used jsp:useBean
  	EmployeeBean b1 = (EmployeeBean) request.getAttribute("b1");
  	if( b1 != null) {
  		
  	%>
  	  		
  		<div class="col-md-8 order-md-1">
	    <form class="needs-validation" novalidate method="post" action="/newtest/delete">
	      
	      <img src="/newtest/image?eid=<%=b1.getId()%>"
             width="200" height="200">
  			
	      <hr class="mb-4">
	      
	      <div class="row">
	      <div class="col-md-4 mb-3">
	          <label for="firstName">Employee ID</label>
	          <input type="text" class="form-control" value="<% out.println(b1.getId()); %>" name="eid" readonly>
	        </div>	
	        <div class="col-md-4 mb-3">
	          <label for="firstName">First name</label>
	          <input type="text" class="form-control" value="<% out.println(b1.getFname()); %>" readonly>
	        </div>
	        <div class="col-md-4 mb-3">
	          <label for="lastName">Last name</label>
	          <input type="text" class="form-control" value="<% out.println(b1.getLname()); %>" readonly>
	        </div>
	      </div>
	
	      <div class="mb-3">
	        <label for="username">Username</label>
	        <div class="input-group">
	          <div class="input-group-prepend">
	            <span class="input-group-text">@</span>
	          </div>
	          <input type="text" class="form-control" value="<% out.println(b1.getUsername()); %>" readonly>
	        </div>
	      </div>
	
	      <div class="mb-3">
	        <label for="email">Email <span class="text-muted">(Optional)</span></label>
	        <input type="email" class="form-control" value="<% out.println(b1.getEmail()); %>" readonly>
	      </div>
	
	      <div class="mb-3">
	        <label for="address">Address</label>
	        <input type="text" class="form-control" value="<% out.println(b1.getAddress()); %>" readonly>
	      </div>
	
	      <div class="mb-3">
	        <label for="address2">Contact number </label>
	        <input type="text" class="form-control" value="<% out.println(b1.getPhno()); %>" readonly>
	      </div>
	
	      
	      <div class="row">
  	              <div class="col-md-5 mb-3">
  	                <label for="address2">Country </label>
  	              	<input type="text" class="form-control" readonly value="<% out.println(b1.getCountry() ); %>">
  	              </div>
  	              <div class="col-md-4 mb-3">
  	                <label for="address2">State </label>
  	              	<input type="text" class="form-control" readonly value="<% out.println(b1.getState() ); %>">
  	              </div>
  	              <div class="col-md-3 mb-3">
  	                <label for="address2">Zip </label>
  	              	<input type="text" class="form-control" readonly value="<% out.println(b1.getZip() ); %>">
  	              </div>
  	            </div>
  	            
  	      <hr class="mb-4">
	      
	      <div class="row">
  	              <div class="col-md-6 mb-6">
  	                <label for="address2">Remote </label>
  	                
  	                <% if (b1.getRemote() == 0 ) {  %>
  	              	<input type="text" class="form-control" readonly value="No">
  	              	<% } else { %>
  	              	<input type="text" class="form-control" readonly value="Yes">
  	              	<%  }  %>
  	              	
  	              </div>
  	              <div class="col-md-6 mb-6">
  	                <label for="address2">Job Type </label>
  	              	<input type="text" class="form-control" readonly value="<% out.println(b1.getJobtype() ); %>">
  	              </div>
  	            </div>
  	              
  	      <hr class="mb-4">
	
	      <button class="btn btn-primary" type="submit">Delete</button>
	    </form>
	      
	      <hr class="mb-4">
	</div>

  		
   <%	} %>
 	 
   <%	} %>    
<%@page import="com.newtest.utility.ServletUtility"%>
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
            <h1 class="h2">Update Employee</h1>
            
            <div class="dropdown">
			  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown">
			    Select Employee ID
			  </button>
			  
			  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
			  
			  <%
			  ArrayList l1 = (ArrayList) request.getAttribute("list");
			  for(int i=0; i<l1.size(); i++) {
				  out.println("<a class='dropdown-item' href='/newtest/update?eid=" + l1.get(i)  + "'>" + l1.get(i) + "</a>" ); 
			  }
			  %>
			  </div>
			</div>
            
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
	</div>
		
  
  	<% 
  	// <jsp:useBean id="b1" class="com.newtest.bean.EmployeeBean" scope="request"></jsp:useBean>  	
  	// Not needed below as we have used jsp:useBean
  	EmployeeBean b1 = (EmployeeBean) request.getAttribute("b1");
  	if( b1 != null) {
  		
  	%>
  	  		
  		<div class="col-md-8 order-md-1">
	    <form class="needs-validation" novalidate method="post" action="/newtest/update"  enctype="multipart/form-data">
	      
	      <img src="/newtest/image?eid=<%=b1.getId()%>"
             width="200" height="200">
  			
	      
	      <div class="form-group">
			    <label for="profile">Change profile picture</label>
			    <input type="file" class="form-control-file" name="profile">
		  </div>
	      
	      <hr class="mb-4">
	      
	      <div class="row">
	      <div class="col-md-4 mb-3">
	          <label for="firstName">Employee ID</label>
	          <input type="text" class="form-control" value="<% out.println(b1.getId()); %>" readonly name="updateid">
	        </div>
	        <div class="col-md-4 mb-3">	        
	          <label for="firstName">First name</label>
	          <input type="text" class="form-control" value="<% out.println(b1.getFname()); %>" required name="fname">
	          <div class="invalid-feedback">
	            Valid first name is required.
	          </div>
	        </div>
	        <div class="col-md-4 mb-3">
	          <label for="lastName">Last name</label>
	          <input type="text" class="form-control" value="<% out.println(b1.getLname()); %>" required name="lname">
	          <div class="invalid-feedback">
	            Valid last name is required.
	          </div>
	        </div>
	      </div>
	
	      <div class="mb-3">
	        <label for="username">Username</label>
	        <div class="input-group">
	          <div class="input-group-prepend">
	            <span class="input-group-text">@</span>
	          </div>
	          <input type="text" class="form-control" required value="<% out.println(b1.getUsername()); %>" name="username">
	          <div class="invalid-feedback" style="width: 100%;">
	            Your username is required.
	          </div>
	        </div>
	      </div>
	
	      <div class="mb-3">
	        <label for="email">Email <span class="text-muted">(Optional)</span></label>
	        <input type="email" class="form-control" value="<% out.println(b1.getEmail()); %>"  name="email">
	        <div class="invalid-feedback">
	          Please enter a valid email address for shipping updates.
	        </div>
	      </div>
	
	      <div class="mb-3">
	        <label for="address">Address</label>
	        <input type="text" class="form-control" value="<% out.println(b1.getAddress()); %>" required name="address">
	        <div class="invalid-feedback">
	          Please enter your shipping address.
	        </div>
	      </div>
	
	      <div class="mb-3">
	        <label for="address2">Contact number </label>
	        <input type="text" class="form-control" value="<% out.println(b1.getPhno()); %>" name="phno">
	      </div>
	
	      <div class="row">
	        <div class="col-md-5 mb-3">
	          <label for="country">Country</label>
	          <select class="custom-select d-block w-100" required name="country">
	          
	          <% if (b1.getCountry().equals("India")) { %>
	            <option value="India" selected>India</option>
		          <% }
		          else {
		          %>   
	            <option value="India" >India</option>
			  <% } %>
	          <% if (b1.getCountry().equals("US")) { %>
	            <option value="US" selected>United States</option>
		          <% }
		          else {
		          %>   
	            <option value="US" >United States</option>
			  <% } %>
	          
	          </select>
	          <div class="invalid-feedback">
	            Please select a valid country.
	          </div>
	        </div>
	        <div class="col-md-4 mb-3">
	          <label for="state">State</label>
	          <select class="custom-select d-block w-100" name="state" required>
	          <% if (b1.getState().equals("MAH")) { %>
	            <option value="MAH" selected>MAH</option>
	           <% }
		          else {
		       %>
		        <option value="MAH">MAH</option>
	          <% } %>
	          <% if (b1.getState().equals("DELHI")) { %>
                  <option value="DELHI" selected>DELHI</option>
                 <% }
		          else {
		         %>
		         <option value="DELHI">DELHI</option>
              <% } %>
	          </select>
	          <div class="invalid-feedback">
	            Please provide a valid state.
	          </div>
	        </div>
	        <div class="col-md-3 mb-3">
	          <label for="zip">Zip</label>
	          <input type="text" class="form-control" value="<% out.println(b1.getZip()); %>" required name="zip">
	          <div class="invalid-feedback">
	            Zip code required.
	          </div>
	        </div>
	      </div>
	      <hr class="mb-4">
	      <div class="custom-control custom-checkbox" >
	        
	        <% if (b1.getRemote() == 1) { %>
	        <input type="checkbox" id="same-address" checked name="remote">
	        <% } else { %>
	        <input type="checkbox" id="same-address" name="remote">
	        <% } %>
	        
	        <label for="same-address">Remote</label>
	      </div>
	      
	      <hr class="mb-4">
	
	      <h4 class="mb-3">Job Type</h4>
	
		
	      <div class="d-block my-3">
	        
	        
	        <% if ( b1.getJobtype().equalsIgnoreCase("temporary") ) { %>
	          	<div class="custom-control custom-radio">
                <input value="temporary" name="jobtype" type="radio"  checked required>
                <label for="temporary">Temporary</label>
              	</div>
            <% } else { %>
            	<div class="custom-control custom-radio">
                <input value="temporary" name="jobtype" type="radio" required>
                <label for="temporary">Temporary</label>
              	</div>
            <% } %>
            
            <% if (b1.getJobtype().equalsIgnoreCase("permanent")) { %>
              <div class="custom-control custom-radio">
                <input value="permanent" name="jobtype" type="radio" checked  required>
                <label for="permanent">Permanent</label>
              </div>
            <% } else { %>
              <div class="custom-control custom-radio">
                <input value="permanent" name="jobtype" type="radio" required>
                <label for="permanent">Permanent</label>
              </div>
           	<% } %>
            
            <% if (b1.getJobtype().equalsIgnoreCase("contract")) { %>
              <div class="custom-control custom-radio">
                <input value="contract" name="jobtype" type="radio" checked required>
                <label for="contract">Contract</label>
	        </div>
	        <% } else { %>
	        	<div class="custom-control custom-radio">
                	<input value="contract" name="jobtype" type="radio" required>
                	<label for="contract">Contract</label>
	        	</div>
	        <% } %>
	        
	      </div>
	      
	      <hr class="mb-4">
	      <button class="btn btn-primary" type="submit">Update</button>
	    </form>
	      
	      <hr class="mb-4">
	</div>

  		
   <%	} %>
 	 
 <%	} %>
                
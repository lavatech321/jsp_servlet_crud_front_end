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
            <h1 class="h2">Employee Report</h1>
  </div>    
            
        <div class="table-responsive">
            <table class="table table-striped table-sm">
              <thead>
                <tr>
                  <th>Employee ID</th>
                  <th>First Name</th>
                  <th>Last Name</th>
                  <th>Username</th>
                  <th>Email</th>
                  <th>Address</th>
                  <th>Contact</th>
                  <th>Country</th>
                  <th>State</th>
                  <th>Zip</th>
                  <th>Remote</th>
                  <th>Job Type</th>
                </tr>
              </thead>
              
              <tbody>
                
                	<%
					  ArrayList l1 = (ArrayList) request.getAttribute("list");
              			for(int i=0; i<l1.size(); i++) {
              		%>
              		
						<tr>
						 	<%
							 	EmployeeBean b1 = (EmployeeBean) l1.get(i);
							 	out.println("<td>" + b1.getId() + "</td>" );
							 	out.println("<td>" + b1.getFname() + "</td>" );
							 	out.println("<td>" + b1.getLname() + "</td>" );
							 	out.println("<td>" + b1.getUsername() + "</td>" );
							 	out.println("<td>" + b1.getEmail() + "</td>" );
							 	out.println("<td>" + b1.getAddress() + "</td>" );
							 	out.println("<td>" + b1.getPhno() + "</td>" );
							 	out.println("<td>" + b1.getCountry() + "</td>" );
							 	out.println("<td>" + b1.getState() + "</td>" );
							 	out.println("<td>" + b1.getZip() + "</td>" );
							 	
							 	if ( b1.getRemote() == 1 ) { 
							 		out.println("<td>Yes</td>" );
							 	}
							 	else {
							 		out.println("<td>No</td>" );
							 	}
							 	out.println("<td>" + b1.getJobtype() + "</td>" );
						 	%>
              			  
                		</tr>
                	
                	<%	} %>
              		  
                
                
              </tbody>
              
            </table>
          </div>


   <%	} %>      
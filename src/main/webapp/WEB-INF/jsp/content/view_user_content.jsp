 <%@ page import="com.newtest.bean.*" %>
 <%@ page import="java.util.*" %>
  
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
            <h1 class="h2">View Users</h1>
  </div>    
            
        <div class="table-responsive">
            <table class="table table-striped table-sm">
              <thead>
                <tr>
                  <th>User ID</th>
                  <th>Username</th>
                  <th></th>
                  <th></th>
                </tr>
              </thead>
              <tbody>
                <tr>
                
                	<%
					  ArrayList l1 = (ArrayList) request.getAttribute("list");
              			for(int i=0; i<l1.size(); i++) {
              		%>
              		
						<tr>
						 	<%
							 	UserBean b1 = (UserBean) l1.get(i);
							 	out.println("<td>" + b1.getId() + "</td>" );
							 	out.println("<td>" + b1.getUsername() + "</td>" );
							 	out.println("<td><a href='/newtest/edituser?id="+b1.getId()+"'>Edit</a></td>" );
							 	out.println("<td><a href='/newtest/deleteuser?id="+b1.getId()+"'>Delete</a></td>" );
						 	%>
                		</tr>
                	
                	<%	} %>
              	
                </tr>
                
              </tbody>
            </table>
          </div>
    
    <%	} %>
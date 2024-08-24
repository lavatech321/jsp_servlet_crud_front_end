  
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
            <h1 class="h2">New Employee</h1>
  </div>
  
        <div class="col-md-8 order-md-1">
          <form action="/newtest/add" method="post" enctype="multipart/form-data">
            <div class="row">
              <div class="col-md-6 mb-3">
                <label for="firstName">First name</label>
                <input type="text" class="form-control" name="fname" >
                <div class="invalid-feedback">
                  Valid first name is required.
                </div>
              </div>
              <div class="col-md-6 mb-3">
                <label for="lastName">Last name</label>
                <input type="text" class="form-control" name="lname">
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
                <input type="text" class="form-control" name="username">
                <div class="invalid-feedback" style="width: 100%;">
                  Your username is required.
                </div>
              </div>
            </div>

			<div class="mb-3">
              <label for="email">Email <span class="text-muted">(Optional)</span></label>
              <input type="email" class="form-control" name="email" placeholder="you@example.com">
              <div class="invalid-feedback">
                Please enter a valid email address for shipping updates.
              </div>
            </div>

            <div class="mb-3">
              <label for="address">Address</label>
              <input type="text" class="form-control" name="address" placeholder="1234 Main St">
              <div class="invalid-feedback">
                Please enter your shipping address.
              </div>
            </div>

            <div class="mb-3">
              <label for="phno">Contact number </label>
              <input type="text" class="form-control" name="phno" placeholder="10 digit number">
            </div>
            
            <div class="row">
              <div class="col-md-5 mb-3">
                <label for="country">Country</label>
                <select class="custom-select d-block w-100" name="country">
                  <option value="India">India</option>
                  <option value="US">United States</option>
                </select>
                <div class="invalid-feedback">
                  Please select a valid country.
                </div>
              </div>
              <div class="col-md-4 mb-3">
                <label for="state">State</label>
                <select class="custom-select d-block w-100" name="state">
                  <option value="MAH">MAH</option>
                  <option value="DELHI">DELHI</option>
                </select>
                <div class="invalid-feedback">
                  Please provide a valid state.
                </div>
              </div>
              <div class="col-md-3 mb-3">
                <label for="zip">Zip</label>
                <input type="text" class="form-control" name="zip">
                <div class="invalid-feedback">
                  Zip code required.
                </div>
              </div>
            </div>
            
            <hr class="mb-4">
            <div class="custom-control custom-checkbox">
              <input type="checkbox" name="remote">
              <label for="status1">Remote</label>
            </div>
            
            <hr class="mb-4">
            
            <h4 class="mb-3">Job Type</h4>

            <div class="d-block my-3">
              <div class="custom-control custom-radio">
                <input value="temporary" name="jobtype" type="radio" required>
                <label for="temporary">Temporary</label>
              </div>
              <div class="custom-control custom-radio">
                <input value="permanent" name="jobtype" type="radio"  required>
                <label for="permanent">Permanent</label>
              </div>
              <div class="custom-control custom-radio">
                <input value="contract" name="jobtype" type="radio" required>
                <label for="contract">Contract</label>
              </div>
            </div>
            
            <div class="form-group">
			    <label for="profile">Upload profile picture</label>
			    <input type="file" class="form-control-file" name="profile">
			</div>
            
            <hr class="mb-4">
            
            <button class="btn btn-primary" type="submit">Save</button>
          </form>
            
            <hr class="mb-4">
</div>
  
  <% } %>      
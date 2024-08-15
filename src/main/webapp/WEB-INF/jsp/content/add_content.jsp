  <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
            <h1 class="h2">New Employee</h1>
  </div>
  
        <div class="col-md-8 order-md-1">
          <form class="needs-validation" novalidate>
            <div class="row">
              <div class="col-md-6 mb-3">
                <label for="firstName">First name</label>
                <input type="text" class="form-control" id="firstName" placeholder="" value="" required>
                <div class="invalid-feedback">
                  Valid first name is required.
                </div>
              </div>
              <div class="col-md-6 mb-3">
                <label for="lastName">Last name</label>
                <input type="text" class="form-control" id="lastName" placeholder="" value="" required>
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
                <input type="text" class="form-control" id="username" placeholder="Username" required>
                <div class="invalid-feedback" style="width: 100%;">
                  Your username is required.
                </div>
              </div>
            </div>

            <div class="mb-3">
              <label for="email">Email <span class="text-muted">(Optional)</span></label>
              <input type="email" class="form-control" id="email" placeholder="you@example.com">
              <div class="invalid-feedback">
                Please enter a valid email address for shipping updates.
              </div>
            </div>

            <div class="mb-3">
              <label for="address">Address</label>
              <input type="text" class="form-control" id="address" placeholder="1234 Main St" required>
              <div class="invalid-feedback">
                Please enter your shipping address.
              </div>
            </div>

            <div class="mb-3">
              <label for="address2">Contact number </label>
              <input type="text" class="form-control" id="address2" placeholder="10 digit number">
            </div>

            <div class="row">
              <div class="col-md-5 mb-3">
                <label for="country">Country</label>
                <select class="custom-select d-block w-100" id="country" required>
                  <option value="">Choose...</option>
                  <option>United States</option>
                </select>
                <div class="invalid-feedback">
                  Please select a valid country.
                </div>
              </div>
              <div class="col-md-4 mb-3">
                <label for="state">State</label>
                <select class="custom-select d-block w-100" id="state" required>
                  <option value="">Choose...</option>
                  <option>California</option>
                </select>
                <div class="invalid-feedback">
                  Please provide a valid state.
                </div>
              </div>
              <div class="col-md-3 mb-3">
                <label for="zip">Zip</label>
                <input type="text" class="form-control" id="zip" placeholder="" required>
                <div class="invalid-feedback">
                  Zip code required.
                </div>
              </div>
            </div>
            <hr class="mb-4">
            <div class="custom-control custom-checkbox">
              <input type="checkbox" id="same-address">
              <label for="same-address">Remote</label>
            </div>
            <div class="custom-control custom-checkbox">
              <input type="checkbox" id="save-info">
              <label for="save-info">Flexible</label>
            </div>
            <hr class="mb-4">

            <h4 class="mb-3">Job Type</h4>

            <div class="d-block my-3">
              <div class="custom-control custom-radio">
                <input id="credit" name="paymentMethod" type="radio"  checked required>
                <label for="credit">Temporary</label>
              </div>
              <div class="custom-control custom-radio">
                <input id="debit" name="paymentMethod" type="radio"  required>
                <label for="debit">Permanent</label>
              </div>
              <div class="custom-control custom-radio">
                <input id="paypal" name="paymentMethod" type="radio" required>
                <label for="paypal">Contract</label>
              </div>
            </div>
            
            <hr class="mb-4">
            <button class="btn btn-primary" type="submit">Save</button>
          </form>
            
            <hr class="mb-4">
</div>
        
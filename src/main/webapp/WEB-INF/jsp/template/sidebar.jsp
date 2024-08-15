<nav class="col-md-2 d-none d-md-block bg-light sidebar">
          <div class="sidebar-sticky">
            <ul class="nav flex-column">
              <li class="nav-item">
                <a class="nav-link active" href="<%= request.getContextPath() %>/add">
                  <span data-feather="home"></span>
                  Add Employee <span class="sr-only">(current)</span>
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="<%= request.getContextPath() %>/update">
                  <span data-feather="file"></span>
                Update Employee
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="<%= request.getContextPath() %>/delete">
                  <span data-feather="file"></span>
                Delete Employee
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="<%= request.getContextPath() %>/view">
                  <span data-feather="shopping-cart"></span>
                  View Employee
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="<%= request.getContextPath() %>/report">
                  <span data-feather="users"></span>
                  Report
                </a>
              </li>
            </ul>

          </div>
        </nav>

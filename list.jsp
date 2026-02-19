<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!doctype html>
<html lang="en">
<%
    String pageName = "List Students";
    String projectName = "Servlet API";
%>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css" type="text/css" />
    <title><%= pageName %></title>

    <script>
        function loadStudents() {
            console.log("inside method call");
            const tableBody = document.getElementById("studentTableBody");
            const messageDiv = document.getElementById("messageDiv");

            fetch("http://localhost/StudentManagementSystem/api/all-student")
                .then(response => response.json()) //
                .then(data => {
                    tableBody.innerHTML = "";
                    if (data.length === 0) {
                        messageDiv.classList.remove("d-none", "alert-danger");
                        messageDiv.classList.add("alert-warning");
                        messageDiv.textContent = "No students found.";
                        return;
                    }
                    messageDiv.classList.add("d-none");

                    data.forEach(student => {
                        const row = `<tr>
                            <td>${student.id}</td>
                            <td>${student.name}</td>
                            <td>${student.phone}</td>
                            <td>${student.email}</td>
                            <td>${student.courseId}</td>
                        </tr>`;
                        tableBody.innerHTML += row;
                    });
                })
                .catch(error => {
                    console.log("An error occurred:" + error);
                    messageDiv.classList.remove("d-none", "alert-warning");
                    messageDiv.classList.add("alert-danger");
                    messageDiv.textContent = "Error loading students. Please try again.";
                });
        };

        window.onload = loadStudents;
    </script>
</head>
<body>
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
          <a class="navbar-brand" href="index.jsp"><%= projectName %></a>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>

          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
              <li class="nav-item">
                <a class="nav-link" href="register.jsp">Register Student <span class="sr-only">(current)</span></a>
              </li>
              <li class="nav-item active">
                <a class="nav-link" href="list.jsp">List</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="update.jsp">Update</a>
              </li>
              <li class="nav-item">
                 <a class="nav-link" href="remove.jsp">Remove</a>
              </li>
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  Courses
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                  <a class="dropdown-item" href="#">Java SE (Core)</a>
                  <a class="dropdown-item" href="#">Java EE (Adv)</a>
                  <div class="dropdown-divider"></div>
                  <a class="dropdown-item" href="#">Java Fullstack with Spring Boot & Microservices</a>
                  <a class="dropdown-item" href="#">Spring Boot & Microservices</a>
                  <a class="dropdown-item" href="#">Gen AI</a>
                  <a class="dropdown-item" href="#">DSA with Java</a>
                </div>
              </li>
            </ul>
            <form class="form-inline my-2 my-lg-0">
              <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
              <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
          </div>
        </nav>

    <!-- Main Content -->
    <div class="container mt-4">
        <h2>All Students</h2>

        <!-- Message Div -->
        <div id="messageDiv" class="alert d-none" role="alert"></div>

        <!-- Student Table -->
        <div class="table-responsive mt-3">
            <table class="table table-bordered table-striped">
                <thead class="thead-dark">
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Phone</th>
                        <th>Email</th>
                        <th>Course ID</th>
                    </tr>
                </thead>
                <tbody id="studentTableBody">
                    <!-- Data will be loaded here dynamically -->
                </tbody>
            </table>
        </div>
    </div>

    <!-- Footer -->
    <footer class="text-center text-lg-start bg-body-tertiary text-muted mt-5">
        <div class="text-center p-4" style="background-color: rgba(0, 0, 0, 0.05);">
            © 2025 Copyright:
            <a class="text-reset fw-bold" href="index.jsp"><%= projectName %></a>
        </div>
    </footer>

    <!-- JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js"></script>
</body>
</html>

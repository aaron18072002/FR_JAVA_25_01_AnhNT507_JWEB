<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.Cookie, com.coding.dao.HibernateMemberDao, com.coding.persistence.Member" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit member</title>
<link rel="stylesheet" href="./assests/css/bootstrap.min.css" />
<link rel="stylesheet" href="./assests/fontawesome/css/all.min.css" />
<style>
		* {
			margin: 0;
		    padding: 0;
		    border: 0;
		    box-sizing: border-box;
		}
        body, html {
            height: 100vh;
            margin: 0;
        }
        .wrapper {
            display: flex;
            height: 100vh;
        }
        .sidebar {
            width: 300px;
            background: #f8f9fa;
            /* padding: 15px; */
        }
        
        .sidebar-title {
        	padding: 15px;
        	border-bottom: 1px solid #D4D4D4;
        	margin-bottom: 30px
        }
        
        .search-box {
            display: flex;
            align-items: center;
            border: 1px solid #ccc;
            border-radius: 5px;
            overflow: hidden;
        }
        
        .search-box input {
            border: none;
            padding: 8px 10px;
            flex: 1;
            outline: none;
        }
        
        .search-box .search-icon {
            padding: 8px 12px;
            background: white;
            color: #555;
            border-left: 1px solid #ccc;
        }
        
        .content {
            flex-grow: 1;
            display: flex;
            flex-direction: column;
        }
        
        .navbar {
            border-bottom: 1px solid #D4D4D4;
            background-color: #f8f9fa;
        }
        
        .form-title {
        	width: 100%;
        	padding: 30px 0px 0px 0px;
        	border-bottom: 1px solid #D4D4D4;
        	margin-bottom: 30px;
        } 
        
        .form-container {
            width: 80%; 
            padding: 30px;
        }
        
		.nav.flex-column {
		    width: 250px;
		    background: #f8f9fa;
		    padding: 10px;
		    border-radius: 5px;
		}
		
		.nav.flex-column .nav-link {
		    color: #007bff;
		    padding: 10px;
		    border-radius: 5px;
		    display: flex;
		    align-items: center;
		}
		
		.nav.flex-column .nav-link:hover {
		    background: #e9ecef;
		    text-decoration: none;
		}
		
		.nav.flex-column .nav-link i {
		    margin-right: 10px;
		}
		
		.dropdown-menu {
		    right: 0 !important;
		    left: auto !important;
		}
  
        .dropdown-item i {
            margin-right: 8px;
        }
    </style>
</head>
<body>
	<%
	    String loggedInEmail = null;
	    Cookie[] cookies = request.getCookies();
	    if (cookies != null) {
	        for (Cookie cookie : cookies) {
	            if ("loggedInEmail".equals(cookie.getName())) {
	                loggedInEmail = cookie.getValue();
	            }
	        }
	    }
	
	    if (loggedInEmail == null) {
	        response.sendRedirect("login.jsp");
	        return;
	    }
	
	    HibernateMemberDao memberDao = new HibernateMemberDao();
	    Member member = memberDao.getMemberEmail(loggedInEmail);
	    
	    System.out.println(member);
	%>
	
	<%
	    String success = request.getParameter("success");
	    if ("true".equals(success)) {
	%>
	    <div class="alert alert-success alert-dismissible fade show" role="alert">
	        Cập nhật thông tin thành công!
	        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
	            <span aria-hidden="true">&times;</span>
	        </button>
	    </div>
	<%
	    }
	%>
	 <div class="wrapper">
        <!-- Sidebar -->
        <nav class="sidebar d-none d-md-block">
        	<div class="sidebar-title">
	            <h5 style="margin: 0px">CMS</h5>
        	</div>
        	<div style="padding: 15px">
	            <form action="<%=request.getContextPath()%>/SearchContentServlet"
					method="GET" class="search-box">
					<input type="text" name="title" placeholder="Search...">
					<button type="submit" class="search-icon">
						<i class="fas fa-search"></i>
					</button>
				</form>
				
	            <ul class="nav flex-column">
				    <li class="nav-item">
				        <a class="nav-link" href="<%=request.getContextPath()%>/ContentViewServlet"><i class="fas fa-th-list"></i> View contents</a>
				    </li>
				    <li class="nav-item">
				        <a class="nav-link" href="<%=request.getContextPath()%>/addContent.jsp"><i class="fas fa-edit"></i> Form content</a>
				    </li>
				</ul>
        	</div>
        </nav>

        <!-- Main content -->
        <div class="content">
            <!-- Navbar -->
            <nav class="navbar navbar-expand-lg navbar-light">
                <div class="container-fluid">
                    <div class="dropdown ml-auto">
                        <button class="btn btn-light dropdown-toggle" type="button" data-toggle="dropdown">
                            <i class="fas fa-user"></i>
                        </button>
                         <div class="dropdown-menu">
				            <a class="dropdown-item" href="<%=request.getContextPath()%>/edit.jsp"><i class="fas fa-user"></i> User Profile</a>
				            <a class="dropdown-item" href="<%=request.getContextPath()%>/MemberLogoutServlet">
				            	<i class="fas fa-sign-out-alt"></i> Logout
				            </a>
				        </div>
                    </div>
                </div>
            </nav>

            <div class="form-container">
            	<div class="form-title"> 
                	<h2>Edit Profile</h2>
            	</div>
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Profile Form Elements</h5>
						<form id="editForm" action="<%=request.getContextPath()%>/MemberEditServlet"
								method="get">
							<input type="hidden" name="id" value="<%=member.getId()%>">
							<div class="form-group">
								<label>First Name</label> <input type="text"
									class="form-control" name="firstName"
									value="<%=member.getFirstName()%>"> <span
									class="error-message text-danger"></span>
							</div>
							<div class="form-group">
								<label>Last Name</label> <input type="text" class="form-control"
									name="lastName" value="<%=member.getLastName()%>"> <span
									class="error-message text-danger"></span>
							</div>
							<div class="form-group">
								<label>Email</label> <input type="email" class="form-control"
									name="email" value="<%=member.getEmail()%>" readonly>
								<span class="error-message text-danger"></span>
							</div>
							<div class="form-group">
								<label>Phone</label> <input type="text" class="form-control"
									name="phone" value="<%=member.getPhone()%>"> <span
									class="error-message text-danger"></span>
							</div>
							<div class="form-group">
								<label>Description</label>
								<textarea class="form-control" name="description"><%=member.getDescription()%></textarea>
								<span class="error-message text-danger"></span>
							</div>
							<button type="submit" class="btn btn-primary">Submit</button>
							<button type="reset" class="btn btn-secondary">Reset</button>
						</form>
					</div>
                </div>
            </div>
        </div>
    </div>
    
	<script src="./assests/js/jquery-3.7.1.min.js"></script>
	<script src="./assests/js/bootstrap.bundle.min.js"></script>
	<script src="./assests/js/jquery.validate.min.js"></script>
	<script src="./assests/js/editMemberValidate.js"></script>
	
	<script>
	    $(document).ready(function () {
	        setTimeout(function () {
	            $(".alert").alert('close');
	        }, 3000);
	    });
	</script>
</body>
</html>
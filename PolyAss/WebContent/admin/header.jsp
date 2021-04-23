<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>

<header class="top-navbar">
<fmt:setLocale value="vi_VN"/>
<fmt:setBundle basename="Language.lang"/>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="container-fluid">
				<a class="navbar-brand" href="/PolyAss/HomeAdminServlet">
					<img src=" <c:url value="/images/FPT_Polytechnic.png" />"  alt="" />
				</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbars-host" aria-controls="navbars-rs-food" aria-expanded="false" aria-label="Toggle navigation">
					<span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbars-host">
					<ul class="navbar-nav ml-auto">
						<li class="nav-item active"><a class="nav-link" href="/PolyAss/HomeAdminServlet">Home</a></li>
						<li class="nav-item"><a class="nav-link" href="/PolyAss/admin/UserManagement">User</a></li>
						<li class="nav-item"><a class="nav-link" href="/PolyAss/admin/VideoManagement">Video </a></li>
						<li class="nav-item"><a class="nav-link" href="/PolyAss/admin/ReportManagementServlet">Report </a></li>
						<li class="nav-item dropdown">
							<a class="nav-link dropdown-toggle" href="#" id="dropdown-a" data-toggle="dropdown">My Account </a>
							<div class="dropdown-menu" aria-labelledby="dropdown-a">
								<c:if test="${ isLogin }">
								<a class="dropdown-item" href="/PolyAss/Logout">Logoff</a>
								<a class="dropdown-item" href="/PolyAss/admin/ChangePasswordAdmin">Change Password</a>
								<a class="dropdown-item" href="/PolyAss/admin/EditProfileAdmin">Edit Profile</a>
							</c:if>
							<c:if test="${ !isLogin }">
								<a class="dropdown-item" href="/PolyAss/Login">Login</a>
								<a class="dropdown-item" href="/PolyAss/ForgotPasswordAdmin">ForgotPassword</a>
								<a class="dropdown-item" href="/PolyAss/Registration">Registration </a>
							</c:if>

							</div>
						</li>
						<li class="nav-item"><a class="nav-link" href="domain.html">Tiếng Anh</a></li>
						<li class="nav-item"><a class="nav-link" href="pricing.html">Tiếng Việt</a></li>
					</ul>
					
				</div>
			</div>
		</nav>
	</header>
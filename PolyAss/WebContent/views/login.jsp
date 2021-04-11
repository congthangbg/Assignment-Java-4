<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>   
    
    
    <div class="modal fade" id="login" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header tit-up">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title">Customer Login</h4>
			</div>
			<div class="modal-body customer-box">
				<!-- Nav tabs -->
				<ul class="nav nav-tabs">
					<li><a class="active" href="#Login" data-toggle="tab">Login</a></li>
					<li><a href="#Registration" data-toggle="tab">Registration</a></li>
					<li><a href="#ChangePassword" data-toggle="tab">Change Password</a></li>
					<li><a href="#EditProfile" data-toggle="tab">Edit Profile</a></li>
					<li><a href="#ForgotPassword" data-toggle="tab">Forgot Password </a></li>
					
				</ul>
				<!-- Tab panes -->
				<div class="tab-content">
					<div class="tab-pane active" id="Login">

					<jsp:include page="users/login.jsp"></jsp:include> 
					</div>
					
					<!-- Registration -->
					<div class="tab-pane" id="Registration">
						<jsp:include page="users/Registration.jsp"></jsp:include>
					</div>

					<!-- EditProfile -->
					<div class="tab-pane" id="EditProfile">
						<jsp:include page="users/edit-profile.jsp"></jsp:include>
					</div>
					
					<!-- Forgot Password -->
					<div class="tab-pane" id="ForgotPassword">
						<jsp:include page="users/forgot-password.jsp"></jsp:include>
					</div>
					<!-- #ChangePassword -->
					<div class="tab-pane" id="ChangePassword">
						<jsp:include page="users/change-password.jsp"></jsp:include>
					</div>
				</div>
			</div>
		</div>
	  </div>
	</div>
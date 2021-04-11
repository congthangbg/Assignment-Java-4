<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>

            <form action="" method="post" role="form" class="form-horizontal">
               <div class="card">
                  <div class="card-body">
         			<jsp:include page="/common/inform.jsp"></jsp:include>
                  <div class="form-group">
                     <label for="username">Username</label>
                     <input type="text" class="form-control" name="username" id="username" aria-describedby="usernameHid" placeholder="Username">
                   </div>
                  <div class="form-group">
                    <label for="password">Password</label>
                    <input type="text" class="form-control" name="password" id="password" aria-describedby="passwordHId" placeholder="Password">
                  </div>
                  <div class="form-check form-check-inline">
                     <label for="remember"><input type="checkbox" id="remember"class="form-check-input" name="remember">Remember me?</label>
                  </div>
               </div>
               <div class="card-footer text-muted">
                  <button class="btn btn-success">Login</button>
                  <a class="ml-5" href="#ForgotPassword" data-toggle="tab">Forgot Password ?</a>
               </div>
            </div>
            </form>
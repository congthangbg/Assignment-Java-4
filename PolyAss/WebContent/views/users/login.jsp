<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>

 <div class="offset-4 col-4">
            <form action="" method="post" role="form" class="form-horizontal">
               <div class="card">
                <div class="card-header">
                     <b>Login to system</b>
                  </div>
                  <div class="card-body">
         			<jsp:include page="/common/inform.jsp"></jsp:include>
                  <div class="form-group">
                     <label for="username">UserId</label>
                     <input type="text" class="form-control" name="userId" id="userId" aria-describedby="userIdHid" >
                   </div>
                  <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" name="password" id="password" aria-describedby="passwordHId">
                  </div>
                  <div class="form-check form-check-inline">
                     <label for="remember"><input type="checkbox" id="remember"class="form-check-input" name="remember">Remember me?</label>
                  </div>
               </div>
               <div class="card-footer text-muted">
                  <button class="btn btn-success">Login</button>
                  <a class="ml-5" href="/PolyAss/ForgotPasswordAdmin" data-toggle="tab">Forgot Password ?</a>
               </div>
            </div>
            </form>
             </div>
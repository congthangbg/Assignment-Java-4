<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>


               <form action="ChangePassword" method="post">
                  <div class="card">
                     <div class="card-body">
                     <jsp:include page="/common/inform.jsp"></jsp:include>
                        <div class="row">
                           <div class="col">
                              <div class="form-group">
                                <label for="username">Username</label>
                                <input type="text" class="form-control" name="username" value="${username }" id="username" aria-describedby="usernameHid" placeholder="Username">
                              </div>
                              <div class="form-group">
                                <label for="password">Password</label>
                                <input type="text" class="form-control" name="password" id="password" aria-describedby="passwordHid" placeholder="Password">
                              </div>
                           </div>
                           <div class="col">
                              <div class="form-group">
                                <label for="curentPassword">Current Password</label>
                                <input type="text" class="form-control" name="curentPassword" id="curentPassword" aria-describedby="curentPassword" placeholder="current password">
                              </div>
                              <div class="form-group">
                                 <label for="confirmPassword">Confirm Password</label>
                                 <input type="text" class="form-control" name="confirmPassword" id="confirmPassword" aria-describedby="confirmPassword" placeholder="Confirm password">
                               </div>
                           </div>
                        </div>
                     </div>
                     <div class="card-footer text-muted">
                        <button class="btn btn-success">Change Password</button>
                     </div>
                  </div>
               </form>
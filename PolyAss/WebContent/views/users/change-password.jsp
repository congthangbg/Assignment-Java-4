<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>

 <div class="offset-3 col-6 mt-4">
               <form action="user/ChangePassword" method="post">
                  <div class="card">
                  <div class="card">
                     <div class="card-header">
                        Change Password
                     </div>
                     <div class="card-body">
                      <jsp:include page="/common/inform.jsp"></jsp:include>
                        <div class="row">
                           <div class="col">
                              <div class="form-group">
                                <label for="username">UserId</label>
                                <input type="text" class="form-control" name="userId" value="${userId }" id="userId" aria-describedby="usernameHid" >
                              </div>
                              <div class="form-group">
                                <label for="password">Password</label>
                                <input type="password" class="form-control" value="${form.password }" name="password" id="password" aria-describedby="passwordHid" >
                              </div>
                           </div>
                           <div class="col">
                              <div class="form-group">
                                <label for="currentPassw">Current Password</label>
                                <input type="password" class="form-control" name="currentPassw" value="${form.currentPassw }" id="currentPassw" aria-describedby="currentPassw" >
                              </div>
                              <div class="form-group">
                                 <label for="confirmPassw">Confirm Password</label>
                                 <input type="password" class="form-control" name="confirmPassw"  id="confirmPassw" aria-describedby="confirmPassw" >
                               </div>
                           </div>
                        </div>
                     </div>
                     <div class="card-footer text-muted">
                        <button class="btn btn-success">Change Password</button>
                     </div>
                  </div>
               </form>
               </div>
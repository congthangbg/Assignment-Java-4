<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>   

<div class="col-8 offset-2">
               <form action="user/EditProfile" method="post" role="form" class="form-horizontal">
                  <div class="card">
                  <div class="card-header">
                       <b>Edit Profile</b>
                     </div>
                     <div class="card-body">
                     <jsp:include page="/common/inform.jsp"></jsp:include>
                        <div class="row">
                           <div class="col">
                              <div class="form-group">
                              <label for="username">UserId</label>      
                              <input type="text" class="form-control" value="${user.userId }" name="userId" id="username" aria-describedby="userIdHid" >
                              </div>
                              <div class="form-group">
                                 <label for="fullname">Fullname</label>                   
                                 <input type="text" class="form-control" value="${user.fullname }"  name="fullname" id="fullname" aria-describedby="fullnameHid" >
                                 </div>
                           </div>
                           <div class="col">
                              <div class="form-group">
                                 <label for="password">Password</label>                     
                                 <input type="password" class="form-control" name="password"  value="${user.password }" id="password" aria-describedby="passwordHid" >
                                 </div>
                                 <div class="form-group">
                                    <label for="email">Email Address</label>                     
                                    <input type="text" class="form-control" value="${user.email }"  name="email" id="email" aria-describedby="emailHid" >
                                 </div>
                           </div>
                        </div>
                     </div>
                     <div class="card-footer text-muted">
                       <button class="btn btn-success">Update</button>
                     </div>
                  </div>
               </form>
                </div>
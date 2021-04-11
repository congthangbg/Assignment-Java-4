<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>   

               <form action="" method="post" role="form" class="form-horizontal">
                  <div class="card">
                     <div class="card-body">
                        <div class="row">
                           <div class="col">
                              <div class="form-group">
                              <label for="username">Username</label>      
                              <input type="text" class="form-control" name="username" id="username" aria-describedby="usernameHid" placeholder="Username">
                              </div>
                              <div class="form-group">
                                 <label for="fullname">Fullname</label>                   
                                 <input type="text" class="form-control" name="fullname" id="fullname" aria-describedby="fullnameHid" placeholder="Fullname">
                                 </div>
                           </div>
                           <div class="col">
                              <div class="form-group">
                                 <label for="password">Password</label>                     
                                 <input type="text" class="form-control" name="password" id="password" aria-describedby="passwordHid" placeholder="Password">
                                 </div>
                                 <div class="form-group">
                                    <label for="email">Email Address</label>                     
                                    <input type="text" class="form-control" name="email" id="email" aria-describedby="emailHid" placeholder="Email Address">
                                 </div>
                           </div>
                        </div>
                     </div>
                     <div class="card-footer text-muted">
                       <button class="btn btn-success">Update</button>
                     </div>
                  </div>
               </form>
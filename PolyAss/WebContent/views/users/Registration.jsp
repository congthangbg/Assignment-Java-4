<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>

            <form action="" method="post" role="form" class="form-horizontal">
            ${Routes.SITE_REGISTRATION_SHOW }
               <div class="card">
                  <div class="card-body">
                  <jsp:include page="/common/inform.jsp"></jsp:include>
                   
                    <div class="row">
                       <div class="col">
                        <div class="form-group">
                          <label for="username">Username</label>
                          <input type="text" value="${user.username }" class="form-control" name="username" id="username" aria-describedby="usernameHid" placeholder="Username">
                        </div>
                        <div class="form-group">
                           <label for="fullname">Fullname</label>
                           <input type="text" value="${user.fullname }"  class="form-control" name="fullname" id="fullname" aria-describedby="fullnameHid" placeholder="fullname">
                         </div>
                       </div>
                       <div class="col">
                          <div class="form-group">
                            <label for="password">Password</label>
                            <input type="password" class="form-control" name="password" id="password" placeholder="Password">
                          </div>
                          <div class="form-group">
                            <label for="email">Email</label>
                            <input type="text" class="form-control" name="email" value="${user.email }"  id="email" aria-describedby="emailHid" placeholder="Email">
                          </div>
                     </div>
                    </div>
                  </div>
                  <div class="card-footer text-muted">
                     <button class="btn btn-success">Sign up</button>
                  </div>
               </div>
            </form>
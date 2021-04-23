<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="offset-3 col-6">
	<jsp:include page="/common/inform.jsp"></jsp:include>
               <form action="/PolyAss/user/ShareVideoUser" method="post">
                  <input type="hidden" name="videoId" value="${videoId }">
                  <div class="card">
                     <div class="card-header">
                        Send video to your Friends
                     </div>
                     <div class="card-body">
                        <div class="form-group">
                          <label for="email">Your friends email :</label>
                          <input type="text"
                            class="form-control" name="email" id="email" aria-describedby="helpId" placeholder="Email">
                          <small id="emailHelperId" class="form-text text-muted">Email is required !</small>
                        </div>
                     </div>
                     <div class="card-footer">
                        <button class="btn btn-success">Send</button>
                     </div>
                  </div>

               </form>
            </div>
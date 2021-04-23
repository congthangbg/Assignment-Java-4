<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="offset-4 col-4">
	<form action="/PolyAss/ForgotPasswordAdmin" method="post">
		<div class="card ">
		<div class="card-header">
                        Forgot Password
                     </div>
			<div class="card-body">
				<jsp:include page="/common/inform.jsp"></jsp:include>
				<div class="row">
					<div class="col">
						<div class="form-group">
							<label for="userId">UserId</label> <input type="text"
								class="form-control" name="userId" id="userId"
								aria-describedby="userIdHid" placeholder="userId">
						</div>
						<div class="form-group">
							<label for="email">Email</label> <input type="text"
								class="form-control" name="email" id="email"
								aria-describedby="emailHid" placeholder="Email">
						</div>
					</div>
				</div>

			</div>
			<div class="card-footer text-muted">
				<button class="btn btn-success">Retrieve</button>
			</div>
		</div>

	</form>
</div>
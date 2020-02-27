<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="includes/header.jsp" %>

<div class="card">
    <div class="card-body">
        <h5 class="card-title">Please signup</h5>

        <form method="post">
            <div class="form-group">
                <label for="inputEmail">Email address</label>
                <input name="email" type="email" class="form-control" id="inputEmail" aria-describedby="emailHelp">
                <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.
                </small>
            </div>
            <div class="form-group">
                <label for="inputName">Name</label>
                <input name="name" type="text" class="form-control" id="inputName" aria-describedby="nameHelp">
                <small id="nameHelp" class="form-text text-muted">Your name is safe with us</small>
            </div>
            <div class="form-group">
                <label for="inputPassword">Password</label>
                <input name="password" type="password" class="form-control" id="inputPassword">
            </div>

            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
</div>

<%@ include file="includes/footer.jsp" %>
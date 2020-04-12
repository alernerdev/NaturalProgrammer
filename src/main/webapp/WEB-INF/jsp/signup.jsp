<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="includes/header.jsp" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="card">
    <div class="card-body">
        <h5 class="card-title">Please signup</h5>

        <form:form method="post" modelAttribute="userCommand">
            <form:errors cssClass="error" />

            <div class="form-group">
                <form:label path="email">Email address</form:label>
                <form:input path="email" type="email" class="form-control" id="inputEmail" />
                <form:errors path="email" cssClass="error" />
            </div>
            <div class="form-group">
                <form:label path="name">Name</form:label>
                <form:input path="name" type="text" class="form-control" id="inputName" />
                <form:errors path="name" cssClass="error" />
            </div>
            <div class="form-group">
                <form:label path="password">Password</form:label>
                <form:input path="password" type="password" class="form-control" id="inputPassword"/>
                <form:errors path="password" cssClass="error" />
            </div>

            <button type="submit" class="btn btn-primary">Submit</button>
        </form:form>
    </div>
</div>

<%@ include file="includes/footer.jsp" %>
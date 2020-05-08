<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="includes/header.jsp" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="card">
    <div class="card-body">
        <h5 class="card-title">Please sign in</h5>

        <c:if test="${param.logout != null}">
            <div class="alert alert-success" >
                You have been logged out
            </div>
        </c:if>

        <c:if test="${param.error != null}">
            <div class="alert alert-danger" >
                Failed to login
                <c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
                    Reason: ${SPRING_SECURITY_LAST_EXCEPTION.message}
                </c:if>
            </div>
        </c:if>

        <form:form method="post" action="/login">
            <div class="form-group">
                <label for="email">Email address</label>
                <input name="username" id="email" type="email" class="form-control"  />
                <p class="help-block">Enter your email address</p>
            </div>

            <div class="form-group">
                <label for="password">Password</label>
                <input name="password" id="password" type="password" class="form-control" />
            </div>

            <button type="submit" class="btn btn-primary">Hellooo</button>
        </form:form>
    </div>
</div>

<%@ include file="includes/footer.jsp" %>
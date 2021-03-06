<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<br><br><br><br>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
	
	<div class="container">

                        <c:url var="loginUrl" value="/login" />
                        <form action="${loginUrl}" method="post" class="form-horizontal">
                        
                            <c:if test="${param.error != null}">
                                <div class="alert alert-danger">
                                    <p><spring:message code="login.form.errmsg"/></p>
                                </div>
                            </c:if>
                            
                            <c:if test="${param.forbidden != null}">
                                <div class="alert alert-danger">
                                    <p><spring:message code="login.form.forbiddenmsg"/></p>
                                </div>
                            </c:if>
                            
                            <c:if test="${param.logout != null}">
                                <div class="alert alert-success">
                                    <p><spring:message code="login.form.logoutmsg"/></p>
                                </div>
                            </c:if>
                            
                            <div class="form-group">
                                <label class="input-group-addon" for="userId"><i class="fa fa-user"></i></label>
                                <input type="text" class="form-control" id="userId" name="userId" placeholder="Nome Utente" required>
                            </div>
                            <div class="form-group">
                                <label class="input-group-addon" for="password"><i class="fa fa-lock"></i></label> 
                                <input type="password" class="form-control" id="password" name="password" placeholder="Password" required>
                            </div>
                            <div class="form-group">

                            </div>
                            <input type="hidden" name="${_csrf.parameterName}"
                                value="${_csrf.token}" />
                                 
                            <div class="form-actions">
                                <input type="submit"
                                    class="btn btn-block btn-primary btn-default" value="Log in">
                            </div>
                        </form>
                    </div>

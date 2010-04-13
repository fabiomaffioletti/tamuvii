<%@ include file="/common/taglibs.jsp"%>

<head>
	<title><fmt:message key="registered.title" /></title>
</head>

<h2>Home page del sito</h2>

<%@ include file="/common/messages.jsp"%>

<spring:bind path="user.*">
    <c:if test="${not empty status.errorMessages}">
    	<ul id="user_form_errors">
	    	<c:forEach var="e" items="${status.errorMessages}">
	    		<li><img src="../images/alert.png" style="margin-right:5px; vertical-align: bottom;" />${e}</li>
	    	</c:forEach>
    	</ul>
    </c:if>
</spring:bind>

<form:form commandName="user" method="post" action="signup.html" id="userForm" name="userForm">
	<form:hidden path="id"/>
	
	Username: <form:input path="username" id="username" cssErrorClass="validation_error"/><br/>
	Email: <form:input path="email" id="email" cssErrorClass="validation_error"/><br/>
	Password: <form:password path="password" id="password" cssErrorClass="validation_error" showPassword="true"/><br/>
	Conferma password: <form:password path="confirmPassword" id="confirmPassword" cssErrorClass="validation_error" showPassword="true"/><br/>
	<input type="submit" class="button" name="save" value="Salva" />
</form:form>
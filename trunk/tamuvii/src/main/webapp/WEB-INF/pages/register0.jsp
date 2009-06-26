<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="register.title"/></title>
</head>

Primo passo: dati obbligatori

<spring:bind path="user.*">
    <c:if test="${not empty status.errorMessages}">
    <div class="error">    
        <c:forEach var="error" items="${status.errorMessages}">
            <img src="<c:url value="/images/iconWarning.gif"/>"
                alt="<fmt:message key="icon.warning"/>" class="icon" />
            <c:out value="${error}" escapeXml="false"/><br />
        </c:forEach>
    </div>
    </c:if>
</spring:bind>

<form:form name="user" id="user" commandName="user" method="post" action="/register.html">
	<input type="hidden" name="_page0" value="true" />
	<input type="hidden" name="_target1" value="true" />
	
	username: <form:input path="username" />
	<br/>
	email: <form:input path="email" />
	<br/>
	password: <form:input path="password" />
	<br/>
	conferma password: <form:input path="confirmPassword" />
	<br/>
	<input type="submit" value="Vai al secondo step" />
</form:form>
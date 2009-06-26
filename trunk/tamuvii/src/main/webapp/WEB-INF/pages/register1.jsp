<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="register.title"/></title>
</head>

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
	<input type="hidden" name="_page1" value="true" />
	<input type="hidden" name="_finish" value="true" />
	<form:input path="firstName" />
	
	<input type="submit" value="Vai" />
</form:form>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="userForm.title"/></title>
   	<security:authorize ifAnyGranted="ROLE_ADMIN">
   		<meta name="menu" content="AdminMenu"/>		
   	</security:authorize>
   	<security:authorize ifNotGranted="ROLE_ADMIN">
   		<meta name="menu" content="UserMenu"/>
   	</security:authorize>
   	
   	<style type="text/css">
   		.validation_error {
   			background-color: red;
   		}
   	</style>
</head>

<h2><fmt:message key="userForm.title"/></h2>

<spring:bind path="user.*">
    <c:if test="${not empty status.errorMessages}">
    	<ul id="user_form_errors">
	    	<c:forEach var="e" items="${status.errorMessages}">
	    		<li><img src="../images/alert.png" style="margin-right:5px; vertical-align: bottom;" />${e}</li>
	    	</c:forEach>
    	</ul>
    </c:if>
</spring:bind>

<%@ include file="/common/messages.jsp"%>

<form:form commandName="user" method="post" action="userForm.html" id="userForm" name="userForm">
	<form:hidden path="id"/>
	<input type="password" style="display:none;" />
	<input type="hidden" name="from" value="<c:out value="${param.from}"/>"/>

	<ul id="user_form_ul">
		<li>
			<span class="form_label"><fmt:message key="user.username" /></span>
			<span class="form_input"><form:input path="username" id="username" cssErrorClass="validation_error"/></span>
		</li>
		<li>
			<span class="form_label"><fmt:message key="user.password" /></span>
			<span class="form_input"><form:password path="password" id="password" cssErrorClass="validation_error" showPassword="true"/></span>
		</li>
		<li>
			<span class="form_label"><fmt:message key="user.confirmPassword" /></span>
			<span class="form_input"><form:password path="confirmPassword" id="confirmPassword" cssErrorClass="validation_error" showPassword="true"/></span>
		</li>
		<li>
			<span class="form_label"><fmt:message key="user.firstName" /></span>
			<span class="form_input"><form:input path="firstName" id="firstName" cssErrorClass="validation_error"/></span>
		</li>
		<li>
			<span class="form_label"><fmt:message key="user.lastName" /></span>
			<span class="form_input"><form:input path="lastName" id="lastName" cssErrorClass="validation_error"/></span>
		</li>
		<li>
			<span class="form_label"><fmt:message key="user.email" /></span>
			<span class="form_input"><form:input path="email" id="email" cssErrorClass="validation_error"/></span>
		</li>
		<security:authorize ifAnyGranted="ROLE_ADMIN">
			<li>
				<span class="form_label"><fmt:message key="user.enabled" /></span>
				<span class="form_input"><form:checkbox path="enabled" id="enabled" /></span> 
			</li>
			<li>
				<span class="form_label"><fmt:message key="user.can.invite" /></span>
				<span class="form_input"><form:checkbox path="canInvite" id="canInvite" /></span> 
			</li>	
		</security:authorize>
		<security:authorize ifNotGranted="ROLE_ADMIN">
			<form:hidden path="enabled" id="enabled" />
		</security:authorize>
	</ul>
	
	<security:authorize ifAnyGranted="ROLE_ADMIN">
		<ul id="user_form_roles">
			<c:forEach var="r" items="${roles}">
				<c:forEach var="ur" items="${user.roles}">
					<c:choose>
						<c:when test="${ur.id == r.id}">
							<li><input type="radio" name="role" value="${r.id}" checked="checked"><span class="form_input_role">${r.description}</span></li>
						</c:when>
						<c:otherwise>
							<li><input type="radio" name="role" value="${r.id}"><span class="form_input_role">${r.description}</span></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</c:forEach>
		</ul>
	</security:authorize>
	
	<ul id="user_form_buttons">
		<li><input type="submit" class="button" name="save" value="Salva" /></li>
		<c:if test="${not empty user.id}">
			<li>
				<input type="submit" class="button" name="delete" onclick="return confirm('<fmt:message key="confirm.user.remove" />')" value="Elimina" />
			</li>
		</c:if>
		<li><input type="submit" class="button" name="cancel" value="Annulla" /></li>
	</ul>
	
	<form:hidden path="accountExpired" />
	<form:hidden path="accountLocked" /> 
	<form:hidden path="credentialsExpired" />
</form:form>
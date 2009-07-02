<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="Modifica il profilo"/></title>
</head>

<div id="main">
	<spring:bind path="userImage.*">
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
	
	${user.username}, la tua immagine al momento è questa:
	<br/>
	<div id="user_image_div" style="background-image: url(${user.imageLink});" >
	</div>
	<br/><br/><br/>
	Vuoi cambiarla?
	
	<form:form commandName="userImage" method="post" action="/image.html" enctype="multipart/form-data" id="userImage">
		<ul>
		    <li class="info">
		        <fmt:message key="upload.message"/>
		    </li>
		    <li>
		        <appfuse:label key="uploadForm.file" styleClass="desc"/>
		        <form:errors path="file" cssClass="fieldError"/>
		        <input type="file" name="file" id="file" class="file medium"/>
		    </li>
		    <li class="buttonBar bottom">
		        <input type="submit" name="upload" class="button" onclick="bCancel=false"
		            value="<fmt:message key="button.upload"/>" />
		        <input type="submit" name="cancel" class="button" onclick="bCancel=true"
		            value="<fmt:message key="button.cancel"/>" />
		    </li>
		</ul>
	</form:form>
</div>



<div id="sidebar">
	<div id="registration_menu">
		<ul>
			<li>
				<a href="/preferences.html">Dati del profilo</a>
			</li>
			<li>
				<b>Immagine personale</b>
			</li>
			<li>
				<a href="/password.html">Modifica la tua password</a>
			</li>
		</ul>
	</div>
</div>
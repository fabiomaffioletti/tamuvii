<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="registration.title"/></title>
</head>

<div id="sidebar">
	<div id="registration_menu">
		<ul>
			<li>
				<b><fmt:message key="registration.data"/></b>
			</li>
			<li>
				<fmt:message key="registration.a.bit.about.you"/>
			</li>
			<li>
				<fmt:message key="registration.other"/>
			</li>
			<li>
				<fmt:message key="registration.finished"/>
			</li>
		</ul>
	</div>
</div>

<div id="main">
	<form:form name="user" id="user" commandName="user" method="post" action="/register.html">
		<input type="hidden" name="_page0" value="true" />
		<input type="hidden" name="_target1" value="true" />
		
		<div id="registration_form_container">
			<b><fmt:message key="welcome.to.tamuvii"/></b>
			<br/>
			<span class="light_text_italic"><fmt:message key="registration.beginning"/></span>
			<br/><br/>
			
			<spring:bind path="user.*">
			    <c:if test="${not empty status.errorMessages}">
			    <div id="validation0" style="border: 1px dashed #ccc; padding: 10px;">
		            <img src="/images/error.png" style="vertical-align: bottom; margin-right: 5px;" />
		            Sono presenti degli errori di compilazione del form, correggi i campi evidenziati e riprova!
			    </div>
			    </c:if>
			</spring:bind>
			
			<ul>
				<li>
					<div class="td_sx"><span class="mandatory">* </span><fmt:message key="registration.choose.username"/></div>
					<div class="td_dx"><form:input path="username" cssErrorClass="fieldError" /></div>
				</li>
				<li>
					<div class="td_sx"><span class="mandatory">* </span><fmt:message key="registration.choose.email"/></div>
					<div class="td_dx"><form:input path="email" cssErrorClass="fieldError" /></div>
				</li>
				<li>
					<div class="td_sx"><span class="mandatory">* </span><fmt:message key="registration.choose.password"/></div>
					<div class="td_dx"><form:input path="password" cssErrorClass="fieldError" /></div>
				</li>
				<li>
					<div class="td_sx"><span class="mandatory">* </span><fmt:message key="registration.choose.confirm.password"/></div>
					<div class="td_dx"><form:input path="confirmPassword" cssErrorClass="fieldError" /></div>
				</li>
				<li>
					<a href="#" style="float:right;" onclick="showConfirmationDiv(); return false;"><fmt:message key="l.proceed"/></a>
				</li>
			</ul>
		</div>
		<div id="confirmation_data_container" style="display:none;">
			<fmt:message key="registration.confirm.data.question"/>
			<ul>
				<li>
					<div style="float:left; margin-right: 20px;"><b><fmt:message key="registration.username"/></b></div><div id="chosenUsername" style="float:left"></div>
				</li>
				<li>
					<div style="float:left; margin-right: 20px;"><b><fmt:message key="registration.email"/></b></div><div id="chosenEmail" style="float:left"></div>
				</li>
				<li>
					<div style="float:left; margin-right: 20px;"><b><fmt:message key="registration.password"/></b></div><div id="chosenPassword" style="float:left"></div>
				</li>
				<li>
					<a style="float:left;" href="#" onclick="hideConfirmationDiv(); return false;"><fmt:message key="registration.modify.data"/></a>
					<input type="submit" style="float:right;" value="<fmt:message key='registration.go.to.second.step'/>" />
				</li>
			</ul>
		</div>
	</form:form>
</div>



<script>
	function showConfirmationDiv() {
		$('chosenUsername').innerHTML = $('username').value;
		$('chosenEmail').innerHTML = $('email').value;
		$('chosenPassword').innerHTML = $('password').value;
		$('confirmation_data_container').appear({ duration: 0.2 });
		return false;
	}
	
	function hideConfirmationDiv() {
		$('confirmation_data_container').fade({ duration: 0.2 });
		return false;
	}
</script>
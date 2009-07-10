<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="login.title"/></title>
</head>


<div id="main">
	<div id="registration_form_container">
		<form method="post" id="loginForm" action="<c:url value='/j_security_check'/>" onsubmit="saveUsername(this);">
			<b><fmt:message key="welcome.to.tamuvii"/></b>
			<br/><br/>
			<c:if test="${param.error != null}">
				<div id="validation0" style="border: 1px dashed #ccc; padding: 10px;">    
			        <img src="/images/error.png" style="vertical-align: bottom; margin-right: 10px;" />
			        <fmt:message key="tamuvii.login.failed"/>
				</div>
			</c:if>
			
			<ul>
			    <li>
			    	<div class="td_sx" style="width: 120px;"><span class="mandatory">* </span>Username: </div>
					<div class="td_dx"><input type="text" name="j_username" id="j_username" /></div>
			    </li>
			
			    <li>
			        <div class="td_sx" style="width: 120px;"><span class="mandatory">* </span>Password: </div>
					<div class="td_dx"><input type="password" name="j_password" id="j_password" /></div>
			    </li>
				<c:if test="${appConfig['rememberMeEnabled']}">
					<li>
				    	<div class="td_sx" style="width: 120px;">&nbsp;</div>
				    	<div class="td_dx"><input style="width: 20px;" type="checkbox" class="checkbox" name="_spring_security_remember_me" id="rememberMe" /><span class="light_text_italic"><fmt:message key="tamuvii.remember.me" /></span></div>
				    </li>
			    </c:if>
			    <li>
			    	<div class="td_sx" style="width: 120px;">&nbsp;</div>
			        <div class="td_dx"><input type="submit" class="login_submit_button" name="login" value="<fmt:message key="b.login" />" /></div>
			    </li>
			</ul>
		</form>
	</div>
</div>


<div id="sidebar">
	<div id="tamuvii_info_login_page">
		<ul>
			<li>
				<fmt:message key="tamuvii.description" />
			</li>
			<li>
				<fmt:message key="tamuvii.register.message" />
			</li>
			<li style="background-color: #FFDF8F;">
				<fmt:message key="tamuvii.note.firefox" /> 
			</li>
		</ul>
	</div>
</div>


<%@ include file="/scripts/login.js"%>

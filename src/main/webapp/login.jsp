<%@ include file="/common/taglibs.jsp"%>

<head>
	<title><fmt:message key="login.title"/></title>
	<script type="text/javascript" src="<c:url value='/js/jquery-1.4.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/js/common.js'/>"></script>
	<link rel="stylesheet" type="text/css" href="/css/userForm.css" />
	<style type="text/css">
		* {
			margin: 0;
			padding: 0;
		}
		
		body {
			font-family: Arial, Helvetica, sans-serif;
			font-size: 13px;
		}
		
		#wrapper {
			margin: 150px auto;
			width: 500px;
		}
	</style>
</head>

<div id="wrapper">
	<h2><fmt:message key="login.title"/></h2>

	<form method="post" id="loginForm" action="<c:url value='/j_security_check'/>">
	
		<c:if test="${param.error != null}">
			<ul id="user_form_errors">
	    		<li><img src="../images/alert.png" style="margin-right:5px; vertical-align: top" /><fmt:message key="login.error"/></li>
	    	</ul>
		</c:if>
		
		<ul id="user_form_ul">
		    <li>
	            <span style="width: 120px; float:left;"><fmt:message key="user.username"/><span class="req">*</span></span>
		        <span class="form_input"><input type="text" name="j_username" id="j_username"/></span>
		    </li>
		
		    <li>
	            <span style="width: 120px; float:left;"><fmt:message key="user.password"/><span class="req">*</span></span>
		        <input type="password" name="j_password" id="j_password" />
		    </li>
		
		    <li>
		    	<span style="width: 120px; float:left;">&nbsp;</span>
		    	<span class="form_input"><input type="submit" value="<fmt:message key="login.login"/>"></span>
		    </li>
		</ul>
	</form>

</div>
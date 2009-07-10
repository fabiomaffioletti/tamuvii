<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="registration.title"/></title>
</head>


<div id="sidebar">
	<div id="registration_menu">
		<ul>
			<li>
				<fmt:message key="registration.data"/>
			</li>
			<li>
				<fmt:message key="registration.a.bit.about.you"/>
			</li>
			<li>
				<b><fmt:message key="registration.other"/></b>
			</li>
			<li>
				<fmt:message key="registration.finished"/>
			</li>
		</ul>
	</div>
</div>


<div id="main">
	<form:form name="user" id="user" commandName="user" method="post" action="/register.html">
		<input type="hidden" name="_page2" value="true" />
		<input type="hidden" name="_finish" value="true" />
		
		<div id="registration_form_container">
			<b><fmt:message key="registration.last.effort"/></b>
			<br/>
			<span class="light_text_italic"><fmt:message key="registration.third"/></span>
			<br/><br/>
			
			<ul>
				<li>
					<div class="td_sx"><fmt:message key="registration.website.url"/></div>
					<div class="td_dx"><form:input path="website" /></div>
				</li>
				<li>
					<div class="td_sx"><fmt:message key="registration.website.title"/></div>
					<div class="td_dx"><form:input path="websitetitle" /></div>
				</li>
				<li>
					<div class="td_sx"><fmt:message key="registration.quotation"/></div>
					<div class="td_dx"><form:input path="quotation" /></div>
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
					<div style="float:left; margin-right: 20px;"><b><fmt:message key="registration.website.url"/></b></div><div id="chosenWebsiteURL" style="float:left"></div>
				</li>
				<li>
					<div style="float:left; margin-right: 20px;"><b><fmt:message key="registration.website.title"/></b></div><div id="chosenWebsiteTitle" style="float:left"></div>
				</li>
				<li>
					<div style="float:left; margin-right: 20px;"><b><fmt:message key="registration.quotation"/></b></div><div id="chosenQuotation" style="float:left"></div>
				</li>
				<li>
					<a style="float:left;" href="#" onclick="hideConfirmationDiv(); return false;"><fmt:message key="registration.modify.data"/></a>
					<input type="submit" style="float:right;" value="<fmt:message key='registration.do.register'/>" />
				</li>
			</ul>
		</div>
	</form:form>
</div>



<script>
	function showConfirmationDiv() {
		$('chosenWebsiteURL').innerHTML = $('website').value;
		$('chosenWebsiteTitle').innerHTML = $('websitetitle').value;
		$('chosenQuotation').innerHTML = $('quotation').value;
		$('confirmation_data_container').appear({ duration: 0.2 });
		return false;
	}
	
	function hideConfirmationDiv() {
		$('confirmation_data_container').fade({ duration: 0.2 });
		return false;
	}
</script>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="registration.title"/></title>
    <script type="text/javascript" src="${ctx}/scripts/calendar/calendar.js"></script>
	<script type="text/javascript" src="${ctx}/scripts/calendar/lang/calendar-it.js"></script>
  	<script type="text/javascript" src="${ctx}/scripts/calendar/calendar-setup.js"></script>
</head>

<div id="sidebar">
	<div id="registration_menu">
		<ul>
			<li>
				<fmt:message key="registration.data"/>
			</li>
			<li>
				<b><fmt:message key="registration.a.bit.about.you"/></b>
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
		<input type="hidden" name="_page1" value="true" />
		<input type="hidden" name="_target2" value="true" />
		
		<div id="registration_form_container">
			<b><fmt:message key="registration.perfect"/></b>
			<br/>
			<span class="light_text_italic"><fmt:message key="registration.second"/></span>
			<br/><br/>
			
			<spring:bind path="user.*">
			    <c:if test="${not empty status.errorMessages}">
			    <div id="validation0" style="border: 1px dashed #ccc; padding: 10px;">
		            <img src="/images/error.png" style="vertical-align: bottom; margin-right: 5px;" />
		            Attenzione, devi selezionare il paese in cui vivi.
			    </div>
			    </c:if>
			</spring:bind>
			
			<ul>
				<li>
					<div class="td_sx"><fmt:message key="registration.name"/></div>
					<div class="td_dx"><form:input path="firstName" /></div>
				</li>
				<li>
					<div class="td_sx"><fmt:message key="registration.surname"/></div>
					<div class="td_dx"><form:input path="lastName" /></div>
				</li>
				<li>
					<div class="td_sx"><fmt:message key="registration.sex"/></div>
					<div class="td_dx">
						<form:select path="sex">
							<form:option value="M"><fmt:message key="registration.sex.m"/></form:option>
							<form:option value="F"><fmt:message key="registration.sex.f"/></form:option>
						</form:select>
					</div>
				</li>
				<li>
					<div class="td_sx"><fmt:message key="registration.dob"/></div>
					<div class="td_dx"><form:input path="dob" readonly="true" cssStyle="width: 210px;" /><img src="${ctx}/images/iconCalendar.gif" id="dobButton" style="vertical-align: middle; cursor: pointer; margin-left:10px;" title="Calendario" /></div>
				</li>
				<li>
					<div class="td_sx"><fmt:message key="registration.city"/></div>
					<div class="td_dx"><form:input path="address.city" /></div>
				</li>
				<li>
					<div class="td_sx"><span class="mandatory">* </span><fmt:message key="registration.country"/></div>
					<div class="td_dx"><appfuse:country name="address.country" prompt="" default="${user.address.country}"/></div>
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
					<div style="float:left; margin-right: 20px;"><b><fmt:message key="registration.name"/></b></div><div id="chosenFirstName" style="float:left"></div>
				</li>
				<li>
					<div style="float:left; margin-right: 20px;"><b><fmt:message key="registration.surname"/></b></div><div id="chosenLastName" style="float:left"></div>
				</li>
				<li>
					<div style="float:left; margin-right: 20px;"><b><fmt:message key="registration.sex"/></b></div><div id="chosenSex" style="float:left"></div>
				</li>
				<li>
					<div style="float:left; margin-right: 20px;"><b><fmt:message key="registration.dob"/></b></div><div id="chosenDob" style="float:left"></div>
				</li>
				<li>
					<div style="float:left; margin-right: 20px;"><b><fmt:message key="registration.city"/></b></div><div id="chosenCity" style="float:left"></div>
				</li>
				<li>
					<div style="float:left; margin-right: 20px;"><b><fmt:message key="registration.country"/></b></div><div id="chosenCountry" style="float:left"></div>
				</li>
				<li>
					<a style="float:left;" href="#" onclick="hideConfirmationDiv(); return false;"><fmt:message key="registration.modify.data"/></a>
					<input type="submit" style="float:right;" value="<fmt:message key='registration.go.to.third.step'/>" />
				</li>
			</ul>
		</div>
	</form:form>
</div>



<script>
	function showConfirmationDiv() {
		$('chosenFirstName').innerHTML = $('firstName').value;
		$('chosenLastName').innerHTML = $('lastName').value;
		$('chosenSex').innerHTML = $('sex').value;
		$('chosenDob').innerHTML = $('dob').value;
		$('chosenCity').innerHTML = $('address.city').value;
		$('chosenCountry').innerHTML = $('address.country').value;
		$('confirmation_data_container').appear({ duration: 0.2 });
		return false;
	}
	
	function hideConfirmationDiv() {
		$('confirmation_data_container').fade({ duration: 0.2 });
		return false;
	}
</script>

<script type="text/javascript"> 
    Calendar.setup({
        inputField     :    "dob",      // id of the input field
        ifFormat       :    "%d/%m/%Y",       // format of the input field
        showsTime      :    false,            // will display a time selector
        button         :    "dobButton",   // trigger for the calendar (button ID)
        singleClick    :    true,           // single-click mode
        step           :    1                // show all years in drop-down boxes (instead of every other year as default)
    });
</script>
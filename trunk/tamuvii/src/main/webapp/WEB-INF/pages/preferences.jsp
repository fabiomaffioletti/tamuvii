<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="Modifica il profilo"/></title>
    <script type="text/javascript" src="${ctx}/scripts/calendar/calendar.js"></script>
	<script type="text/javascript" src="${ctx}/scripts/calendar/lang/calendar-it.js"></script>
  	<script type="text/javascript" src="${ctx}/scripts/calendar/calendar-setup.js"></script>
</head>

<div id="sidebar">
	<div id="registration_menu">
		<ul>
			<li>
				<b>Dati del profilo</b>
			</li>
			<li>
				<a href="/image.html">Immagine personale</a>
			</li>
			<li>
				<a href="/password.html">Modifica la tua password</a>
			</li>
		</ul>
	</div>
</div>

<div id="main">
	<form:form commandName="appUser" name="appUser" id="appUser" method="post" action="/preferences.html">
		<form:hidden path="id"/>
		<form:hidden path="username"/>
		<div id="registration_form_container">
			<b>Ciao ${appUser.username}!</b>
			<br/>
			<span class="light_text_italic">Da questa pagina puoi modificare i dati del tuo profilo. Ricorda che i campi contrassegnati con <span class="mandatory">* </span>sono obbligatori.</span>
			<br/><br/>
			
			<spring:bind path="appUser.*">
			    <c:if test="${not empty status.errorMessages}">
			    <div id="validation0" style="border: 1px dashed #ccc; padding: 10px;">
		            <img src="/images/error.png" style="vertical-align: bottom; margin-right: 5px;" />
		            Attenzione, devi selezionare il paese in cui vivi.
			    </div>
			    </c:if>
			</spring:bind>
			
			<c:if test="${not empty tamuviiSuccessMessages}">
			    <div id="tamuviiSuccessMessage" class="tamuviiSuccessMessage">
			        <c:forEach var="msg" items="${tamuviiSuccessMessages}">
			            <c:out value="${msg}"/><br />
			        </c:forEach>
			    </div>
			    <c:remove var="tamuviiSuccessMessages" scope="session"/>
			</c:if>
			
			<ul>
				<li>
					<div class="td_sx">Nome: </div>
					<div class="td_dx"><form:input path="firstname" /></div>
				</li>
				<li>
					<div class="td_sx">Cognome: </div>
					<div class="td_dx"><form:input path="lastname" /></div>
				</li>
				<li>
					<div class="td_sx">Sesso: </div>
					<div class="td_dx">
						<form:select path="sex">
							<form:option value="M">M</form:option>
							<form:option value="F">F</form:option>
						</form:select>
					</div>
				</li>
				<li>
					<div class="td_sx">Data di nascita: </div>
					<div class="td_dx"><form:input path="dob" readonly="true" cssStyle="width: 210px;" /><img src="${ctx}/images/iconCalendar.gif" id="dobButton" style="vertical-align: middle; cursor: pointer; margin-left:10px;" title="Calendario" /></div>
				</li>
				<li>
					<div class="td_sx">Citt&agrave;: </div>
					<div class="td_dx"><form:input path="city" /></div>
				</li>
				<li>
					<div class="td_sx"><span class="mandatory">* </span>Paese: </div>
					<div class="td_dx"><appfuse:country name="country" prompt="" default="${appUser.country}"/></div>
				</li>
				<li>
					<div class="td_sx">Sito web: </div>
					<div class="td_dx"><form:input path="website" /></div>
				</li>
				<li>
					<div class="td_sx">Titolo del sito web: </div>
					<div class="td_dx"><form:input path="websitetitle" /></div>
				</li>
				<li>
					<div class="td_sx">Citazione preferita: </div>
					<div class="td_dx"><form:textarea path="quotation" cssStyle="width: 238px; border:1px dashed #ccc;"/></div>
				</li>
				<li>
					<a href="#" style="float:right;" onclick="showConfirmationDiv(); return false;">Avanti</a>
				</li>
			</ul>
		</div>
		<div id="confirmation_data_container" style="display:none;">
			Vuoi confermare i dati che hai inserito?
			<ul>
				<li>
					<div style="float:left; margin-right: 20px;"><b>Nome: </b></div><div id="chosenFirstName" style="float:left"></div>
				</li>
				<li>
					<div style="float:left; margin-right: 20px;"><b>Cognome: </b></div><div id="chosenLastName" style="float:left"></div>
				</li>
				<li>
					<div style="float:left; margin-right: 20px;"><b>Sesso: </b></div><div id="chosenSex" style="float:left"></div>
				</li>
				<li>
					<div style="float:left; margin-right: 20px;"><b>Data di nascita: </b></div><div id="chosenDob" style="float:left"></div>
				</li>
				<li>
					<div style="float:left; margin-right: 20px;"><b>Citt&agrave;: </b></div><div id="chosenCity" style="float:left"></div>
				</li>
				<li>
					<div style="float:left; margin-right: 20px;"><b>Paese: </b></div><div id="chosenCountry" style="float:left"></div>
				</li>
				<li>
					<div style="float:left; margin-right: 20px;"><b>URL del tuo sito web: </b></div><div id="chosenWebsiteURL" style="float:left"></div>
				</li>
				<li>
					<div style="float:left; margin-right: 20px;"><b>Titolo del tuo sito web: </b></div><div id="chosenWebsiteTitle" style="float:left"></div>
				</li>
				<li>
					<div style="float:left; margin-right: 20px;"><b>Citazione preferita: </b></div><div id="chosenQuotation" style="float:left"></div>
				</li>
				<li>
					<a style="float:left;" href="#" onclick="hideConfirmationDiv(); return false;">No, voglio modificarli</a>
					<input type="submit" style="float:right;" value="S&igrave;, confermo!" />
				</li>
			</ul>
		</div>
	</form:form>
</div>



<script>
	Event.observe(window, 'load', function(event) {
		if ($('tamuviiSuccessMessage')) {
	        new Effect.Highlight('tamuviiSuccessMessage', {startcolor: '#4F8CC9',	restorecolor: true});
	    }
	});
</script>

<script>
	function showConfirmationDiv() {
		$('chosenFirstName').innerHTML = $('firstname').value;
		$('chosenLastName').innerHTML = $('lastname').value;
		$('chosenSex').innerHTML = $('sex').value;
		$('chosenDob').innerHTML = $('dob').value;
		$('chosenCity').innerHTML = $('city').value;
		$('chosenCountry').innerHTML = $('country').value;
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
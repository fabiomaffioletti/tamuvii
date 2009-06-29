<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="register.title"/></title>
</head>

<div id="main">
	<form:form name="user" id="user" commandName="user" method="post" action="/register.html">
		<input type="hidden" name="_page0" value="true" />
		<input type="hidden" name="_target1" value="true" />
		
		<div id="registration_form_container">
			<b>Benvenuto su taMuvii!</b>
			<br/>
			<span class="light_text_italic">Per cominciare inserisci i dati di registrazione, quelli contrassegnati con <span class="mandatory">* </span> sono obbligatori.</span>
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
					<div class="td_sx"><span class="mandatory">* </span>Scegli il tuo username: </div>
					<div class="td_dx"><form:input path="username" cssErrorClass="fieldError" /></div>
				</li>
				<li>
					<div class="td_sx"><span class="mandatory">* </span>Inserisci l'indirizzo email: </div>
					<div class="td_dx"><form:input path="email" cssErrorClass="fieldError" /></div>
				</li>
				<li>
					<div class="td_sx"><span class="mandatory">* </span>Inserisci la password: </div>
					<div class="td_dx"><form:input path="password" cssErrorClass="fieldError" /></div>
				</li>
				<li>
					<div class="td_sx"><span class="mandatory">* </span>Riscrivi la password: </div>
					<div class="td_dx"><form:input path="confirmPassword" cssErrorClass="fieldError" /></div>
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
					<div style="float:left; margin-right: 20px;"><b>Username: </b></div><div id="chosenUsername" style="float:left"></div>
				</li>
				<li>
					<div style="float:left; margin-right: 20px;"><b>Indirizzo email: </b></div><div id="chosenEmail" style="float:left"></div>
				</li>
				<li>
					<div style="float:left; margin-right: 20px;"><b>Password: </b></div><div id="chosenPassword" style="float:left"></div>
				</li>
				<li>
					<a style="float:left;" href="#" onclick="hideConfirmationDiv(); return false;">No, voglio modificarli</a>
					<input type="submit" style="float:right;" value="S&igrave;, vai al secondo step" />
				</li>
			</ul>
		</div>
	</form:form>
</div>



<div id="sidebar">
	<div id="registration_menu">
		<ul>
			<li>
				<b>Dati di registrazione</b>
			</li>
			<li>
				Un po' di te
			</li>
			<li>
				Altre informazioni
			</li>
			<li>
				Finito!
			</li>
		</ul>
	</div>
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
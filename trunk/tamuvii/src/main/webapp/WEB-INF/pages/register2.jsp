<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="register.title"/></title>
</head>



<div id="main">
	<form:form name="user" id="user" commandName="user" method="post" action="/register.html">
		<input type="hidden" name="_page2" value="true" />
		<input type="hidden" name="_finish" value="true" />
		
		<div id="registration_form_container">
			<b>Ancora un ultimo sforzo!</b>
			<br/>
			<span class="light_text_italic">Vuoi arricchire la tua pagina con altre informazioni per renderla unica? Anche questi dati non sono obbligatori, e potrai modificarli anche in seguito. Ricorda che se hai dubbi sui dati inseriti puoi sempre <a href="/register.html">iniziare da capo.</a></span>
			<br/><br/>
			
			<ul>
				<li>
					<div class="td_sx">URL del tuo sito web: </div>
					<div class="td_dx"><form:input path="website" /></div>
				</li>
				<li>
					<div class="td_sx">Titolo del tuo sito web: </div>
					<div class="td_dx"><form:input path="websitetitle" /></div>
				</li>
				<li>
					<div class="td_sx">Citazione preferita: </div>
					<div class="td_dx"><form:input path="quotation" /></div>
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
					<input type="submit" style="float:right;" value="S&igrave;, registrami!" />
				</li>
			</ul>
		</div>
	</form:form>
</div>



<div id="sidebar">
	<div id="registration_menu">
		<ul>
			<li>
				Dati di registrazione
			</li>
			<li>
				Un po' di te
			</li>
			<li>
				<b>Altre informazioni</b>
			</li>
			<li>
				Finito!
			</li>
		</ul>
	</div>
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
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="register.title"/></title>
</head>

<div id="main">
	<form:form name="user" id="user" commandName="user" method="post" action="/register.html">
		<input type="hidden" name="_page1" value="true" />
		<input type="hidden" name="_target2" value="true" />
		
		<div id="registration_form_container">
			<b>Perfetto!</b>
			<br/>
			<span class="light_text_italic">Ora puoi inserire alcuni dati per personalizzare il tuo profilo. Questi non sono obbligatori, e potrai modificarli anche in seguito. Se non sei convinto dei dati inseriti al punto precedente puoi <a href="/register.html">iniziare da capo.</a></span>
			<br/><br/>
			
			<ul>
				<li>
					<div class="td_sx">Nome: </div>
					<div class="td_dx"><form:input path="firstName" /></div>
				</li>
				<li>
					<div class="td_sx">Citt&agrave;: </div>
					<div class="td_dx"><form:input path="address.city" /></div>
				</li>
				<li>
					<div class="td_sx">Paese: </div>
					<div class="td_dx"><appfuse:country name="address.country" prompt="" default="${user.address.country}"/></div>
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
					<div style="float:left; margin-right: 20px;"><b>Citt&agrave;: </b></div><div id="chosenCity" style="float:left"></div>
				</li>
				<li>
					<div style="float:left; margin-right: 20px;"><b>Paese: </b></div><div id="chosenCountry" style="float:left"></div>
				</li>
				<li>
					<a style="float:left;" href="#" onclick="hideConfirmationDiv(); return false;">No, voglio modificarli</a>
					<input type="submit" style="float:right;" value="S&igrave;, vai al terzo step" />
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
				<b>Un po' di te</b>
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
		$('chosenFirstName').innerHTML = $('firstName').value;
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
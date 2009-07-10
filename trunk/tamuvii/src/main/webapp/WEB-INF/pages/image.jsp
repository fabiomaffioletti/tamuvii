<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="Modifica il profilo"/></title>
    
    <style type="text/css">
    	#uploadImageForm ul {
    		list-style: none;
    		padding: 0;
    		margin: 0;
    	}
    	#uploadImageForm li {
    		margin: 0;
    		padding: 0;
    		width: 100%;
    	}
    </style>
</head>

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


<div id="main">

	<div id="registration_form_container">
		<b>${user.username}, da qui puoi modificare la tua immagine personale</b>
		<br/>
		<span class="light_text_italic">Puoi caricarne una dal tuo pc oppure, se hai un account su flickr, usare la buddy icon del tuo profilo. Ricorda che, nel caso caricassi l'immagine da tuo pc, questa deve avere dimensioni 48x48 pixel, altrimenti verr&agrave; ridimensionata automaticamente. Un'ultima cosa: la dimensione dell'immagine non pu&ograve; essere maggiore di 2 Mb.</span>
		<br/><br/>
		
		<spring:bind path="userImage.*">
		    <c:if test="${not empty status.errorMessages}">
			    <div id="validation0" style="border: 1px dashed #ccc; padding: 10px;">
					<img src="/images/error.png" style="vertical-align: bottom; margin-right: 5px;" />
					Si &egrave; verificato un errore, controlla i dati inseriti e riprova.
			    </div><br/>
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

		Puoi vedere l'immagine attuale qui sotto:
		<br/><br/>
		<div id="user_image_div" style="margin-left: 40px; background-image: url(${user.imageLink});" ></div>
		<div id="uploadImageForm" style="clear: both; padding-top: 30px;">
			<form:form commandName="userImage" method="post" action="/image.html" enctype="multipart/form-data" id="userImage">
				<ul>
				    <li>
				        Immagine da caricare: 
				        <input type="file" name="file" id="file" style="width: 200px;"/>
				        <input type="submit" name="upload" value="Carica" style="width: 120px; height: 23px;" />
				    </li>
				</ul>
			</form:form>
		</div>
	</div>

</div>



<script>
	Event.observe(window, 'load', function(event) {
		if ($('tamuviiSuccessMessage')) {
	        new Effect.Highlight('tamuviiSuccessMessage', {startcolor: '#4F8CC9',	restorecolor: true});
	    }
	});
</script>
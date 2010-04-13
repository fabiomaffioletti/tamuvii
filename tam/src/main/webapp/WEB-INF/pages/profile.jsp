<%@ include file="/common/taglibs.jsp"%>

<head>
	<title><fmt:message key="profile.title" /></title>
	
	<script type="text/javascript">
	$(document).ready(function(){
		var button = $('#upload_button'), interval;
		
		new AjaxUpload(button, {
			action: '../profileImage.html', 
			name: 'myfile',
			data: {
				user_id : '${profile.id}'
			},
			responseType: "json",
			onSubmit : function(file, ext){
				button.text('Sto caricando');
								
				this.disable();
				
				interval = window.setInterval(function(){
					var text = button.text();
					if (text.length < 13){
						button.text(text + '.');					
					} else {
						button.text('Uploading');				
					}
				}, 200);
				
			},
			onComplete: function(file, response) {
				if(response.result != 'ko') {
					$('#user_avatar').attr({src: '/user_images/'+response.result});
					button.text('Immagine caricata. Cambia di nuovo');
				} else {
					alert('errore nel caricamento della immagine personale');
					button.text('Cambia immagine');
				}

				window.clearInterval(interval);
				this.enable();			
			}
		});
	});
	
	</script>
</head>

<h2>Profilo</h2>

<%@ include file="/common/messages.jsp"%>

<spring:bind path="profile.*">
    <c:if test="${not empty status.errorMessages}">
    	<ul id="user_form_errors">
	    	<c:forEach var="e" items="${status.errorMessages}">
	    		<li><img src="../images/alert.png" style="margin-right:5px; vertical-align: bottom;" />${e}</li>
	    	</c:forEach>
    	</ul>
    </c:if>
</spring:bind>

<form:form commandName="profile" method="post" action="/profile.html" id="userForm" name="userForm">
	<form:hidden path="id"/>
	<form:hidden path="username"/>
	<input type="password" style="display:none;" />
	
	<img id="user_avatar" src="/user_images/${profile.avatar}" />
	<br/>
	<div id="upload_button">Cambia immagine</div>
	<br/>
	<br/>
	Nome: <form:input path="firstName" id="firstName" cssErrorClass="validation_error"/>
	<br/>
	Cognome: <form:input path="lastName" id="lastName" cssErrorClass="validation_error"/>
	<br/>
	Email: <form:input path="email" id="email" cssErrorClass="validation_error"/>
	<br/>
	Password: <form:password path="password" id="password" cssErrorClass="validation_error" showPassword="true"/>
	<br/>
	Conferma password: <form:password path="confirmPassword" id="confirmPassword" cssErrorClass="validation_error" showPassword="true"/>
	<br/>
	Website title: <form:input path="websiteTitle" id="websiteTitle" maxlength="35" cssErrorClass="validation_error" />
	<br/>
	Website url: <form:input path="websiteUrl" id="websiteUrl" maxlength="200" cssErrorClass="validation_error" />
	<br/>
	<input type="submit" class="button" name="save" value="Salva" />
	<input type="submit" class="button" name="cancel" value="Annulla" />
</form:form>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="userForm.title"/></title>
   	<style type="text/css">
   		.validation_error {
   			background-color: red;
   		}
   	</style>
   	
   	<script type="text/javascript">
	$(document).ready(function(){
		var button = $('#upload_button'), interval;
		
		new AjaxUpload(button, {
			action: '../movieImage.html', 
			name: 'myfile',
			data: {
				movie_id : '${movie.id}'
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
					$('#movie_image').attr({src: '/movie_images/t/'+response.result});
					button.text('Immagine caricata. Cambia di nuovo');
				} else {
					alert('errore nel caricamento della immagine');
					button.text('Cambia immagine');
				}

				window.clearInterval(interval);
				this.enable();			
			}
		});
	});
	
	</script>
</head>

<h2><fmt:message key="movieForm.title"/></h2>

<spring:bind path="movie.*">
    <c:if test="${not empty status.errorMessages}">
    	<ul id="movie_form_errors">
	    	<c:forEach var="e" items="${status.errorMessages}">
	    		<li><img src="../images/alert.png" style="margin-right:5px; vertical-align: bottom;" />${e}</li>
	    	</c:forEach>
    	</ul>
    </c:if>
</spring:bind>

<%@ include file="/common/messages.jsp"%>

<form:form commandName="movie" method="post" action="movieForm.html" id="movieForm" name="movieForm">
	<form:hidden path="id"/>
	
	<img id="movie_image" src="/movie_images/t/${movie.image}" />
	<br/>
	<div id="upload_button">Cambia immagine</div>

	<ul id="user_form_ul">
		<li>
			<span class="form_label">Titolo</span>
			<span class="form_input"><form:input path="title" id="title" cssErrorClass="validation_error"/></span>
		</li>
		<li>
			<span class="form_label">Trama</span>
			<span class="form_input"><form:textarea path="plot" id="plot" cssErrorClass="validation_error"/></span>
		</li>
		<li>
			<span class="form_label">Anno</span>
			<span class="form_input"><form:input path="year" id="year" cssErrorClass="validation_error"/></span>
		</li>
		<li>
			<span class="form_label">Durata</span>
			<span class="form_input"><form:input path="duration" id="duration" cssErrorClass="validation_error"/></span>
		</li>
		<li>
			<span class="form_label">Regista</span>
			<span class="form_input"><form:select path="director" id="director" itemValue="id" itemLabel="fullName" items="${directors}" cssErrorClass="validation_error"/></span>
		</li>
		<li>
			<span class="form_label">Genere</span>
			<span class="form_input">
			${movie.genres }
				<form:select path="genres" multiple="multiple">
					<form:options items="${allgenres}" itemLabel="name" itemValue="name"/>
				</form:select>
			</span>
		</li>
	</ul>
	
	<ul id="user_form_buttons">
		<li><input type="submit" class="button" name="save" value="Salva" /></li>
		<c:if test="${not empty user.id}">
			<li>
				<input type="submit" class="button" name="delete" onclick="return confirm('<fmt:message key="confirm.user.remove" />')" value="Elimina" />
			</li>
		</c:if>
		<li><input type="submit" class="button" name="cancel" value="Annulla" /></li>
	</ul>
	
</form:form>
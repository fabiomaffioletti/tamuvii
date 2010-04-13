<%@ include file="/common/taglibs.jsp"%>

<head>
	<title><fmt:message key="home.title" /></title>
	<script type="text/javascript" src="/dwr/engine.js"></script>
    <script type="text/javascript" src="/dwr/util.js"></script>
    <script type="text/javascript" src="/dwr/interface/CommunicationManager.js"> </script>
</head>

<h2>Ultimi inseriti</h2>

<%@ include file="/common/messages.jsp"%>

<c:forEach var="li" items="${lastInserted}">
	<a href="/${pageContext.request.remoteUser}/movies/?movie=${li.movie.id}">${li.movie.title}</a><br/>
</c:forEach>

<br/><br/><br/>
<h2>Ultimi iscritti</h2>
<c:forEach var="lr" items="${lastRegistered}">
	<a href="/${lr.username}/movies/">${lr.username}</a><br/>
</c:forEach>

<br/><br/><br/>
<h2>Ultimi film aggiunti</h2>
<c:forEach var="la" items="${lastAdded}">
	<a href="/${la.movie.title}/movies/">${la.movie.title}</a><br/>
</c:forEach>

<c:if test="${userInfo.canInvite == true}">
	<br/><br/><br/>
	Invita per email: <input type="text" name="invited_email" id="invited_email" />
	<br/>
	<input type="button" value="manda invito" onclick="sendInvitation()" />
</c:if>

<script>
	function sendInvitation() {
		var invited_email = $('#invited_email').val();
		
		CommunicationManager.sendInvitation(invited_email, {
			callback: function(str) {
				if(str == 0)
					alert("invitato con successo");
				else if(str == 1)
					alert("errore nell'invito");
				else if(str == 2)
					alert("limite degli inviti raggiunto");
			},
			errorHandler:function(errorString, exception) {
				alert("Errore" + errorString + " " + exception);
			}
		});
	}
</script>
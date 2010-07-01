<%@ include file="/common/taglibs.jsp"%>

<head>
	<title>Invia communicazione</title>
	<script type="text/javascript" src="/dwr/engine.js"></script>
    <script type="text/javascript" src="/dwr/util.js"></script>
    <script type="text/javascript" src="/dwr/interface/CommunicationManager.js"> </script>
</head>

<h2>Invia comunicazione</h2>
<br/>
<%@ include file="/common/messages.jsp"%>


<form name="communicationForm" id="communicationForm" action="/communicationForm.html">
	<select name="tos" id="tos" onchange="toggleUsers()">
		<option value="0">Invia a tutti</option>
		<option value="1">Seleziona utenti</option>
	</select>
	<select name="users" id="users" multiple="multiple" style="display:none;">
		<c:forEach var="u" items="${users}">
			<option value="${u.id}">${u.username} (${u.firstName} ${u.lastName}) </option>
		</c:forEach>
	</select>
	<br/><br/>
	Titolo: <input type="text" name="comTitle" id="comTitle">
	<br/>
	Testo:<textarea name="comText" id="comText"></textarea>
	<br/>
	<input type="button" value="Invia" onclick="setTos()" />
</form>

<ul id="selection">
	
</ul>

Success: <span id="oks"></span>
<br/>
Failure: <span id="kos"></span>

<script>

var userids = new Array();
var t = 0;

function toggleUsers() {
	var selected = $('#tos').val();
	if(selected == 1) {
		$('#users').val(null);
		$('#users').show();
	} else {
		$('#users').hide();
	}
}

function setTos() {
	var selected = $('#tos').val();
	var title = $('#comTitle').val();
	var text = $('#comText').val();

	if(selected == 1) {
		userids = $.makeArray($('#users').val());
	} else  {
		$('#users option').each(function(i) {
			userids[i] = this.value;
		});
	}

	t = 0;
	$('#oks').html("");
	$('#kos').html("");
	sendCommunication(t, title, text);
}

function sendCommunication(num, title, text) {
	var id = userids[num];
	//console.debug("sending email to id: "+id);
	//console.debug("t: "+t);
	//console.debug("length: "+userids.length);
	
	CommunicationManager.sendCommunication(id, title, text, {
		callback: function(str) {
			if(str == 0)
				$('#oks').append(id+",");
			else {
				$('#kos').append(id+",");
			}
		
			t++;
			if(t > userids.length-1) {
				t = 0;
				return;
			}

			sendCommunication(t, title, text);
		},
		errorHandler:function(errorString, exception) {
			alert("Errore" + errorString + " " + exception);
		}
	});
}

</script>
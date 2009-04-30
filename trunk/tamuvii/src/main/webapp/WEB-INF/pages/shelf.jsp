<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="shelf.pagetitle"/></title>
    <meta name="menu" content="AdminMenu"/>
</head>

<script>
	function sendMessage() {
		var receiver = $('receiver').value;
		var messagetext = $('messagetext').value;
		new Ajax.Request('/sendMessage.html?ajax=true&receiver='+receiver+'&messagetext='+messagetext, {
			  method: 'post',
			  onSuccess: function(response) {
			    var notice = $('messagetext');
			    notice.value = response.responseText;
			    setTimeout("endEffect()", 2000);
			}
		});
	}

	function endEffect() {
		$('messagetext').value = "";
		Effect.BlindUp('sendMessage');
	}
</script>

<div id="sx">
<center>
<img style="cursor: pointer; border: 2px solid #ccc;" src="${userPublicInfo.imageLink}" onclick="Effect.toggle('publicInfo', 'slide',{ duration: 0.2 }); return false;" />
<div id="publicInfo" style="width:100%; display:none;">
	<div style="font-size: 20px; margin-top: 5px;">
		${userPublicInfo.username}
	</div>
  <div>
    <table>
		<tr>
			<td>Website</td>
			<td><a href="${userPublicInfo.website}" target="_blank">${userPublicInfo.websiteTitle}</a></td>
		</tr>
	</table>
  </div>
</div>
</center>

<br/>
<br/>
<br/>
<br/>

<c:if test="${not empty username && username != pageContext.request.remoteUser}">

<a href="#" onclick="Effect.toggle('sendMessage', 'slide',{ duration: 0.2 }); return false;">Spedisci Messaggio</a>
	<div id="sendMessage" style="width:100%;display:none;">
			<textarea id="messagetext" name="messagetext" cols="20" rows="5"></textarea>
			<input type="hidden" id="receiver" name="receiver" value="${username}" />
			<input type="button" name="sendMessage" value="Spedisci" onclick="sendMessage()" />
			<a href="#" onclick="Effect.toggle('sendMessage', 'slide',{ duration: 0.2 }); return false;">Annulla</a>
	</div>
<br/>
<br/>
</c:if>

<c:if test="${fn:length(friends) > 0}">
	<a href="#" onclick="Effect.toggle('friends', 'slide',{ duration: 0.2 }); return false;">Friends</a>
	<div id="friends" style="width:200px;">
	  <div>
		<display:table name="friends" cellspacing="0" cellpadding="0" defaultsort="1" requestURI="" id="friend" length="5" class="table" export="false">
			<display:column escapeXml="false" sortable="false" titleKey="immagine">
				<img src="${friend.imageLink}" height="20px" width="20px;"/>
			</display:column>
		    <display:column escapeXml="false" sortable="true" titleKey="username">
		    	<a href="/shelf.html?username=${friend.username}">${friend.username}</a> 
		    </display:column>
	</display:table>  
	  </div>
	</div>
	<br/>
	<br/>
</c:if>

<c:if test="${fn:length(neighborhoods) > 0}">
	<a href="#" onclick="Effect.toggle('neighborhoods', 'slide',{ duration: 0.2 }); return false;">Vicini</a>
	<div id="neighborhoods" style="width:200px;">
	  <div>
		<display:table name="neighborhoods" cellspacing="0" cellpadding="0" defaultsort="1" requestURI="" id="neighborhood" pagesize="1" length="5" class="table" export="false">
			<display:column escapeXml="false" sortable="false" titleKey="immagine">
				<img src="${neighborhood.imageLink}" height="20px" width="20px;"/>
			</display:column>
		    <display:column escapeXml="false" sortable="true" titleKey="username">
		    	<a href="/shelf.html?username=${neighborhood.username}">${neighborhood.username}</a> 
		    </display:column>
	</display:table>  
	  </div>
	</div>
	<br/>
	<br/>
</c:if>

<div id="follow">
	<c:if test="${not empty username && username != pageContext.request.remoteUser}">
		<c:choose>
			<c:when test="${areFriends}">
				<c:set var="type" value="è un tuo amico" />
			</c:when>
			<c:when test="${areNeighborhoods}">
				<c:set var="type" value="è un tuo vicino" />
			</c:when>
			<c:otherwise>
				<c:set var="type" value="follow" />
			</c:otherwise>
		</c:choose>
		<a href="#" id="follow" onclick="Effect.toggle('relationship', 'slide',{ duration: 0.2 }); return false;"><b><c:out value="${type}" /></b></a>
	</c:if>
</div>

<div id="relationship" style="display:none;">
<c:choose>
	<c:when test="${not empty username && username != pageContext.request.remoteUser}">
		<c:choose>
			<c:when test="${areFriends}">
				<a href="/relationshipManagement.html?action=moveToNeighborhoods&username=${username}">Cambia a vicino</a>
				<br/>
				<a href="/relationshipManagement.html?action=deleteFriend&username=${username}">Cancella come amico</a>
				<br/>
				<br/>
			</c:when>
			<c:when test="${areNeighborhoods}">
				<a href="/relationshipManagement.html?action=moveToFriends&username=${username}">Cambia a amico</a> <br/>
				<a href="/relationshipManagement.html?action=deleteNeighborhood&username=${username}">Cancella come vicino</a> <br/>
			</c:when>
			<c:otherwise>
				<a href="/relationshipManagement.html?action=addFriend&username=${username}">Aggiungi come amico</a> <br/>
				<a href="/relationshipManagement.html?action=addNeighborhood&username=${username}">Aggiungi come vicino</a> <br/>
			</c:otherwise>
		</c:choose>
		
		<a href="/relationship.html?mode=friends&username=${username}">Vedi i suoi amici</a>
		<a href="/relationship.html?mode=neighborhoods&username=${username}">Vedi i suoi vicini</a>
	</c:when>
</c:choose>
</div>

</div>

<div id="cont">

<div id="searchBar">
	<form:form name="searchSocialMovieForm" action="/searchSocialMovies.html" method="POST">
		<input type="text" name="filter" />
		<input type="submit" name="doSearch" value="Search" />
	</form:form>
	<br/>
</div>

<display:table name="shelfItems" cellspacing="0" cellpadding="0" requestURI="" defaultsort="1" id="shelfItems" pagesize="16" class="table" export="true">
	<display:column escapeXml="false" sortable="false" style="border: none;">
		<img src="/images/placeholder_movie.jpg" height="70px" style="border:1px solid gray;" />
	</display:column>
    <display:column escapeXml="false" sortable="true" style="border: none;">
    	<a href="/socialMovie.html?movie=${shelfItems.movie}"><b>${shelfItems.originalTitle}</b></a>
    	<br/>
    	<a href="/directorDetail.html?director=${shelfItems.directorId}">${shelfItems.director}</a>
    	<c:if test="${not empty shelfItems.dateViewed}">
    		<br/>
    	 	Visto il: <fmt:formatDate value="${shelfItems.dateViewed}" />  
    	</c:if>
    	<div style="margin-top: 5px;">
	    	<c:if test="${shelfItems.mark > 0}">
		    	<c:forEach begin="1" end="${shelfItems.mark}">
					<img src="/images/sun.png" height="11px" />	    		
		    	</c:forEach>
	    	</c:if>
    	</div>
    </display:column>
    
    <c:choose>
	    <c:when test="${empty username || username == pageContext.request.remoteUser}">
		    <display:column style="border: none;">
		    	<a href="/personalMovie.html?movie=${shelfItems.movie}">modify</a>
		    </display:column>
	    </c:when>
	    <c:when test="${not empty username && username != pageContext.request.remoteUser}">
	    	<display:column style="border: none;">
	    		<c:set var="isInPersonalMovies" value="0" />
	    		<c:set var="isWished" value="0" />
		    	<c:forEach var="personalMovieId" items="${personalMoviesIdsAndWishedFlags}">
		    		<c:if test="${personalMovieId.movie == shelfItems.movie}">
		    			<c:set var="isInPersonalMovies" value="1" />
		    			<c:if test="${personalMovieId.wished == 1}">
		    				<c:set var="isWished" value="1" />
		    			</c:if>
		    		</c:if>
		    	</c:forEach>
		    	
		    	<c:choose>
			    	<c:when test="${isInPersonalMovies == 0}">
			    		<a href="/shelfManagement.html?action=add&movie=${shelfItems.movie}">add</a>
			    		<a href="/wishlistManagement.html?action=wish&movie=${shelfItems.movie}">wish</a>
			    	</c:when>
			    	<c:otherwise>
			    		Film gi&agrave; presente in
			    		<c:if test="${isWished == 0}"> libreria </c:if>
			    		<c:if test="${isWished == 1}"> wishlist </c:if>
			    	</c:otherwise>
		    	</c:choose>
		    	
	    	</display:column>
	    </c:when>
    </c:choose>
    
</display:table>

</div>
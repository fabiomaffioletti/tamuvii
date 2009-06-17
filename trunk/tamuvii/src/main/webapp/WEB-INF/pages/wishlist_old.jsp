<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="wishlist.pagetitle"/></title>
    <meta name="menu" content="AdminMenu"/>
</head>

<div id="sx">
<center>
<img style="cursor: pointer; border: 2px solid #ccc;" src="${userPublicInfo.imageLink}" onclick="Effect.toggle('publicInfo', 'slide',{ duration: 0.2 }); return false;" />
<div id="publicInfo" style="width:150px; display:none;">
  <div>
    <table>
		<tr>
			<td>Username</td>
			<td>${userPublicInfo.username}</td>
		</tr>
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

<c:choose>
	<c:when test="${not empty username && username != pageContext.request.remoteUser}">
		<c:choose>
			<c:when test="${areFriends}">
				è un tuo amico<br/>
				<a href="/relationshipManagement.html?action=moveToNeighborhoods&username=${username}">Cambia a vicino</a>
				<br/>
				<a href="/relationshipManagement.html?action=deleteFriend&username=${username}">Cancella come amico</a>
				<br/>
				<br/>
			</c:when>
			<c:when test="${areNeighborhoods}">
				è un tuo vicino<br/>
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

<div id="cont">

<div id="searchBar">
	<form:form name="searchSocialMovieForm" action="/searchSocialMovies.html" method="POST">
		<input type="text" name="filter" />
		<input type="submit" name="doSearch" value="Search" />
	</form:form>
	<br/>
</div>

<display:table name="wishedItems" cellspacing="0" cellpadding="0" requestURI="" defaultsort="1" id="wishedItem" pagesize="25" class="table" export="true">
    <display:column escapeXml="false" sortable="false" titleKey="movie.image">
		<img src="/images/placeholder_movie.jpg" height="100px" style="border:1px solid gray;" />
	</display:column>
    <display:column escapeXml="false" sortable="true" titleKey="movie.originaltitle">
    	<a href="/socialMovie.html?movie=${wishedItem.movie}"><b>${wishedItem.originalTitle}</b></a>
    	<br/>
    	<a href="/directorDetail.html?director=${wishedItem.directorId}">${wishedItem.director}</a>
    </display:column>
    <display:column titleKey="actions">
    	<a href="/wishlistManagement.html?action=move&movie=${wishedItem.movie}">Move to shelf</a>
    	<a href="/wishlistManagement.html?action=delete&movie=${wishedItem.movie}">Delete from wishlist</a>
    </display:column>
</display:table>

</div>
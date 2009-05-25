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

	function jsonShelfDirectorReport(p) {
		var u = "${userPublicInfo.username}";
		new Ajax.Request('/jsonShelfDirectorReport.html?ajax=true', {
			  method: 'post',
			  parameters: {page: p, username: u },
			  onSuccess: function(response) {
				var JSONobj = response.responseText.evalJSON();
				buildShelfDirectorReportTable(JSONobj);
				
				if(!JSONobj.last) {
					var next = new Element('a', {href: '#', onclick: 'jsonShelfDirectorReport('+(p+1)+')' }).update("Next");
					$('directorReportTable').insert(next);
				}
				if(p > 0) {
					var prev = new Element('a', {href: '#', onclick: 'jsonShelfDirectorReport('+(p-1)+')' }).update("Prev");
					$('directorReportTable').insert(prev);
				}
			}
		});
	}

	function buildShelfDirectorReportTable(JSONobj) {
		var ex = $('directorReportTable');
		if(ex != null) {
			ex.remove();
		}

		var table = Builder.node('table', {
			  width: '100%',
			  cellpadding: '0',
			  cellspacing: '0',
			  border: '0',
			  id: 'directorReportTable'
			});
		
		var tbody = Builder.node('tbody');
		tr = Builder.node('tr');
		td = Builder.node('td', 'Regista');
		tr.appendChild(td);
		td = Builder.node('td', '');
		tr.appendChild(td);
		tbody.appendChild(tr);

		for (var i = 0; i < JSONobj.itemList.length; i++)
		{
			var item = JSONobj.itemList[i];
			tr = Builder.node('tr');
			td = Builder.node('td', item.name + ' ' + item.surname);
			tr.appendChild(td);
			td = Builder.node('td', item.numMovies);
			tr.appendChild(td);
			tbody.appendChild(tr);
		}
				
		table.appendChild(tbody);
		//$('jsonShelfDirectorReport').insert(table);
		$('jsr').insert(table);
	}

	jsonShelfDirectorReport(0);

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


<br/><br/><br/>

<div id="jsonShelfDirectorReport" style="height: 100px; border: 1px solid #ccc;">
	<div id="jsr">
	</div>
</div>

<br/><br/><br/>

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
	<a href="#" onclick="">Vicini</a>
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

<display:table name="shelfItems" cellspacing="0" cellpadding="0" requestURI="" defaultsort="1" id="shelfItems" pagesize="10" class="table" export="true">
	<!-- Image -->
	<display:column escapeXml="false" sortable="false" style="padding-right:20px; width: 10%; vertical-align: top;">
		<c:choose>
			<c:when test="${not empty shelfItems.localizedImage}">
				<img src="${shelfItems.localizedImage}" height="110px" style="border:1px solid gray; vertical-align: top;" />
			</c:when>
			<c:otherwise>
				<img src="${shelfItems.originalImage}" height="110px" style="border:1px solid gray; vertical-align: top;" />
			</c:otherwise>
		</c:choose>
		
	</display:column>
	
    <display:column escapeXml="false" sortable="true" style="padding-left: 20px; padding-right: 20px; border: none; width: 65%;" >
		<!-- Title -->
    	<div style="margin-bottom: 5px;">
	    	<c:choose>
	    		<c:when test="${empty shelfItems.localizedTitle}">
		    		<a href="/socialMovie.html?movie=${shelfItems.movie}"><b>${shelfItems.originalTitle}</b></a> (${shelfItems.numUsers}) 
		    		<c:if test="${not empty shelfItems.originalPlot || not empty shelfItems.localizedPlot}">
		    			<a href="#" onclick="Effect.toggle('plot_${shelfItems.movie}', 'slide',{ duration: 0.2 }); return false;" style="vertical-align: middle;"><img src="/images/plot.png" height="11px" /></a>
		    		</c:if>
		    		<c:if test="${not empty shelfItems.review}">
		    			<a href="#" onclick="Effect.toggle('review_${shelfItems.review}', 'slide',{ duration: 0.2 }); return false;" style="vertical-align: middle;"><img src="/images/view_review.png" height="11px" /></a>
		    		</c:if>
		    	</c:when>
		    	<c:otherwise>
		    		<a href="/socialMovie.html?movie=${shelfItems.movie}"><b>${shelfItems.localizedTitle}</b></a> (${shelfItems.numUsers})
		    		<c:if test="${not empty shelfItems.originalPlot || not empty shelfItems.localizedPlot}">
		    			<a href="#" onclick="Effect.toggle('plot_${shelfItems.movie}', 'slide',{ duration: 0.2 }); return false;" style="vertical-align: middle;" ><img src="/images/plot.png" height="11px" /></a>
		    		</c:if>
		    		<c:if test="${not empty shelfItems.review}">
		    			<a href="#" onclick="Effect.toggle('review_${shelfItems.review}', 'slide',{ duration: 0.2 }); return false;" style="vertical-align: middle;"><img src="/images/view_review.png" height="11px" /></a>
		    		</c:if>
		    		<br/>
		    		<c:if test="${shelfItems.originalTitle != shelfItems.localizedTitle}">
			    		<i>Titolo originale: ${shelfItems.originalTitle}</i>
			    	</c:if>
		    	</c:otherwise>
	    	</c:choose>
	    </div>
    	
    	<!-- Director -->
    	<div style="margin-bottom: 3px;">
    		di <a href="/directorDetail.html?director=${shelfItems.directorId}">${shelfItems.director}</a>
    	</div>
    	
		<!-- Date viewed -->
    	<div style="margin-bottom: 3px;">
	    	<c:if test="${not empty shelfItems.dateViewed}">
	    	 	Visto il: <fmt:formatDate value="${shelfItems.dateViewed}" />  
	    	</c:if>
	   	</div>
	
    	<!-- Mark -->
    	<div style="margin-bottom:3px;">
	    	<c:if test="${shelfItems.mark > 0}">
		    	<c:forEach begin="1" end="${shelfItems.mark}">
					<img src="/images/sun.png" height="11px" />	    		
		    	</c:forEach>
	    	</c:if>
	    </div>
    	
    	
    	<!-- Plot -->
    	<div id="plot_${shelfItems.movie}" style="display:none; border:1px dotted #ccc; text-align: justify; padding: 3px; margin-top: 10px;">
    		<div style="float:left; margin-bottom: 2px;">
    			<b>Trama:</b>
    		</div>
    		<div style="float:right; margin-bottom: 2px;">
    			<span style="text-align: right;"><img src="/images/close.png" onclick="Effect.toggle('plot_${shelfItems.movie}', 'slide',{ duration: 0.2 }); return false;" style="cursor: pointer; border: none;" height="11px" /></span>
    		</div>
    		
    		<div style="clear: both;">
		    	<c:choose>
		    		<c:when test="${empty shelfItems.localizedPlot}">
			    		${shelfItems.originalPlot}
			    	</c:when>
			    	<c:otherwise>
			    		${shelfItems.localizedPlot}
			    	</c:otherwise>
		    	</c:choose>
		    </div>
    	</div>
    	
    	<div id="review_${shelfItems.review}" style="display:none; border:1px dotted #ccc; text-align: justify; padding: 3px; margin-top: 10px;">
    		<div style="float:left; margin-bottom: 2px;">
    			<b>${shelfItems.reviewTitle}:</b>
    		</div>
    		<div style="float:right; margin-bottom: 2px;">
    			<span style="text-align: right;">
    				<a href="/reviewDiscussion.html?review=${shelfItems.review}"><img src="/images/discuss.png" style="cursor: pointer; border: none;" height="11px" /></a>
    				<img src="/images/close.png" onclick="Effect.toggle('review_${shelfItems.review}', 'slide',{ duration: 0.2 }); return false;" style="cursor: pointer; border: none;" height="11px" />
    			</span>
    		</div>
    		
    		<div style="clear: both;">
	    		${shelfItems.reviewText}
		    </div>
    	</div>
    	
    </display:column>
    
    <!-- Actions -->
    <c:choose>
	    <c:when test="${empty username || username == pageContext.request.remoteUser}">
		    <display:column style="border: none; width: 25%; vertical-align: top;">
		    	<a href="/personalMovie.html?movie=${shelfItems.movie}">modify</a>
		    </display:column>
	    </c:when>
	    <c:when test="${not empty username && username != pageContext.request.remoteUser}">
	    	<display:column style="border: none; width: 25%; vertical-align: top;">
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
				    		<div id="options">
				    			<span style="float: left;">
				    				<img src="/images/ciack.png" style="margin-bottom: 10px;" />
				    			</span>
				    			<span style="float:left;">
				    				Opzioni
				    			</span>
				    		</div>
				    		<div id="actions_${shelfItems.movie}" style="clear: both;">
					    		<img src="/images/record.png" style="cursor: pointer; vertical-align: middle;" height="11px" /> <a href="/shelfManagement.html?action=add&movie=${shelfItems.movie}">Aggiungi alla videoteca</a>
					    		<br/>
					    		<img src="/images/play.png" style="cursor: pointer; vertical-align: middle;" height="11px" /> <a href="/wishlistManagement.html?action=wish&movie=${shelfItems.movie}">Aggiungi alla wishlist</a>
				    		</div>
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
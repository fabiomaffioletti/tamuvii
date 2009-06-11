<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="shelf.pagetitle"/></title>
    <script type="text/javascript" src="/dwr/engine.js"></script>
    <script type="text/javascript" src="/dwr/util.js"></script>
    <script type="text/javascript" src="/dwr/interface/ShelfManager.js"> </script>
    
    
    <style>
    	.sdrli:hover {
    		background-color: yellow;
    		cursor: pointer;
    	}
    	
    	.sdrli {
    		height:20px;
    		width:100%; 
    		border-bottom:1px dotted #ccc;
   		}
   		
   		.fli:hover {
    		background-color: yellow;
    		cursor: pointer;
    	}
    	
    	.fli {
    		height:20px;
    		width:100%; 
    		border-bottom:1px dotted #ccc;
   		}
   		
   		.nli:hover {
    		background-color: yellow;
    		cursor: pointer;
    	}
    	
    	.nli {
    		height:20px;
    		width:100%; 
    		border-bottom:1px dotted #ccc;
   		}
    </style>
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


	//////// FUNZIONI DI AGGIORNAMENTO PER IL REPORT DEI REGISTI ////////
	// Ordina per cognome
	function orderShelfDirectorReportBySurname(username) {
		new Effect.Opacity('shelfDirectorReport', { from: 1, to: 0.5 });
		
		ShelfManager.getShelfDirectorReport(username, null, null, "surname", function(str) {
			refreshShelfDirectorReportList(str);
		});

		new Effect.Opacity('shelfDirectorReport', { from: 0.5, to: 1 });
	}
	// Ordina per numero di film
	function orderShelfDirectorReportByNumMovies(username) {
		ShelfManager.getShelfDirectorReport(username, null, null, null, function(str) {
			refreshShelfDirectorReportList(str);
		});
	}
	// Aggiorna la ul
	function refreshShelfDirectorReportList(str) {
		dwr.util.removeAllOptions('sdrul');
		for(var x=0; x<str.length; x++) {
			var li = Builder.node('li', {
											className: "sdrli",
											onclick: "document.location.href='/directorDetail.html?director="+str[x].director+"'"
										}, 
					         str[x].name + ' ' + str[x].surname + ' (' + str[x].numMovies + ')')
			$('sdrul').insert(li);
		}
	}
	//////// FINE FUNZIONI DI AGGIORNAMENTO PER IL REPORT DEI REGISTI ////////

	
	// Variabili globali per ShelfDirectorReport
	var indexSDR;
	var totSDR;
	var recordsPerRowSDR; 
	var pagesSDR;
	var heightSDR;

	// Variabili globali per Friends
	var indexF;
	var totF;
	var recordsPerRowF; 
	var pagesF;
	var heightF;

	// Variabili globali per Neighborhoods
	var indexN;
	var totN;
	var recordsPerRowN; 
	var pagesN;
	var heightN;
	
	Event.observe(window, 'load', function(event) {
		// Inizializzo la parte relativa allo ShelfDirectorReport
		indexSDR = 0;
		totSDR = ${fn:length(shelfDirectorReportList)};
		recordsPerPageSDR = 4;
		pagesSDR = Math.ceil(totSDR/recordsPerPageSDR);

		// Inizializzo la parte relativa a Friends
		indexF = 0;
		totF = ${fn:length(friends)};
		recordsPerPageF = 1;
		pagesF = Math.ceil(totF/recordsPerPageF);

		// Inizializzo la parte relativa a Neighborhoods
		indexN = 0;
		totN = ${fn:length(neighborhoods)};
		recordsPerPageN = 1;
		pagesN = Math.ceil(totN/recordsPerPageN);
		
		// Controllo il numero di pagine per lo ShelfDirectorReport		
	    if(pagesSDR > 1) {
    		$('downSDR').setStyle({ display: 'block' });
	    }
	 	// Controllo il numero di pagine per friends
	    if(pagesF > 1) {
    		$('downF').setStyle({ display: 'block' });
	    }
	 	// Controllo il numero di pagine per neighborhoods		
	    if(pagesN > 1) {
    		$('downN').setStyle({ display: 'block' });
	    }
	});

	//////// FUNZIONI GENERICHE PER LO SCROLLING //////// 
	function doup(index, step, container, h, down, up) {
		index = index-step;
		if(!$(down).visible()) {
			$(down).setStyle({ display: 'block' });
		}
		if(index == 0) {
			$(up).setStyle({ display: 'none' });
		}
		new Effect.Move($(container),{x: 0, y: step*h, duration: 0.3}); return index;
	}

	function dodown(index, pages, step, container, h, down, up) {
		index = index+step;
		if(!$(up).visible()) {
			$(up).setStyle({ display: 'block' });
		}
		if(index == (pages-1)) {
			$(down).setStyle({ display: 'none' });
		} else {
			$(down).setStyle({ display: 'block' });
		}
		new Effect.Move($(container),{x: 0, y: step*-h, duration: 0.3}); return index;
	}
	//////// FINE FUNZIONI GENERICHE PER LO SCROLLING ////////
	
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

Report registi
<br/>
<a href="#" onclick="orderShelfDirectorReportBySurname('${userPublicInfo.username}');">surname order</a>
<br/>
<a href="#" onclick="orderShelfDirectorReportByNumMovies('${userPublicInfo.username}');">numMovies order</a>
<br/>
<div id="shelfDirectorReport" style="height: 84px; width:100%; overflow:hidden; position: relative;">
	<div id="shelfDirectorReportContent">
		<ul id="sdrul" style="margin:0px;list-style:none;padding:0;line-height: 20px;">
			<c:forEach var="shelfDirectorReportItem" items="${shelfDirectorReportList}">
				<li class="sdrli" onclick="document.location.href='/directorDetail.html?director=${shelfDirectorReportItem.director}'">${shelfDirectorReportItem.name} ${shelfDirectorReportItem.surname} (${shelfDirectorReportItem.numMovies})</li>
			</c:forEach>
		</ul>
	</div>
</div>
<div style="width:100%;">
	<a href="#" id="upSDR" style="display:none;float:left;" onclick="indexSDR = doup(indexSDR, 1, 'shelfDirectorReportContent', $('shelfDirectorReport').getHeight(), 'downSDR', 'upSDR')">prev</a>
	<a href="#" id="downSDR" style="float:right;" onclick="indexSDR = dodown(indexSDR, pagesSDR, 1, 'shelfDirectorReportContent', $('shelfDirectorReport').getHeight(), 'downSDR', 'upSDR')">next</a>
</div>

<br/><br/><br/>

	<c:if test="${fn:length(friends) > 0}">
		<a href="#" onclick="Effect.toggle('friends', 'slide',{ duration: 0.2 }); return false;">Friends</a>
		<div id="friends" style="height: 21px; width:100%; overflow:hidden; position: relative;">
			<div id="friendsContent">
				<ul id="ful" style="margin:0px;list-style:none;padding:0;line-height: 20px;">
					<c:forEach var="friend" items="${friends}">
						<li class="fli" onclick="document.location.href='/shelf.html?username=${friend.username}'"><img src="${friend.imageLink}" height="20px" width="20px;"/> ${friend.username}</li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div style="width:100%;">
			<a href="#" id="upF" style="display:none;float:left;" onclick="indexF = doup(indexF, 1, 'friendsContent', $('friends').getHeight(), 'downF', 'upF')">prev</a>
			<a href="#" id="downF" style="float:right;" onclick="indexF = dodown(indexF, pagesF, 1, 'friendsContent', $('friends').getHeight(), 'downF', 'upF')">next</a>
		</div>
	</c:if>

<br/><br/><br/>

<c:choose>
	<c:when test="${fn:length(neighborhoods) > 0}">
		<a href="#">Vicini</a>
		<div id="neighborhoods" style="height: 21px; width:100%; overflow:hidden; position: relative;">
			<div id="neighborhoodsContent">
				<ul id="nul" style="margin:0px;list-style:none;padding:0;line-height: 20px;">
					<c:forEach var="neighborhood" items="${neighborhoods}">
						<li class="nli" onclick="document.location.href='/shelf.html?username=${neighborhood.username}'"><img src="${neighborhood.imageLink}" height="20px" width="20px;"/> ${neighborhood.username}</li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div style="width:100%;">
			<a href="#" id="upN" style="display:none;float:left;" onclick="indexN = doup(indexN, 1, 'neighborhoodsContent', $('neighborhoods').getHeight(), 'downN', 'upN')">prev</a>
			<a href="#" id="downN" style="float:right;" onclick="indexN = dodown(indexN, pagesN, 1, 'neighborhoodsContent', $('neighborhoods').getHeight(), 'downN', 'upN')">next</a>
		</div>
	</c:when>
	<c:otherwise>
		<div id="neighborhoods" style="display:none;">
		</div>
	</c:otherwise>
</c:choose>

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

<script>
	
</script>
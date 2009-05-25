<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="socialMovie.title"/></title>
    <meta name="menu" content="AdminMenu"/>
</head>

<div id="sx">

<c:choose>
	<c:when test="${!presentInShelf && !presentInWishlist}">
		<a href="/shelfManagement.html?action=add&movie=${socialMovie.movie}">Add to shelf</a>
		<a href="/wishlistManagement.html?action=wish&movie=${socialMovie.movie}">Add to wishlist</a>
	</c:when>
	<c:when test="${!presentInShelf && presentInWishlist}">
		Questo libro è presente nella tua wishlist:
		<a href="/shelfManagement.html?action=move&movie=${socialMovie.movie}">Move to shelf</a>
	</c:when>
	<c:otherwise>
		Questo libro è presente nella tua shelf!
		<a href="/shelfManagement.html?action=delete&movie=${socialMovie.movie}">Delete from shelf</a>
	</c:otherwise>
</c:choose>

<br/>
<br/>
<center>
	<c:choose>
		<c:when test="${not empty socialMovie.localizedImage}">
			<img src="${socialMovie.localizedImage}" width="150px;" style="border: 1px dotted #ccc;">
		</c:when>
		<c:otherwise>
			<img src="${socialMovie.originalImage}" width="150px;">		
		</c:otherwise>
	</c:choose>
</center>
LocalizedTitle: ${socialMovie.localizedTitle}
<br/>
OriginalTitle: ${socialMovie.originalTitle}
<br/>
Duration: ${socialMovie.duration} min
<br/>
Director: <a href="/directorDetail.html?director=${socialMovie.directorId}">${socialMovie.director}</a>
<br/>
Release date: ${socialMovie.releaseDate}
<br/>
Num. Reviews: ${socialMovie.numReviews}
<br/>
Avg Mark: ${socialMovie.avgMark}
<br/>
<br/>
<br/>

Totale Users:
<c:out value="${fn:length(socialMovie.movieUsers)}" />

<display:table name="${socialMovie.movieUsers}" cellspacing="0" cellpadding="0" id="movieUser" pagesize="25" class="table" export="false">
	<display:column escapeXml="false" sortable="false" titleKey="i">
		<img src="${movieUser.imageLink}" height="20px" width="20px;"/>
	</display:column>
	<display:column escapeXml="false" sortable="true" titleKey="u">
		<a href="/shelf.html?username=${movieUser.username}">${movieUser.username}</a>
	</display:column>
	<display:column escapeXml="false" sortable="false" titleKey="m">
		<c:if test="${movieUser.mark > 0}">
	    	<c:forEach begin="1" end="${movieUser.mark}">
				<img src="/images/sun.png" height="11px" />	    		
	    	</c:forEach>
    	</c:if>
	</display:column>
</display:table>

</div>

<div id="cont">

<div id="searchBar">
	<form:form name="searchSocialMovieForm" action="/searchSocialMovies.html" method="POST">
		<input type="text" name="filter" />
		<input type="submit" name="doSearch" value="Search" />
	</form:form>
	<br/>
</div>

<display:table name="${socialMovie.detailedReviews}" cellspacing="0" cellpadding="0" requestURI="" defaultsort="1" id="review" pagesize="25" class="table" export="false">
	<display:column>
		<div id="message_${review.review}" style="background-color: yellow; width: 100%; border: 1px solid red; margin-bottom: 5px; display:none;">
			ciao
		</div>
		<div style="border-bottom: 1px dotted #ccc; margin-bottom: 5px; padding-bottom: 5px; height: 20px;">
			<div style="float:left; margin-top: 3px;">
				<span style="font-weight: bold; font-size: 14px;">${review.title}</span>		
			</div>
			<div style="float:right;">
				<img src="/images/emotes-ok.png" style="cursor: pointer;" onclick="voteOk('${review.review}')"> <span id="ok_${review.review}">${review.ok} </span>
				<img src="/images/emotes-ko.png" style="cursor: pointer;" onclick="voteKo('${review.review}')"> <span id="ko_${review.review}">${review.ko} </span>
			</div>
		</div>
		${review.reviewtext}
		<div style="border-top: 1px dotted #ccc; margin-top: 5px; padding-bottom: 10px;">
			<div style="float: left;">
				<a href="/shelf.html?username=${review.username}">${review.username}</a>, <i>${review.dateinserted}</i>
			</div>
			<div style="float: right;">
				<a href="/reviewDiscussion.html?review=${review.review}">${review.numOpinions} commenti</a>
			</div>
		</div>
	</display:column>
</display:table>

</div>

<script>
	function voteOk(review) {
		new Ajax.Request('/voteReview.html?ajax=true&type=ok&review='+review, {
			  method: 'post',
			  onSuccess: function(response) {
			  if(response.responseText == -1) {
				var message = $('message_'+review);
				message.innerHTML = "Hai già votato per questa review... TODO!! Da internazionalizzare";
				Effect.BlindDown(message, { duration: 0.2 });
			  } else if(response.responseText == -2) {
				var message = $('message_'+review);
				message.innerHTML = "Non si può votare la review che hai fatto tu... TODO!! da internazionalizzare";
				Effect.BlindDown(message, { duration: 0.2 });
			  } else {
			    var oks = $('ok_'+review);
			    oks.innerHTML = response.responseText;
			  }
			}
		});
	}

	function voteKo(review) {
		new Ajax.Request('/voteReview.html?ajax=true&type=ko&review='+review, {
			  method: 'post',
			  onSuccess: function(response) {
			  if(response.responseText == -1) {
				var message = $('message_'+review);
				message.innerHTML = "Hai già votato per questa review... TODO!! Da internazionalizzare";
				Effect.BlindDown(message, { duration: 0.2 });
			  } else if(response.responseText == -2) {
				var message = $('message_'+review);
				message.innerHTML = "Non si può votare la review che hai fatto tu... TODO!! da internazionalizzare";
				Effect.BlindDown(message, { duration: 0.2 });
			  } else {
			    var kos = $('ko_'+review);
			    kos.innerHTML = response.responseText;
			  }
			}
		});
	}
</script>
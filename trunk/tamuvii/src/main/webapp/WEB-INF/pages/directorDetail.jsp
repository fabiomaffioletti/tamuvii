<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="Dettagli regista"/></title>
</head>

<div id="sidebar">
	<div id="user_profile">
		<div id="user_profile_image">
			<div id="user_image_div" style="background-image: url(/images/placeholder_user_48.jpg);">
			</div>
			<div id="user_profile_info" style="margin-bottom: 10px;">
				<b>${fn:substring(directorDetail.director.name, 0, 1)}. ${directorDetail.director.surname}</b>
				<br/>
				<span class="light_text_italic font12">${directorDetail.numMovies} film</span>
				<br/>
				<a href="#" id="other_info_link" onclick="displayOtherInfo('other_info_container')">Vedi altre informazioni</a>
			</div>
		</div>
		<div id="other_info_container" style="display: none;">
			<div id="other_info">
				<span class="font12">Nome completo: <span class="light_text_italic">${directorDetail.director.name} ${directorDetail.director.surname}</span></span>
			</div>
		</div>
	</div>
</div>



<div id="main">
	<div id="options">
		<div id="order_div">
			<select id="order" name="">
				<option value="0">Ordina per:</option>
				<option value="1">data visto (dal pi&ugrave; recente)</option>
				<option value="2">data visto (dal pi&ugrave; vecchio)</option>
				<option value="3">giudizio (dal pi&ugrave; alto) </option>
				<option value="4">giudizio (dal pi&ugrave; basso) </option>
			</select>
		</div>
	</div>
	
	<div id="movies">
		<div id="movies_list_container">
			<ul class="movie_list">
				<c:forEach var="movie" items="${directorDetail.movies}">
					<c:set var="displayOriginalTitle" value="n" />
					
					<li class="movie_image">
						<c:choose>
							<c:when test="${not empty movie.localizedImage}">
								<img src="${movie.localizedImage}" />
							</c:when>
							<c:otherwise>
								<img src="${movie.originalImage}" />
							</c:otherwise>
						</c:choose>
					</li>
				
					<li class="movie_data">
						<div class="title" id="title_${movie.movie}">
							<c:choose>
					    		<c:when test="${empty movie.localizedTitle}">
						    		<a href="/socialMovie.html?movie=${movie.movie}"><b>${movie.originalTitle}</b></a> 
						    	</c:when>
						    	<c:otherwise>
						    		<a href="/socialMovie.html?movie=${movie.movie}"><b>${movie.localizedTitle}</b></a>
						    		<c:set var="displayOriginalTitle" value="y" />
						    	</c:otherwise>
					    	</c:choose>
						</div>
						<c:if test="${movie.originalTitle != movie.localizedTitle && displayOriginalTitle == 'y'}">
				    		<div class="localized_title">
				    			<i>Titolo originale: ${movie.originalTitle}</i>
				    		</div>
				    	</c:if>
				    	<span class="font11">${movie.numReviews} recensioni</span>
				    	<br/>
				    	<span class="font11">${movie.numUsers} utenti</span>
				    	<br/>
				    	<span class="font11">Voto medio: ${movie.avgMark}</span>
				    	
						
						
					</li>
					
					<li class="movie_actions">
						<div class="action action_title">Opzioni</div>
						<c:if test="${not empty movie.originalPlot || not empty movie.localizedPlot}">
							<div class="action"><a href="#" onclick="toggleAndMove('movie_plot_${movie.movie}', 'title_${movie.movie}'); return false;">Vedi trama</a></div>
						</c:if>
				    	<c:set var="isInPersonalMovies" value="0" />
			    		<c:set var="isWished" value="0" />
				    	<c:forEach var="personalMovieId" items="${personalMoviesIdsAndWishedFlags}">
				    		<c:if test="${personalMovieId.movie == movie.movie}">
				    			<c:set var="isInPersonalMovies" value="1" />
				    			<c:if test="${personalMovieId.wished == 1}">
				    				<c:set var="isWished" value="1" />
				    			</c:if>
				    		</c:if>
				    	</c:forEach>
				    	<c:choose>
	    					<c:when test="${isInPersonalMovies == 0}">
	    						<div class="action"><a href="/shelfManagement.html?action=add&movie=${movie.movie}">Aggiungi alla videoteca</a></div>
	    						<div class="action"><a href="/wishlistManagement.html?action=wish&movie=${movie.movie}">Aggiungi alla wishlist</a></div>
	    					</c:when>
	    					<c:otherwise>
	    						<div class="action">Presente in 
	    							<c:if test="${isWished == 0}"> videoteca</c:if>
					    			<c:if test="${isWished == 1}"> wishlist</c:if>
	    						</div>
					    	</c:otherwise>
	    				</c:choose>
					</li>
					<li class="movie_plot" id="movie_plot_${movie.movie}" style="display: none;">
						<div class="plot_text">
							 <c:choose>
					    		<c:when test="${empty movie.localizedPlot}">
						    		${movie.originalPlot}
						    	</c:when>
						    	<c:otherwise>
						    		${movie.localizedPlot}
						    	</c:otherwise>
					    	</c:choose>
						</div>
					</li>
					<li class="separator">
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>
	
</div>


<script>
	function displayElement(id) {
		$(id).appear({ duration: 0.2 });
		return false;
	}
	function hideElement(id) {
		$(id).fade({ duration: 0.2 });
		return false;
	}
	
	function chooseOption(id) {
		if($(id).visible()) {
			new Effect.Fade(id, { duration: 0.4 });
		} else {
			new Effect.Appear(id, { duration: 0.4 });
		}
		return false;
	}
	
	function displayOptionHint(hint) {
		$('option_hint').innerHTML = hint;		
		return false;
	}
	function resetOptionHint() {
		$('option_hint').innerHTML = 'Cosa vuoi fare?';		
		return false;
	}
	function displayOtherInfo() {
		$('other_info_container').appear({ duration: 0.2 });
		$('other_info_link').innerHTML = "Nascondi altre informazioni";
		$('other_info_link').onclick = hideOtherInfo;
		return false;
	}
	function hideOtherInfo() {
		$('other_info_container').fade({ duration: 0.2 });
		$('other_info_link').innerHTML = "Vedi altre informazioni";
		$('other_info_link').onclick = displayOtherInfo;
		return false;
	}
	function toggleAndMove(id, title) {	
		new Effect.toggle(id, 'slide', { duration: 0.5, afterFinish: function(effect) {
	      new Effect.ScrollTo(title, { duration: 0.5 });
	    }});
	}
</script>
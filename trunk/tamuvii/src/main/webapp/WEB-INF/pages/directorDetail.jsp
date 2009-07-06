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
		<div id="search_div">
			<form>
				<input type="text" name="searchbox" id="searchbox_text" value="Cerca in questa videoteca" />
				<input type="image" src="/images/search.png" name="doSearchShelf" id="searchbox_button" />
			</form>
		</div>
	</div>
	
	<div id="movies">
		<div id="movies_list_container">
			<ul class="movie_list">
				<c:forEach var="movie" items="${directorDetail.movies}">
					<li class="movie_image">
						<img src="persepolis.jpg" />
					</li>
					<li class="movie_data">
						<div class="title" id="title_1"><a href="/socialMovie.html?movie=${directorMovie.movie}">Persepolis</a></div>
						<div class="localized_title">Il titolo originale &egrave; Persepolis</div>
						<div class="directed_by">di <a href="#">Vincent Paronnaud</a>, <a href="#">Marjane Satrapi</a></div>
						<div class="date_viewed">visto il 24/05/2009</div>
						<div class="mark"><img src="sun.png"/><img src="sun.png"/><img src="sun.png"/><img src="sun.png"/><img src="sun.png"/></div>
					</li>
					<li class="movie_actions">
						<div class="action action_title">Opzioni</div>
						<div class="action"><a href="#" onclick="toggleAndMove('movie_plot_1', 'title_1'); return false;">Vedi trama</a></div>
						<div class="action"><a href="#" onclick="toggleAndMove('movie_review_1', 'title_1'); return false;">Vedi recensione</a></div>
						<div class="action"><a href="#">Aggiungi a shelf</a></div>
						<div class="action"><a href="#">Aggiungi a wishlist</a></div>
					</li>
					<li class="movie_plot" id="movie_plot_1" style="display: none;">
						<div class="plot_text">
							Attraverso gli occhi di una bambina di nove anni, la precoce ed estroversa Marjane, il film ci fa vedere come le speranze di un popolo vengano distrutte quando i fondamentalisti prendono il potere, imponendo il velo alle donne e imprigionando migliaia di oppositori. Intelligente e impavida, la piccola Marjane aggira il controllo sociale dei "tutori dell'ordine" scoprendo il punk, gli ABBA e gli Iron Maiden. Ma dopo l'insensata esecuzione di suo zio, e sotto i bombardamenti della guerra Iraq/Iran, la paura diventa una realtà quotidiana con cui fare i conti. Temondo per la sua sicurezza, i genitori decidono di mandarla a studiare in Austria quando compie 14 anni. Marjane si ritrova così da sola con i problemi dell'adolescenza ed i pregiudizi di chi la identifica proprio con quel fondamentalismo religioso e quell'estremismo che l'hanno costretta a fuggire. Col tempo, riesce a farsi accettare e incontra perfino l'amore, ma dopo il liceo si ritrova nuovamente da sola e con una gran nostalgia di casa. Benché questo significhi mettersi il velo e vivere sotto una dittatura, Marjane decide di tornare in Iran per stare con la sua famiglia. Dopo un difficile periodo di adattamento, entra in un Istituto d'arte e poi si sposa, senza mai smettere di denunciare le ipocrisie di cui è testimone. A 24 anni, però, pur sentendosi profondamente iraniana, capisce di non poter più vivere in Iran. E' così che prende la drammatica decisione di lasciare il proprio paese per la Francia - piena di speranze per il proprio futuro, ma segnata in modo indelebile dal proprio passato. 
						</div>
					</li>
					<li class="movie_review" id="movie_review_1" style="display: none;">
						<div class="review_text">
							E' già tutto stato detto nella recensione del film, Persepolis è semplicemente Meraviglioso!, io credo che chi guarda questo film debba considerarsi uno spettatore privilegiato, è un capolavoro che coinvolge, commuove, diverte insomma è un film che trasmette delle emozioni fortissime e vere ed io per questo lo ho amato! penso d non commettere un sacrilegio se lo giudico con un bel 10
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


<%-- 

<display:table name="${directorDetail.movies}" cellspacing="0" cellpadding="0" requestURI="" defaultsort="1" id="directorMovie" pagesize="25" class="table" export="true">
    <display:column property="movie" escapeXml="true" sortable="true" titleKey="movie.movie" />
    <display:column escapeXml="false" sortable="true" titleKey="movie.originaltitle">
    	<a href="/socialMovie.html?movie=${directorMovie.movie}">${directorMovie.originaltitle}</a>
    </display:column>
</display:table>--%>
<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="Dati personali sul film"/></title>
    <script type="text/javascript" src="${ctx}/scripts/calendar/calendar.js"></script>
	<script type="text/javascript" src="${ctx}/scripts/calendar/lang/calendar-it.js"></script>
  	<script type="text/javascript" src="${ctx}/scripts/calendar/calendar-setup.js"></script>
</head>


<div id="sidebar">
	<div id="movie_details">
		<ul>
			<li>
				<c:choose>
					<c:when test="${not empty personalMovie.localizedImage}">
						<img class="movie_details_image" src="${personalMovie.localizedImage}" />
					</c:when>
					<c:otherwise>
						<img class="movie_details_image" src="${personalMovie.originalImage}" />
					</c:otherwise>
				</c:choose>
			</li>
			<li class="title">${personalMovie.localizedTitle}</li>
			<li><span class="light_text_italic">Titolo originale: ${personalMovie.originalTitle}</span></li>
			<li>di <a href="/directorDetail.html?director=${personalMovie.directorId}">${personalMovie.director}</a></li>
			<li>Durata: ${personalMovie.duration} min</li>
			<li>Data di rilascio: <fmt:formatDate pattern="${df}" value="${personalMovie.releaseDate}" /></li>
		</ul>
	</div>
</div>

<div id="main">
	<form:form name="personalMovieForm" commandName="personalMovie" method="post">
		<div id="personal_movie_general_info">
			<div id="personal_movie_general_info_title">
				<div style="padding:10px;">
					Inserisci le informazioni generali sul film
				</div>
			</div>
			
			<div id="personal_movie_general_info_mark">
				<b>Cosa ne pensi del film?</b><br/>
				<form:select path="mark" id="mark" onchange="refreshMark(); return false;">
					<c:if test="${empty personalMovie.mark}">
						<form:option value="">Dai un voto al film</form:option>
					</c:if>
					<form:option value="1">Bruttissimo</form:option>
					<form:option value="2">Brutto</form:option>
					<form:option value="3">Così così</form:option>
					<form:option value="4">Bello</form:option>
					<form:option value="5">Bellissimo</form:option>
				</form:select>
				<span id="displayed_mark"></span>
			</div>
			<div id="personal_movie_general_info_date_viewed">
				<b>Quando lo hai visto?</b>
				<br/>
				<form:input path="dateViewed" readonly="true" cssStyle="width: 160px;"/><img src="${ctx}/images/iconCalendar.gif" id="dateViewedButton" style="vertical-align: middle; cursor: pointer; margin-left:10px;" title="Calendario" />
			</div>
		</div>
		<div id="personal_movie_review_info">
			<div id="personal_movie_general_info_title">
				<div style="padding:10px;">
					Scrivi una recensione
				</div>
			</div>
			<div style="width: 100%;">
				<b>Titolo:</b>
				<br/>
				<form:input path="review.title" cssStyle="width:478px;" />
				<br/>
				<b>Testo:</b>
				<br/>
				<form:textarea path="review.reviewtext" />
			</div>
		</div>
		
		<br/><br/><br/>
		<input type="submit" name="update" value="salva" />
		<input type="submit" name="cancel" value="annulla" />
		<input type="submit" name="delete" value="elimina" />
		
	</form:form>
</div>


<script>
	Event.observe(window, 'load', function(event) {
		refreshMark();
	});

	
	function refreshMark() {
		var choosen_mark = $('mark').value;
		var images = "";
		for(i=0; i<choosen_mark; i++) {
			images += "<img src='/images/star.gif' />";
		}
		$('displayed_mark').innerHTML = images;
	}
</script>

<script type="text/javascript"> 
    Calendar.setup({
        inputField     :    "dateViewed",      // id of the input field
        ifFormat       :    "%d/%m/%Y",       // format of the input field
        showsTime      :    false,            // will display a time selector
        button         :    "dateViewedButton",   // trigger for the calendar (button ID)
        singleClick    :    true,           // single-click mode
        step           :    1                // show all years in drop-down boxes (instead of every other year as default)
    });
</script>
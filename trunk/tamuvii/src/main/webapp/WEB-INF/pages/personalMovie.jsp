<%@ include file="/common/taglibs.jsp"%>
<c:choose>
	<c:when test="${language=='it'}">
		<c:set var="firstDayOfWeek">1</c:set>
		<c:set var="localeLanguage">it</c:set>
		<c:set var="dateFormat">"%d/%m/%Y"</c:set>
	</c:when>
	<c:otherwise>
		<c:set var="firstDayOfWeek">0</c:set>
		<c:set var="localeLanguage">en</c:set>
		<c:set var="dateFormat">"%m/%d/%Y"</c:set>
	</c:otherwise>
</c:choose>
<head>
    <title><fmt:message key="Dati personali sul film"/></title>
    <link rel="stylesheet" type="text/css" href="${ctx}/scripts/dynarchcalendar/css/tamuvii_jscal2.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/scripts/dynarchcalendar/css/border-radius.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/scripts/dynarchcalendar/css/tamuvii/tamuvii.css" />
  	<script type="text/javascript" src="${ctx}/scripts/dynarchcalendar/js/jscal2.js"></script>
  	<script type="text/javascript" src="${ctx}/scripts/dynarchcalendar/js/lang/${localeLanguage}.js"></script>
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
//<![CDATA[
var c = Calendar.setup({
	trigger       : "dateViewedButton",
	inputField    : "dateViewed",
	dateFormat	  : ${dateFormat},
	weekNumbers   : false,
	showTime      : false,
	bottomBar	  : false,
	fdow		  : ${firstDayOfWeek},
	date		  : $('dateViewed').value,
	onSelect      : function() {
			this.hide();
		}
	});          
//]]>
</script>

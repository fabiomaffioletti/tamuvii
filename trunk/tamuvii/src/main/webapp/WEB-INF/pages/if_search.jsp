<%@ include file="/common/taglibs.jsp"%>

<head>
	<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/custom/movies.css'/>" />
	<script type="text/javascript" src="<c:url value='/scripts/prototype.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/scripts/scriptaculous.js'/>"></script>
</head>

<div id="resultMoviesContainer">
	<display:table name="resultSocialMovies" cellspacing="0" cellpadding="0" requestURI="" defaultsort="1" id="resultMovie" pagesize="10" class="table" export="false">
	    <display:column escapeXml="false" sortable="true" titleKey="Titolo originale">
	    	<div class="movie_image">
				<c:choose>
					<c:when test="${not empty resultMovie.localizedImage}">
						<img src="${resultMovie.localizedImage}" />
					</c:when>
					<c:otherwise>
						<img src="${resultMovie.originalImage}" />
					</c:otherwise>
				</c:choose>
			</div>
	    </display:column>
	</display:table>
</div>

<script type="text/javascript">
	Event.observe(window, 'load', function(event) {
		window.parent.$('searchFrameContainer').setStyle({display: 'block'});
		new Effect.Morph(
			window.parent.$('searchFrameContainer'), {
				style: 'height:'+$('resultMoviesContainer').getHeight() + "px", 
				duration: 0.3
			}
		);
	});
</script>

<style type="text/css">
body{
	margin:0;
}
</style>
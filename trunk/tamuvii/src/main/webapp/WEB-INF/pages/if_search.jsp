<%@ include file="/common/taglibs.jsp"%>

<head>
	<script type="text/javascript" src="<c:url value='/scripts/prototype.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/scripts/scriptaculous.js'/>"></script>
</head>

<div id="resultMoviesContainer">
	<display:table name="resultSocialMovies" cellspacing="0" cellpadding="0" requestURI="" defaultsort="1" id="resultMovie" pagesize="25" class="table" export="true">
	    <display:column property="originalTitle" escapeXml="true" sortable="true" titleKey="Titolo originale" />
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
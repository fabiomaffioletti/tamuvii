<%@ include file="/common/taglibs.jsp"%>

<head>
	<script type="text/javascript" src="<c:url value='/scripts/prototype.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/scripts/scriptaculous.js'/>"></script>
</head>

<div id="resultMoviesContainer">
	<display:table name="resultSocialMovies" cellspacing="0" cellpadding="0" requestURI="" defaultsort="1" id="resultMovie" pagesize="3" style="width:100%" class="table" export="false">
	    <display:column escapeXml="false" class="movie_image">
			<c:choose>
				<c:when test="${not empty resultMovie.localizedImage}">
					<img src="${resultMovie.localizedImage}" />
				</c:when>
				<c:otherwise>
					<img src="${resultMovie.originalImage}" />
				</c:otherwise>
			</c:choose>
	    </display:column>
	</display:table>
</div>

<script type="text/javascript">
	Event.observe(window, 'load', function(event) {
		window.parent.$('searchFrameContainer').setStyle({display: 'block'});
		new Effect.Morph(
			window.parent.$('searchFrameContainer'), {
				style: 'height:' + ($('resultMoviesContainer').getHeight()+35) + "px", 
				duration: 0.3
			}
		);
	});
</script>

<style type="text/css">

body {
	margin:0;
}

.movie_image {
	width: 120px;
	padding-left: 5px;
	clear: both;
	border-bottom: 1px dashed #ccc;
	padding-bottom: 20px;
	padding-top: 20px;
}
.movie_image img {
	height: 120px;
	width: 85px;
	padding: 2px;
	border: 1px solid #666;
	-moz-box-shadow: 3px 3px 15px #999;
}


span.pagebanner {
    display: block;
    margin: 10px 0 10px 0;
    padding: 2px 4px 2px 0;
}

span.pagelinks {
    display: block;
    margin-top: 15px;
    text-align: right;
    float:right;
    width: 100%;
}

span.pagelinks a {
	border: 1px solid #ccc;
	padding: 3px 8px;
	text-decoration: none;
	margin-left: 3px;
	font-size: 12px;
	font-family: arial,helvetica,clean,sans-serif;
	color: black;
	background-color: #eee;
}

span.pagelinks a:hover {
	background-color: #FFCE8A;
}

</style>
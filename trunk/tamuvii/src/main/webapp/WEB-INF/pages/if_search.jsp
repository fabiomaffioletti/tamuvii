<%@ include file="/common/taglibs.jsp"%>

<head>
	<script type="text/javascript" src="<c:url value='/scripts/prototype.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/scripts/scriptaculous.js'/>"></script>
</head>

<div id="resultMoviesContainer">
	<display:table name="resultSocialMovies" cellspacing="0" cellpadding="0" requestURI="" defaultsort="1" id="resultMovie" pagesize="2" class="table" export="false">
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
				style: 'height:'+$('resultMoviesContainer').getHeight() + "px", 
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


div.exportlinks {
    margin: -5px 0 10px 10px;
    padding: 2px 4px 2px 0;
    width: 100%;
}

div.exportlinks a {
    text-decoration: none;
}

div.exportlinks span {
    background-repeat: no-repeat;
}

span.csv {
    background-image: url(../images/ico_file_csv.png);
}

span.excel {
    background-image: url(../images/ico_file_excel.png);
}

span.pdf {
    background-image: url(../images/ico_file_pdf.png);
}

span.xml {
    background-image: url(../images/ico_file_xml.png);
}

span.export {
    cursor: pointer;
    display: inline-block;
    padding: 0 4px 1px 20px;
}

span.pagebanner {
    display: block;
    margin: 10px 0 10px 0;
    padding: 2px 4px 2px 0;
}

span.pagelinks {
    display: block;
    font-size: .95em;
    margin-bottom: 5px;
    margin-top: -18px;
    padding: 2px 0 2px 0;
    text-align: right;
    width: 80%;
}

</style>
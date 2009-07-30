<%@ include file="/common/taglibs.jsp"%>

<head>
	<script type="text/javascript" src="<c:url value='/scripts/prototype.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/scripts/scriptaculous.js'/>"></script>
</head>

<div id="resultMoviesContainer">
	<display:table name="resultSocialMovies" cellspacing="0" cellpadding="0" requestURI="" defaultsort="1" id="resultMovie" pagesize="3" style="width:100%" class="table" export="false">
	    <!-- IMAGE -->
	    <display:column escapeXml="false" class="movie_image">
			<c:choose>
				<c:when test="${not empty resultMovie.localizedImage}">
					<img src="${resultMovie.localizedImage}" />
				</c:when>
				<c:otherwise>
					<img src="${resultMovie.originalImage}" />
				</c:otherwise>
			</c:choose>
			<div class="movie_additional_info">
				- ${resultMovie.duration} minuti
				<br/>
				<c:choose>
					<c:when test="${not empty resultMovie.localizedCountry}">
						- ${resultMovie.localizedCountry}, <fmt:formatDate pattern="yyyy" value="${resultMovie.releaseDate}" />	
					</c:when>
					<c:otherwise>
						- ${resultMovie.originalCountry}, <fmt:formatDate pattern="yyyy" value="${resultMovie.releaseDate}" />
					</c:otherwise>
				</c:choose>
				
			</div>
	    </display:column>
	    
	    <!-- DATA -->
	    <display:column escapeXml="false" class="movie_data">
	    	<div class="title" id="title_${resultMovie.movie}">
				<c:choose>
		    		<c:when test="${empty resultMovie.localizedTitle}">
			    		<a href="/socialMovie.html?movie=${resultMovie.movie}" target="_parent"><b>${resultMovie.originalTitle}</b></a> 
			    	</c:when>
			    	<c:otherwise>
			    		<a href="/socialMovie.html?movie=${resultMovie.movie}" target="_parent"><b>${resultMovie.localizedTitle}</b></a>
			    	</c:otherwise>
		    	</c:choose>
			</div>
			<div class="localized_title">
    			<i><fmt:message key="label.original.title" />: ${resultMovie.originalTitle}</i>
    		</div>
    		<div class="directed_by"><fmt:message key="label.by" /> <a href="/directorDetail.html?director=${resultMovie.directorId}" target="_parent">${resultMovie.director}</a></div>
    		
			<div class="options">
	   			<ul>
	   				<li class="plot_link" id="info_link_${resultMovie.movie}" onclick="scontent('${resultMovie.movie}', 'users_thoughts_${resultMovie.movie}'); return false;">social</li>
	   				<li class="plot_link" id="plot_link_${resultMovie.movie}" onclick="scontent('${resultMovie.movie}', 'movie_plot_${resultMovie.movie}'); return false;">trama</li>
	   			</ul>
	   		</div>
	   		<div id="content_${resultMovie.movie}" class="scrollable_content">
	    		<div class="users_thoughts" id="users_thoughts_${resultMovie.movie}" style="display:block;">
					<ul>
						<li>${resultMovie.numUsers}0
				    		<c:choose>
				    			<c:when test="${resultMovie.numUsers > 1 || resultMovie.numUsers == 0}">
				    				<fmt:message key="label.users" />
				    			</c:when>
				    			<c:otherwise>
				    				<fmt:message key="label.user" />
				    			</c:otherwise>
				    		</c:choose> 
						</li>
						<li>Voto medio: 3</li>
						<li>${resultMovie.numReviews} reviews</li>
					</ul>
	    		</div>
	    		<div class="plot_text" id="movie_plot_${resultMovie.movie}" style="display: none;">
				 	<c:choose>
			    		<c:when test="${empty resultMovie.localizedPlot}">
				    		${resultMovie.originalPlot}
				    	</c:when>
				    	<c:otherwise>
				    		${resultMovie.localizedPlot}
				    	</c:otherwise>
			    	</c:choose>
				</div>
    		</div>
	    </display:column>
	</display:table>
</div>

<script>
	function scontent(id_movie, id_to_display) {
		if($('users_thoughts_'+id_movie)) {
			$('users_thoughts_'+id_movie).setStyle({display:'none'});
		}
		if($('movie_plot_'+id_movie)) {
			$('movie_plot_'+id_movie).setStyle({display:'none'});
		}

		$(id_to_display).appear();
	}

</script>

<script type="text/javascript">
	Event.observe(window, 'load', function(event) {
		/*window.parent.$('searchFrameContainer').setStyle({display: 'block'});
		new Effect.Morph(
			window.parent.$('searchFrameContainer'), {
				style: 'height:' + ($('resultMoviesContainer').getHeight()+35) + "px", 
				duration: 0.3
			}
		);*/
	});
</script>

<style type="text/css">

.scrollable_content {
	height:95px; 
	clear:both;
	overflow: hidden;
	float:left;
	width: 100%; 
}

body {
	margin:0;
	font-family: arial,helvetica,clean,sans-serif;
	font-size: 12px;
}

.movie_image {
	width: 110px;
	padding-left: 5px;
	clear: both;
	border-bottom: 1px dashed #ccc;
	padding-top: 15px;
	vertical-align: top;
}
.movie_image img {
	height: 120px;
	width: 85px;
	padding: 2px;
	border: 1px solid #666;
	-moz-box-shadow: 3px 3px 15px #999;
}

.movie_additional_info {
	font-size: 11px;
	padding-left: 5px;
	padding-top: 2px;
	color: #999;
}

.movie_data {
	border-bottom:1px dashed #ccc;
	height:100px;
	padding-top: 15px;
	vertical-align: top;
	padding-right: 10px;
}

.title {
	font-weight: bold;
	font-size: 13px;
	color: black;
}
.title a {
	color: black;
	text-decoration: none;
}
.title a:hover {
	color: black;
	text-decoration: underline;
}
.localized_title {
	font-style: italic;
	color: #aaa;
	font-size: 11px;
}

.directed_by {
	font-size: 11px;
	float: left;
	width: 100%;
	color: black;
}
.directed_by a {
	text-decoration: none;
	color: black;
}
.directed_by a:hover {
	text-decoration: underline;
	color: black;
}


.users_thoughts {
	padding: 10px;
	padding-top: 14px;
	border-top: 1px solid #ccc;
	font-size: 12px;
	height: 60px;
	clear: both;
	margin-bottom: 10px;
}
.users_thoughts ul {
	list-style-image: url(/images/arrow.gif); 
	padding-left: 25px; 
	margin: 0;
}
.users_thoughts li {
	line-height: 16px;
	vertical-align: -10px;
}

.options {
	font-size: 11px;
	margin-top: 7px;
	float:right;
}

.options ul {
	list-style: none;
	margin:0;
	padding:0;
}

.options li {
	-moz-border-radius-topright: 5px;
	-moz-border-radius-topleft: 5px;
	padding-top: 2px;
	padding-bottom: 2px;
	padding-left: 10px;
	padding-right: 10px;
	float: left;
	cursor: pointer;
	margin-right: 3px;
}

.options li.plot_link {
	background-color: #ADCEFF;	
}
.options li.review_link {
	background-color: #ADCEFF;	
}

.plot_text {
	height: 60px; 
	overflow:hidden;  
	margin-bottom:10px; 
	clear: both;
	text-align:justify; 
	border-top: 1px solid #ccc; 
	padding: 10px; 
	font-size: 12px; 
}



<!-- DisplayTag -->
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
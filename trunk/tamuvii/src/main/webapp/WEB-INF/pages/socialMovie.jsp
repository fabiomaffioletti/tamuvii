<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="socialMovie.title"/></title>
    <meta name="heading" content="<fmt:message key='socialMovie.heading'/>"/>
    <meta name="menu" content="AdminMenu"/>
</head>


MovieId: ${socialMovie.movie}
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

Reviews:
<br/>
<display:table name="${socialMovie.reviews}" cellspacing="0" cellpadding="0" requestURI="" defaultsort="1" id="review" pagesize="25" class="table" export="false">
	<display:column property="review" escapeXml="true" sortable="true" titleKey="review" />
	<display:column property="title" escapeXml="true" sortable="true" titleKey="title" />
	<display:column property="reviewtext" escapeXml="true" sortable="true" titleKey="text" />
	<display:column property="username" escapeXml="true" sortable="true" titleKey="username" />
	<display:column property="dateinserted" escapeXml="true" sortable="true" titleKey="dateinserted" />
	<display:column escapeXml="false" sortable="false" title="actions">
		<a href="/reviewDiscussion.html?review=${review.review}">Segui discussione</a>
	</display:column>
</display:table>

<script type="text/javascript">
    highlightTableRows("review");
</script>
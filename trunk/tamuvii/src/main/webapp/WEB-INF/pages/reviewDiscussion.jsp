<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="reviewDiscussion.title"/></title>
    <meta name="heading" content="<fmt:message key='reviewDiscussion.heading'/>"/>
    <meta name="menu" content="AdminMenu"/>
</head>

<a href="/socialMovie.html?movie=${discussion.review.movie}">Torna indietro alla pagina del film</a>
<br/>
<br/>

<c:if test="${not empty discussion.review.title}">
	Title: ${discussion.review.title}
	<br/>
</c:if>
Text: ${discussion.review.reviewtext}

<display:table name="${discussion.opinions}" cellspacing="0" cellpadding="0" requestURI="" defaultsort="1" id="opinion" pagesize="25" class="table" export="false">
	<display:column property="opinion" escapeXml="true" sortable="true" titleKey="opinion" />
	<display:column property="opiniontext" escapeXml="true" sortable="true" titleKey="text" />
	<display:column escapeXml="false" sortable="true" titleKey="username">
		<a href="/shelf.html?username=${opinion.username}">${opinion.username}</a>
	</display:column>
	<display:column property="dateinserted" escapeXml="true" sortable="true" titleKey="dateinserted" />
</display:table>


Insert new opinion:
<form:form name="reviewDiscussionForm" commandName="opinion" method="POST">
	<form:textarea path="opiniontext"/>
	<br/>

	<input type="submit" name="update" value="salva" />
	<input type="submit" name="cancel" value="annulla" />
</form:form>
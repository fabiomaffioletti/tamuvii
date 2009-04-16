<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="reviewDiscussion.title"/></title>
    <meta name="heading" content="<fmt:message key='reviewDiscussion.heading'/>"/>
    <meta name="menu" content="AdminMenu"/>
</head>

${discussion.review}

<form:form name="reviewDiscussionForm" commandName="opinion" method="POST">

	<input type="submit" name="update" value="salva" />
	<input type="submit" name="cancel" value="annulla" />
	<input type="submit" name="delete" value="elimina" />
	
</form:form>
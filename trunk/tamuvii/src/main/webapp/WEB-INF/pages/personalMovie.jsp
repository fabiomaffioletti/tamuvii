<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="userList.title"/></title>
    <meta name="heading" content="<fmt:message key='userList.heading'/>"/>
    <meta name="menu" content="AdminMenu"/>
</head>

TITOLO: ${personalMovie.originalTitle}
<br/>


<form:form name="personalMovieForm" commandName="personalMovie" method="POST">
	
	voto: 	<form:select path="mark">
				<form:option value="0">0</form:option>
				<form:option value="1">1</form:option>
				<form:option value="2">2</form:option>
				<form:option value="3">3</form:option>
				<form:option value="4">4</form:option>
				<form:option value="5">5</form:option>
			</form:select> 
	<br/>
	
	review title: <form:input path="review.title"/>
	<br/>
	
	review text: <form:input path="review.reviewtext"/>
	<br/>
	
	<input type="submit" name="update" value="salva" />
	<input type="submit" name="cancel" value="annulla" />
	<input type="submit" name="delete" value="elimina" />
	
</form:form>
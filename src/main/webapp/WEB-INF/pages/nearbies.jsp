<%@ include file="/common/taglibs.jsp"%>

<%@ include file="/common/contacts_menu.jsp"%>
<br/>
<%@ include file="/common/messages.jsp"%>
<br/>
<c:forEach var="n" items="${nearbies}">
	<a href="/${n.username}/movies/">${n.username}</a>
	<br/>
</c:forEach>

<br/>
<br/>
<br/>

ultima pagina: ${isLast}
<c:if test="${isLast != true}">
	<a href="#" onclick="getNearbiesPage('${page+1}', '${filter}')">next</a>
</c:if>

<br/>
numero pagina: ${page}
<c:if test="${page - 1 != 0}">
	<a href="#" onclick="getNearbiesPage('${page-1}', '${filter}')">prev</a>	
</c:if>
<br/>
totale oggetti: ${itemsCount}
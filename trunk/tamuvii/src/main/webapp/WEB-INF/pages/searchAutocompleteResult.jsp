<%@ include file="/common/taglibs.jsp"%>
<ul>
    <c:forEach var="searchResult" items="${searchResults}" varStatus="row">
    <c:choose>
    	<c:when test="${row.first}">
    		<c:choose>
			    <c:when test="${empty searchResult.localizedTitle}">
					<li class="first">${searchResult.originalTitle}, ${searchResult.director}</li>
			    </c:when>
			    <c:otherwise>
					<li class="first">${searchResult.localizedTitle}, ${searchResult.director}</li>    	
			    </c:otherwise>
		    </c:choose>	
    	</c:when>
    	<c:otherwise>
    		<c:choose>
			    <c:when test="${empty searchResult.localizedTitle}">
					<li>${searchResult.originalTitle}, ${searchResult.director}</li>
			    </c:when>
			    <c:otherwise>
					<li>${searchResult.localizedTitle}, ${searchResult.director}</li>    	
			    </c:otherwise>
		    </c:choose>
    	</c:otherwise>
    </c:choose>
    
    </c:forEach>
</ul>
<%@ include file="/common/taglibs.jsp"%>
<ul>
    <c:forEach var="searchResult" items="${searchResults}">
        <li>${searchResult.originalTitle}</li>
    </c:forEach>
</ul>
<%@ include file="/common/taglibs.jsp"%>

<c:if test="${not empty errorMessages}">
    <div class="validation_error" id="errorMessages">
        <c:forEach var="error" items="${errorMessages}">
            <img src="../images/alert.png" style="margin-right:5px; vertical-align: bottom;" /><c:out value="${error}" escapeXml="false"/><br />
        </c:forEach>
    </div>
    <c:remove var="errorMessages"/>
</c:if>

<c:if test="${not empty successMessages}">
    <div class="message" id="successMessages">
        <c:forEach var="msg" items="${successMessages}">
            <img src="../images/success.png" style="margin-right:5px; vertical-align: bottom;" /><c:out value="${msg}" escapeXml="false"/><br />
        </c:forEach>
    </div>
    <c:remove var="successMessages" scope="session"/>
</c:if>

<c:if test="${not empty infoMessages}">
    <div class="message" id="infoMessages">
        <c:forEach var="msg" items="${infoMessages}">
            <img src="../images/info.png" style="margin-right:5px; vertical-align: bottom;" /><c:out value="${msg}" escapeXml="false"/><br/>
        </c:forEach>
    </div>
    <c:remove var="infoMessages" scope="session"/>
</c:if>
<%@ include file="/common/taglibs.jsp"%>

<%--
<c:if test="${pageContext.request.locale.language != 'en'}">
    <div id="switchLocale"><a href="<c:url value='/?locale=en'/>"><fmt:message key="webapp.name"/> in English</a></div>
</c:if>

<div id="branding">
    <h1><a href="<c:url value='/'/>"><fmt:message key="webapp.name"/></a></h1>
    <p><fmt:message key="webapp.tagline"/></p>
</div>
<hr />

<appfuse:constants scope="request"/>
--%>

<fmt:message var="df" key="date.format" scope="session"/>
<img src="/images/logo.png"/>
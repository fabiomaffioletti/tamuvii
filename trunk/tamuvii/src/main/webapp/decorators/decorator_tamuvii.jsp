<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="/common/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
    <head>
        <%@ include file="/common/meta.jsp" %>
        <title><decorator:title/> | <fmt:message key="webapp.name"/></title>

        <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/custom/sx.css'/>" />
        <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/custom/common.css'/>" />
        <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/custom/layout.css'/>" />
        <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/custom/movies.css'/>" />
        <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/custom/socialMovie.css'/>" />
        <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/custom/personalMovie.css'/>" />
        <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/custom/options.css'/>" />
        <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/custom/contacts.css'/>" />

        <script type="text/javascript" src="<c:url value='/scripts/prototype.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/scripts/scriptaculous.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/scripts/global.js'/>"></script>
        <decorator:head/>
    </head>
<body<decorator:getProperty property="body.id" writeEntireProperty="true"/><decorator:getProperty property="body.class" writeEntireProperty="true"/>>

    <div id="wrap">
		<div id="header">
			<jsp:include page="/common/header.jsp"/>
		</div>
		
		<div id="nav">
			<div class="wrapper">
            	<jsp:include page="/common/menu.jsp"/>
            </div>
        </div>
        
        <div id="main_content">
        	<decorator:body></decorator:body>
        </div>
		
		
		<div id="footer">
			<jsp:include page="/common/footer.jsp"/>
		</div>
	</div>
	
</body>
</html>

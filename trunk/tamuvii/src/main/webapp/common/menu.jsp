<%@ include file="/common/taglibs.jsp"%>

<menu:useMenuDisplayer name="Velocity" config="cssHorizontalMenu.vm" permissions="rolesAdapter">
<ul id="primary-nav" class="menuList">
    <!--<c:if test="${empty pageContext.request.remoteUser}"><li><a href="<c:url value="/login.jsp"/>" class="current"><fmt:message key="login.title"/></a></li></c:if>-->
    <menu:displayMenu name="Search"/>
    <menu:displayMenu name="AdminMenu"/>
    <menu:displayMenu name="MyMenu"/>
    <menu:displayMenu name="RelationshipMenu"/>
    <menu:displayMenu name="MessageMenu"/>
    <menu:displayMenu name="Logout"/>
</ul>
</menu:useMenuDisplayer>
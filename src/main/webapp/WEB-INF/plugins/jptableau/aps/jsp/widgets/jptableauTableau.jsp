<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="wp" uri="/aps-core"%>
<%@ taglib prefix="jptableau" uri="/jptableau-core"%>

<jptableau:tableau var="tableau" />
<article>
<c:choose>
	<c:when test="${not empty tableau}">
	<h1><wp:i18n key="jptableau_TABLEAU_ID" />: <c:out value="${tableau.id}" /></h1>
	<ul>
		<li>
			<wp:i18n key="jptableau_TABLEAU_NAME" />: <c:out value="${tableau.name}" /><br />
			<wp:i18n key="jptableau_TABLEAU_SITEROLE" />: <c:out value="${tableau.siterole}" /><br />
			<wp:i18n key="jptableau_TABLEAU_AUTHSETTING" />: <c:out value="${tableau.authsetting}" /><br />
			<wp:i18n key="jptableau_TABLEAU_LASTLOGIN" />: <c:out value="${tableau.lastlogin}" /><br />
		</li>
	</ul>
	</c:when>
	<c:otherwise>
	<div class="alert alert-error">
		<p><wp:i18n key="jptableau_TABLEAU_NOT_FOUND" /></p>
	</div>
	</c:otherwise>
</c:choose>
</article>
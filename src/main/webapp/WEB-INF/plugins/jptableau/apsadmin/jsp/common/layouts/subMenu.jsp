<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="wp" uri="/aps-core" %>

<wp:ifauthorized permission="superuser">
	<li><a href="<s:url namespace="/do/jptableau/Tableau" action="list" />" ><s:text name="jptableau.title.tableauManagement" /></a></li>
</wp:ifauthorized>

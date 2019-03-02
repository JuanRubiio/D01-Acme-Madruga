<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<div>
	<display:table pagesize="5" class="displaytag" keepStatus="true"
	name="processions" requestURI="${requestURI}" id="row">
	
	<spring:message code="procession.ticker" var="tickerHeader" />
	<display:column property="ticker" title="${tickerHeader}" />
	
	<spring:message code="procession.title" var="titleHeader" />
	<display:column property="title" title="${titleHeader}" />
	
	<display:column> 
	<a href="procession/show.do?processionId=${row.id}">
			<spring:message code="procession.show"/>
	</a> 
	</display:column>
	
	<display:column> 
	<a href="procession/brotherhood/edit.do?processionId=${row.id}">
			<spring:message code="procession.edit"/>
	</a> 
	</display:column>
	
	
	
</display:table>
</div>
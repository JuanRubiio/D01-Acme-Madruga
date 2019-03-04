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
	name="march" requestURI="${requestURI}" id="row">
	
	<spring:message code="march.procession" var="processionHeader" />
	<display:column property="procession" title="${processionHeader}" />
	
	<spring:message code="march.status" var="statusHeader" />
	<display:column property="status" title="${statusHeader}" />
	
	<display:column> 
	<a href="march/member/show.do?marchId=${row.id}">
			<spring:message code="march.show"/>
	</a> 
	</display:column>
	
	<display:column> 
	<a href="march/member/edit.do?marchId=${row.id}">
			<spring:message code="march.edit"/>
	</a> 
	</display:column>	
	
</display:table>
</div>
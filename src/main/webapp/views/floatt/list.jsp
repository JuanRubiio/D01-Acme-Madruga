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
	name="floats" requestURI="${requestURI}" id="row">
	
	<spring:message code="floatt.title" var="titleHeader" />
	<display:column property="title" title="${titleHeader}" />
	
	<spring:message code="floatt.description" var="descriptionHeader" />
	<display:column property="description" title="${descriptionHeader}" />
	
	<spring:message code="floatt.photos" var="photosHeader" />
	<display:column property="photos" title="${photosHeader}" />
	
	<display:column> 
	<a href="floatt/brotherhood/show.do?floattId=${row.id}">
			<spring:message code="floatt.show"/>
	</a> 
	</display:column>
	
	<display:column> 
	<a href="floatt/brotherhood/edit.do?floattId=${row.id}">
			<spring:message code="floatt.edit"/>
	</a> 
	</display:column>
	
	<display:column> 
	<a href="floatt/brotherhood/delete.do?floattId=${row.id}">
			<spring:message code="floatt.delete"/>
	</a> 
	</display:column>
	
	
	
</display:table>
</div>

<%--
 * action-1.jsp
 *
 * Copyright (C) 2013 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="acme" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jstl:if test="${readonly == null}">
	<jstl:set var="readonly" value="false"/>
</jstl:if>


<form:form action="floatt/brotherhood/edit.do"
	modelAttribute="floatt" method="post">

	<form:hidden path="id" />
	<form:hidden path="version" />
	


	<acme:textarea code="floatt.title" path="title" readonly="${readonly}"/>
	<br />

	<acme:textbox code="floatt.description" path="description" readonly="${readonly}"/>
	<br />

	<acme:textarea code="floatt.photos" path="photos" readonly="${readonly}"/>
	<br />

	
	
	<jstl:if test="${readonly == false }">
	
	<input type="submit" name="save"
		value="<spring:message code="floatt.save"/>" />
	
	<input type="button" name="cancel"
		value="<spring:message code="floatt.cancel" />"
		onclick="javascript: relativeRedir('floatt/brotherhood/list.do');" />
	<br />

	</jstl:if>
	
		<jstl:if test="${readonly == true }">
	
	<input type="button" name="cancel"
		value="<spring:message code="floatt.cancel" />"
		onclick="javascript: relativeRedir('floatt/brotherhood/list.do');" />
	<br />

	</jstl:if>
	

</form:form>
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

<form:form action="configuration/administrator/edit.do"
	modelAttribute="configuration" method="post">

	<form:hidden path="id" />
	<form:hidden path="version" />
	<form:hidden path="spam" />
	<form:hidden path="positiveWords" />
	<form:hidden path="negativeWords" />
	<form:hidden path="positionEsp" />
	<form:hidden path="positionEng" />
	


	<acme:textarea code="configuration.banner" path="banner" readonly="${readonly}"/>
	<br />

	<acme:textbox code="configuration.system" path="system" readonly="${readonly}"/>
	<br />

	<acme:textarea code="configuration.welcomMessage" path="welcomMessageEng" readonly="${readonly}"/>
	<br />

	<acme:textarea code="configuration.welcomMessageEs" path="welcomMessageEsp" readonly="${readonly}"/>
	<br />
	
	<acme:textbox code="configuration.countryCode" path="countryCode" readonly="${readonly}"/>
	<br />

	<acme:textbox code="configuration.finderDuration" path="finderDuration" readonly="${readonly}"/>
	<br />

	<acme:textbox code="configuration.maxFiders" path="maxFiders" readonly="${readonly}"/>
	<br />
	
	<acme:textbox code="configuration.absolutMaxFinders" path="absolutMaxFinders" readonly="${readonly}"/>
	<br />
	
	
	<input type="button" name="spam"
		value="<spring:message code="configuration.spam" />"
		onclick="javascript: relativeRedir('configuration/administrator/showSpam.do');" />
	
	<input type="button" name="words"
		value="<spring:message code="configuration.words" />"
		onclick="javascript: relativeRedir('configuration/administrator/showWords.do');" />

	<input type="button" name="position"
		value="<spring:message code="configuration.position" />"
		onclick="javascript: relativeRedir('configuration/administrator/showPosition.do');" />
	
	

	<br />
	
	
	<jstl:if test="${readonly == false }">
	
	<input type="submit" name="save"
		value="<spring:message code="configuration.save"/>" />
	
	<input type="button" name="cancel"
		value="<spring:message code="configuration.cancel" />"
		onclick="javascript: relativeRedir('configuration/administrator/show.do');" />
	<br />

	</jstl:if>
	
		<jstl:if test="${readonly == true }">
	
	<input type="button" name="edit"
		value="<spring:message code="configuration.edit"/>" 
		onclick="javascript: relativeRedir('configuration/administrator/edit.do');" />


	<input type="button" name="back"
		value="<spring:message code="configuration.back" />"
		onclick="javascript: relativeRedir('welcome/index.do');" />
	<br />

	</jstl:if>
	

</form:form>

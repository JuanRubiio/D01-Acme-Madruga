<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<display:table name="positiveWords" id="row" requestURI="${requestURI}"
	pagesize="10" class="displaytag">


	<display:column titleKey="configuration.positiveWords">
		<a>${row}</a>
	</display:column>

	
	<security:authorize access="hasRole('ADMIN')">
		<display:column titleKey="configuration.delete">
			<input type="submit" name="delete" 
				value="<spring:message code="configuration.delete" />"
				onclick="javascript: relativeRedir('configuration/administrator/deletePostiveWord?word=${row}');" />

		</display:column>

	</security:authorize>

</display:table>

<display:table name="negativeWords" id="row" requestURI="${requestURI}"
	pagesize="10" class="displaytag">


	<display:column titleKey="configuration.negativeWords">
		<a>${row}</a>
	</display:column>

	
	<security:authorize access="hasRole('ADMIN')">
		<display:column titleKey="configuration.delete">
			<input type="submit" name="delete" 
				value="<spring:message code="configuration.delete" />"
				onclick="javascript: relativeRedir('configuration/administrator/deleteNegativeWord?word=${row}');" />

		</display:column>

	</security:authorize>

</display:table>

<security:authorize access="hasRole('ADMIN')">
	<input type="submit" name="create"
		value="<spring:message code="configuration.create" />"
		onclick="javascript: relativeRedir('configuration/administrator/createWord.do');" />

</security:authorize>

<input type="button" name="back"
		value="<spring:message code="configuration.back" />"
		onclick="javascript: relativeRedir('configuration/administrator/show.do');" />
	<br />

<br>


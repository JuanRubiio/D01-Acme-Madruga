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
	<p><spring:message code="march.status" />: <jstl:out value="${status}"></jstl:out></p>
	<jstl:if test="${application.status=='APPROVED'}">
		<p><spring:message code="march.row" />: <jstl:out value="${row}"></jstl:out></p>
		<p><spring:message code="march.column" />: <jstl:out value="${column}"></jstl:out></p>
	</jstl:if>
	
	<jstl:if test="${application.status=='REJECTED'}">
	<p><spring:message code="march.reason" />: <jstl:out value="${reason}"></jstl:out></p>
	</jstl:if>
	
	<p><spring:message code="march.procession" />: <jstl:out value="${procession}"></jstl:out></p>

	<input type="button" name="Back"
		value="<spring:message code="march.back" />"
		onclick="javascript: relativeRedir('march/member/list.do');" />

</div>
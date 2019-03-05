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
	<p><spring:message code="procession.title" />: <jstl:out value="${procession.title}"></jstl:out></p>
	<p><spring:message code="procession.description" />: <jstl:out value="${procession.description}"></jstl:out></p>
	<p><spring:message code="procession.moment" />: <jstl:out value="${procession.moment}"></jstl:out></p>
	<p><spring:message code="procession.ticker" />: <jstl:out value="${procession.ticker}"></jstl:out></p>
	<p><spring:message code="procession.draft" />: <jstl:out value="${procession.draft}"></jstl:out></p>
</div>
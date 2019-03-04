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
	<p><spring:message code="member.name" />: <jstl:out value="${name}"></jstl:out></p>
	<p><spring:message code="member.middleName" />: <jstl:out value="${middleName}"></jstl:out></p>
	<p><spring:message code="member.surname" />: <jstl:out value="${surname}"></jstl:out></p>
	<p><spring:message code="member.email" />: <jstl:out value="${email}"></jstl:out></p>
	<p><spring:message code="member.phone" />: <jstl:out value="${phone}"></jstl:out></p>
	<p><spring:message code="member.address" />: <jstl:out value="${address}"></jstl:out></p>

	<input type="button" name="Back"
		value="<spring:message code="march.back" />"
		onclick="javascript: relativeRedir('march/member/list.do');" />

</div>
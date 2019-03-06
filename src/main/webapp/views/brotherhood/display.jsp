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
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<b><spring:message code="brotherhood.title" /></b>
<jstl:out value="${brotherhood.title}" />
<br />

<b><spring:message code="brotherhood.establishmentDate" /></b>
<jstl:out value="${brotherhood.establishmentDate}" />
<br />

<b><spring:message code="brotherhood.photos" /></b>
<jstl:out value="${brotherhood.photos}" />
<br />

<b><spring:message code="brotherhood.area" /></b>
<jstl:out value="${brotherhood.area.name}" />
<br />

<!--  List -->

<b><spring:message code="brotherhood.members" /></b>

<display:table pagesize="5" class="displaytag" name="members"
	requestURI="member/list.do" id="row">

	<!-- Attributes -->
	
	<spring:message code="member.name" var="nameHeader" />
	<display:column property="name"title="${nameHeader}"/>
	
	<spring:message code="member.middleName" var="middleNameHeader" />
	<display:column property="middleName" title="${middleNameHeader}"/>
	
	<spring:message code="member.surname" var="surnameHeader" />
	<display:column property="surname" title="${surnameHeader}"/>
			
</display:table>
<br />
<!--  List -->

<b><spring:message code="brotherhood.floats" /></b>

<display:table pagesize="5" class="displaytag" name="floats"
	requestURI="float/list.do" id="row">

	<!-- Attributes -->
	<spring:message code="float.title" var="titleHeader" />
	<display:column property="title" title="${titleHeader}"/>
	
	<spring:message code="float.description" var="descriptionHeader" />
	<display:column property="description" title="${descriptionHeader}"/>

</display:table>
<br />
<!--  List -->

<b><spring:message code="brotherhood.processions" /></b>

<display:table pagesize="5" class="displaytag" name="processions"
	requestURI="procession/list.do" id="row">

	<!-- Attributes -->
	
	<spring:message code="procession.ticker" var="tickerHeader" />
	<display:column property="ticker" title="${tickerHeader}"/>
	
	<spring:message code="procession.title" var="titleHeader" />
	<display:column property="title" title="${titleHeader}"/>
	
	<spring:message code="procession.description" var="descriptionHeader" />
	<display:column property="description" title="${descriptionHeader}"/>

	<spring:message code="procession.moment" var="momentHeader" />
	<display:column property="moment" title="${momentHeader}"/>

</display:table>
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
	name="member" requestURI="${requestURI}" id="row">
	
	<spring:message code="member.name" var="nameHeader" />
	<display:column property="name" title="${nameHeader}" />
	
	<spring:message code="member.surname" var="surnameHeader" />
	<display:column property="surname" title="${surnameHeader}" />
	
	<spring:message code="member.phone" var="phoneHeader" />
	<display:column property="phone" title="${phoneHeader}" />
	
	<display:column> 
	<a href="member/show.do?memberId=${row.id}">
			<spring:message code="member.show"/>
	</a> 
	</display:column>
	
	<display:column> 
	<a href="member/edit.do?memberId=${row.id}">
			<spring:message code="member.edit"/>
	</a> 
	</display:column>	
	
</display:table>
</div>
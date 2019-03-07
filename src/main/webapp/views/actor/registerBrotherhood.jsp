
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

<form:form action="actor/registerBrotherhood.do" modelAttribute="registerBrotherhoodForm">
<fieldset>
	
	<br />
	<form:label path="username">
		<spring:message code="actor.username" />:
	</form:label>
	<form:input path="username" />
	<form:errors cssClass="error" path="username" />
	<br />
<br />
	<form:label path="password">
		<spring:message code="actor.password" />:
	</form:label>
	<form:password path="password" />
	<form:errors cssClass="error" path="password" />
	<br />
<br />
	<form:label path="password2">
		<spring:message code="actor.password2" />:
	</form:label>
	<form:password path="password2" />
	<form:errors cssClass="error" path="password2" />
	<br />
<br />
	<form:label path="title">
		<spring:message code="actor.title" />:
	</form:label>
	<form:input path="title" />
	<form:errors cssClass="error" path="title" />
	<br />
	<br />
	<form:label path="establishment">
		<spring:message code="actor.establishment" />:
	</form:label>
	<form:input path="establishment" />
	<form:errors cssClass="error" path="establishment" />
	<br />
<br />
	<form:label path="name">
		<spring:message code="actor.name" />:
	</form:label>
	<form:input path="name" />
	<form:errors cssClass="error" path="name" />
	<br />
<br />
	<form:label path="middleName">
		<spring:message code="actor.middlename" />:
	</form:label>
	<form:input path="middleName" />
	<form:errors cssClass="error" path="middleName" />
	<br />
<br />
	<form:label path="surname">
		<spring:message code="actor.surname" />:
	</form:label>
	<form:input path="surname" />
	<form:errors cssClass="error" path="surname" />
	<br />
<br />
	<form:label path="photo">
		<spring:message code="actor.photo" />:
	</form:label>
	<form:input path="photo" />
	<form:errors cssClass="error" path="photo" />
	<br />
<br />
	<form:label path="email">
		<spring:message code="actor.email" />:
	</form:label>
	<form:input path="email" />
	<form:errors cssClass="error" path="email" />
	<br />
<br />
	<form:label path="address">
		<spring:message code="actor.address" />:
	</form:label>
	<form:input path="address" />
	<form:errors cssClass="error" path="address" />
	<br />
<br />
	<form:label path="phone">
		<spring:message code="actor.phone" />:
	</form:label>
	<form:input path="phone" />
	<form:errors cssClass="error" path="phone" />
	<br />
	<br />
	<form:label path="agree">
		<spring:message code="actor.agree" />
	</form:label>
	<form:checkbox path="agree" />
	<form:errors cssClass="error" path="agree" />
	<br />
	<br />
	
	<input type="submit" name="save"
		value="<spring:message code="actor.save" />" />
	<input type="button" name="cancel"
		value="<spring:message code="actor.cancel" />"
		onclick="javascript: window.location.replace('welcome/index.do');" />
</fieldset>
</form:form>
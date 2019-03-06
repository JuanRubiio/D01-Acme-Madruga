<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h2><spring:message	code="administrator.query1" />:</h2> <jslt:out value="${query1[0]}"/> - <jslt:out value="${query1[1]}"/> - <jslt:out value="${query1[2]}"/> - <jslt:out value="${query1[3]}"/><br>
<h2><spring:message	code="administrator.query2" />:</h2> <jslt:out value="${query2}"/><br>
<h2><spring:message	code="administrator.query3" />:</h2> <jslt:out value="${query3})"/><br>
<h2><spring:message	code="administrator.query4" />:</h2> <jslt:out value="${query4[0]}"/> - <jslt:out value="${query4[1]}"/> - <jslt:out value="${query4[2]}"/> - <jslt:out value="${query4[3]}"/><br>
<h2><spring:message	code="administrator.query5" />:</h2> <jslt:out value="${query5}"/><br>
<h2><spring:message	code="administrator.query6" />:</h2> <jslt:out value="${query6}"/><br>
<h2><spring:message	code="administrator.query7" />:</h2> <jslt:out value="${query7}"/><br>

<br>

<%@page language="java" contentType="text/html; charset=ISO-8859-1"
		pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<%@ taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<form:form action="administrator/register.do" modelAttribute="administrator" method="post">
	
	

	<acme:textbox code="row.name" path="name"/>
	<acme:textbox code="row.surname" path="surname"/>
	<acme:textbox code="row.middlename" path="middleName"/>
	<acme:textbox code="row.email" path="email"/>
	<acme:textbox code="row.phone" path="phone"/>
	<acme:textbox code="row.direction" path="address"/>
	<acme:textbox code="row.photo" path="photo"/>
	

<tr>
			<td>
				<input type="submit" name="save" 
						onclick="validateFeedback()" value="<spring:message code="actor.save" />">
					
				
				<input type="button" name="back"
		value="<spring:message code="configuration.back" />"
		onclick="javascript: relativeRedir('welcome/index.do');" />
	<br />

			</td>
		</tr>

</form:form>

<script type="text/javascript">
    function validateFeedback() {
        var phone = document.getElementById("phone");
        var RE = /(\+\d{1,3} \d{1,3} \d{4,}$) |(\+\d{1,3} \d{4,}$) |(\d{4,}$)/;
        if (!(phone.value).match(RE)) {
            alert('<spring:message code="row.confirm.register" />');
        }
        return confirm('<spring:message code="row.confirm.edit" />');
    }
    
    function validateEmail(email) 
    {
        var re = /\S+@\S+\.\S+/;
        var res = re.test(email);
        if(res!=true){
        	 alert('<spring:message code="row.confirm.register" />');
        }
    }
</script>
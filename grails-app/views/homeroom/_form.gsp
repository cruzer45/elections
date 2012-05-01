<%@ page import="elections.Homeroom" %>



<div class="fieldcontain ${hasErrors(bean: homeroomInstance, field: 'homeroom', 'error')} ">
	<label for="homeroom">
		<g:message code="homeroom.homeroom.label" default="Homeroom" />
		
	</label>
	<g:textField name="homeroom" value="${homeroomInstance?.homeroom}"/>
</div>


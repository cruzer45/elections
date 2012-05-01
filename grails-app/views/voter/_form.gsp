<%@ page import="elections.Voter" %>



<div class="fieldcontain ${hasErrors(bean: voterInstance, field: 'firstName', 'error')} ">
	<label for="firstName">
		<g:message code="voter.firstName.label" default="First Name" />
		
	</label>
	<g:textField name="firstName" value="${voterInstance?.firstName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: voterInstance, field: 'lastName', 'error')} ">
	<label for="lastName">
		<g:message code="voter.lastName.label" default="Last Name" />
		
	</label>
	<g:textField name="lastName" value="${voterInstance?.lastName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: voterInstance, field: 'homeroom', 'error')} required">
	<label for="homeroom">
		<g:message code="voter.homeroom.label" default="Homeroom" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="homeroom" name="homeroom.id" from="${elections.Homeroom.list()}" optionKey="id" required="" value="${voterInstance?.homeroom?.id}" class="many-to-one"/>
</div>


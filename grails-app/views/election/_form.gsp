<%@ page import="elections.Election" %>



<div class="fieldcontain ${hasErrors(bean: electionInstance, field: 'title', 'error')} ">
	<label for="title">
		<g:message code="election.title.label" default="Title" />
		
	</label>
	<g:textField name="title" value="${electionInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: electionInstance, field: 'electionDate', 'error')} required">
	<label for="electionDate">
		<g:message code="election.electionDate.label" default="Election Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="electionDate" precision="day"  value="${electionInstance?.electionDate}"  />
</div>


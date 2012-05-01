<%@ page import="elections.Candidate" %>



<div class="fieldcontain ${hasErrors(bean: candidateInstance, field: 'firstName', 'error')} ">
	<label for="firstName">
		<g:message code="candidate.firstName.label" default="First Name" />
		
	</label>
	<g:textField name="firstName" value="${candidateInstance?.firstName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: candidateInstance, field: 'lastName', 'error')} ">
	<label for="lastName">
		<g:message code="candidate.lastName.label" default="Last Name" />
		
	</label>
	<g:textField name="lastName" value="${candidateInstance?.lastName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: candidateInstance, field: 'post', 'error')} required">
	<label for="post">
		<g:message code="candidate.post.label" default="Post" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="post" name="post.id" from="${elections.Post.list()}" optionKey="id" required="" value="${candidateInstance?.post?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: candidateInstance, field: 'team', 'error')} required">
	<label for="team">
		<g:message code="candidate.team.label" default="Team" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="team" name="team.id" from="${elections.Team.list()}" optionKey="id" required="" value="${candidateInstance?.team?.id}" class="many-to-one"/>
</div>


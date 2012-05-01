
<%@ page import="elections.Election" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'election.label', default: 'Election')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-election" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-election" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list election">
			
				<g:if test="${electionInstance?.title}">
				<li class="fieldcontain">
					<span id="title-label" class="property-label"><g:message code="election.title.label" default="Title" /></span>
					
						<span class="property-value" aria-labelledby="title-label"><g:fieldValue bean="${electionInstance}" field="title"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${electionInstance?.electionDate}">
				<li class="fieldcontain">
					<span id="electionDate-label" class="property-label"><g:message code="election.electionDate.label" default="Election Date" /></span>
					
						<span class="property-value" aria-labelledby="electionDate-label"><g:formatDate date="${electionInstance?.electionDate}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${electionInstance?.id}" />
					<g:link class="edit" action="edit" id="${electionInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>

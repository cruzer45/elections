
<%@ page import="elections.Vote" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'vote.label', default: 'Vote')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-vote" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-vote" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list vote">
			
				<g:if test="${voteInstance?.president}">
				<li class="fieldcontain">
					<span id="president-label" class="property-label"><g:message code="vote.president.label" default="President" /></span>
					
						<span class="property-value" aria-labelledby="president-label"><g:link controller="candidate" action="show" id="${voteInstance?.president?.id}">${voteInstance?.president?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${voteInstance?.firstVicePresident}">
				<li class="fieldcontain">
					<span id="firstVicePresident-label" class="property-label"><g:message code="vote.firstVicePresident.label" default="First Vice President" /></span>
					
						<span class="property-value" aria-labelledby="firstVicePresident-label"><g:link controller="candidate" action="show" id="${voteInstance?.firstVicePresident?.id}">${voteInstance?.firstVicePresident?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${voteInstance?.secondVicePresident}">
				<li class="fieldcontain">
					<span id="secondVicePresident-label" class="property-label"><g:message code="vote.secondVicePresident.label" default="Second Vice President" /></span>
					
						<span class="property-value" aria-labelledby="secondVicePresident-label"><g:link controller="candidate" action="show" id="${voteInstance?.secondVicePresident?.id}">${voteInstance?.secondVicePresident?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${voteInstance?.treasurer}">
				<li class="fieldcontain">
					<span id="treasurer-label" class="property-label"><g:message code="vote.treasurer.label" default="Treasurer" /></span>
					
						<span class="property-value" aria-labelledby="treasurer-label"><g:link controller="candidate" action="show" id="${voteInstance?.treasurer?.id}">${voteInstance?.treasurer?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${voteInstance?.secretary}">
				<li class="fieldcontain">
					<span id="secretary-label" class="property-label"><g:message code="vote.secretary.label" default="Secretary" /></span>
					
						<span class="property-value" aria-labelledby="secretary-label"><g:link controller="candidate" action="show" id="${voteInstance?.secretary?.id}">${voteInstance?.secretary?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${voteInstance?.directorOfSports}">
				<li class="fieldcontain">
					<span id="directorOfSports-label" class="property-label"><g:message code="vote.directorOfSports.label" default="Director Of Sports" /></span>
					
						<span class="property-value" aria-labelledby="directorOfSports-label"><g:link controller="candidate" action="show" id="${voteInstance?.directorOfSports?.id}">${voteInstance?.directorOfSports?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${voteInstance?.directorOfEducation}">
				<li class="fieldcontain">
					<span id="directorOfEducation-label" class="property-label"><g:message code="vote.directorOfEducation.label" default="Director Of Education" /></span>
					
						<span class="property-value" aria-labelledby="directorOfEducation-label"><g:link controller="candidate" action="show" id="${voteInstance?.directorOfEducation?.id}">${voteInstance?.directorOfEducation?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${voteInstance?.id}" />
					<g:link class="edit" action="edit" id="${voteInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>

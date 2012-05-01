
<%@ page import="elections.Election" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'election.label', default: 'Election')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-election" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-election" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="title" title="${message(code: 'election.title.label', default: 'Title')}" />
					
						<g:sortableColumn property="electionDate" title="${message(code: 'election.electionDate.label', default: 'Election Date')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${electionInstanceList}" status="i" var="electionInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${electionInstance.id}">${fieldValue(bean: electionInstance, field: "title")}</g:link></td>
					
						<td><g:formatDate date="${electionInstance.electionDate}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${electionInstanceTotal}" />
			</div>
		</div>
	</body>
</html>

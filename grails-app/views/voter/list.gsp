
<%@ page import="elections.Voter" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'voter.label', default: 'Voter')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-voter" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-voter" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="firstName" title="${message(code: 'voter.firstName.label', default: 'First Name')}" />
					
						<g:sortableColumn property="lastName" title="${message(code: 'voter.lastName.label', default: 'Last Name')}" />
					
						<th><g:message code="voter.homeroom.label" default="Homeroom" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${voterInstanceList}" status="i" var="voterInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${voterInstance.id}">${fieldValue(bean: voterInstance, field: "firstName")}</g:link></td>
					
						<td>${fieldValue(bean: voterInstance, field: "lastName")}</td>
					
						<td>${fieldValue(bean: voterInstance, field: "homeroom")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${voterInstanceTotal}" />
			</div>
		</div>
	</body>
</html>

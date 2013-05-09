
<%@ page import="elections.Vote" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'vote.label', default: 'Vote')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-vote" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-vote" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<th><g:message code="vote.president.label" default="President" /></th>
					
						<th><g:message code="vote.firstVicePresident.label" default="First Vice President" /></th>
					
						<th><g:message code="vote.secondVicePresident.label" default="Second Vice President" /></th>
					
						<th><g:message code="vote.treasurer.label" default="Treasurer" /></th>
					
						<th><g:message code="vote.secretary.label" default="Secretary" /></th>
					
						<th><g:message code="vote.directorOfSports.label" default="Director Of Sports" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${voteInstanceList}" status="i" var="voteInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${voteInstance.id}">${fieldValue(bean: voteInstance, field: "president")}</g:link></td>
					
						<td>${fieldValue(bean: voteInstance, field: "firstVicePresident")}</td>
					
						<td>${fieldValue(bean: voteInstance, field: "secondVicePresident")}</td>
					
						<td>${fieldValue(bean: voteInstance, field: "treasurer")}</td>
					
						<td>${fieldValue(bean: voteInstance, field: "secretary")}</td>
					
						<td>${fieldValue(bean: voteInstance, field: "directorOfSports")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${voteInstanceTotal}" />
			</div>
		</div>
	</body>
</html>

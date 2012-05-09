<%@ page import="elections.Vote"%>
<!doctype html>
<html>
<head>
<meta name="layout" content="main">
<g:set var="entityName"
	value="${message(code: 'vote.label', default: 'Vote')}" />
<title><g:message code="default.create.label"
		args="[entityName]" /></title>
</head>
<body>
	<div class="body">
		<g:jasperReport jasper="results"
			format="PDF"
			name="Election Results"/>
	</div>
</body>
</html>
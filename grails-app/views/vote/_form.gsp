<%@page import="elections.Candidate"%>
<%@page import="elections.Post"%>
<%@ page import="elections.Vote"%>



<div
	class="fieldcontain ${hasErrors(bean: voteInstance, field: 'president', 'error')} ">
	<label for="president"> <g:message code="vote.president.label"
			default="President" />

	</label>
	<g:select id="president" name="president.id"
		from="${Candidate.findAllByPost(Post.findByTitle("President"))}"
		optionKey="id" value="${voteInstance?.president?.id}"
		class="many-to-one" noSelection="['null': '']" />
</div>

<div
	class="fieldcontain ${hasErrors(bean: voteInstance, field: 'firstVicePresident', 'error')} ">
	<label for="firstVicePresident"> <g:message
			code="vote.firstVicePresident.label" default="First Vice President" />

	</label>
	<g:select id="firstVicePresident" name="firstVicePresident.id"
		from="${Candidate.findAllByPost(Post.findByTitle("First Vice President"))}"
		optionKey="id" value="${voteInstance?.firstVicePresident?.id}"
		class="many-to-one" noSelection="['null': '']" />
</div>

<div
	class="fieldcontain ${hasErrors(bean: voteInstance, field: 'secondVicePresident', 'error')} ">
	<label for="secondVicePresident"> <g:message
			code="vote.secondVicePresident.label" default="Second Vice President" />

	</label>
	<g:select id="secondVicePresident" name="secondVicePresident.id"
		from="${Candidate.findAllByPost(Post.findByTitle("Second Vice President"))}"
		optionKey="id" value="${voteInstance?.secondVicePresident?.id}"
		class="many-to-one" noSelection="['null': '']" />
</div>

<div
	class="fieldcontain ${hasErrors(bean: voteInstance, field: 'treasurer', 'error')} ">
	<label for="treasurer"> <g:message code="vote.treasurer.label"
			default="Treasurer" />

	</label>
	<g:select id="treasurer" name="treasurer.id"
		from="${Candidate.findAllByPost(Post.findByTitle("Treasurer"))}"
		optionKey="id" value="${voteInstance?.treasurer?.id}"
		class="many-to-one" noSelection="['null': '']" />
</div>

<div
	class="fieldcontain ${hasErrors(bean: voteInstance, field: 'secretary', 'error')} ">
	<label for="secretary"> <g:message code="vote.secretary.label"
			default="Secretary" />

	</label>
	<g:select id="secretary" name="secretary.id"
		from="${elections.Candidate.findAllByPost(Post.findByTitle("Secretary"))}"
		optionKey="id" value="${voteInstance?.secretary?.id}"
		class="many-to-one" noSelection="['null': '']" />
</div>

<div
	class="fieldcontain ${hasErrors(bean: voteInstance, field: 'directorOfSports', 'error')} ">
	<label for="directorOfSports"> <g:message
			code="vote.directorOfSports.label" default="Director Of Sports" />

	</label>
	<g:select id="directorOfSports" name="directorOfSports.id"
		from="${Candidate.findAllByPost(Post.findByTitle("Director of Sports"))}"
		optionKey="id" value="${voteInstance?.directorOfSports?.id}"
		class="many-to-one" noSelection="['null': '']" />
</div>

<div
	class="fieldcontain ${hasErrors(bean: voteInstance, field: 'directorOfEducation', 'error')} ">
	<label for="directorOfEducation"> <g:message
			code="vote.directorOfEducation.label" default="Director Of Education" />

	</label>
	<g:select id="directorOfEducation" name="directorOfEducation.id"
		from="${Candidate.findAllByPost(Post.findByTitle("Director of Education"))}"
		optionKey="id" value="${voteInstance?.directorOfEducation?.id}"
		class="many-to-one" noSelection="['null': '']" />
</div>


<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="layout" content="main" />
<title>Insert title here</title>
</head>
<body>
	<div class="content body center">
		<div id="voteNotice">
			<h1>Vote Saved</h1>
			<p>Your vote has been cast.</p>
			<p>Kindly leave the polling station.</p>

			<form name="redirect">
				<center>
					<strong>You will be redirected in <br /> <br />
						<form>
							<input type="text" size="3" name="redirect2" />
						</form> seconds
					</strong>

				</center>
			</form>
			<g:javascript src="countdown.js" />
		</div>
	</div>
</body>


</html>
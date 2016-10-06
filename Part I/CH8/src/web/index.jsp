<html>
	<head>
		<title>JavaMail Sample Form</title>
	</head>
	<body>
		<form name="mailForm" action="send" method="post">
		
			<table border="0">
				<tr>
					<td>From:</td>
					<td><input type="text" name="from" value="test@apress.com"></td>
				</tr>
				<tr>
					<td>To:</td>
					<td><input type="text" name="to" value="rob@cakesolutions.net"></td>
				</tr>
				<tr>
					<td>Subject:</td>
					<td><input type="text" name="subject" value="Test"></td>
				</tr>
				<tr>
					<td>Body</td>
					<td><textarea name="body" rows="5" cols="50">Some Content</textarea></td>
				</tr>
				<tr>
					<td>JNDI Scope:</td>
					<td>
						<select name="jndiScope">
							<option value="local">Local</option>
							<option value="global">Global</option>
						</select>
					</td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Send"></td>
				</tr>
			</table>
		
		</form>
	</body>
</html>
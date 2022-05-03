<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1" />
	<title>Prima Webapp</title>
</head>
<body>
	<div> ${messaggioErrore} </div>
	<form action="persona" method="post">
		<div>
			Nome: <input type="text" name="nome" value="${nome}" />
		</div>
		<div> ${messaggiErrore["nome"]} </div>
		<div>
			Cognome: <input type="text" name="cognome" value="${cognome}" />
		</div>
		<div> ${messaggiErrore["cognome"]} </div>
		<div>
			<input type="submit" name="sumbit" value="invia" />
		</div>
	</form>
</body>
</html>
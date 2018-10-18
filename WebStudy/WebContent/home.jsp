<html>

<head>
<title>Web Study</title>
<link rel="stylesheet" type="text/css" href="css/estilo.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />


</head>

<body onclick="verif()">
	<script>
		
		function desceDiv(b){
			var a = document.getElementById('divLogin');
			if(a.style.opacity == 0){
				a.style.opacity = "1";
				a.style.top = "30%";
			}else{
				a.style.opacity = "0";
				a.style.top = "-40%";
			}
			

		}
			
		</script>
	<div class="cabecalho">

		<text class="logotxt" id="logo"> WS </text>
		<text id="login" onclick="desceDiv()"> login </text>

	</div>

	<div id="divLogin">

		<div id="a">
			<text id="wsLogin"> Web Study </text>
		</div>

		<form action="login" method="POST">

			<input class="campos" id="campoL" name="email" placeholder="usuario">
			<br> <input type="password" class="campos" id="campoS"
				name="password" placeholder="senha"> <br>
			<button id="botaoOk" type="submit">ok</button>

		</form>

		<text id="esqueceu"> Esqueceu sua senha? </text>

	</div>


	<text class="titulo"> Web Study </text>
	<text class="subtitulo"> Faça suas provas online </text>

	<text id="direitos"> Todos os direitos reservados a <a
		href="http://www.univercode.com.br" target="_blank"> Univercode ®
	</a> 2017-2018 </text>

</body>

</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Escolha a sua Tabela</title>
    <link rel="stylesheet" href="css/comum.css">
    <link rel="stylesheet" href="css/comum2.css">
    <link rel="stylesheet" href="css/escolherTabela.css">
</head>
<body>
<div id="linhaEnfeite"></div>

<div id="fundoIrregular"></div>
<img src="assets/Icone.png" alt="Praceando">

<p id="titulo">Selecione a tabela que você deseja manipular:</p>

<form action="escolher-tabela" method="post">
    <div id="caixaLogin">
        <div class="container-checkbox">
            <label><input type="radio" name="opcao" class="checkbox-arredondado" value="Avatar"> Avatar</label>
            <label><input type="radio" name="opcao" class="checkbox-arredondado" value="Evento Local"> Evento Local</label>
            <label><input type="radio" name="opcao" class="checkbox-arredondado" value="Frase Sustentável"> Frase Sustentável</label>
            <label><input type="radio" name="opcao" class="checkbox-arredondado" value="Log"> Log</label>
            <label><input type="radio" name="opcao" class="checkbox-arredondado" value="Produto"> Produto</label>
            <label><input type="radio" name="opcao" class="checkbox-arredondado" value="Tag"> Tag</label>

            <button type="submit">Confirmar</button>
            
            <a href="cadastro.html">Cadastrar um administrador</a>
        </div>
    </div>
</form>


<p id="textoEnfeite">&lt; \ &gt;</p>
</body>
</html>
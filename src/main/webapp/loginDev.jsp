<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login Desenvolvedores</title>
  <link rel="stylesheet" href="css/loginDev.css">
  <!-- NAO CONSIGO FAZER O COMUM -->
</head>
<body>
<div id="fundoIrregular"></div>
<img src="assets/Icone.png" alt="Praceando">

<div id="caixaLogin">
  <p id="textoPrincipal">Login dos Devs</p>
  <p id="pontoGradiente">.</p>

  <form action="processa-login" method="post">
    <div class="input-container" id="container-Email">
      <label for="email" id="labelEmail">E-mail</label>
      <input type="email" id="email" name="email" class="inputForm" placeholder="Digite seu e-mail" required/>
    </div>

    <div class="input-container" id="container-Senha">
      <label for="senha" id="labelSenha">Senha</label>
      <input type="password" id="senha" name="senha" class="inputForm" placeholder="Digite sua senha" required/>
    </div>
    <button type="submit">Entrar</button>
  </form>

  <img src="assets/OlavoPraceando.jpg" alt="imagem Ilustrativa">
</div>

<p id="textoEnfeite">&lt; \ &gt;</p>
</body>
</html>
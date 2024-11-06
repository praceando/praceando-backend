# Padronização de Código

* Essas regras foram aplicadas no projeto para deixar o código _limpo_ e _fácil de se navegar_ para os **desenvolvedores** do grupo.

## Java
- Nomeação de classes CamelCase
- Nomeação de atributos
  - Models: seguindo tabela do banco
  - Estáticos finais (Constantes): LETRA_MAIUSCULA
  - Pacotes: Letras minúsculas sem underlines

- Servlets
  - Todas as classes terminam em `Servlet`
  - Pasta `auth` contém autenticação e cadastro
  - Pasta `form` contém servlets que geram formulários
  - Pasta `util` contém classes de utilidades
## HTML
### Espaçamento entre elementos HTML
Regras para espaçamentos entre elementos HTML

1. Grudar os elementos filhos no elemento pai
```html
<div class="pai">
    <p>Filho</p>
<div>
```


2. Elementos irmãos iguais juntos
```html
<div class="pai">
    <span>Maçã</span>
    <span>Banana</span>
</div>
```

3. Elementos irmãos diferentes separados
```html
<div class="pai">
    <p>Irmão 1</p>
    <p>Irmão 2</p>

    <a href="#">Irmão 3<a/>     <!-- a != p  -->
</div>
```

### Indentação e Quebras de linha para HTML
1. Indentação de 4 espaços
```html
<div>
    <p>Quatro</p>
</div>
```

2. Elementos HTML sem conteúdo não quebram linha
```html
<form class="box">
    <label>Imagem</label>

    <div class="content"></div>
</form>
```
3. Sem elementos `<br>`
4. Conteúdo de texto de qualquer tag quebram linha e indentam 4 espaços _se_ excedem a visualização da IDE (~100 caracteres)
```html
<body>
    <p>
        Lorem ipsum, dolor sit amet consectetur adipisicing elit. 
        Sequi illum ab pariatur saepe ducimus perspiciatis animi hic sed 
        praesentium ratione recusandae quos quod, nemo laborum soluta
        magnam ex iure doloremque!
    </p>
</body>
```

<hr>

### CSS

### Ordenação das principais propriedades CSS
1. `z-index`
2. `position`
3. `display:`
4. `width`
5. `height`
6. `margin`
7. _`padding`_ 
8. _`flex`_
9. _`grid`_
10. _`cor e fonte`_
11. _`transição / animação`_
12. _separação_ // Separa o resto das outras propriedades em 2 espaços 
13. _`resto`_

### Subseletores estando sempre por último.
Regras aninhadas sempre vêm por último em relação a propriedades da regra mãe. Ou seja, subseletores sempre estando após qualquer regra do seletor pai, exemplo:
```css
h1 {
    display: flex;
    width: 30px;
    flex-flow: column wrap;
   
    span {
        background-image: linear-gradient(red, white); 
    }
}
```


### Divisão de outras propriedades mais satélites (resto)
Em geral, a regra segue agrupando elementos de prefixos iguais.

1. _`background-image`_
2. _`background-attachment`_
3. _`background-position`_
4. _`background-repeat`_
5. _`background-size`_
6. _`background-clip`_
7. _`-webkit-background-clip`_
8. _`transform`_
9. _`overflow`_
10. _`border`_
11. _`border-radius`_
12. _`border-bottom`_
13. _`box-shadow`_
14. _`opacity`_
15. _`text-decoration`_
16. _`content`_
17. _`filter`_
18. _`object-fit`_
19. _`will-change`_
20. _`animation-play-state`_
21. _`outline`_
22. _`clip-path`_
23. _`box-sizing`_
24. _`order`_
